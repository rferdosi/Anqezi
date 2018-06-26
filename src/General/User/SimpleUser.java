package General.User;

import java.io.Serializable;

public class SimpleUser implements Serializable {
    String profilePictureAddress;
    String name;
    String username;

    public SimpleUser(String username) {
        this.username = username;
    }

    public SimpleUser(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public SimpleUser(String profilePictureAddress, String name, String username) {
        this.profilePictureAddress = profilePictureAddress;
        this.name = name;
        this.username = username;
    }
}
