/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author quang
 */
public class DBconnection {
//    private static final String DB_URL = "jdbc:mysql://localhost/hotelmanager";
//    private static final String USERNAME = "your_username";
//    private static final String PASSWORD = "your_password";
//
//    private Connection connection;
//    
//    public void connect() {
//        try {
//            // Kết nối tới cơ sở dữ liệu
//            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//            System.out.println("Connected to the database.");
//        } catch (SQLException e) {
//            System.out.println("Failed to connect to the database.");
//            e.printStackTrace();
//        }
//    }
//    
//    public void disconnect() {
//        try {
//            if (connection != null) {
//                // Đóng kết nối cơ sở dữ liệu
//                connection.close();
//                System.out.println("Disconnected from the database.");
//            }
//        } catch (SQLException e) {
//            System.out.println("Failed to disconnect from the database.");
//            e.printStackTrace();
//        }
//    }
//    
//    public void executeQuery(String query) {
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//            
//            // Xử lý kết quả truy vấn
//            while (resultSet.next()) {
//                // Lấy giá trị từ các cột trong kết quả
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                // ...
//                
//                // Thực hiện các tác vụ khác với dữ liệu
//                
//                System.out.println("ID: " + id + ", Name: " + name);
//            }
//            
//            // Đóng statement và resultSet
//            statement.close();
//            resultSet.close();
//        } catch (SQLException e) {
//            System.out.println("Failed to execute the query.");
//            e.printStackTrace();
//        }
//    }
//    
//    public static void main(String[] args) {
//        DatabaseConnection databaseConnection = new DatabaseConnection();
//        databaseConnection.connect();
//        
//        // Thực hiện các truy vấn SQL
//        String query = "SELECT * FROM customers";
//        databaseConnection.executeQuery(query);
//        
//        // Ngắt kết nối cơ sở dữ liệu
//        databaseConnection.disconnect();
//    }
//    
}
