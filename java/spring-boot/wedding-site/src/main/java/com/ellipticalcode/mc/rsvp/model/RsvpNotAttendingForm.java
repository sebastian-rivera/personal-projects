package com.ellipticalcode.mc.rsvp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by crono on 5/2/2017.
 */
public class RsvpNotAttendingForm {

    @NotEmpty(message = "Enter first name.")
    @NotNull(message = "Enter first name.")
    @Size(max=100, message = "Full name must be 30 characters or less.")
    private String firstName;

    @NotEmpty(message = "Enter your last name.")
    @NotNull(message = "Enter last name.")
    @Size(max=100, message = "Last name must be 30 characters or less.")
    private String lastName;

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
}
