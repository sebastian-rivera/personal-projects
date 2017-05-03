package com.ellipticalcode.data.entity.rsvp;

/**
 * Created by crono on 5/1/2017.
 */
public class Guest {

    private String firstName;
    private String lastName;
    private String dinnerChoice;

    public Guest(String firstName, String lastName, String dinnerChoice) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dinnerChoice = dinnerChoice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDinnerChoice() {
        return dinnerChoice;
    }

    public void setDinnerChoice(String dinnerChoice) {
        this.dinnerChoice = dinnerChoice;
    }
}
