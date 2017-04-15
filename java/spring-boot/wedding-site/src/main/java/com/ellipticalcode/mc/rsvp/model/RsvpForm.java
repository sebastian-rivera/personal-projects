package com.ellipticalcode.mc.rsvp.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by crono on 4/8/2017.
 */
public class RsvpForm {

    private String isAttending;

    @Pattern(regexp = "[0-9]+", message = "Select how many will be invited.")
    private String totalInvitedGuests;

    @NotEmpty(message = "Enter your full name.")
    @NotNull(message = "Enter your full name.")
    @Size(max=100, message = "Full name must be 100 characters or less.")
    private String name;

    @NotEmpty(message = "Enter your email.")
    @NotNull(message = "Enter your email.")
    @Size(max=100, message="Email must be 100 characters or less.")
    @Email(message = "Please enter a valid email.")
    private String email;

    //******************** PROPERTIES ********************

    public RsvpForm() {
        isAttending = "";
        totalInvitedGuests = "";
    }

    public String getIsAttending() {
        return isAttending;
    }

    public void setIsAttending(String isAttending) {
        this.isAttending = isAttending;
    }

    public String getTotalInvitedGuests() {
        return totalInvitedGuests;
    }

    public void setTotalInvitedGuests(String totalInvitedGuests) {
        this.totalInvitedGuests = totalInvitedGuests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
