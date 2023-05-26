
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prijaviDKResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prijaviDKResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://Server/}generickiTransferObjekatKorisnik" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prijaviDKResponse", propOrder = {
    "_return"
})
public class PrijaviDKResponse {

    @XmlElement(name = "return")
    protected GenerickiTransferObjekatKorisnik _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link GenerickiTransferObjekatKorisnik }
     *     
     */
    public GenerickiTransferObjekatKorisnik getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenerickiTransferObjekatKorisnik }
     *     
     */
    public void setReturn(GenerickiTransferObjekatKorisnik value) {
        this._return = value;
    }

}
