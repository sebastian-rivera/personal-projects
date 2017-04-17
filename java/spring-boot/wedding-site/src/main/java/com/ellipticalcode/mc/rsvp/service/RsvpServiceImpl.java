package com.ellipticalcode.mc.rsvp.service;

import com.ellipticalcode.data.entity.rsvp.Rsvp;
import com.ellipticalcode.data.repository.RsvpRepository;
import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveRsvp(RsvpForm rsvpForm) {

        Rsvp existing = rsvpRepository.findByEmail(rsvpForm.getEmail());

        if(existing == null) {

            Rsvp rsvp = new Rsvp();

            if(rsvpForm.getIsAttending() == "True") {
                rsvp.setAttending(true);
            } else {
                rsvp.setAttending(false);
            }

            rsvp.setTotalInvitedGuests(Integer.parseInt(rsvpForm.getTotalInvitedGuests()));

            rsvp.setName(rsvpForm.getName());

            rsvp.setEmail(rsvpForm.getEmail());

            rsvpRepository.save(rsvp);

        } else {

            if(rsvpForm.getIsAttending() == "Yes") {
                existing.setAttending(true);
            } else {
                existing.setAttending(false);
            }

            existing.setTotalInvitedGuests(Integer.parseInt(rsvpForm.getTotalInvitedGuests()));

            existing.setName(rsvpForm.getName());

            rsvpRepository.save(existing);

        }

    }

}
