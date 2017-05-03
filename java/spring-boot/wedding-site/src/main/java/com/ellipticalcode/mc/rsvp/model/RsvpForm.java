package com.ellipticalcode.mc.rsvp.model;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by crono on 4/8/2017.
 */
public class RsvpForm {

    private String totalInvitedGuests;

    @Pattern(regexp = "[(Yes)|(No)]+", message = "Select if you are attending ceremony.")
    private String isAttendingCeremony;

    @Valid
    private List<RsvpGuest> rsvpGuests;

    //******************** PROPERTIES ********************

    public RsvpForm() {
        isAttendingCeremony = "";
        totalInvitedGuests = "";

        rsvpGuests = new ArrayList<>();
    }

    public String getTotalInvitedGuests() {
        return totalInvitedGuests;
    }

    public void setTotalInvitedGuests(String totalInvitedGuests) {
        this.totalInvitedGuests = totalInvitedGuests;
    }

    public String getIsAttendingCeremony() {
        return isAttendingCeremony;
    }

    public void setIsAttendingCeremony(String isAttendingCeremony) {
        this.isAttendingCeremony = isAttendingCeremony;
    }

    public List<RsvpGuest> getRsvpGuests() {
        return rsvpGuests;
    }

    public void setRsvpGuests(List<RsvpGuest> rsvpGuests) {
        this.rsvpGuests = rsvpGuests;
    }
}
