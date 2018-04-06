/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Attendance;
import BE.DateReference;
import BE.Student;
import BE.Teacher;
import DAL.DALController;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
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
    
    private final ObservableList<Attendance> aList
            = FXCollections.observableArrayList();

    DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

    public void attend(LocalDate now, int id) {
        if (!dayOfWeek.equals(java.time.DayOfWeek.SATURDAY) || !dayOfWeek.equals(java.time.DayOfWeek.SUNDAY)) {
            boolean attendanceRegistered = false;

            for (Attendance attendance : getStudentAttendance(id)) {
                if (now.equals(attendance.getDate())) {
                    attendanceRegistered = true;
                    break;
                }
            }
            if (attendanceRegistered != true) {
                java.sql.Date sqlDate = localToSql(now);

                Attendance attend = new Attendance();
                attend.setStudentId(id);
                attend.setDate(now);
                attend.setSqlDate(sqlDate);
                attend.setPresent(true);
                dal.attend(attend);
            }
        }
    }

    public List<Attendance> getStudentAttendance(int id) {
        List<Attendance> attendance = new ArrayList();
        for (Attendance attend : dal.getStudentAttendance(id)) {
            java.sql.Date sqlDate = attend.getSqlDate();
            attend.setDate(sqlToLocal(sqlDate));
            attendance.add(attend);
        }
        return attendance;
    }

    public List<Student> studentLogin() throws SQLException {
        return dal.studentLogin();
    }

    public List<Teacher> teacherLogin() throws SQLException {
        return dal.teacherLogin();
    }

    public LocalDate sqlToLocal(java.sql.Date date) {
        LocalDate localDate = date.toLocalDate();
        return localDate;
    }

    public java.sql.Date localToSql(LocalDate date) {
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        return sqlDate;
    }

    public List<Student> getTeacherStudents(int id) {
        List<Student> students = new ArrayList();
        for (Student teacherStudent : dal.getTeacherStudents(id)) {
            teacherStudent.setAbsencePercentage(calculatePercentage(teacherStudent.getId()));
            students.add(teacherStudent);
        }
        System.out.println(students);
        return students;
    }

    public List<DateReference> getDateReferences() {
        return dal.getDateReferences();
    }

    public void makeDateReference() {
        boolean needsReference = false;
        for (DateReference dateReference : dal.getDateReferences()) {
            if (!dateReference.getDate().equals(LocalDate.now())) {
                needsReference = true;
            } else {
                needsReference = false;
                break;
            }
        }

        if (needsReference) {
            if (dayOfWeek.equals(java.time.DayOfWeek.SATURDAY) || dayOfWeek.equals(java.time.DayOfWeek.SUNDAY)) {
                return;
            } else {
                dal.makeDateReference(LocalDate.now());
            }
        }
    }

    private double calculatePercentage(int id) {
        double dateReference = dal.getDateReferences().size();
        double attendance = dal.getStudentAttendance(id).size();
        double percentage = attendance / dateReference * 100;

        return percentage;
    }

    public void setAllAttendance(int studentId) {
        aList.clear();
        boolean needsNewAttendance = true;
       
        for (DateReference dateReference : dal.getDateReferences()) {
            needsNewAttendance = true;
            for (Attendance attendance : dal.getStudentAttendance(studentId)) {
                if (dateReference.getDate().equals(attendance.getDate())) {
                    needsNewAttendance = false;
                    aList.add(attendance);
                }
            }
            if (needsNewAttendance) {
                Attendance newAttend = new Attendance();

                newAttend.setStudentId(studentId);
                newAttend.setPresent(false);
                newAttend.setDate(dateReference.getDate());
                aList.add(newAttend);
            }
        }
    }

    public ObservableList<Attendance> getAllAttendance() {
        return aList;
    }

    public void setPercentage(Student student) {
        student.setAbsencePercentage(calculatePercentage(student.getId()));
    }
}
