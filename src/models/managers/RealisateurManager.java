package models.managers;
import models.Realisateur;
import java.sql.SQLException;
import java.sql.Statement;
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

    public int insert(String valuesRealisateurNom, String valuesRealisateurPrenom) throws SQLException {

        String query = "INSERT INTO realisateur (`Id_Realisateur`, `Nom_Realisateur`, `Prenom_Realisateur`) VALUES (null , '"+valuesRealisateurNom+ "' , '"+valuesRealisateurPrenom+ "')";
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

