package ServerSide;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<Game> games;
    private static ArrayList<ClientHandler>clientHandlers;

    public static void main(String[] args) throws IOException {
        games = new ArrayList<>();
        while (true) {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ClientHandler clientHandler = new ClientHandler(socket, ois, oos);
            clientHandlers.add(clientHandler);
            Thread thread = new Thread(clientHandler);
            thread.run();
        }
    }
}
