/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
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


    public void setLabels(String name, String lName, String Class) {
        fname.setText(name);
        lname.setText(lName);
        classes.setText(Class);
    }

    @FXML
    private void clickAttend(ActionEvent event) {
        System.out.println("attended");
        //TODO
    }

    @FXML
    private void clickAttendence(ActionEvent event) throws IOException {
            Stage primaryStage = new Stage();
            primaryStage.initModality(Modality.WINDOW_MODAL);
            Parent root = FXMLLoader.load(getClass().getResource("StudentAttendence.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
    }
}
