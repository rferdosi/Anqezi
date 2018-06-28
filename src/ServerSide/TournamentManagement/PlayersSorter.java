package ServerSide.TournamentManagement;

import java.util.Comparator;

public class PlayersSorter implements Comparator<TournamentPlayer> {
    @Override
    public int compare(TournamentPlayer o1, TournamentPlayer o2) {
        return (o1.rating - o2.rating);
    }
}
