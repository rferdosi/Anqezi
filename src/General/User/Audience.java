package General.User;

import java.io.Serializable;

public class Audience extends User implements Serializable {
    public Audience(String username, String password) {
        super(username, password);
    }
}
