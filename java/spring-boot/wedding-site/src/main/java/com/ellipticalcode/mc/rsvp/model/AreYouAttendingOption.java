package com.ellipticalcode.mc.rsvp.model;

/**
 * Created by crono on 4/8/2017.
 */
public class AreYouAttendingOption {
    private String isAttending;
    private String answerText;

    public AreYouAttendingOption(String isAttending, String answerText) {
        this.isAttending = isAttending;
        this.answerText = answerText;
    }

    public String getIsAttending() {
        return isAttending;
    }

    public void setIsAttending(String isAttending) {
        this.isAttending = isAttending;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
