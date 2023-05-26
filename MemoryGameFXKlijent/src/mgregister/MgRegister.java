package mgregister;

import DomenskiObjekat.Korisnik;
import mgregister.listener.CreateDKListener;
import mgregister.listener.KorisnikRegistrationListener;
import TransferObjekat.GenerickiTransferObjekat;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.scene.control.Alert;

/**
 *
 * @author mario
 */
public class MgRegister {

    FXMLDocumentController fxcon;
    Socket soket;
    ObjectOutputStream out;
    ObjectInputStream in;

    GenerickiTransferObjekat gto;
    KorisnikRegistrationListener krl;

    public MgRegister(FXMLDocumentController fxcon) throws IOException {
        this.fxcon = fxcon;
        krl = new KorisnikRegistrationListener(fxcon);

        this.fxcon.registerButton.setOnAction(new CreateDKListener(this));
        this.fxcon.loginButton.setOnAction(krl);

        soket = new Socket("127.0.0.1", 8189);
        gto = new GenerickiTransferObjekat();

    }

    public void alertBoxShow(String poruka) {
        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setTitle("Info:");
        infoAlert.setHeaderText(null);
        infoAlert.setContentText(poruka);
        infoAlert.showAndWait();
    }

    public void kreirajDK() {
        if (isFilledAllFields()) {
            Korisnik kor = new Korisnik();
            kor.setKorisnickoIme(fxcon.korisnickoIme.getText());
            kor.setSifra(fxcon.sifraKorisnik.getText());
            kor.setIme(fxcon.imeKorisnik.getText());
            gto.setDK(kor);
            pozivSO("kreirajDK");
            alertBoxShow(gto.getPoruka().getPoruka());
        } else {
            alertBoxShow("Sva polja moraju biti popunjena!");
        }
    }

    public void pozivSO(String nazivSO) {
        gto.setNazivOperacije(nazivSO);
        try {
            out = new ObjectOutputStream(soket.getOutputStream());
            in = new ObjectInputStream(soket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            out.writeObject(gto);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            gto = (GenerickiTransferObjekat) in.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private boolean isFilledAllFields() {
        String korIme = this.fxcon.korisnickoIme.getText();
        String sifra = this.fxcon.sifraKorisnik.getText();
        String ime = this.fxcon.imeKorisnik.getText();

        if (!korIme.isEmpty() && !sifra.isEmpty() && !ime.isEmpty()) {
            return true;
        }
        return false;
    }
    
}