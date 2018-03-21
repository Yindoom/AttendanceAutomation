/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.Attendance;
import BLL.BLLController;
import BE.Student;
import BE.Teacher;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
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
 * @author ZeXVex
 */
public class DALController {
    
    private ConnectionManager cm = new ConnectionManager();
    

    public void attend(Attendance attend) {
         try (Connection con = cm.getConnection()) {
            String sql
                    = "INSERT INTO Attendance"
                    + "(SId, Date, Present) "
                    + "VALUES(?,?,?)";
            PreparedStatement pstmt
                    = con.prepareStatement(
                            sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, attend.getStudentId());
            pstmt.setDate(2, attend.getSqlDate());
            pstmt.setBoolean(3, attend.isPresent());

            int affected = pstmt.executeUpdate();
            if (affected<1)
                throw new SQLException("fuck you");

        }
        catch (SQLException ex) {
            Logger.getLogger(DALController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }

    public List<Student> studentLogin() throws SQLException {
        List<Student> studentLogin
                = new ArrayList();
        
        try (Connection con = cm.getConnection()){
            PreparedStatement stmt
                    = con.prepareStatement("SELECT * FROM STUDENT");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("ID"));
                student.setUsername(rs.getString("Username"));
                student.setPassword(rs.getString("Password"));
                student.setName(rs.getString("fName"));
                student.setLname(rs.getString("lName"));
                
                studentLogin.add(student);
            }
        }
        return studentLogin;
    }
    
    public List<Teacher> teacherLogin() throws SQLException {
        List<Teacher> teacherLogin
                = new ArrayList();
        
        try (Connection con = cm.getConnection()){
            PreparedStatement stmt
                    = con.prepareStatement("SELECT * FROM STUDENT");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Teacher teacher = new Teacher();
                teacher.setId(rs.getInt("ID"));
                teacher.setUsername(rs.getString("Username"));
                teacher.setPassword(rs.getString("Password"));
                teacher.setfName(rs.getString("fName"));
                teacher.setlName(rs.getString("lName"));
                
                teacherLogin.add(teacher);
            }
        }
        return teacherLogin;
    }
    
    public List<Attendance> getStudentAttendance()  {
        List<Attendance> attendances
                = new ArrayList();
    
     try (Connection con = cm.getConnection()) {
            PreparedStatement stmt
                    = con.prepareStatement("SELECT * FROM Attendance");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Attendance attendance = new Attendance();
                attendance.setPresent(rs.getBoolean("Present"));
                attendance.setStudentId(rs.getInt("SId"));
                attendance.setSqlDate(rs.getDate("Date"));

                attendances.add(attendance);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DALController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        return attendances;
    }
    
    
}
