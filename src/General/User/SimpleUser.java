package General.User;

import java.io.Serializable;

public class SimpleUser implements Serializable {
    String profilePictureAddress;
    String name;
    String username;
    int rate;

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

    @Override
    public String toString() {
        return username;
    }

    public String getProfilePictureAddress() {
        return profilePictureAddress;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getRate() {
        return rate;
    }
}
