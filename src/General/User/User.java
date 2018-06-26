package General.User;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = 858569L;


    SimpleUser simpleUser;
    String email;
    String password;
    int ID;
    int age;
    int rate; //integer between 0 and 5
    ArrayList<User> blockList;

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

    public User(String name, String username, String email, String password, int age, int ID, String profilePictureAddress) {
        this.email = email;
        this.password = password;
        this.age = age;
        this.ID = ID;
        simpleUser = new SimpleUser(profilePictureAddress, name, username);
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
}
