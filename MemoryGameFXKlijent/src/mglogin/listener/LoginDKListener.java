package mglogin.listener;

import mglogin.MgLogin;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author mario
 */
public class LoginDKListener implements EventHandler {

    MgLogin kongui;

    public LoginDKListener(MgLogin kongui) {
        this.kongui = kongui;
    }

    @Override
    public void handle(Event event) {
        kongui.prijaviDK();
    }
}
