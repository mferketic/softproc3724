package DomenskiObjekat;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mario
 */
public abstract class GeneralDObject implements Serializable {

    abstract public String getAtrValue();

    abstract public String getAtrValue2();

    abstract public String setAtrValue();

    abstract public String getClassName();

    abstract public String getWhereCondition();

    abstract public String getNameByColumn(int column);

    abstract public DomenskiObjekat.GeneralDObject getNewRecord(ResultSet rs) throws SQLException;

    public abstract String columnsForInsert();
}
