package mgmenu;

import Server_client.Korisnik;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class JFX03 extends Application {

    FXMLDocumentController con;

    @Override
    public void start(Stage stage) throws Exception {
        String resourcePath = "FXMLDocument.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        Parent root = fxmlLoader.load();
        con = (FXMLDocumentController) fxmlLoader.getController();
        con.setStage(stage);
        Scene scene = new Scene(root);
        scene.getStylesheets().add("CSS/stylesheet.css");
        stage.setScene(scene);
        stage.setTitle("Softverski proces");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public mgmenu.FXMLDocumentController getController() {
        return con;
    }

    public void closeStage() {
        con.stage.close();
    }

    public void setLoggedKorisnik(Long id) {
        con.idKorisnika = id;
    }

    public Long getLoggedKorisnik() {
        return con.idKorisnika;
    }

    public void setKorisnik(Korisnik kor) {
        con.loggedKorisnik = kor;
    }

    public Korisnik getKorisnik() {
        return con.loggedKorisnik;
    }

}
