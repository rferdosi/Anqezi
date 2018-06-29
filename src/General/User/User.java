package General.User;

import ClientSide.Game.Game;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = 858569L;


    private SimpleUser simpleUser;
    private String email;
    private String password;
    private int ID;
    private int age;
    private ArrayList<SimpleUser> blockList;
    private ArrayList<Game> requestedGames;
    private int wins;
    private int losts;
    private int draws;
    private int K_Factor;

    public User(String username, String password) {
        simpleUser = new SimpleUser(username);
        this.password = password;
    }

    public User(String name, String username, String email, String password, int age) {
        this.email = email;
        this.password = password;
        this.age = age;
        simpleUser = new SimpleUser(name, username);
    }

    public User(String name, String username, String email, String password, int age, int ID,
                String profilePictureAddress) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.ID = ID;
        simpleUser = new SimpleUser(profilePictureAddress, name, username);
    }

    {
        blockList = new ArrayList<>();
        requestedGames = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return this.simpleUser.username.equals(user.simpleUser.username) && this.password.equals(user.password);
    }

    public SimpleUser getSimpleUser() {
        return simpleUser;
    }

    public String getUsername() {
        return simpleUser.username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return simpleUser.name;
    }

    public ArrayList<Game> getRequestedGames() {
        return requestedGames;
    }

    public void setSimpleUser(SimpleUser simpleUser) {
        this.simpleUser = simpleUser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
