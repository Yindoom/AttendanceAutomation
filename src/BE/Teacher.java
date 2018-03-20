/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 *
 * @author Yindo
 */
public class Teacher {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty fName = new SimpleStringProperty();
    private final StringProperty lName = new SimpleStringProperty();
    private final StringProperty Username = new SimpleStringProperty();
    private final StringProperty Password = new SimpleStringProperty();
    private final ListProperty<Class> classes = new SimpleListProperty<>();

    public ObservableList getClasses() {
        return classes.get();
    }

    public void setClasses(ObservableList value) {
        classes.set(value);
    }

    public ListProperty classesProperty() {
        return classes;
    }
    
    

    public String getPassword() {
        return Password.get();
    }

    public void setPassword(String value) {
        Password.set(value);
    }

    public StringProperty PasswordProperty() {
        return Password;
    }
    

    public String getUsername() {
        return Username.get();
    }

    public void setUsername(String value) {
        Username.set(value);
    }

    public StringProperty UsernameProperty() {
        return Username;
    }
    
    
    public String getlName() {
        return lName.get();
    }

    public void setlName(String value) {
        lName.set(value);
    }

    public StringProperty lNameProperty() {
        return lName;
    }
    

    public String getfName() {
        return fName.get();
    }

    public void setfName(String value) {
        fName.set(value);
    }

    public StringProperty fNameProperty() {
        return fName;
    }
    
    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    @Override
    public String toString() {
        return "Teacher{" + "fName=" + fName + ", lName=" + lName + ", Username=" + Username + ", Password=" + Password + '}';
    }
    
    
    
}
