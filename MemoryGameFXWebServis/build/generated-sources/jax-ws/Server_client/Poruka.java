
package Server_client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for poruka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="poruka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idKorisnika" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ulogovaniKorisnik" type="{http://Server/}korisnik" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "poruka", propOrder = {
    "idKorisnika",
    "sadrzaj",
    "ulogovaniKorisnik"
})
public class Poruka {

    protected Long idKorisnika;
    protected String sadrzaj;
    protected Korisnik ulogovaniKorisnik;

    /**
     * Gets the value of the idKorisnika property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdKorisnika() {
        return idKorisnika;
    }

    /**
     * Sets the value of the idKorisnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdKorisnika(Long value) {
        this.idKorisnika = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadrzaj(String value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the ulogovaniKorisnik property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

    /**
     * Sets the value of the ulogovaniKorisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setUlogovaniKorisnik(Korisnik value) {
        this.ulogovaniKorisnik = value;
    }

}
