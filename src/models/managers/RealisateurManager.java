package models.managers;

import models.Realisateur;
import models.managers.BDDManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class RealisateurManager extends BDDManager {


    public ArrayList<Realisateur> getAll () throws SQLException {
        ArrayList listOfRealisateur = new ArrayList();
        String query = "SELECT  * FROM realisateur ";
        this.start();
        st = db.createStatement();
        rs = st.executeQuery(query);
        while (rs.next()){
            listOfRealisateur.add(new Realisateur(rs.getString(Realisateur.ID_COLNAME),
                    rs.getString(Realisateur.NOM_COLNAME),
                    rs.getString(Realisateur.PRENOM_COLNAME)
            ));
        }
        this.stop();
        return listOfRealisateur;
    }


}

