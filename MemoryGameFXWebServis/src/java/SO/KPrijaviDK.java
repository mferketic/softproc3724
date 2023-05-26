package SO;

import DomenskiObjekat.GeneralDObject;
import DomenskiObjekat.Korisnik;
import DomenskiObjekat.Poruka;
import TransferObjekat.GenerickiTransferObjekatKorisnik;
import java.util.ArrayList;
import java.util.List;
import static SO.OpsteIzvrsenjeSO.dbu;

/**
 *
 * @author mario
 */
public class KPrijaviDK extends OpsteIzvrsenjeSO {

    GenerickiTransferObjekatKorisnik gto;

    public void prijaviDK(GenerickiTransferObjekatKorisnik gto) {
        this.gto = gto;
        opsteIzvrsenjeSO();
    }

    @Override
    public boolean izvrsiSO() {
        Poruka p = new Poruka();
        List<GeneralDObject> l = new ArrayList<>();
        gto.signal = false;
        Korisnik k = (Korisnik) gto.vratiDK();
        if (gto.vratiDK() == null) {
            p.setSadrzaj("Greska");
            gto.postaviPoruka(p);
        }
        try {
            l = dbu.findRecord(gto.gdo,
                    " WHERE korisnickoIme='" + gto.gdo.getKorisnickoIme() + "' AND sifra='" + gto.gdo.getSifra() + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (l.size() > 0) {
            p.setSadrzaj("korisnik prijavljen");
            Korisnik kor = (Korisnik) l.get(0);
            p.setIdKorisnika(kor.getIDKorisnik());
            p.setUlogovaniKorisnik(kor);
            gto.postaviPoruka(p);
            gto.postaviSignal(true);
        } else {
            p.setSadrzaj("korisnik nije uspesno prijavljen");
            gto.postaviPoruka(p);
        }

        return gto.signal;
    }
}
