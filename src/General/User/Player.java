package General.User;

import General.Side;

import java.io.Serializable;

public class Player implements Serializable {
    protected Side side;
    protected SimpleUser simpleUser;
    int time;

    public Player(SimpleUser simpleUser, Side side, int time) {
        this.simpleUser = simpleUser;
        this.side = side;
        this.time = time;
    }

    public Player(SimpleUser simpleUser,Side side) {
        this.side = side;
        this.simpleUser = simpleUser;
    }

    public Player(SimpleUser simpleUser) {
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

    public int getTime() {
        return time;
    }
}
