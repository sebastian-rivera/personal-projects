package com.ellipticalcode.mc.rsvp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by crono on 4/8/2017.
 */
public class RsvpOptions {

    private final List<AreYouAttendingOption> areYouAttendingOptions;
    private final List<AreYouAttendingOption> areYouAttendingCeremonyOptions;
    private final List<TotalInvitedGuestsOption> totalInvitedGuestsOptions;
    private final List<DinnerOption> dinnerOptions;

    public RsvpOptions() {
        areYouAttendingOptions = new ArrayList<>();
        areYouAttendingOptions.add(new AreYouAttendingOption("", "Are You Attending?"));
        areYouAttendingOptions.add(new AreYouAttendingOption("Yes", "Yes"));
        areYouAttendingOptions.add(new AreYouAttendingOption("No", "No"));

        areYouAttendingCeremonyOptions = new ArrayList<>();
        areYouAttendingCeremonyOptions.add(new AreYouAttendingOption("", "Going to the Ceremony?"));
        areYouAttendingCeremonyOptions.add(new AreYouAttendingOption("Yes", "Yes"));
        areYouAttendingCeremonyOptions.add(new AreYouAttendingOption("No", "No I just want to party!"));

        totalInvitedGuestsOptions = new ArrayList<>();
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("", "How Many?"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("1", "Just Me"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("2", "2"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("3", "3"));
        totalInvitedGuestsOptions.add(new TotalInvitedGuestsOption("4", "4"));


        dinnerOptions = new ArrayList<>();
        dinnerOptions.add(new DinnerOption("", "What are you eating?"));
        dinnerOptions.add(new DinnerOption("Chicken", "Chicken"));
        dinnerOptions.add(new DinnerOption("Pork", "Pork"));
    }

    public List<AreYouAttendingOption> getAreYouAttendingOptions() {
        return areYouAttendingOptions;
    }

    public List<AreYouAttendingOption> getAreYouAttendingCeremonyOptions() {
        return areYouAttendingCeremonyOptions;
    }

    public List<TotalInvitedGuestsOption> getTotalInvitedGuestsOptions() {
        return totalInvitedGuestsOptions;
    }

    public List<DinnerOption> getDinnerOptions() {
        return dinnerOptions;
    }
}
