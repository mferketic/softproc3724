package mgmenu.listener;

import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author mario
 */
public class PlayGameListener implements EventHandler {

    mgmenu.MgMenu gamegui;

    public PlayGameListener(mgmenu.MgMenu gamegui) {
        this.gamegui = gamegui;
    }

    @Override
    public void handle(Event t) {
        gamegui.openGame();
    }

}