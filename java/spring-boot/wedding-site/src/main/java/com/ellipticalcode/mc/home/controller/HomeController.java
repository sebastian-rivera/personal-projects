package com.ellipticalcode.mc.home.controller;

import com.ellipticalcode.data.entity.rsvp.Rsvp;
import com.ellipticalcode.data.repository.RsvpRepository;
import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import com.ellipticalcode.mc.rsvp.model.RsvpNotAttendingForm;
import com.ellipticalcode.mc.rsvp.model.RsvpOptions;
import com.ellipticalcode.util.ExcelExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by crono on 1/22/2017.
 */
@Controller
public class HomeController {

    RsvpRepository rsvpRepository;

    @Autowired
    public HomeController(RsvpRepository rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    @RequestMapping("/")
    public String home(Model model) {

        model.addAttribute("showGallergy", false);

        model.addAttribute("rsvpOptions", new RsvpOptions());
        model.addAttribute("isAttending", "");
        model.addAttribute("rsvpForm", new RsvpForm());
        model.addAttribute("rsvpNotAttendingForm", new RsvpNotAttendingForm());
        
        return "home/index";
    }

    @RequestMapping("/pacman")
    public String pacman() {
        return "games/pacman";
    }

    @ResponseBody
    @RequestMapping("/download")
    public Resource exportToExcel(HttpServletResponse response) throws IOException {

        List<Rsvp> rsvpList = rsvpRepository.findAll();

        //Create Workbook Rows
        Map<String, Object[]> rows = new TreeMap<String, Object[]>();

        Integer count = 1;
        rows.put(count.toString(), new Object[] {"IsAttending", "Ceremony", "Total Invited", "Guest 1", "Guest 1 Dinner", "Guest 2", "Guest 2 Dinner", "Guest 3", "Guest 3 Dinner", "Guest 4", "Guest 4 Dinner"});
        count++;

        for (Rsvp rsvp : rsvpList) {

            String guest1 = "";
            String guest1Dinner = "";
            String guest2 = "";
            String guest2Dinner = "";
            String guest3 = "";
            String guest3Dinner = "";
            String guest4 = "";
            String guest4Dinner = "";
            String attending = "";
            String ceremony = "";
            String totalAttending = "";

            if(rsvp.getGuests().size() > 0) {
                guest1 = rsvp.getGuests().get(0).getFirstName() + " " + rsvp.getGuests().get(0).getLastName();
                guest1Dinner = rsvp.getGuests().get(0).getDinnerChoice();
            }

            if(rsvp.getGuests().size() > 1) {
                guest2 = rsvp.getGuests().get(1).getFirstName() + " " + rsvp.getGuests().get(0).getLastName();
                guest2Dinner = rsvp.getGuests().get(1).getDinnerChoice();
            }

            if(rsvp.getGuests().size() > 2) {
                guest3 = rsvp.getGuests().get(2).getFirstName() + " " + rsvp.getGuests().get(0).getLastName();
                guest3Dinner = rsvp.getGuests().get(2).getDinnerChoice();
            }

            if(rsvp.getGuests().size() > 3) {
                guest4 = rsvp.getGuests().get(3).getFirstName() + " " + rsvp.getGuests().get(0).getLastName();
                guest4Dinner = rsvp.getGuests().get(3).getDinnerChoice();
            }

            if(rsvp.getAttending()) {
                attending = "Yes";
            } else {
                attending = "No";
            }

            if(rsvp.getAttendingCeremony() != null && rsvp.getAttendingCeremony()) {
                ceremony = "Yes";
            } else {
                ceremony = "No";
            }

            if(rsvp.getTotalInvitedGuests() != null) {
                totalAttending = rsvp.getTotalInvitedGuests().toString();
            }

            rows.put(count.toString(),
                    new Object[] {stringNullCheck(attending), stringNullCheck(ceremony),
                            stringNullCheck(totalAttending),
                            stringNullCheck(guest1), stringNullCheck(guest1Dinner),
                            stringNullCheck(guest2), stringNullCheck(guest2Dinner),
                            stringNullCheck(guest3), stringNullCheck(guest3Dinner),
                            stringNullCheck(guest4), stringNullCheck(guest4Dinner)});
            count++;
        }

        Resource resource = new ByteArrayResource(ExcelExport.ExportToExcel(rows, "Workload"));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentLength(resource.contentLength());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "InviteList.xlsx" + "\"");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return resource;
    }

    private String stringNullCheck(String value) {
        if(value == null) {
            return "";
        } else {
            return value;
        }
    }

}
