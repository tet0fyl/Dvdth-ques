package models.managers;
import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import java.sql.*;

public abstract class BDDManager {
    protected Connection db = null;
    protected Statement st = null;
    protected ResultSet rs = null;

    /* CONFIG BDD */
    private String url = "jdbc:mysql://localhost/dvdtheque?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private String user = "root";
    private String password = "";

    /**
     * Methode qui permet de tester la connexion (utiliser lors de l'ecran de chargement ViewLoadScreen)
     * pour arreter l'application si il y a un probleme de connection a la bdd
     * @throws SQLException
     */
    public void checkConnection() throws SQLException{
        this.start();
        this.stop();
    }

    /**
     * Demarre la connection a la bdd
     * @throws SQLException
     */
    public void start() throws SQLException{
            db = DriverManager.getConnection(url, user, password);
    }

    /**
     * Stop la connection a la bdd
     * @throws SQLException
     */
    public void stop() throws SQLException{
            if(db != null){
                db.close();
            }
            if(st != null) {
                st.close();
            }
            if(rs != null){
                rs.close();
            }
    }
}
