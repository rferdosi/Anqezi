package ClientSide.Controllers;

import General.User.SimpleUser;
import javafx.scene.control.ListCell;

public class MyListCell extends ListCell<SimpleUser> {
    @Override
    protected void updateItem(SimpleUser item, boolean empty) {
        super.updateItem(item, empty);
        setGraphic(new Field(item).getBack());
    }
}
