package mgmenu;

import Server_client.Korisnik;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML
    public Button playGameButton;
    
    public MgMenu kngui;
    public Long idKorisnika;
    public Korisnik loggedKorisnik;
    public Stage stage;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        kngui = new MgMenu(this);
    }

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeForm() {
        stage.close();
    }

    public Long getIdKorisnik() {
        return idKorisnika;
    }

    public void setLoggedKorisnik(Korisnik kor) {
        this.loggedKorisnik = kor;
    }

    public Korisnik getLoggedKorisnik() {
        return loggedKorisnik;
    }
}
