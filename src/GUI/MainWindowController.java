/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Attendance;
import BE.Student;
import BE.Teacher;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ZeXVex
 */
public class MainWindowController implements Initializable {

    Model model = new Model();
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField username;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (Attendance attendance : model.getStudentAttendance()) {
            System.out.println(attendance.getDate());
        }

    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException, SQLException {
        for (Student student : model.studentLogin()) {
            if (username.getText().equals(student.getUsername())) {
                openStudent();
            }
        }
<<<<<<< HEAD
=======

>>>>>>> 1c56c5dbe1f7c251676b28a95fce533c8ff282bd
        for (Teacher teacher : model.teacherLogin()) {
            if (username.getText().equals(teacher.getUsername())) {
                openTeacher();
            }
<<<<<<< HEAD

        }

=======
        }
>>>>>>> 1c56c5dbe1f7c251676b28a95fce533c8ff282bd
    }

    private void openStudent() throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("StudentView.fxml"));

        Parent root = fxLoader.load();
        StudentViewController stc = fxLoader.getController();
        String name = "fuck";
        String lName = "you";
        int id = 1;
        stc.setLabels(name, lName, id);
        stc.setModel(model);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void openTeacher() throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("TeacherView.fxml"));

        Parent root = fxLoader.load();
        TeacherViewController tvc = fxLoader.getController();
        String name = "fuck";
        String lname = "you";

        tvc.setLabels(name, lname);
        tvc.setModel(model);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
