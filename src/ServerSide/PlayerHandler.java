package ServerSide;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class PlayerHandler extends ClientHandler  {
    public PlayerHandler(Socket socket, InputStream inputStream, OutputStream outputStream) {
        super(socket, inputStream, outputStream);
    }

    @Override
    public void run() {

    }
}
