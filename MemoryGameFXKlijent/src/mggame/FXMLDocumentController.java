package mggame;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class FXMLDocumentController {

    @FXML
    public GridPane grid;
    @FXML
    public VBox vbox00;
    @FXML
    public VBox vbox01;
    @FXML
    public VBox vbox02;
    @FXML
    public VBox vbox03;
    @FXML
    public VBox vbox10;
    @FXML
    public VBox vbox11;
    @FXML
    public VBox vbox12;
    @FXML
    public VBox vbox13;
    @FXML
    public VBox vbox20;
    @FXML
    public VBox vbox21;
    @FXML
    public VBox vbox22;
    @FXML
    public VBox vbox23;
    @FXML
    public VBox vbox30;
    @FXML
    public VBox vbox31;
    @FXML
    public VBox vbox32;
    @FXML
    public VBox vbox33;

    @FXML
    public Button giveUp;
    @FXML
    public Button oneMoreTry;

    public Stage stage;
    public MgGame kngui;
    public Long idKorisnika;
    
    @FXML
    public void iGiveUp() {
        stage.close();
    }

    @FXML
    public void oneMore() {
        Stage s1;
        mggame.JFX04 jfx06;

        jfx06 = new mggame.JFX04();
        s1 = new Stage();
        try {
            jfx06.start(s1);
            jfx06.setKorisnikData(idKorisnika);
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void initialize() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        kngui = new MgGame(this);

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void closeStage() {
        stage.close();
    }

    public void setPicture() {
        kngui.populateCardWithPicture();
    }
    
    public void setIdKorisnika(Long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Long getLoggedKorisnik() {
        return this.idKorisnika;
    }

}