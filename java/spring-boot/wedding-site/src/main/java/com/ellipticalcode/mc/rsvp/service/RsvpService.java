package com.ellipticalcode.mc.rsvp.service;

import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import com.ellipticalcode.mc.rsvp.model.RsvpList;
import com.ellipticalcode.mc.rsvp.model.RsvpNotAttendingForm;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by crono on 4/16/2017.
 */
public interface RsvpService {

    public void saveAttendingRsvp (RsvpForm rsvpForm);
    public void saveNotAttendingRsvp (RsvpNotAttendingForm rsvpNotAttendingForm);
    public Resource exportRsvpListToExcel() throws IOException;
    public RsvpList getRsvpList();

}
