package mgregister.listener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class KorisnikRegistrationListener implements EventHandler {

    mglogin.JFX02 jfx02;
    mglogin.FXMLDocumentController fxmldc;
    mgregister.FXMLDocumentController fxmldc01;
    Stage s;

    public KorisnikRegistrationListener(mgregister.FXMLDocumentController fxcon) {
        this.fxmldc01 = fxcon;
    }

    @Override
    public void handle(Event event) {
        if (jfx02 == null) {
            jfx02 = new mglogin.JFX02();
            s = new Stage();
        }
        try {
            jfx02.start(s);
            fxmldc = jfx02.getController();
            fxmldc01.closeStage();
        } catch (Exception ex) {
            Logger.getLogger(KorisnikRegistrationListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public mglogin.FXMLDocumentController vratiFXMLDocumentController() {
        return fxmldc;
    }

}
