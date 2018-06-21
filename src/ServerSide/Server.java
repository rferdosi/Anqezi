package ServerSide;

import General.Game;
import General.User.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class Server {
    private static ArrayList<Game> games;
    private static ArrayList<ClientHandler> activeClients;
    private static ArrayList<User> registeredUsers;
    public static boolean ExitRequested = false;
    public static File file;
    private static int IDGenerator = 0;

    public static ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public static ArrayList<ClientHandler> getActiveClients() {
        return activeClients;
    }

    public static void main(String[] args) {
        try {
            loadData();
            for (User user : getRegisteredUsers()) {
                System.out.println(user.getUsername());
                System.out.println(user.getName());
            }
        } catch (IOException ignored) {
        }

        Date date = new Date();
        games = new ArrayList<>();
        registeredUsers = new ArrayList<>();
        activeClients = new ArrayList<>();
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        try {
            serverSocket = new ServerSocket(8569);
        } catch (IOException e) {
            e.printStackTrace();
        }
        file = new File("log.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("New Session Started At:        " + date.toString());
        while (!ExitRequested) {
            try {
                clientSocket = serverSocket.accept();
                log("A new Client has connected");
                ClientHandler clientHandler = new ClientHandler(clientSocket, clientSocket.getInputStream(), clientSocket.getOutputStream(), IDGenerator++);

                Thread thread = new Thread(clientHandler);
                activeClients.add(clientHandler);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log("End of The Session At:         " + date.toString());

    }

    public static void log(String message) {
        try {
            FileWriter wLog = new FileWriter(Server.file, true);
            wLog.write(message + "\n");
            wLog.flush();
            wLog.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void saveData() throws IOException {
        FileOutputStream fout = new FileOutputStream("userList.yolo");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fout);
        objectOutputStream.writeObject(registeredUsers);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    static void loadData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("userList.yolo");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        try {
            registeredUsers = (ArrayList<User>) objectInputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
