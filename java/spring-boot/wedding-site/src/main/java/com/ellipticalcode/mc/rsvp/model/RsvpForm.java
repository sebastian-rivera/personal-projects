package com.ellipticalcode.mc.rsvp.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by crono on 4/8/2017.
 */
public class RsvpForm {

    private boolean isAttending;

    private int totalInvitedGuests;

    @NotEmpty(message = "Please enter your full name.")
    @NotNull(message = "Please enter your full name.")
    @Size(max=100, message = "Full name is too long. It must be 100 characters or less.")
    private String name;

    @NotEmpty(message = "Please enter your email.")
    @NotNull(message = "Please enter your email.")
    @Size(max=100, message="Email must be 100 characters or less.")
    @Email(message = "Please enter a valid email.")
    private String email;

    public boolean getIsAttending() {
        return isAttending;
    }

    public void setAttending(boolean attending) {
        isAttending = attending;
    }

    public int getTotalInvitedGuests() {
        return totalInvitedGuests;
    }

    public void setTotalInvitedGuests(int totalInvitedGuests) {
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
