package mgregister.listener;

import mgregister.MgRegister;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author mario
 */
public class CreateDKListener implements EventHandler{

    MgRegister kongui;

    public CreateDKListener(MgRegister kongui) {
        this.kongui = kongui;
    }

    @Override
    public void handle(Event t) {
        kongui.kreirajDK();
    }
    
}
