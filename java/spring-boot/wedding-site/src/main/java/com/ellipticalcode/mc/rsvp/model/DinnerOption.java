package com.ellipticalcode.mc.rsvp.model;

/**
 * Created by crono on 5/1/2017.
 */
public class DinnerOption {

    private String optionId;
    private String optionText;

    public DinnerOption(String optionId, String optionText) {
        this.optionId = optionId;
        this.optionText = optionText;
    }

    public String getOptionId() {
        return optionId;
    }

    public String getOptionText() {
        return optionText;
    }
}
