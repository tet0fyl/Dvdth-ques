package models;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;

import java.sql.*;

public abstract class BDDManager {
    protected Connection db = null;
    protected Statement st = null;
    protected ResultSet rs = null;

    private String url = "jdbc:mysql://localhost/Dvdtheque";
    private String user = "root";
    private String password = "";

    public void checkConnection() throws SQLException{
        this.start();
        this.stop();
    }

    public void start() throws SQLException{
            db = DriverManager.getConnection(url, user, password);
    }

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
