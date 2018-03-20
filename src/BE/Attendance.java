/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author ZeXVex
 */
public class Attendance {

    @Override
    public String toString() {
        return "Presence:" + getString();
    }

    public Attendance(boolean present) {
        this.present.set(present);
    }
        
    private final BooleanProperty present = new SimpleBooleanProperty();
    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate value) {
        date.set(value);
    }

    public ObjectProperty dateProperty() {
        return date;
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
