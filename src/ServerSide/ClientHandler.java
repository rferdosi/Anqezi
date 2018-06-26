package ServerSide;

import General.Game;
import General.Request;
import General.User.SimpleUser;
import General.User.User;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private User user;
    final private int ID;
    private boolean exitRequested = false;
    private Thread myThread;


    ClientHandler(Socket socket, InputStream ois, OutputStream oos, int ID) throws IOException {
        this.socket = socket;
        this.oos = new ObjectOutputStream(oos);
        this.ois = new ObjectInputStream(ois);
        this.ID = ID;
    }

    public void setThread(Thread myThread) {
        this.myThread = myThread;
    }

    @Override
    public void run() {
        while (!exitRequested) {
            //This Part Proceed When It's On Welcoming Page
            if (user == null && !exitRequested) {
                setUser();
            }

            //During Rest Of The Game
            else {
                Request request = null;
                try {
                    request = (Request) ois.readObject();
                    System.out.println(request);
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
//                assert request != null;
                switch (request) {
                    case EXIT:
                        exitRequested = true;
                        break;
                    case GET_USERS_TO_STRING:
                        try {
                            System.out.println(request);
                            String username = ois.readUTF();
                            ArrayList<SimpleUser> users = new ArrayList<>();
                            for (User user1 : Server.getRegisteredUsers()) {
                                if (user1.getUsername().contains(username)) {
                                    users.add(user1.getSimpleUser());
                                }
                            }
                            oos.writeObject(users);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case NEW_GAME_REQUEST:
                        try {
                            System.out.println("now");
                            SimpleUser requestedUser = (SimpleUser) ois.readObject();
                            boolean isRated = ois.readBoolean();
                            Game game = new Game(user.getSimpleUser(), requestedUser, isRated);
                            oos.writeObject(game);
                            System.out.println("dn");
                            break;
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
//                        TODO adding more parts of requests like NEW_GAME and NEW_TOURNAMENT
                }
            }
        }
        System.err.println("Exiting");
        Thread.currentThread().interrupt();
    }


    private void register() {
        try {
            boolean isEmailAccepted = true;
            boolean isUsernameAccepted = true;
            boolean backRequested = false;
            do {
                Request nextReq = (Request) ois.readObject();
                switch (nextReq) {
                    case SIGN_UP:
                        String username = (String) ois.readObject();
                        for (User user1 : Server.getRegisteredUsers()) {
                            if (user1.getUsername().equals(username)) {
                                isUsernameAccepted = false;
                                break;
                            }
                        }
                        oos.writeObject(isUsernameAccepted);
                        String email = (String) ois.readObject();
                        for (User user1 : Server.getRegisteredUsers()) {
                            if (user1.getEmail().equals(email)) {
                                isEmailAccepted = false;
                                break;
                            }
                        }
                        oos.writeObject(isEmailAccepted);
                        user = (User) ois.readObject();
                        Server.getRegisteredUsers().add(user);
                        Server.saveData();
                        System.out.println("REG Done!");
                        break;
                    case BACK:
                        backRequested = true;
                        break;
                    default:
//                        System.out.println("Reg" + nextReq);
                }
            } while ((!isUsernameAccepted || !isEmailAccepted) && !backRequested);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void login() {
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
                    oos.writeObject(user);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        try {
            if (!isLoggedIn) {
                oos.writeObject(isLoggedIn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setUser() {
        loop:
        while (user == null) {
            try {
                Request request = (Request) ois.readObject();
                System.out.println(request);
                switch (request) {
                    case SIGN_IN:
                        login();
                        break;
                    case SIGN_UP:
                        register();
                        break;
                    case SEND_USER:
                        user = (User) ois.readObject();
                        break;
                    case EXIT:
                        exitRequested = true;
                        break loop;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
//                Thread thread=
            }

        }
    }

}