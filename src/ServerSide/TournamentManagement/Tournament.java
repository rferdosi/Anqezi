package ServerSide.TournamentManagement;

import General.Game;
import General.User.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Tournament {

    private Player winner;
    private ArrayList<Game> FinishedGames;
    private ArrayList<Game> UndoneGames;
    private ArrayList<TournamentPlayer> tournamentPlayers;
    private int currentRound = 0;

    Tournament (Player[] players, MatchMakingMethod matchMakingMethod, ScoringSystem scoringSystem){

        this.tournamentPlayers = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            TournamentPlayer player = new TournamentPlayer(players[i], 0);
            tournamentPlayers.add(player);
        }


    }

    private void RoundRobinMatchMaker(){
        Collections.shuffle(tournamentPlayers);
        for (int i = 0; i < tournamentPlayers.size(); i++){
            for (int j = 0; j < tournamentPlayers.size() - 1; j++) {
                Game game = new Game();
                game.setPlayer1(tournamentPlayers.get(i).player);
                game.setPlayer2(tournamentPlayers.get(j).player);

            }
        }
    }

}
