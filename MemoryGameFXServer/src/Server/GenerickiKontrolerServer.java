package Server;

import SO.KreirajDKRegistracija;
import TransferObjekat.GenerickiTransferObjekat;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mario
 */
public class GenerickiKontrolerServer {

    static ServerSocket ss;
    static List<Klijent> lkl = new ArrayList<>();
    static int brojKlijenta;

    public GenerickiKontrolerServer() {
    }

    public static void main(String arg[]) throws Exception {
        GenerickiKontrolerServer gks = new GenerickiKontrolerServer();
        gks.izvrsiGenerickiKontroler();
    }

    void izvrsiGenerickiKontroler() throws Exception {
        ss = new ServerSocket(8189);
        System.out.println("Server je pokrenut!");
        while (true) {
            Socket soketS = ss.accept();
            Klijent kl = new Klijent(soketS, ++brojKlijenta);
            lkl.add(kl);
        }
    }
}

class Klijent extends Thread {

    public Klijent(Socket soketS1, int brojKlijenta) {
        soketS = soketS1;
        this.brojKlijenta = brojKlijenta;
        System.out.println("Klijent:" + brojKlijenta + " je povezan!");
        start();
    }

    public void run() {
        try {

            GenerickiTransferObjekat tok;

            while (true) {
                out = new ObjectOutputStream(soketS.getOutputStream());
                in = new ObjectInputStream(soketS.getInputStream());

                tok = (GenerickiTransferObjekat) in.readObject();

                if (tok.nazivOperacije.equals("kreirajDK")) {
                    kreirajDK(tok);
                }
                out.writeObject(tok);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Socket soketS;
    ObjectOutputStream out;
    ObjectInputStream in;

    int brojKlijenta;

    private GenerickiTransferObjekat kreirajDK(GenerickiTransferObjekat gto) {
        new KreirajDKRegistracija().kreirajDK(gto);
        return gto;
    }
}
