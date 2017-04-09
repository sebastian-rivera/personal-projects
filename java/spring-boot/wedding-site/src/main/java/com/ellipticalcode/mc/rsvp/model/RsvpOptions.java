package com.ellipticalcode.mc.rsvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crono on 4/8/2017.
 */
public class RsvpOptions {

    private List<AreYouAttendingOption> areYouAttendingOptions;
    private List<TotalInvitedGuestsOption> totalInvitedGuestsOptions;

    public RsvpOptions() {
        areYouAttendingOptions = new ArrayList<>();
        areYouAttendingOptions.add(new AreYouAttendingOption(true, "Yes"));
        areYouAttendingOptions.add(new AreYouAttendingOption(false, "No"));

        totalInvitedGuestsOptions = new ArrayList<>();
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption(0, "Just Me"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption(1, "+1"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption(2, "+2"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption(3, "+3"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption(4, "+4"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption(5, "+5"));
    }

    public List<AreYouAttendingOption> getAreYouAttendingOptions() {
        return areYouAttendingOptions;
    }

    public List<TotalInvitedGuestsOption> getTotalInvitedGuestsOptions() {
        return totalInvitedGuestsOptions;
    }
}
