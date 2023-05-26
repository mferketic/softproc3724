package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Korisnik extends GeneralDObject implements Serializable {

    Long idKorisnik;
    String korisnickoIme;
    String sifra;
    String ime;

    public Korisnik() {
        this.idKorisnik = 0L;
        this.korisnickoIme = "";
        this.sifra = "";
        this.ime = "";
    }

    public Korisnik(Long idKorisnik, String korisnickoIme, String sifra, String ime) {
        this.idKorisnik = idKorisnik;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
    }

    public Korisnik(String korisnickoIme, String sifra, String ime) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
    }

    public Korisnik(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Korisnik(Long idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public Long getIDKorisnik() {
        return this.idKorisnik;
    }

    public String getKorisnickoIme() {
        return this.korisnickoIme;
    }

    public String getSifra() {
        return this.sifra;
    }

    public String getIme() {
        return this.ime;
    }

    public void setIDKorisnika(Long idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String getAtrValue() {
        return idKorisnik + ", '" + korisnickoIme + "', '" + sifra + "', '" + ime + "'";
    }

    @Override
    public String getAtrValue2() {
        return "'" + korisnickoIme + "', '" + sifra + "', '" + ime + "'";
    }

    @Override
    public String setAtrValue() {
        return "idKorisnik=" + idKorisnik + ", " + "korisnickoIme='" + korisnickoIme + "', " + "sifra='" + sifra + "', ime='" + ime + "'";
    }

    @Override
    public String getClassName() {
        return "Korisnik";
    }

    @Override
    public String getWhereCondition() {
        return "idKorisnik=" + idKorisnik;
    }

    @Override
    public String getNameByColumn(int column) {
        String names[] = {"idKorisnik", "korisnickoIme", "sifra", "ime"};
        return names[column];
    }

    @Override
    public DomenskiObjekat.GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        return new DomenskiObjekat.Korisnik(rs.getLong("idKorisnik"), rs.getString("korisnickoIme"), rs.getString("sifra"), rs.getString("ime"));
    }

    @Override
    public String columnsForInsert() {
        return " (korisnickoIme, sifra, ime) ";
    }
}