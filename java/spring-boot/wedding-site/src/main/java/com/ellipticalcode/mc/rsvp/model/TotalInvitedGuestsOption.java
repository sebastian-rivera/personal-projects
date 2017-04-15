package com.ellipticalcode.mc.rsvp.model;

/**
 * Created by crono on 4/8/2017.
 */
public class TotalInvitedGuestsOption {
    private String totalInvited;
    private String totalInvitedText;

    public TotalInvitedGuestsOption(String totalInvited, String totalInvitedText) {
        this.totalInvited = totalInvited;
        this.totalInvitedText = totalInvitedText;
    }

    public String getTotalInvited() {
        return totalInvited;
    }

    public String getTotalInvitedText() {
        return totalInvitedText;
    }
}
