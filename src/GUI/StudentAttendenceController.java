/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Attendance;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;

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
        Attendance d1 = new Attendance(1, 01, 2018, true);
        Attendance d2 = new Attendance(2, 01, 2018, true);
        Attendance d3 = new Attendance(3, 01, 2018, true);
        Attendance d4 = new Attendance(4, 01, 2018, true);
        Attendance d5 = new Attendance(5, 01, 2018, true);
        Attendance d6 = new Attendance(6, 01, 2018, true);
        Attendance d7 = new Attendance(7, 01, 2018, true);
        Attendance d8 = new Attendance(8, 01, 2018, true);
        Attendance d9 = new Attendance(9, 01, 2018, true);
        Attendance d10 = new Attendance(10, 01, 2018, true);
        Attendance d11 = new Attendance(11, 01, 2018, true);
        Attendance d12 = new Attendance(12, 01, 2018, true);
        Attendance d13 = new Attendance(13, 01, 2018, true);
        Attendance d14 = new Attendance(14, 01, 2018, true);
        Attendance d15 = new Attendance(15, 01, 2018, true);
        Attendance d16 = new Attendance(16, 01, 2018, true);
        Attendance d17 = new Attendance(17, 01, 2018, true);
        Attendance d18 = new Attendance(18, 01, 2018, true);
        Attendance d19 = new Attendance(19, 01, 2018, true);
        Attendance d20 = new Attendance(20, 01, 2018, true);
        Attendance d21 = new Attendance(21, 01, 2018, true);
        Attendance d22 = new Attendance(22, 01, 2018, true);
        Attendance d23 = new Attendance(23, 01, 2018, true);
        Attendance d24 = new Attendance(24, 01, 2018, true);
        Attendance d25 = new Attendance(25, 01, 2018, true);
        Attendance d26 = new Attendance(26, 01, 2018, true);
        Attendance d27 = new Attendance(27, 01, 2018, true);
        Attendance d28 = new Attendance(28, 01, 2018, true);
        Attendance d29 = new Attendance(29, 01, 2018, true);
        Attendance d30 = new Attendance(30, 01, 2018, true);
        Attendance d31 = new Attendance(31, 01, 2018, true);
        lstAttendence.getItems().add(d1);
        lstAttendence.getItems().add(d2);
        lstAttendence.getItems().add(d3);
        lstAttendence.getItems().add(d4);
        lstAttendence.getItems().add(d5);
        lstAttendence.getItems().add(d6);
        lstAttendence.getItems().add(d7);
        lstAttendence.getItems().add(d8);
        lstAttendence.getItems().add(d9);
        lstAttendence.getItems().add(d10);
        lstAttendence.getItems().add(d11);
        lstAttendence.getItems().add(d12);
        lstAttendence.getItems().add(d13);
        lstAttendence.getItems().add(d14);
        lstAttendence.getItems().add(d15);
        lstAttendence.getItems().add(d16);
        lstAttendence.getItems().add(d17);
        lstAttendence.getItems().add(d18);
        lstAttendence.getItems().add(d19);
        lstAttendence.getItems().add(d20);
        lstAttendence.getItems().add(d21);
        lstAttendence.getItems().add(d22);
        lstAttendence.getItems().add(d23);
        lstAttendence.getItems().add(d24);
        lstAttendence.getItems().add(d25);
        lstAttendence.getItems().add(d26);
        lstAttendence.getItems().add(d27);
        lstAttendence.getItems().add(d28);
        lstAttendence.getItems().add(d29);
        lstAttendence.getItems().add(d30);
        lstAttendence.getItems().add(d31);
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
