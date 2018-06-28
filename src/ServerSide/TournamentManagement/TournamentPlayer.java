package ServerSide.TournamentManagement;

import General.User.Player;

public class TournamentPlayer implements Comparable<TournamentPlayer> {
    Player player;
    int rating;

    public TournamentPlayer(Player player, int rating) {
        this.player = player;
        this.rating = rating;
    }

    @Override
    public int compareTo(TournamentPlayer o) {
        if (this.rating > o.rating){
            return 1;
        } else if (this.rating == o.rating){
            return 0;
        } else {
            return -1;
        }
    }
}
