package ServerSide;

import General.User.User;
import ServerSide.Controllers.ServerMainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Optional;

// todo import org.slf4j.Logger and use slf4j api for log

public class Server {
    public static boolean ExitRequested = false;
    public static Stage pStage;
    private static ArrayList<ClientHandler> activeClients;
    private static ArrayList<User> registeredUsers;
    private static int IDGenerator; //lastID

    static ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public static ArrayList<ClientHandler> getActiveClients() {
        return activeClients;
    }

    public static void main(String[] args) {
        loadData();
        Date date = new Date();
        registeredUsers = new ArrayList<>();
        activeClients = new ArrayList<>();
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(8569);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("New Session Started At:\t" + date.toString());
        while (!ExitRequested) {
            try {
                System.out.println(getRegisteredUsers().size());
                for (User user : getRegisteredUsers()) {
                    System.out.println(user);
                }
                clientSocket = serverSocket.accept();
                log("A new Client has connected");
                ClientHandler clientHandler = new ClientHandler
                        (clientSocket, clientSocket.getInputStream(), clientSocket.getOutputStream(), IDGenerator++);
                Thread thread = new Thread(clientHandler);
                activeClients.add(clientHandler);
                thread.start();
                clientHandler.setThread(thread);
            } catch (IOException e) {
                e.printStackTrace();
                saveData();
                log(e.getMessage() + "At\t" + date.toString());
            }
        }
        saveData();
        log("End of The Session At:\t" + date.toString());
    }


    public static void log(String message) {
        try (FileOutputStream fos = new FileOutputStream("log.txt", true);
             Formatter wLog = new Formatter(fos)) {
            wLog.format(message + "\n");
            wLog.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveData() {
        try (FileOutputStream users = new FileOutputStream("userList.yolo")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(users);
            objectOutputStream.writeObject(registeredUsers);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            log("Cant save user list");
            e.printStackTrace();
        }
    }

    public static void loadData() {
        try {
            FileInputStream users = new FileInputStream("userList.yolo");
            ObjectInputStream objectInputStream = new ObjectInputStream(users);
            registeredUsers = (ArrayList<User>) objectInputStream.readObject();
        } catch (IOException e1) {
            log("User list file not found");
        } catch (ClassNotFoundException e2) {
            log("User list can't be load");
            e2.printStackTrace();
        }
    }

}

