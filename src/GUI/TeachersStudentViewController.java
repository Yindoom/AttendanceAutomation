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
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class TeachersStudentViewController implements Initializable {
    
    private JFXListView<Attendance> lstAttendence;
    Model model;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setAccount(Student selectedAccount) {
        List<Attendance> studentAttendance = model.getStudentAttendance(selectedAccount.getId());
        lstAttendence.getItems().addAll(studentAttendance);
        //TODO
        
}

    void setModel(Model model) {
        this.model = model;
    }
    
}
