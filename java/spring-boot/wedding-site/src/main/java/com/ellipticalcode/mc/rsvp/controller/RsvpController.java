package com.ellipticalcode.mc.rsvp.controller;

import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import com.ellipticalcode.mc.rsvp.model.RsvpOptions;
import com.ellipticalcode.mc.rsvp.service.RsvpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by crono on 4/8/2017.
 */
@Controller
public class RsvpController {

    RsvpService rsvpService;

    @Autowired
    public RsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @RequestMapping("/rsvp")
    public String getRsvp(Model model) {

        model.addAttribute("showGallergy", false);
        model.addAttribute("showRsvp", true);
        model.addAttribute("rsvpOptions", new RsvpOptions());
        model.addAttribute("rsvpForm", new RsvpForm());

        return "home/index";
    }

    @RequestMapping(value="/rsvp", method= RequestMethod.POST)
    public String postRsvp(@Valid RsvpForm rsvpForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("showGallergy", false);
            model.addAttribute("showRsvp", true);
            model.addAttribute("rsvpOptions", new RsvpOptions());
            model.addAttribute("rsvpForm", rsvpForm);
            return "home/index";
        }

        rsvpService.saveRsvp(rsvpForm);

        redirectAttributes.addFlashAttribute("rsvpSaved", "RSVP Information saved!");

        return "redirect:/";

    }

}
