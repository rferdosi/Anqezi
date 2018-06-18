package ServerSide;

import General.User.User;
import General.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private User user;
    final private int ID;

    ClientHandler(Socket socket, ObjectInputStream ois, ObjectOutputStream oos, int ID) {
        this.socket = socket;
        this.oos = oos;
        this.ois = ois;
        this.ID = ID;
    }

    @Override
    public void run() {
        setUser();


    }

    private void signUp() {
        try {
            boolean isUsernameAccepted = true;
            String username = (String) ois.readObject();
            for (User user1 : Server.getRegisteredUsers()) {
                if (user1.getUsername().equals(username)) {
                    isUsernameAccepted = false;
                    break;
                }
            }
            oos.writeObject(isUsernameAccepted);
            boolean isEmailAccepted = true;
            String email = (String) ois.readObject();
            for (User user1 : Server.getRegisteredUsers()) {
                if (user1.getEmail().equals(email)) {
                    isEmailAccepted = false;
                    break;
                }
            }
            oos.writeObject(isEmailAccepted);
            if (isUsernameAccepted && isEmailAccepted) {
                user = (User) ois.readObject();
                Server.getRegisteredUsers().add(user);
                Server.saveData();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void signIn() {
        try {
            user = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean isLoggedIn = false;
        for (User user1 : Server.getRegisteredUsers()) {
            if (user1.equals(user)) {
                user = user1;
                isLoggedIn = true;
                try {
                    oos.writeObject(isLoggedIn);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        try {
            if (!isLoggedIn) {
                oos.writeObject(false);
            } else {
                oos.writeObject(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUser() {
        while (user == null) {
            try {
                Request request = (Request) ois.readObject();
                System.out.println(request);
                System.out.println(true);
                switch (request) {
                    case SIGN_IN:
                        signIn();
                        break;
                    case SIGN_UP:
                        signUp();
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
