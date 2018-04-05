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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ZeXVex
 */
public class MainWindowController implements Initializable {

    Stage login;
    Model model = new Model();
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField username;
    @FXML
    private Label warningLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException, SQLException {
        model.makeDateReference();
        boolean loggedIn = false;
        for (Student student : model.studentLogin()) {
            if (username.getText().equals(student.getUsername()) && password.getText().equals(student.getPassword())) {
                loggedIn = true;
                openStudent(student);
                ((Node)event.getSource()).getScene().getWindow().hide();
            }
        }
        if(!loggedIn)
        for (Teacher teacher : model.teacherLogin()) {
            if (username.getText().equals(teacher.getUsername()) && password.getText().equals(teacher.getPassword())) {
                loggedIn = true;
                openTeacher(teacher);
                ((Node)event.getSource()).getScene().getWindow().hide();
            }

        }
        if(!loggedIn)
            warningLabel.setText("Username or Password is wrong");

    }

    private void openStudent(Student student) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("StudentView.fxml"));

        Parent root = fxLoader.load();
        StudentViewController stc = fxLoader.getController();
        String name = student.getName();
        String lName = student.getLname();
        int id = student.getId();
        stc.setLabels(name, lName, id);
        stc.setModel(model);
        

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void openTeacher(Teacher teacher) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("TeacherView.fxml"));

        Parent root = fxLoader.load();
        TeacherViewController tvc = fxLoader.getController();
        String name = teacher.getfName();
        String lname = teacher.getlName();
        int id = teacher.getId();

        tvc.setModel(model);
        tvc.setLabels(name, lname, id);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
