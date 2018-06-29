package General;

import ClientSide.Game.Game;
import General.User.SimpleUser;

import java.util.ArrayList;

public class Tournament {
    private ArrayList<SimpleUser> invitedUsers;
    private ArrayList<Game> games;

    public ArrayList<SimpleUser> getInvitedUsers() {
        return invitedUsers;
    }

    public void setInvitedUsers(ArrayList<SimpleUser> invitedUsers) {
        this.invitedUsers = invitedUsers;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }
}
