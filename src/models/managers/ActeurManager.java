package models.managers;

import models.Acteur;

import java.sql.SQLException;
import java.util.ArrayList;

public class ActeurManager  extends BDDManager {


        public ArrayList<Acteur> getAll () throws SQLException {
            ArrayList listOfActeur = new ArrayList();
            String query = "SELECT  * FROM Acteur ";
            this.start();
            st = db.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()){
                listOfActeur.add(new Acteur(rs.getString(Acteur.ID_COLNAME),
                        rs.getString(Acteur.NOM_COLNAME),
                        rs.getString(Acteur.PRENOM_COLNAME)
                ));
            }
            this.stop();
            return listOfActeur;
        }


    }



