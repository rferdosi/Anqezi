package ServerSide;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SpectatorHandler extends ClientHandler {
    public SpectatorHandler(Socket socket, InputStream inputStream, OutputStream outputStream) {
        super(socket, inputStream, outputStream);
    }

    @Override
    public void run() {

    }
}
