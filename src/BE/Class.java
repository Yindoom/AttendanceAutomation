/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Fábio
 */
public class Class {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty Name = new SimpleStringProperty();
    private final IntegerProperty tId = new SimpleIntegerProperty();

    public int gettId() {
        return tId.get();
    }

    public void settId(int value) {
        tId.set(value);
    }

    public IntegerProperty tIdProperty() {
        return tId;
    }
    

    public String getName() {
        return Name.get();
    }

    public void setName(String value) {
        Name.set(value);
    }

    public StringProperty NameProperty() {
        return Name;
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
    
    
}
