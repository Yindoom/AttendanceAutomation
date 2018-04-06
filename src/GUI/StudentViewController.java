/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Student;
import com.jfoenix.controls.JFXButton;
import com.sun.deploy.util.FXLoader;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ZeXVex
 */
public class StudentViewController implements Initializable {
    
    Model model;
    Student student;
    int studentId;
    
    @FXML
    private Label fname;
    @FXML
    private Label lname;
    @FXML
    private Label classes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }


    public void setLabels(Student student) {
        this.student = student;
        fname.setText(student.getName());
        lname.setText(student.getLname());
        this.studentId = student.getId();
        
    }

    @FXML
    private void clickAttend(ActionEvent event) throws SQLException {
        LocalDate date = LocalDate.now();
        model.attend(date, studentId);
    }

    @FXML
    private void clickAttendence(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("StudentAttendence.fxml"));
        Parent root = fxLoader.load();
        
        StudentAttendenceController sac = fxLoader.getController();
        sac.setModel(student, model);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
