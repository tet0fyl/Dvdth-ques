package models.managers;
import models.Acteur;
import java.sql.SQLException;
import java.sql.Statement;
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

        public int insert(String valuesActeurNom, String valuesActeurPrenom) throws SQLException {
            String query = "INSERT INTO `acteur`(`Id_Acteur`, `Nom_Acteur`, `Prenom_Acteur`) VALUES (null , '"+valuesActeurNom+ "' , '"+valuesActeurPrenom+ "')";
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






