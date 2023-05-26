package Server;

import Server_client.GenerickiKontrolerServer;
import Server_client.GenerickiTransferObjekatKorisnik;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * REST Web Service
 *
 * @author mario
 */
@Path("generickikontrolerserverport")
public class GenerickiKontrolerServerPort {

    private GenerickiKontrolerServer port;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenerickiKontrolerServerPort
     */
    public GenerickiKontrolerServerPort() {
        port = getPort();
    }

    /**
     * Invokes the SOAP method prijaviDK
     * @param arg0 resource URI parameter
     * @return an instance of javax.xml.bind.JAXBElement<Server_client.GenerickiTransferObjekatKorisnik>
     */
    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    @Path("prijavidk/")
    public JAXBElement<GenerickiTransferObjekatKorisnik> postPrijaviDK(JAXBElement<GenerickiTransferObjekatKorisnik> arg0) {
        try {
            // Call Web Service Operation
            if (port != null) {
                Server_client.GenerickiTransferObjekatKorisnik result = port.prijaviDK(arg0.getValue());
                return new JAXBElement<Server_client.GenerickiTransferObjekatKorisnik>(new QName("http//Server_client/", "generickitransferobjekatkorisnik"), Server_client.GenerickiTransferObjekatKorisnik.class, result);
            }
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }

    /**
     *
     */
    private GenerickiKontrolerServer getPort() {
        try {
            // Call Web Service Operation
            Server_client.GenerickiKontrolerServer_Service service = new Server_client.GenerickiKontrolerServer_Service();
            Server_client.GenerickiKontrolerServer p = service.getGenerickiKontrolerServerPort();
            return p;
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return null;
    }
}
