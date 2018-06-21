package General.User;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = 858569L;


    String name;
    String username;
    String email;
    String password;
    String profilePictureAddress;
    int ID;
    int age;
    int rate; //integer between 0 and 5
    ArrayList<User> blockList;

    public User (String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String name ,String username, String email, String password , int age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.age = age;
    }

    public User(String name ,String username, String email, String password , int age, int ID, String profilePictureAddress) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = username;
        this.age = age;
        this.ID = ID;
        this.profilePictureAddress = profilePictureAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return this.username.equals(user.username) && this.password.equals(user.password);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}