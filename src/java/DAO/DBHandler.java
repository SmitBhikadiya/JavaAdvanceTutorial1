/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.UserDetailes;

/**
 *
 * @author Smit Bhikadiya
 */
public class DBHandler {
    
    public static Connection conn = null;
    
    public DBHandler() {
        System.out.println(">>>Hello from DHHandler class Constructor");
    }
    
    public static Connection establishConnection(){
        conn = null;
        try {
            // step-1 : load jdbc driver from static forName method of `Class` name class
            Class.forName("com.mysql.jdbc.Driver");
            
            // step-2 : connect to the database using database url
            String mysqlURL = "jdbc:mysql://localhost:3306/javadatabase?user=root";
            conn = (Connection) DriverManager.getConnection(mysqlURL);
                
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return conn;
    }
    
    public static void closeConnection(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String insert(UserDetailes obj){
        conn = establishConnection();
        try {
            // step-3 create preparedstatment obje to execute query
            String query = "Insert into tutorial1 (Username, Address, Age, Gender) Values (?,?,?,?)";
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);
            st.setString(1, obj.getUsername());
            st.setString(2, obj.getAddress());
            st.setInt(3, obj.getAge());
            st.setString(4, obj.getGender());
        
            //step-4 exceute query
            st.executeUpdate();
            return "Data Inserted Successfully";
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            // step-5 Close the connection
            closeConnection();
        }
        return "<h1 class='errormsg'>Data failed to insert</h1>";
    }
    
    public static String update(UserDetailes obj){
        
        String username = obj.getUsername();
        String address = obj.getAddress();
        String gender = obj.getGender();
        int age = obj.getAge();
        String updateQuery = "UPDATE tutorial1 SET Username = ?,address=?,age=?,gender=? WHERE Username = ?";
        conn = establishConnection();
        
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(updateQuery);
            st.setString(1, username);
            st.setString(2, address);
            st.setInt(3, age);
            st.setString(4, gender);
            st.setString(5, username);
            st.executeUpdate();
            return "<h1>Update user's("+username+") data successfully";
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnection();
        }
        return "<h1 class='errormsg'>Username not Found</h1>";
    }
    
    public static String delete(UserDetailes obj){
        String username = obj.getUsername();
        String deleteQuery = "DELETE FROM tutorial1 WHERE Username = ?";
        conn = establishConnection();
        
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(deleteQuery);
            st.setString(1, username);
            st.executeUpdate();
            return "<h1>Delete user's("+username+") data successfully";
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnection();
        }
        return "<h1 class='errormsg'>Username not found</h1>";
    }
    
    public static String select(){
        String selectQuery = "SELECT * FROM tutorial1";
        String data = "";
        conn = establishConnection();
        
        try {
            PreparedStatement st = (PreparedStatement) conn.prepareStatement(selectQuery);
            ResultSet result = st.executeQuery();
            String row;
            while(result.next()){
                row = "\nName: "+result.getString("Username")+"\nAddress: "+result.getString("Address")+"\nAge: "+String.valueOf(result.getInt("Age"))+"\nGender: "+result.getString("Gender")+"\n\n\n";
                data += row;
            }
            
            return data;
            
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "<h1 class='errormsg'> Not found any data </h1>"; 
    }
}
