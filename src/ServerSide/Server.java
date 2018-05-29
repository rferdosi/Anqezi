package ServerSide;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ArrayList<ClientHandler> clientHandlers;

    public static void main(String[] args) throws IOException {
        clientHandlers = new ArrayList<>();
        while (true) {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            ClientHandler clientHandler = new ClientHandler(socket, inputStream, outputStream);
            clientHandlers.add(clientHandler);
            Thread thread = new Thread(clientHandler);
            thread.run();

        }
    }
}
