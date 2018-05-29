package ServerSide;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;

    public ClientHandler(Socket socket, InputStream inputStream, OutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {

    }
}
