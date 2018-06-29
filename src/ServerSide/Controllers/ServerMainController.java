package ServerSide.Controllers;

import ServerSide.Server;

import java.util.Date;

public class ServerMainController {
    public void CloseServer() {
        Server.saveData();
        Server.ExitRequested = true;
        Date date = new Date();
        Server.log("End of The Session At:\t" + date.toString());
        System.exit(0);
    }
}
