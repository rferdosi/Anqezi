package ServerSide;

import ClientSide.User.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<Game> games;
    private static ArrayList<ClientHandler> clientHandlers;
    private static ArrayList<User> users;

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void main(String[] args)  {
        games = new ArrayList<>();
        users = new ArrayList<>();
        clientHandlers=new ArrayList<>();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("connected");
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ClientHandler clientHandler = new ClientHandler(socket, ois, oos);
                clientHandlers.add(clientHandler);
                Thread thread = new Thread(clientHandler);
                thread.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
