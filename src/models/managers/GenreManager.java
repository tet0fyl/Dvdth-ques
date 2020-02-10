package models.managers;
import models.Genre;
import java.sql.SQLException;
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


    }



