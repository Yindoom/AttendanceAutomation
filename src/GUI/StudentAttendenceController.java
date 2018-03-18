/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Dates;
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
    private JFXListView<Dates> lstAttendence;
    private String prompt = "Set absence";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Dates d1 = new Dates(1, 01, 2018, true);
        Dates d2 = new Dates(2, 01, 2018, true);
        Dates d3 = new Dates(3, 01, 2018, true);
        Dates d4 = new Dates(4, 01, 2018, true);
        Dates d5 = new Dates(5, 01, 2018, true);
        Dates d6 = new Dates(6, 01, 2018, true);
        Dates d7 = new Dates(7, 01, 2018, true);
        Dates d8 = new Dates(8, 01, 2018, true);
        Dates d9 = new Dates(9, 01, 2018, true);
        Dates d10 = new Dates(10, 01, 2018, true);
        Dates d11 = new Dates(11, 01, 2018, true);
        Dates d12 = new Dates(12, 01, 2018, true);
        Dates d13 = new Dates(13, 01, 2018, true);
        Dates d14 = new Dates(14, 01, 2018, true);
        Dates d15 = new Dates(15, 01, 2018, true);
        Dates d16 = new Dates(16, 01, 2018, true);
        Dates d17 = new Dates(17, 01, 2018, true);
        Dates d18 = new Dates(18, 01, 2018, true);
        Dates d19 = new Dates(19, 01, 2018, true);
        Dates d20 = new Dates(20, 01, 2018, true);
        Dates d21 = new Dates(21, 01, 2018, true);
        Dates d22 = new Dates(22, 01, 2018, true);
        Dates d23 = new Dates(23, 01, 2018, true);
        Dates d24 = new Dates(24, 01, 2018, true);
        Dates d25 = new Dates(25, 01, 2018, true);
        Dates d26 = new Dates(26, 01, 2018, true);
        Dates d27 = new Dates(27, 01, 2018, true);
        Dates d28 = new Dates(28, 01, 2018, true);
        Dates d29 = new Dates(29, 01, 2018, true);
        Dates d30 = new Dates(30, 01, 2018, true);
        Dates d31 = new Dates(31, 01, 2018, true);
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
        Dates selectedDay = lstAttendence.getSelectionModel().getSelectedItem();
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
