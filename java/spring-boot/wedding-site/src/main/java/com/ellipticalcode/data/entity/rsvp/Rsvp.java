package com.ellipticalcode.data.entity.rsvp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by crono on 4/16/2017.
 */
@Document(collection = "rsvp")
public class Rsvp {

    @Id
    private String id;

    private boolean isAttending;

    private int totalInvitedGuests;

    private String name;

    @Indexed(unique = true)
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAttending() {
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
