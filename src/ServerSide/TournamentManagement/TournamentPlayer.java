package ServerSide.TournamentManagement;

import General.Board.Side;
import General.User.Player;
import General.User.SimpleUser;

public class TournamentPlayer extends Player implements Comparable<TournamentPlayer> {
    double tournamentRating;
    int howManyTimeWhite = 0;

    public TournamentPlayer(SimpleUser simpleUser, Side side, int tournamentRating) {
        super(simpleUser, side);
        this.tournamentRating = tournamentRating;
    }

    public TournamentPlayer(SimpleUser simpleUser, int tournamentRating) {
        super(simpleUser);
        this.tournamentRating = tournamentRating;
    }

    @Override
    public int compareTo(TournamentPlayer o) {
        if (this.tournamentRating > o.tournamentRating) {
            return 1;
        } else if (this.tournamentRating == o.tournamentRating) {
            return 0;
        } else {
            return -1;
        }
    }
}
