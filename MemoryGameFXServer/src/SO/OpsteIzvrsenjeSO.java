package SO;

import dbutils.DatabaseUtils;
import dbutils.DatabaseUtilsImpl;
import DomenskiObjekat.GeneralDObject;

/**
 *
 * @author mario
 */
public abstract class OpsteIzvrsenjeSO {

    public DatabaseUtils dbu = new DatabaseUtilsImpl();
    int recordsNumber;
    GeneralDObject gdo;

    public boolean opsteIzvrsenjeSO() {
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
