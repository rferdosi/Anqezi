package General.User;

import General.Side;

public class Player {
    protected Side side;
    protected SimpleUser simpleUser;

    public Player(SimpleUser simpleUser, Side side) {
        this.simpleUser = simpleUser;
        this.side = side;
    }

    public Player(SimpleUser simpleUser){
        this.simpleUser = simpleUser;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public void setSimpleUser(SimpleUser simpleUser) {
        this.simpleUser = simpleUser;
    }

    public SimpleUser getSimpleUser() {
        return simpleUser;
    }
}
