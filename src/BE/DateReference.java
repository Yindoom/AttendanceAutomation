/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.time.LocalDate;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author Yindo
 */
public class DateReference {

    private final ObjectProperty<LocalDate> Date = new SimpleObjectProperty<>();

    public LocalDate getDate() {
        return Date.get();
    }

    public void setDate(LocalDate value) {
        Date.set(value);
    }

    public ObjectProperty DateProperty() {
        return Date;
    }
    
}
