package SO;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Poruka;
import TransferObjekat.GenerickiTransferObjekat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mario
 */
public class KreirajDKRegistracija extends OpsteIzvrsenjeSO {

    GenerickiTransferObjekat gto;

    public void kreirajDK(GenerickiTransferObjekat gto) {
        this.gto = gto;
        opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {
        Poruka p = new Poruka();
        gto.setSignal(false);
        if (gto.getDK() == null) {
            p.setPoruka("Greska");
            gto.setPoruka(p);
        }

        if (korisnikAlreadyExists(gto)) {
            gto.setSignal(false);
            return gto.getSignal();
        }

        try {
            PreparedStatement ps = dbu.insert(gto.getDK());
            ResultSet tableKeys = ps.getGeneratedKeys();
            tableKeys.next();
            Long korisnikID = tableKeys.getLong(1);

            Korisnik sacuvaniKor = (Korisnik) gto.getDK();
            sacuvaniKor.setIDKorisnika(korisnikID);
            gto.setDK(sacuvaniKor);

            p.setPoruka("Uspesna registracija");
            p.setIdKorisnika(korisnikID);
            p.setUlogovaniKorisnik(sacuvaniKor);

            gto.setPoruka(p);
            gto.setSignal(true);

        } catch (SQLException ex) {
            p.setPoruka("Nije uspela registracija!");
            gto.setPoruka(p);
        }

        return gto.getSignal();
    }

    private boolean korisnikAlreadyExists(GenerickiTransferObjekat gto) {
        Poruka p = new Poruka();
        List<GeneralDObject> find = dbu.findRecord(gto.getDK(),
                " WHERE korisnickoIme='" + ((Korisnik) gto.getDK()).getKorisnickoIme() + "' AND sifra='" + ((Korisnik) gto.getDK()).getSifra() + "'");

        if (!find.isEmpty()) {
            p.setPoruka("Taj Korisnik vec postoji!!!");
            gto.setPoruka(p);
            return true;
        }
        return false;
    }
}
