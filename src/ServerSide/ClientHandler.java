package ServerSide;

import ClientSide.User.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private User user;

    public ClientHandler(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
        this.socket = socket;
        this.oos = oos;
        this.ois = ois;
    }

    @Override
    public void run() {
        while (user == null) {
            setUser();
       }


    }

    private void setUser() {
        try {
            user = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        boolean isLoggedIn = false;
        for (User user1 : Server.getUsers()) {
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

}
