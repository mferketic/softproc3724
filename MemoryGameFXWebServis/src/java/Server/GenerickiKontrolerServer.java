package Server;

import SO.KPrijaviDK;
import TransferObjekat.GenerickiTransferObjekatKorisnik;
import javax.jws.WebService;

/**
 *
 * @author mario
 */
@WebService(serviceName = "GenerickiKontrolerServer")
public class GenerickiKontrolerServer {

    /**
     * This is a sample web service operation
     */
    public GenerickiTransferObjekatKorisnik prijaviDK(GenerickiTransferObjekatKorisnik gto) {
        new KPrijaviDK().prijaviDK(gto);
        return gto;
    }
}
