/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Fábio
 */
public class Student_Class {

    private final IntegerProperty cId = new SimpleIntegerProperty();
    private final IntegerProperty sId = new SimpleIntegerProperty();

    public int getsId() {
        return sId.get();
    }

    public void setsId(int value) {
        sId.set(value);
    }

    public IntegerProperty sIdProperty() {
        return sId;
    }
    
    
    
    public int getcId() {
        return cId.get();
    }

    public void setcId(int value) {
        cId.set(value);
    }

    public IntegerProperty cIdProperty() {
        return cId;
    }

    @Override
    public String toString() {
        return "Student_Class{" + "cId=" + cId + ", sId=" + sId + '}';
    }
    
    
    
}
