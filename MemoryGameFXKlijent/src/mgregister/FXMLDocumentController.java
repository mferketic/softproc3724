package mgregister;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLDocumentController {

    @FXML
    public TextField imeKorisnik;
    @FXML
    public TextField korisnickoIme;
    @FXML
    public PasswordField sifraKorisnik;
    @FXML
    public Button registerButton;
    @FXML
    public Button loginButton;

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException {
        MgRegister mgRegister = new MgRegister(this);
    }

    public Stage stage;

    void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

}
