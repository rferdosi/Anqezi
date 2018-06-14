package ClientSide.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

public class AboutController extends FatherController {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void backToMain(){
        goTo("mainMenu");
    }
}
