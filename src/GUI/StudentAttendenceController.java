/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Attendance;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ZeXVex
 */
public class StudentAttendenceController implements Initializable {
    
    @FXML
    private Label presentLabel;
    @FXML
    private ComboBox<String> absenceBox;
    @FXML
    private Label fname;
    @FXML
    private Label lname;
    @FXML
    private Label classes;
    @FXML
    private JFXListView<Attendance> lstAttendence;
    
    private String prompt = "Set absence";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        absenceBox.getItems().setAll("Present", "Absent");
        absenceBox.setPromptText(prompt);
    }


    @FXML
    private void chooseAbsence(ActionEvent event) {
        boolean present;
        if(absenceBox.getValue() != null) {
        Attendance selectedDay = lstAttendence.getSelectionModel().getSelectedItem();
        if(absenceBox.getValue() == "Present")
            present = true;
        else
            present = false;
        selectedDay.setPresent(present);
        lstAttendence.refresh();
        System.out.println(absenceBox.getValue());
        }
        absenceBox.getSelectionModel().clearSelection();
    }

}
