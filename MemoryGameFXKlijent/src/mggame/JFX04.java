package mggame;

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
public class JFX04 extends Application {

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
        stage.setTitle("GOOD LUCK!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public FXMLDocumentController getController() {
        return this.con;
    }

    public void setKorisnikData(Long idKorisnika) {
        con.setIdKorisnika(idKorisnika);
    }

}
