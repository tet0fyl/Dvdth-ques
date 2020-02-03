package models;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class FilmManager extends BDDManager{

    /**
     * Get All Film
     * @return an ArrayList of Film
     */
    public ArrayList<Film> getAll () throws SQLException {
        ArrayList listOfFilm = new ArrayList();
        String query = "SELECT *" +
                "FROM Film\n" +
                "INNER JOIN Nationalite\n" +
                "ON Nationalite.Id_Nationalite = Film.Nationalite_id\n" +
                "INNER JOIN Realisateur\n" +
                "ON Realisateur.Id_Realisateur = Film.Realisateur_id\n" +
                "INNER JOIN (\n" +
                "SELECT Film.Id_Film, GROUP_CONCAT(Acteur.Id_Acteur,'/', Acteur.Nom_Acteur,'/', Acteur.Prenom_Acteur) as acteurs\n" +
                "FROM Film\n" +
                "INNER JOIN Film_Acteur\n" +
                "ON Film_Acteur.Film_id = Film.Id_Film\n" +
                "INNER JOIN Acteur\n" +
                "ON Acteur.Id_Acteur = Film_Acteur.Acteur_id\n" +
                "GROUP BY Id_Film\n" +
                ") AS FilmActeur\n" +
                "ON FilmActeur.Id_Film = Film.Id_Film\n" +
                "INNER JOIN (\n" +
                "SELECT Film.Id_Film, GROUP_CONCAT( Genre.Id_Genre,'/',Genre.Libelle_Genre) as genres\n" +
                "FROM Film\n" +
                "INNER JOIN Film_Genre\n" +
                "ON Film_Genre.Film_id = Film.Id_Film\n" +
                "INNER JOIN Genre\n" +
                "ON Genre.Id_Genre = Film_Genre.Genre_id\n" +
                "GROUP BY Id_Film) AS FilmGenre\n" +
                "ON FilmGenre.Id_Film = Film.Id_Film\n" +
                "ORDER BY Film.Id_Film DESC";
            this.start();
            st = db.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()){
                listOfFilm.add(new Film(rs.getString(Film.ID_COLNAME),
                                        rs.getString(Film.NOM_COLNAME),
                                        rs.getString(Film.ANNEE_COLNAME),
                                        rs.getString(Film.NOTE_COLNAME),
                                        rs.getString(Film.CONTENT_COLNAME),
                                        rs.getString(Film.IMG_COLNAME),
                                        rs.getString(Film.ACTEURS_COLNAME),
                                        rs.getString(Film.GENRES_COLNAME),
                                        new Realisateur( rs.getString(Realisateur.ID_COLNAME), rs.getString(Realisateur.NOM_COLNAME),rs.getString(Realisateur.PRENOM_COLNAME)),
                                        new Nationalite( rs.getString(Nationalite.ID_COLNAME), rs.getString(Nationalite.LIBELLE_COLNAME))));
            }
            this.stop();
        return listOfFilm;
    }


}
