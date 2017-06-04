package com.ellipticalcode.mc.guest_list.controller;

import com.ellipticalcode.mc.rsvp.model.RsvpList;
import com.ellipticalcode.mc.rsvp.service.RsvpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by crono on 6/3/2017.
 */
@Controller
public class GuestListController {

    RsvpService rsvpService;

    @Autowired
    public GuestListController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @RequestMapping("/guest-list")
    public String getGuestList(Model model) {

        RsvpList rsvpList = rsvpService.getRsvpList();



        //TotalsRow
        model.addAttribute("headers", rsvpList.getHeaders());
        model.addAttribute("rows", rsvpList.getRows());
        model.addAttribute("footers", rsvpList.getFooters());
        /*model.addAttribute("sortOrder", "asc");
        model.addAttribute("sortColumn", 3);
        model.addAttribute("sortEnable", true);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);*/



        return "guest_list/GuestListView";

    }

    private String stringNullCheck(String value) {
        if(value == null) {
            return "";
        } else {
            return value;
        }
    }

}
