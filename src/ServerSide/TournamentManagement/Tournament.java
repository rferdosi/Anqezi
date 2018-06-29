package ServerSide.TournamentManagement;

import General.Side;
import ClientSide.Game.Game;
import General.User.Player;
import General.User.SimpleUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Tournament implements Serializable {

    private SimpleUser winner;
    private ArrayList<Game> finishedGames;
    private ArrayList<Game> undoneGames;
    private ArrayList<TournamentPlayer> tournamentPlayers;
    private ScoringSystem scoringSystem;
    private MatchMakingMethod matchMakingMethod;
    private int currentRound = 0;
    private final int MaximumRounds = 7;

    Tournament (SimpleUser[] users, MatchMakingMethod matchMakingMethod, ScoringSystem scoringSystem){

        this.tournamentPlayers = new ArrayList<>();
        for (int i = 0; i < users.length; i++) {
            TournamentPlayer player = new TournamentPlayer(users[i], 0);
            tournamentPlayers.add(player);
        }

        if (matchMakingMethod == MatchMakingMethod.RoundRobin){
            roundRobinMatchMaker();
        } else {
            swissSystemMatchMakerInitial();
        }

        this.scoringSystem = scoringSystem;
        this.matchMakingMethod = matchMakingMethod;

    }

    private void roundRobinMatchMaker(){
        Collections.shuffle(tournamentPlayers);
        for (int i = 0; i < tournamentPlayers.size(); i++){
            for (int j = 0; j < tournamentPlayers.size(); j++) {
                if (i != j) {
                    Game game = new Game();
                    tournamentPlayers.get(i).setSide(Side.Black);
                    Player player1 = new Player(tournamentPlayers.get(i).getSimpleUser(), tournamentPlayers.get(i).getSide());
                    game.setPlayer1(player1);
                    tournamentPlayers.get(j).setSide(Side.White);
                    Player player2 = new Player(tournamentPlayers.get(j).getSimpleUser(), tournamentPlayers.get(j).getSide());
                    game.setPlayer2(player2);
                    undoneGames.add(game);
                } else {
                    continue;
                }
            }
        }
    }

    private void swissSystemMatchMakerInitial(){
        Collections.shuffle(tournamentPlayers);
        for (int i = 0; i < tournamentPlayers.size(); i += 2){
            Game game = new Game();
            tournamentPlayers.get(i).setSide(Side.Black);
            Player player1 = new Player(tournamentPlayers.get(i).getSimpleUser(), tournamentPlayers.get(i).getSide());
            game.setPlayer1(player1);
            tournamentPlayers.get(i + 1).setSide(Side.Black);
            Player player2 = new Player(tournamentPlayers.get(i + 1).getSimpleUser(), tournamentPlayers.get(i + 1).getSide());
            game.setPlayer2(player2);
            undoneGames.add(game);
        }
    }
    private void swissSystemMatchMakerNextRounds(){
        ArrayList<TournamentPlayer> tempPlayers = (ArrayList<TournamentPlayer>) tournamentPlayers.clone();
        int negativeValue = 2;
        while (tempPlayers.size() > 1){
            Game game = new Game();
            if (!hasTheyPlayed(tempPlayers.get(tempPlayers.size() - 1).getSimpleUser(), tempPlayers.get(tempPlayers.size() - negativeValue).getSimpleUser())){
                if (tempPlayers.get(tempPlayers.size() - 1).howManyTimeWhite < 2 || tempPlayers.get(tempPlayers.size() - negativeValue).howManyTimeWhite < 2) {
                    Random random = new Random();
                    int player1Side = (random.nextInt() % 2);
                    if (tempPlayers.get(tempPlayers.size() - 1).howManyTimeWhite < 3 && player1Side == 1) {
                        tempPlayers.get(tempPlayers.size() - 1).setSide(Side.White);
                        tempPlayers.get(tempPlayers.size() - 1).howManyTimeWhite++;
                        tempPlayers.get(tempPlayers.size() - negativeValue).setSide(Side.Black);
                        tempPlayers.get(tempPlayers.size() - negativeValue).howManyTimeWhite = 0;
                    } else {
                        //tempPlayers.get(tempPlayers.size() - negativeValue)
                    }
                    game.setPlayer1(tempPlayers.get(tempPlayers.size() - 1));
                }
            }
        }
    }

    private boolean hasTheyPlayed(SimpleUser simpleUser1, SimpleUser simpleUser2){
        for (int i = 0; i < finishedGames.size(); i++) {
            if (finishedGames.get(i).getPlayer1().getSimpleUser().equals(simpleUser1) || finishedGames.get(i).getPlayer2().getSimpleUser().equals(simpleUser1)){
                if (finishedGames.get(i).getPlayer1().getSimpleUser().equals(simpleUser2) || finishedGames.get(i).getPlayer2().getSimpleUser().equals(simpleUser2)){
                    return true;
                }
            }
        }
        return false;
    }

    public void setGameResult(Game game) {
        undoneGames.remove(game);
        finishedGames.add(game);
        if (scoringSystem == ScoringSystem.TRADITIONAL){
            if (game.isDraw()){
                for (int i = 0; i < tournamentPlayers.size(); i++) {
                    if (game.getPlayer1().equals(tournamentPlayers.get(i).getSimpleUser()) ||
                        game.getPlayer2().equals(tournamentPlayers.get(i).getSimpleUser())){
                        tournamentPlayers.get(i).tournamentRating += 0.5;
                    }
                }
            } else {
                for (int i = 0; i < tournamentPlayers.size(); i++) {
                    if (game.getWinner().equals(tournamentPlayers.get(i).getSimpleUser())) {
                        tournamentPlayers.get(i).tournamentRating += 1;
                        break;
                    }
                }
            }
        } else if (scoringSystem == ScoringSystem.THREE_ONE_O){
            if (game.isDraw()){
                for (int i = 0; i < tournamentPlayers.size(); i++) {
                    if (game.getPlayer1().equals(tournamentPlayers.get(i).getSimpleUser()) ||
                        game.getPlayer2().equals(tournamentPlayers.get(i).getSimpleUser())){
                        tournamentPlayers.get(i).tournamentRating += 1;
                    }
                }
            } else {
                for (int i = 0; i < tournamentPlayers.size(); i++) {
                    if (game.getWinner().equals(tournamentPlayers.get(i).getSimpleUser())) {
                        tournamentPlayers.get(i).tournamentRating += 3;
                        break;
                    }
                }
            }
        } else if (scoringSystem == ScoringSystem.BAPS){
            if (game.isDraw()){
                for (int i = 0; i < tournamentPlayers.size(); i++) {
                    if (game.getPlayer1().equals(tournamentPlayers.get(i).getSimpleUser())){
                        if (tournamentPlayers.get(i).getSide() == Side.Black) {
                            tournamentPlayers.get(i).tournamentRating += 1;
                        }
                        break;
                    }
                }
            } else {
                for (int i = 0; i < tournamentPlayers.size(); i++) {
                    if (game.getWinner().equals(tournamentPlayers.get(i).getSimpleUser())) {
                        if (tournamentPlayers.get(i).getSide() == Side.Black) {
                            tournamentPlayers.get(i).tournamentRating += 3;
                        } else if (tournamentPlayers.get(i).getSide() == Side.White){
                            tournamentPlayers.get(i).tournamentRating += 2;
                        }
                        break;
                    }
                }
            }
        }
        updateRanking();
        if (matchMakingMethod == MatchMakingMethod.SwissSystem){
            if (undoneGames.size() == 0 && currentRound < MaximumRounds){
                currentRound++;
                swissSystemMatchMakerNextRounds();
            }
        }
    }

    private void updateRanking() {
        Collections.sort(tournamentPlayers);
    }

}
