package com.ellipticalcode.data.entity.rsvp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by crono on 4/16/2017.
 */
@Document(collection = "RsvpList")
public class Rsvp {

    @Id
    private String id;

    private Boolean isAttending;

    private Boolean isAttendingCeremony;

    private Integer totalInvitedGuests;

    private List<Guest> guests;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getAttending() {
        return isAttending;
    }

    public void setAttending(Boolean attending) {
        isAttending = attending;
    }

    public Boolean getAttendingCeremony() {
        return isAttendingCeremony;
    }

    public void setAttendingCeremony(Boolean attendingCeremony) {
        isAttendingCeremony = attendingCeremony;
    }

    public Integer getTotalInvitedGuests() {
        return totalInvitedGuests;
    }

    public void setTotalInvitedGuests(Integer totalInvitedGuests) {
        this.totalInvitedGuests = totalInvitedGuests;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}
