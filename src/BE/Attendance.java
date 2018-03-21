/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author ZeXVex
 */
public class Attendance {

    public Attendance() {
        
    }

    @Override
    public String toString() {
        return "Presence:" + getString();
    }

    public Attendance(boolean present) {
        this.present.set(present);
    }
        
    private final BooleanProperty present = new SimpleBooleanProperty();
    private final ObjectProperty<LocalDate> localDate = new SimpleObjectProperty<>();
    private final IntegerProperty studentId = new SimpleIntegerProperty();
    private final ObjectProperty<java.sql.Date> sqlDate = new SimpleObjectProperty<>();

    public java.sql.Date getSqlDate() {
        return sqlDate.get();
    }

    public void setSqlDate(java.sql.Date value) {
        sqlDate.set(value);
    }

    public ObjectProperty sqlDateProperty() {
        return sqlDate;
    }
    

    public int getStudentId() {
        return studentId.get();
    }

    public void setStudentId(int value) {
        studentId.set(value);
    }

    public IntegerProperty studentIdProperty() {
        return studentId;
    }
    

    public LocalDate getDate() {
        return localDate.get();
    }

    public void setDate(LocalDate value) {
        localDate.set(value);
    }

    public ObjectProperty dateProperty() {
        return localDate;
    }
    

    public boolean isPresent() {
        return present.get();
    }

    public void setPresent(boolean value) {
        present.set(value);
    }

    public BooleanProperty presentProperty() {
        return present;
    }

    public String getString() {
        String presentString;
        if(present.getValue() == true)
            presentString = "Present";
        else if(present.getValue() == false)
            presentString = "Absent";
        else
            presentString = "What the fuck";
        return presentString;
    }

}
