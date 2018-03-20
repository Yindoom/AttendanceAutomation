/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Student;
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

    Model model = new Model();
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField username;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void loginButton(ActionEvent event) throws IOException {
//        if() 
//        openStudent();
//        else if()
//        openTeacher();
//            
        
    }
    
    private void openStudent(String name, String lName,int id) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("StudentView.fxml"));

        Parent root = fxLoader.load();
        StudentViewController stc = fxLoader.getController();
        stc.setLabels(name, lName, id);
        stc.setModel(model);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    private void openTeacher(String name, String lname) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("TeacherView.fxml"));

        Parent root = fxLoader.load();
        TeacherViewController tvc = fxLoader.getController();
        tvc.setLabels(name, lname);
        tvc.setModel(model);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();}
}
