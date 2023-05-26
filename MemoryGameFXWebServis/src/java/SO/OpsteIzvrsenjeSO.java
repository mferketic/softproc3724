package SO;

import dbutils.DatabaseUtilsImpl;
import dbutils.DatabaseUtils;
import DomenskiObjekat.GeneralDObject;

/**
 *
 * @author mario
 */
public abstract class OpsteIzvrsenjeSO {

    static public DatabaseUtils dbu = new DatabaseUtilsImpl();
    int recordsNumber;
    GeneralDObject gdo;

    synchronized public boolean opsteIzvrsenjeSO() {
        dbu.makeConnection();
        boolean signal = izvrsiSO();
        if (signal == true) {
            dbu.commitTransation();
        } else {
            dbu.rollbackTransation();
        }
        dbu.closeConnection();
        return signal;
    }

    abstract public boolean izvrsiSO();

}
