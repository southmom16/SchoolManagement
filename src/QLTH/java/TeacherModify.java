
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



public class TeacherModify {
    public static List<Teacher> findAll() {
        List<Teacher> teachertList = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        Statement statement = null;
        //Lay du lieu tu database do ra
        String sql = "SELECT * FROM Teacher";

        try {
            statement = connection.createStatement();
            //lay du lieu tra ve
            ResultSet resultSet = statement.executeQuery(sql);
            //resultset la con tro, tro vao du lieu tra ve trong cau sql
            while (resultSet.next()){
                Teacher std = new Teacher(resultSet.getString("TeacherID"),
                        resultSet.getString("TeacherName"),
                        resultSet.getString("Address"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),

                        resultSet.getString("Nationality"),

                        resultSet.getString("Specialization"));
                teachertList.add(std);
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
        return teachertList;
    }
    public static void insert(Teacher std){
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "INSERT INTO Teacher(TeacherID, TeacherName, Address, Email, PhoneNumber, Nationality, Specialization) values(?, ?, ?, ?, ?, ?, ?)";

        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getId());
            statement.setString(2, std.getName());
            statement.setString(3, std.getAddress());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            statement.setString(6, std.getNationality());
            statement.setString(7, std.getSpecialization());

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
    public static void update(Teacher std){
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "UPDATE Teacher SET TeacherName=?, Address=?, Email=?, PhoneNumber=?, Nationality=?, Specialization=? WHERE TeacherID=?";

        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getName());
            statement.setString(2, std.getAddress());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getPhoneNumber());
            statement.setString(5, std.getNationality());
            statement.setString(6, std.getSpecialization());
            statement.setString(7, std.getId());

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
        String sql = "DELETE FROM Teacher WHERE TeacherID = ?";

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
    public static List<Teacher> findByName(String name){
        List<Teacher> teacherList = new ArrayList<>();

        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "SELECT * FROM Teacher WHERE TeacherName LIKE ?";
        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, "%"+name+"%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Teacher std = new Teacher(resultSet.getString("TeacherID"),
                        resultSet.getString("TeacherName"),
                        resultSet.getString("Address"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("Nationality"),
                        resultSet.getString("Specialization"));
                teacherList.add(std);
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
        return teacherList;
    }
  
}

