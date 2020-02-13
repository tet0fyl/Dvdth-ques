package models.managers;
import models.Nationalite;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NationaliteManager  extends BDDManager {


    public ArrayList<Nationalite> getAll () throws SQLException {
        ArrayList listOfNationalite = new ArrayList();
        String query = "SELECT  * FROM Nationalite ";
        this.start();
        st = db.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()){
            listOfNationalite.add(new Nationalite(rs.getString(Nationalite.ID_COLNAME),
                    rs.getString(Nationalite.LIBELLE_COLNAME)

            ));
        }
        this.stop();
        return listOfNationalite;
    }

    public int insert(String valuesNationalite) throws SQLException {

        String query = "INSERT INTO `nationalite`(`Id_Nationalite`, `Libelle_Nationalite`) VALUES (null , '"+valuesNationalite+ "')";
        this.start();
        st = db.createStatement();
        st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        rs = st.getGeneratedKeys();
        rs.next();
        int result =  Integer.parseInt(rs.getString(1));
        this.stop();
        return result;
    }
}



