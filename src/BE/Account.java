/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.util.logging.Logger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ZeXVex
 */
public class Account {
    
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty passeword = new SimpleStringProperty();
    private final StringProperty fname = new SimpleStringProperty();
    private final StringProperty lname = new SimpleStringProperty();
    private final StringProperty classes = new SimpleStringProperty();
    
    @Override
    public String toString() {
        return username.getValue() + "\t"
                + passeword.getValue() + "\t"
                + fname.getValue() + "\t"
                + lname.getValue() + "\t"
                + classes.getValue();
    }
    
    public Account(String username, String passeword, String fname, String lname, String classes) {
        this.username.set(username);
        this.passeword.set(passeword);
        this.fname.set(fname);
        this.lname.set(lname);
        this.classes.set(classes);
    }
    
    public int getId() {
        return id.get();
    }
    
    public void getId(int value) {
        id.set(value);
    }
    
    public IntegerProperty idProperty() {
        return id;
    }
    
    public String getClasses() {
        return classes.get();
    }
    
    public void setClasses(String value) {
        classes.set(value);
    }
    
    public StringProperty classesProperty() {
        return classes;
    }
    
    public String getLname() {
        return lname.get();
    }
    
    public void setLname(String value) {
        lname.set(value);
    }
    
    public StringProperty lnameProperty() {
        return lname;
    }
    
    public String getName() {
        return fname.get();
    }
    
    public void setName(String value) {
        fname.set(value);
    }
    
    public StringProperty nameProperty() {
        return fname;
    }
    
    public String getPasseword() {
        return passeword.get();
    }
    
    public void setPasseword(String value) {
        passeword.set(value);
    }
    
    public StringProperty PassewordProperty() {
        return passeword;
    }
    
    public String getUsername() {
        return username.get();
    }
    
    public void setUsername(String value) {
        username.set(value);
    }
    
    public StringProperty UsernameProperty() {
        return username;
    }
    
}
