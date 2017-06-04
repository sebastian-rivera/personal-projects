package com.ellipticalcode.mc.rsvp.model;

import java.util.List;

/**
 * Created by crono on 6/3/2017.
 */
public class RsvpList {

    private List<String> headers;
    List<List<String>> rows;
    private List<String> footers;

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    public List<String> getFooters() {
        return footers;
    }

    public void setFooters(List<String> footers) {
        this.footers = footers;
    }
}
