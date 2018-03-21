/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Attendance;
import BE.Student;
import DAL.DALController;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author ZeXVex
 */
public class BLLController {
    DALController dal = new DALController();

    public void attend(LocalDate now, int id) throws SQLException {
        java.sql.Date sqlDate = java.sql.Date.valueOf(now);
        dal.attend(sqlDate, id);
    }

    public Student studentLogin() throws SQLException {
        return dal.studentLogin();
    }
    
}
