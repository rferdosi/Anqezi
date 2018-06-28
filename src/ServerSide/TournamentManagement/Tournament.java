package ServerSide.TournamentManagement;

import General.Board.Side;
import General.Game;
import General.User.Player;
import General.User.SimpleUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Tournament implements Serializable {

    private SimpleUser winner;
    private ArrayList<Game> finishedGames;
    private ArrayList<Game> undoneGames;
    private ArrayList<TournamentPlayer> tournamentPlayers;
    private ScoringSystem scoringSystem;
    private MatchMakingMethod matchMakingMethod;
    private int currentRound = 0;

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
        /*for (int i = 0; i < tournamentPlayers.size(); i += 2){
            Game game = new Game();
            tournamentPlayers.get(i).setSide(Side.Black);
            Player player1 = new Player(tournamentPlayers.get(i).getSimpleUser(), tournamentPlayers.get(i).getSide());
            game.setPlayer1(player1);
            tournamentPlayers.get(i + 1).setSide(Side.Black);
            Player player2 = new Player(tournamentPlayers.get(i + 1).getSimpleUser(), tournamentPlayers.get(i + 1).getSide());
            game.setPlayer2(player2);
            undoneGames.add(game);
        }*/
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
            if (undoneGames.size() == 0){
                swissSystemMatchMakerNextRounds();
                currentRound++;
            }
        }
    }

    private void updateRanking() {
        Collections.sort(tournamentPlayers);
    }

}
