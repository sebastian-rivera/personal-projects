package com.ellipticalcode.mc.rsvp.service;

import com.ellipticalcode.data.entity.rsvp.Guest;
import com.ellipticalcode.data.entity.rsvp.Rsvp;
import com.ellipticalcode.data.repository.RsvpRepository;
import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import com.ellipticalcode.mc.rsvp.model.RsvpNotAttendingForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by crono on 4/16/2017.
 */
@Service
public class RsvpServiceImpl implements RsvpService {

    RsvpRepository rsvpRepository;

    @Autowired
    public RsvpServiceImpl(RsvpRepository rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    @Override
    public void saveAttendingRsvp(RsvpForm rsvpForm) {
        Rsvp rsvp = new Rsvp();

        rsvp.setAttending(true);

        rsvp.setAttendingCeremony(rsvpForm.getIsAttendingCeremony().equals("Yes"));

        rsvp.setTotalInvitedGuests(Integer.parseInt(rsvpForm.getTotalInvitedGuests()));

        rsvp.setGuests(new ArrayList<>());

        rsvpForm.getRsvpGuests().forEach(g -> rsvp.getGuests().add(new Guest(g.getFirstName(), g.getLastName(), g.getDinnerChoice())));

        rsvpRepository.save(rsvp);

    }

    @Override
    public void saveNotAttendingRsvp(RsvpNotAttendingForm rsvpNotAttendingForm) {
        Rsvp rsvp = new Rsvp();

        rsvp.setAttending(false);

        rsvp.setGuests(new ArrayList<>());

        rsvp.getGuests().add(new Guest(rsvpNotAttendingForm.getFirstName(), rsvpNotAttendingForm.getLastName(), null));

        rsvpRepository.save(rsvp);
    }

}
