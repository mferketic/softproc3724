package mgutils;

/**
 *
 * @author mario
 */
import DomenskiObjekat.GeneralDObject;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class DatabaseUtils {

    public abstract boolean makeConnection();

    public abstract boolean insertRecord(GeneralDObject odo);

    public abstract boolean updateRecord(GeneralDObject odo, GeneralDObject odoold);

    public abstract boolean updateRecord(GeneralDObject odo);

    public abstract boolean deleteRecord(GeneralDObject odo);

    public abstract boolean deleteRecords(GeneralDObject odo, String where);

    public abstract GeneralDObject findRecord(GeneralDObject odo);

    public abstract List<GeneralDObject> findRecord(GeneralDObject odo, String where);

    public abstract boolean commitTransation();

    public abstract boolean rollbackTransation();
    
    public abstract void closeConnection();

    public abstract GeneralDObject getRecord(GeneralDObject odo, int index);

    public abstract int getRecordsNumber(GeneralDObject odo);

    public abstract PreparedStatement insert(GeneralDObject gdo) throws SQLException;
}
