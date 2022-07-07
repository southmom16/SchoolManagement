package QLTH.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {
    public static Connection connection;
    public static synchronized Connection openConnection(){
        if(connection != null){
            return connection;
        }
        else {
            String url = "jdbc:mysql://localhost:3306/QLTruongHoc";
            String user = "root";
            String pass = "";
            try {
                connection = DriverManager.getConnection(url, user, pass);

            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    public static synchronized void closeConnection(){
        if (connection != null){
            try{
                connection.close();
            }catch (SQLException ex){}
            finally {
                connection = null;
            }
        }
    }
}
