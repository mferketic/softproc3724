package mglogin;

import mglogin.listener.LoginDKListener;

import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiKontrolerServer_Service;
import Server_client.GenerickiTransferObjekatKorisnik;
import Server_client.Korisnik;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class MgLogin {

    FXMLDocumentController fxcon;

    GenerickiTransferObjekatKorisnik gto;

    GenerickiKontrolerServer_Service service;
    GenerickiKontrolerServer kal;

    public MgLogin(FXMLDocumentController fxcon) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException, FileNotFoundException, ClassNotFoundException {
        this.fxcon = fxcon;
        this.fxcon.loginButton.setOnAction(new LoginDKListener(this));
        service = new GenerickiKontrolerServer_Service();
        kal = service.getGenerickiKontrolerServerPort();
        gto = new GenerickiTransferObjekatKorisnik();
    }

    public void prijaviDK() {
        Korisnik loggingKorisnik = new Korisnik();
        loggingKorisnik.setKorisnickoIme(fxcon.korisnickoIme.getText());
        loggingKorisnik.setSifra(fxcon.sifraKorisnik.getText());
        gto.setGdo(loggingKorisnik);
        gto = kal.prijaviDK(gto);
        if (gto.getTekst().getSadrzaj().equals("korisnik prijavljen")) {
            mgmenu.JFX03 jfx03;
            Stage s;
            jfx03 = new mgmenu.JFX03();
            s = new Stage();
            try {
                jfx03.start(s);
                jfx03.setLoggedKorisnik(gto.getTekst().getIdKorisnika());
                jfx03.setKorisnik(gto.getTekst().getUlogovaniKorisnik());
                this.fxcon.closeStage();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
            infoAlert.setTitle("ERROR:");
            infoAlert.setHeaderText(null);
            infoAlert.setContentText("Check your credentials!");
            infoAlert.showAndWait();
        }
    }

    String transferObjekatPoruka() {
        return gto.getTekst().getSadrzaj();
    }

    public GenerickiTransferObjekatKorisnik vratiTransferObjekat() {
        return gto;
    }
}
