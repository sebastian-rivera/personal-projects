package com.ellipticalcode.mc.rsvp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by crono on 5/1/2017.
 */
public class RsvpGuest {

    @NotEmpty(message = "Enter first name.")
    @NotNull(message = "Enter first name.")
    @Size(max=100, message = "Full name must be 100 characters or less.")
    private String firstName;

    @NotEmpty(message = "Enter your full name.")
    @NotNull(message = "Enter last name.")
    @Size(max=100, message = "Full name must be 100 characters or less.")
    private String lastName;

    @Pattern(regexp = "[(Chicken)|(Pork)]+", message = "Select a dinner options.")
    private String dinnerChoice;

    public RsvpGuest () {
        dinnerChoice = "";
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
