/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BE.Account;
import com.jfoenix.controls.JFXListView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class TeachersStudentViewController implements Initializable {
    
    private JFXListView<Account> lstAttendence;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setAccount(Account selectedAccount) {
        lstAttendence.getItems().add(selectedAccount);
        //TODO
        
}
    
}
