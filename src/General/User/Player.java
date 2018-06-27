package General.User;

import General.Board.Side;

public class Player {
    private Side side;
    private SimpleUser simpleUser;

    public Player(SimpleUser simpleUser, Side side) {
        this.simpleUser = simpleUser;
        this.side = side;
    }



    public SimpleUser getSimpleUser() {
        return simpleUser;
    }
}
