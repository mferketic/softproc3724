
package Server_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Server_client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PrijaviDKResponse_QNAME = new QName("http://Server/", "prijaviDKResponse");
    private final static QName _PrijaviDK_QNAME = new QName("http://Server/", "prijaviDK");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Server_client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrijaviDKResponse }
     * 
     */
    public PrijaviDKResponse createPrijaviDKResponse() {
        return new PrijaviDKResponse();
    }

    /**
     * Create an instance of {@link PrijaviDK }
     * 
     */
    public PrijaviDK createPrijaviDK() {
        return new PrijaviDK();
    }

    /**
     * Create an instance of {@link Poruka }
     * 
     */
    public Poruka createPoruka() {
        return new Poruka();
    }

    /**
     * Create an instance of {@link GenerickiTransferObjekatKorisnik }
     * 
     */
    public GenerickiTransferObjekatKorisnik createGenerickiTransferObjekatKorisnik() {
        return new GenerickiTransferObjekatKorisnik();
    }

    /**
     * Create an instance of {@link Korisnik }
     * 
     */
    public Korisnik createKorisnik() {
        return new Korisnik();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrijaviDKResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "prijaviDKResponse")
    public JAXBElement<PrijaviDKResponse> createPrijaviDKResponse(PrijaviDKResponse value) {
        return new JAXBElement<PrijaviDKResponse>(_PrijaviDKResponse_QNAME, PrijaviDKResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrijaviDK }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Server/", name = "prijaviDK")
    public JAXBElement<PrijaviDK> createPrijaviDK(PrijaviDK value) {
        return new JAXBElement<PrijaviDK>(_PrijaviDK_QNAME, PrijaviDK.class, null, value);
    }

}
