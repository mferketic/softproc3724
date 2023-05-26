package mgmenu;

import mgmenu.listener.PlayGameListener;
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class MgMenu {

    FXMLDocumentController fxcon;

    public MgMenu(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        this.fxcon = fxcon;
        this.fxcon.playGameButton.setOnAction(new PlayGameListener(this));
    }

    public void openGame() {
        mggame.JFX04 jfx06;
        Stage s;
        jfx06 = new mggame.JFX04();
        Long ulogovanogKorisnika = this.fxcon.getIdKorisnik();
        s = new Stage();
        try {
            jfx06.start(s);
            jfx06.setKorisnikData(ulogovanogKorisnika);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}