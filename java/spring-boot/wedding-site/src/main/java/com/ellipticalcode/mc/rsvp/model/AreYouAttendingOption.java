package com.ellipticalcode.mc.rsvp.model;

/**
 * Created by crono on 4/8/2017.
 */
public class AreYouAttendingOption {
    private boolean isAttending;
    private String answerText;

    public AreYouAttendingOption(boolean isAttending, String answerText) {
        this.isAttending = isAttending;
        this.answerText = answerText;
    }

    public boolean getIsAttending() {
        return isAttending;
    }

    public void setAttending(boolean attending) {
        isAttending = attending;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
