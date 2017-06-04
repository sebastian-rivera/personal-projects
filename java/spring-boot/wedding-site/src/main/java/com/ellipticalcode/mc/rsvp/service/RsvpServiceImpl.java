package com.ellipticalcode.mc.rsvp.service;

import com.ellipticalcode.data.entity.rsvp.Guest;
import com.ellipticalcode.data.entity.rsvp.Rsvp;
import com.ellipticalcode.data.repository.RsvpRepository;
import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import com.ellipticalcode.mc.rsvp.model.RsvpList;
import com.ellipticalcode.mc.rsvp.model.RsvpNotAttendingForm;
import com.ellipticalcode.util.ExcelExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * Created by crono on 4/16/2017.
 */
@Service
public class RsvpServiceImpl implements RsvpService {

    RsvpRepository rsvpRepository;

    @Autowired
    public RsvpServiceImpl(RsvpRepository rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    @Override
    public void saveAttendingRsvp(RsvpForm rsvpForm) {
        Rsvp rsvp = new Rsvp();

        rsvp.setAttending(true);

        rsvp.setAttendingCeremony(rsvpForm.getIsAttendingCeremony().equals("Yes"));

        rsvp.setTotalInvitedGuests(Integer.parseInt(rsvpForm.getTotalInvitedGuests()));

        rsvp.setGuests(new ArrayList<>());

        rsvpForm.getRsvpGuests().forEach(g -> rsvp.getGuests().add(new Guest(g.getFirstName(), g.getLastName(), g.getDinnerChoice())));

        rsvpRepository.save(rsvp);

    }

    @Override
    public void saveNotAttendingRsvp(RsvpNotAttendingForm rsvpNotAttendingForm) {
        Rsvp rsvp = new Rsvp();

        rsvp.setAttending(false);

        rsvp.setGuests(new ArrayList<>());

        rsvp.getGuests().add(new Guest(rsvpNotAttendingForm.getFirstName(), rsvpNotAttendingForm.getLastName(), null));

        rsvpRepository.save(rsvp);
    }

    @Override
    public Resource exportRsvpListToExcel() throws IOException {
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
                guest2 = rsvp.getGuests().get(1).getFirstName() + " " + rsvp.getGuests().get(1).getLastName();
                guest2Dinner = rsvp.getGuests().get(1).getDinnerChoice();
            }

            if(rsvp.getGuests().size() > 2) {
                guest3 = rsvp.getGuests().get(2).getFirstName() + " " + rsvp.getGuests().get(2).getLastName();
                guest3Dinner = rsvp.getGuests().get(2).getDinnerChoice();
            }

            if(rsvp.getGuests().size() > 3) {
                guest4 = rsvp.getGuests().get(3).getFirstName() + " " + rsvp.getGuests().get(3).getLastName();
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

        return resource;
    }

    @Override
    public RsvpList getRsvpList() {

        //Headers
        List<String> headers = Arrays.asList("IsAttending", "Ceremony", "Total Invited", "Guest 1", "Guest 1 Dinner", "Guest 2", "Guest 2 Dinner", "Guest 3", "Guest 3 Dinner", "Guest 4", "Guest 4 Dinner", "Id");

        //Rows
        List<List<String>> rows = new ArrayList<>();

        List<Rsvp> rsvpList = rsvpRepository.findAll();

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
                guest2 = rsvp.getGuests().get(1).getFirstName() + " " + rsvp.getGuests().get(1).getLastName();
                guest2Dinner = rsvp.getGuests().get(1).getDinnerChoice();
            }

            if(rsvp.getGuests().size() > 2) {
                guest3 = rsvp.getGuests().get(2).getFirstName() + " " + rsvp.getGuests().get(2).getLastName();
                guest3Dinner = rsvp.getGuests().get(2).getDinnerChoice();
            }

            if(rsvp.getGuests().size() > 3) {
                guest4 = rsvp.getGuests().get(3).getFirstName() + " " + rsvp.getGuests().get(3).getLastName();
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

            rows.add(Arrays.asList(stringNullCheck(attending), stringNullCheck(ceremony),
                    stringNullCheck(totalAttending),
                    stringNullCheck(guest1), stringNullCheck(guest1Dinner),
                    stringNullCheck(guest2), stringNullCheck(guest2Dinner),
                    stringNullCheck(guest3), stringNullCheck(guest3Dinner),
                    stringNullCheck(guest4), stringNullCheck(guest4Dinner), rsvp.getId()));
        }


        //Totals Row
        List<String> footers = new ArrayList<>();
        footers.add("Total");
        footers.add(getTotalAttendingCeremony(rsvpList).toString());
        footers.add(getTotalInvited(rsvpList).toString());
        footers.add("");
        footers.add("");
        footers.add("");
        footers.add("");
        footers.add("");
        footers.add("");
        footers.add("");
        footers.add("");
        footers.add("");

        RsvpList rsvpListModel = new RsvpList();

        rsvpListModel.setHeaders(headers);
        rsvpListModel.setRows(rows);
        rsvpListModel.setFooters(footers);

        return rsvpListModel;
    }

    private Integer getTotalInvited(List<Rsvp> rsvpList) {

        int count = 0;

        for (Rsvp rsvp : rsvpList ) {
            if(rsvp.getTotalInvitedGuests() != null) {
                count += rsvp.getTotalInvitedGuests();
            }
        }

        return count;
    }

    private Integer getTotalAttending(List<Rsvp> rsvpList) {

        int count = 0;

        for (Rsvp rsvp : rsvpList ) {
            if(rsvp.getAttending() != null && rsvp.getAttending() && rsvp.getTotalInvitedGuests() != null) {
                count += rsvp.getTotalInvitedGuests();
            }
        }

        return count;
    }

    private Integer getTotalAttendingCeremony(List<Rsvp> rsvpList) {

        int count = 0;

        for (Rsvp rsvp : rsvpList ) {
            if(rsvp.getAttendingCeremony() != null && rsvp.getAttendingCeremony() && rsvp.getTotalInvitedGuests() != null) {
                count += rsvp.getTotalInvitedGuests();
            }
        }

        return count;
    }

    private String stringNullCheck(String value) {
        if(value == null) {
            return "";
        } else {
            return value;
        }
    }
}
