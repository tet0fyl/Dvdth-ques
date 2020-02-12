package models.managers;

import models.Film;
import models.Nationalite;
import models.Realisateur;

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

    /**
     *   Get One Film
     * */
    public ArrayList<Film> getAll (byte limit) throws SQLException {
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
                "ORDER BY Film.Id_Film DESC LIMIT " + limit;
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

    /**
    *   Get One Film
    * */
    public ArrayList<Film> getOneFilm (int idFilm) throws SQLException {
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
                "WHERE Film."+ Film.ID_COLNAME +" LIKE '" + idFilm + "'";
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

    /**
     * Insert Film BDD
     * @throws SQLException
     */
    public void insertFilm() throws SQLException{
        //TODO : Faire la ou les requetes d'insert
        String query = "" ;
        this.start();
        st = db.createStatement();
        rs = st.executeQuery(query);
        this.stop();
    }

    /**
     * Delete Film
     * @param id id du film
     * @throws SQLException
     */
    public void deleteFilm(int id) throws SQLException{
        this.start();
        st = db.createStatement();
        String query = "DELETE FROM Film_Acteur WHERE " + Film.ID_ASSOC_COLNAME + "=" + id + " ;";
        st.executeUpdate(query);
        query = " DELETE FROM Film_Genre WHERE " + Film.ID_ASSOC_COLNAME + "=" + id + " ;";
        st.executeUpdate(query);
        query = " DELETE FROM Film WHERE " + Film.ID_COLNAME + "=" + id + " ;";
        st.executeUpdate(query);
        System.out.println(query);
        this.stop();
    }
    public int insert(String valuesNomFilm, int valuesAnnee, int valuesNote, String valuesDescription ) throws SQLException {
        String query = "INSERT INTO `film`(`Id_Film`, `Nom_Film`, `Annee_Film`, `Note_Film`, `Content_Film`, `Img_Film`, `Realisateur_id`, `Nationalite_id`) VALUES " +
                "(null , '"+valuesNomFilm+ "' , "+valuesAnnee+ ", "+valuesNote+ " , '"+valuesDescription+ "', null, null )";
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
