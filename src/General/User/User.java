package General.User;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    Image profilePicture;

    String name;
    String email;
    String password;
    String username;
    int ID;
    int age;
    int rate; //integer between 0 and 5
    ArrayList<User> blockList;

    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return this.username.equals(user.username) && this.password.equals(user.password);
    }
}
