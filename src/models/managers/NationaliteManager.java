package models.managers;
import models.Nationalite;
import java.sql.SQLException;
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


}



