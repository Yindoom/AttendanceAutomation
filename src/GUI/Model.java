/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Attendance;
import BE.Student;
import BE.Teacher;
import BLL.BLLController;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Yindo
 */
public class Model {
    BLLController bll = new BLLController();

    public void attend(LocalDate now, int id) throws SQLException {
        bll.attend(now, id);
    }

    public List<Student> studentLogin() throws SQLException {
        return bll.studentLogin();
    }
    
    public List<Teacher> teacherLogin() throws SQLException{
        return bll.teacherLogin();
    }
    
    public List<Attendance> getStudentAttendance()  {
        return bll.getStudentAttendance();
    }
}
