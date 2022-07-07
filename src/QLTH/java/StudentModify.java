
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



public class StudentModify {
    public static List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        Statement statement = null;
        //Lay du lieu tu database do ra
        String sql = "SELECT * FROM Student";

        try {
            statement = connection.createStatement();
            //lay du lieu tra ve
            ResultSet resultSet = statement.executeQuery(sql);
            //resultset la con tro, tro vao du lieu tra ve trong cau sql
            while (resultSet.next()){
                Student std = new Student(resultSet.getString("StudentID"),
                        resultSet.getString("StudentName"),
                        resultSet.getString("Address"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),

                        resultSet.getString("Nationality"),

                        resultSet.getString("ClassName"));
                studentList.add(std);
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
        return studentList;
    }
    public static void insert(Student std){
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "INSERT INTO Student(StudentID, StudentName, Address, Email, PhoneNumber, Nationality, ClassName) values(?, ?, ?, ?, ?, ?, ?)";

        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getId());
            statement.setString(2, std.getName());
            statement.setString(3, std.getAddress());
            statement.setString(4, std.getEmail());
            statement.setString(5, std.getPhoneNumber());
            statement.setString(6, std.getNationality());
            statement.setString(7, std.getClassName());

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
    public static void update(Student std){
        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "UPDATE Student SET StudentName=?, Address=?, Email=?, PhoneNumber=?, Nationality=?, ClassName=? WHERE StudentID=?";

        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, std.getName());
            statement.setString(2, std.getAddress());
            statement.setString(3, std.getEmail());
            statement.setString(4, std.getPhoneNumber());
            statement.setString(5, std.getNationality());
            statement.setString(6, std.getClassName());
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
        String sql = "DELETE FROM Student WHERE StudentID = ?";

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
    public static List<Student> findByName(String name){
        List<Student> studentList = new ArrayList<>();

        Connection connection = ConnectionDB.openConnection();
        PreparedStatement statement = null;
        //query
        String sql = "SELECT * FROM Student WHERE StudentName LIKE ?";
        try {
            statement = connection.prepareCall(sql);

            statement.setString(1, "%"+name+"%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student std = new Student(resultSet.getString("StudentID"),
                        resultSet.getString("StudentName"),
                        resultSet.getString("Address"),
                        resultSet.getString("Email"),
                        resultSet.getString("PhoneNumber"),
                        resultSet.getString("Nationality"),
                        resultSet.getString("ClassName"));
                studentList.add(std);
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
        return studentList;
    }
  
}
