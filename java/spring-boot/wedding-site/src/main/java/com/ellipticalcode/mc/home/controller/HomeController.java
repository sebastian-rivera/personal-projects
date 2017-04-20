package com.ellipticalcode.mc.home.controller;

import com.ellipticalcode.mc.rsvp.model.RsvpForm;
import com.ellipticalcode.mc.rsvp.model.RsvpOptions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by crono on 1/22/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {

        model.addAttribute("showGallergy", false);
        model.addAttribute("rsvpOptions", new RsvpOptions());
        model.addAttribute("rsvpForm", new RsvpForm());

        return "home/index";
    }

    @RequestMapping("/pacman")
    public String pacman() {
        return "games/pacman";
    }

}
