/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLTH.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author southmom16
 */
public class ClassModify {
    public static List<Class> findAll() {
        List<Class> classList = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        Statement statement = null;
        //Lay du lieu tu database do ra
        String sql = "SELECT * FROM Class";

        try {
            statement = connection.createStatement();
            //lay du lieu tra ve
            ResultSet resultSet = statement.executeQuery(sql);
            //resultset la con tro, tro vao du lieu tra ve trong cau sql
            while (resultSet.next()){
                Class std = new Class(resultSet.getString("ClassName"));
                       
                classList.add(std);
            }
        } catch (SQLException ex) {
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return classList;
    }
    public static void insert(Class std){
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "INSERT INTO Class(ClassName) values(?)";

        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getClassName());

            statement.execute();
        } catch (SQLException ex) {
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void delete(String id){
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "DELETE FROM Class WHERE ClassName = ?";

        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, id);

            statement.execute();
        } catch (SQLException ex) {
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static List<Class> findByName(String className){
        List<Class> classList = new ArrayList<>();

        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "SELECT * FROM Class WHERE ClassName LIKE ?";
        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, "%"+className+"%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Class std = new Class(resultSet.getString("ClassName"));
                classList.add(std);
            }
        } catch (SQLException ex) {
            if (statement != null){
                try{
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return classList;
    }
    
}
