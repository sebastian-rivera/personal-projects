package com.ellipticalcode.mc.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by crono on 1/22/2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home/index";
    }

}
