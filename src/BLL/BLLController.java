/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Attendance;
import BE.Student;
import BE.Teacher;
import DAL.DALController;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ZeXVex
 */
public class BLLController {
    DALController dal = new DALController();

    public void attend(LocalDate now, int id) throws SQLException {
        boolean attendanceRegistered = false;
        
        for (Attendance attendance : getStudentAttendance()) {
            if(now.equals(attendance.getDate()))    {
                attendanceRegistered = true;
                break;
            }
        }
        if(attendanceRegistered != true)    {
        java.sql.Date sqlDate = localToSql(now);
        
        Attendance attend = new Attendance();
        attend.setStudentId(id);
        attend.setDate(now);
        attend.setSqlDate(sqlDate);
        attend.setPresent(true);
        dal.attend(attend);
        }
    }
    
    public List<Attendance> getStudentAttendance()  {
        List<Attendance> attendance = new ArrayList();
        for (Attendance attend : dal.getStudentAttendance()) {
            java.sql.Date sqlDate = attend.getSqlDate();
            attend.setDate(sqlToLocal(sqlDate));
            attendance.add(attend);
        }
        return attendance;
    }

    public List<Student> studentLogin() throws SQLException {
        return dal.studentLogin();
    }
    
    public List<Teacher> teacherLogin() throws SQLException{
        return dal.teacherLogin();
    }
    
    public LocalDate sqlToLocal(java.sql.Date date)   {
        LocalDate localDate = date.toLocalDate();
        return localDate;
    }
    
    public java.sql.Date localToSql(LocalDate date) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        return sqlDate;
    }
}
