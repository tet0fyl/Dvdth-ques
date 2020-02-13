package models.managers;
import models.Genre;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GenreManager extends BDDManager{

        public ArrayList<Genre> getAll () throws SQLException {
            ArrayList listOfGenre = new ArrayList();
            String query = "SELECT  * FROM Genre ";
            this.start();
            st = db.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()){
                listOfGenre.add(new Genre(rs.getString(Genre.ID_COLNAME),
                        rs.getString(Genre.LIBELLE_COLNAME)

                ));
            }
            this.stop();
            return listOfGenre;
        }

        public int insert(String valuesGenre) throws SQLException {
            String query = "INSERT INTO `genre`(`Id_Genre`, `Libelle_Genre`) VALUES (null , '"+valuesGenre+ "')";
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



