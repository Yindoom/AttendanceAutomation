/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Attendance;
import BE.Student;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author ZeXVex
 */
public class StudentAttendenceController implements Initializable {
    
    Model model;
    Student student;
    int studentId;
    
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
    private JFXListView<Attendance> lstAttendance;
    
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
        Attendance selectedDay = lstAttendance.getSelectionModel().getSelectedItem();
        if(absenceBox.getValue() == "Present")
            present = true;
        else
            present = false;
        selectedDay.setPresent(present);
        lstAttendance.refresh();
        System.out.println(absenceBox.getValue());
        }
        absenceBox.getSelectionModel().clearSelection();
    }

    public void setModel(Student student, Model model) {
        model.setPercentage(student);
        this.model = model;
        this.studentId = student.getId();
        model.setAllAttendance(studentId);
        lstAttendance.setItems(model.getAllAttendance());
        presentLabel.setText(""+student.getAbsencePercentage());
    }

}
