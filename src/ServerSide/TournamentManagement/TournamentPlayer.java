package ServerSide.TournamentManagement;

import General.User.Player;

public class TournamentPlayer {
    Player player;
    double rating;

    public TournamentPlayer(Player player, double rating) {
        this.player = player;
        this.rating = rating;
    }
}
