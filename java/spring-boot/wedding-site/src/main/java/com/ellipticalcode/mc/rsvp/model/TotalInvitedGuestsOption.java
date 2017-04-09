package com.ellipticalcode.mc.rsvp.model;

/**
 * Created by crono on 4/8/2017.
 */
public class TotalInvitedGuestsOption {
    private int totalInvited;
    private String totalInvitedText;

    public TotalInvitedGuestsOption(int totalInvited, String totalInvitedText) {
        this.totalInvited = totalInvited;
        this.totalInvitedText = totalInvitedText;
    }

    public int getTotalInvited() {
        return totalInvited;
    }

    public String getTotalInvitedText() {
        return totalInvitedText;
    }
}
