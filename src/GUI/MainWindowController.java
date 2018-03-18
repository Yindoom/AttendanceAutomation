/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Account;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
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

    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField username;

    Account student1 = new Account("student", "12345", "nicolai", "work", "CS2017");
    Account teacher1 = new Account("teacher", "teacher", "Pasqual", "Caudrier", "SEN");
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException {
        if(student1.getPasseword().equals(password.getText()) && student1.getUsername().equals(username.getText())) 
        openStudent(student1.getName(), student1.getLname(), student1.getClasses());
        else if(teacher1.getPasseword().equals(password.getText()) && teacher1.getUsername().equals(username.getText()))
        openTeacher(teacher1.getName(), teacher1.getLname());
            
        
    }
    
    private void openStudent(String name, String lName, String Class) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("StudentView.fxml"));

        Parent root = fxLoader.load();
        StudentViewController stc = fxLoader.getController();
        stc.setLabels(name, lName, Class);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private void openTeacher(String name, String lname) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("TeacherView.fxml"));

        Parent root = fxLoader.load();
        TeacherViewController stc = fxLoader.getController();
        stc.setLabels(name, lname);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();}
}
