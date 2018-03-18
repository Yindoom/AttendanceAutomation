/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ZeXVex
 */
public class Dates {

    @Override
    public String toString() {
        return "Day:" + Day.getValue() + "\t" + "Month:" + month.getValue() + "\t" + "Year:" + year.getValue() + "Presence:" + getString();
    }

    public Dates(int day, int month, int years, boolean present) {
        this.Day.set(day);
        this.month.set(month);
        this.year.set(years);
        this.present.set(present);
    }
    
    private final IntegerProperty Day = new SimpleIntegerProperty();
    private final IntegerProperty month = new SimpleIntegerProperty();
    private final IntegerProperty year = new SimpleIntegerProperty();
    private final BooleanProperty present = new SimpleBooleanProperty();

    public boolean isPresent() {
        return present.get();
    }

    public void setPresent(boolean value) {
        present.set(value);
    }

    public BooleanProperty presentProperty() {
        return present;
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int value) {
        year.set(value);
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public int getMonth() {
        return month.get();
    }

    public void setMonth(int value) {
        month.set(value);
    }

    public IntegerProperty monthProperty() {
        return month;
    }

    public int getDay() {
        return Day.get();
    }

    public void setDay(int value) {
        Day.set(value);
    }

    public IntegerProperty DayProperty() {
        return Day;
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
