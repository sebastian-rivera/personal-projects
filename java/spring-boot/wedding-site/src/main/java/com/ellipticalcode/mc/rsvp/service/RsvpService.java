package com.ellipticalcode.mc.rsvp.service;

import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import com.ellipticalcode.mc.rsvp.model.RsvpNotAttendingForm;

/**
 * Created by crono on 4/16/2017.
 */
public interface RsvpService {

    public void saveAttendingRsvp (RsvpForm rsvpForm);
    public void saveNotAttendingRsvp (RsvpNotAttendingForm rsvpNotAttendingForm);

}
