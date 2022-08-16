/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.Student;

/**
 *
 * @author tuaan
 */
public class ConJDBC {
    public static List<Student>findAll(){
        List<Student> studentl = new ArrayList<>();        
        
        String url = "jdbc:mysql://localhost:3306/student_management";
        String user = "root";
        String password = "";
        Connection con = null;
        
        Statement stm = null;
        try {
            
            con = DriverManager.getConnection(url, user, password);
            
            String sql = "select * from student";
            stm = con.createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Student st = new Student(rs.getInt("id"), rs.getString("fullname"), rs.getString("genger"), rs.getString("email"), rs.getString("phone_number"), rs.getInt("age"));
                studentl.add(st);
            }
         
        } catch (SQLException e) {
            Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            
            if(stm != null){
                try {
                    stm.close();;
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);

                }
            }
            
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return studentl;
    }
    
    public static void insert(Student st) {
        String url = "jdbc:mysql://localhost:3306/student_management";
        String user = "root";
        String password = "";
        Connection con = null;
        
        PreparedStatement stm = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            
            String sql = "insert into student(fullname, gender, email, phone_number, age) values (?,?,?,?,?)";
            stm = con.prepareCall(sql);
            
            stm.setString(1, st.getFullname());
            stm.setString(2, st.getGender());
            stm.setInt(3, st.getAge());
            stm.setString(4, st.getEmail());
            stm.setString(5, st.getPhoneNumber());
            
            stm.execute();
         
        } catch (SQLException e) {
            Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            
            if(stm != null){
                try {
                    stm.close();;
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);

                }
            }
            
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
    }
    
    public static void update(Student st) {
        String url = "jdbc:mysql://localhost:3306/student_management";
        String user = "root";
        String password = "";
        Connection con = null;
        
        PreparedStatement stm = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            
            String sql = "update student set fullname =?, gender=?,age=?,email=?,phone_number=? where id=?";
            stm = con.prepareCall(sql);
            
            stm.setString(1, st.getFullname());
            stm.setString(2, st.getGender());
            stm.setInt(3, st.getAge());
            stm.setString(4, st.getEmail());
            stm.setString(5, st.getPhoneNumber());
            stm.setInt(6, st.getId());
            
            stm.execute();
         
        } catch (SQLException e) {
            Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            
            if(stm != null){
                try {
                    stm.close();;
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);

                }
            }
            
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
    }
    
    public static void delete(int id) {
        String url = "jdbc:mysql://localhost:3306/student_management";
        String user = "root";
        String password = "";
        Connection con = null;
        
        PreparedStatement stm = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            
            String sql = "delete from student where id =?";
            stm = con.prepareCall(sql);
            
            stm.setInt(1, id);
            
            stm.execute();
         
        } catch (SQLException e) {
            Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            
            if(stm != null){
                try {
                    stm.close();;
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);

                }
            }
            
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
    }
    
    public static List<Student>findByName(String fullname){
        List<Student> studentl = new ArrayList<>();        
        
        String url = "jdbc:mysql://localhost:3306/student_management";
        String user = "root";
        String password = "";
        Connection con = null;
        
        PreparedStatement stm = null;
        try {
            
            con = DriverManager.getConnection(url, user, password);
            
            String sql = "select * from student where fullname like ?";
            stm = con.prepareCall(sql);
            stm.setString(1, fullname);
            
            
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                Student st = new Student(rs.getInt("id"), rs.getString("fullname"), rs.getString("genger"), rs.getString("email"), rs.getString("phone_number"), rs.getInt("age"));
                studentl.add(st);
            }
         
        } catch (SQLException e) {
            Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
        } finally{
            
            if(stm != null){
                try {
                    stm.close();;
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);

                }
            }
            
            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    Logger.getLogger(ConJDBC.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return studentl;
    }
    
}


