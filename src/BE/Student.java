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
public class Student {
    
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty fname = new SimpleStringProperty();
    private final StringProperty lname = new SimpleStringProperty();
    private final StringProperty classes = new SimpleStringProperty();
    
    @Override
    public String toString() {
        return username.getValue() + "\t"
                + password.getValue() + "\t"
                + fname.getValue() + "\t"
                + lname.getValue() + "\t"
                + classes.getValue();
    }
    
    public Student(String username, String password, String fname, String lname, String classes) {
        this.username.set(username);
        this.password.set(password);
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
    
    public String getPassword() {
        return password.get();
    }
    
    public void setPassword(String value) {
        password.set(value);
    }
    
    public StringProperty PasswordProperty() {
        return password;
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
