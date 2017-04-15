package com.ellipticalcode.mc.rsvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crono on 4/8/2017.
 */
public class RsvpOptions {

    private final List<AreYouAttendingOption> areYouAttendingOptions;
    private final List<TotalInvitedGuestsOption> totalInvitedGuestsOptions;

    public RsvpOptions() {
        areYouAttendingOptions = new ArrayList<>();
        areYouAttendingOptions.add(new AreYouAttendingOption("", "Are You Attending?"));
        areYouAttendingOptions.add(new AreYouAttendingOption("Yes", "Yes"));
        areYouAttendingOptions.add(new AreYouAttendingOption("No", "No"));

        totalInvitedGuestsOptions = new ArrayList<>();
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("", "How Many?"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("0", "Just Me"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("1", "+1"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("2", "+2"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("3", "+3"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("4", "+4"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("5", "+5"));
    }

    public List<AreYouAttendingOption> getAreYouAttendingOptions() {
        return areYouAttendingOptions;
    }

    public List<TotalInvitedGuestsOption> getTotalInvitedGuestsOptions() {
        return totalInvitedGuestsOptions;
    }
}
