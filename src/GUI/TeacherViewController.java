/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Student;
import com.jfoenix.controls.JFXListView;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ZeXVex
 */
public class TeacherViewController implements Initializable {

    Model model;

    @FXML
    private Label fname;
    @FXML
    private Label lname;
    @FXML
    private JFXListView<Student> lstStudents;
    int id;
    @FXML
    private DatePicker dateFrom;
    @FXML
    private DatePicker dateTo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }

    @FXML
    private void clickAttendance(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.WINDOW_MODAL);
        FXMLLoader fxLoader = new FXMLLoader(getClass().getResource("TeachersStudentView.fxml"));

        Parent root = fxLoader.load();
        TeachersStudentViewController stc = fxLoader.getController();
        stc.setModel(model);

        Student selectedAccount
                = lstStudents.getSelectionModel().getSelectedItem();
        stc.setAccount(selectedAccount);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
        //TODO
    }

    public void setLabels(String name, String lName, int id) {
        fname.setText(name);
        lname.setText(lName);
        this.id = id;
        lstStudents.getItems().addAll(model.getTeacherStudents(id));
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public List<Student> getTeacherStudents(int id) {
        return model.getTeacherStudents(id);
    }
}
