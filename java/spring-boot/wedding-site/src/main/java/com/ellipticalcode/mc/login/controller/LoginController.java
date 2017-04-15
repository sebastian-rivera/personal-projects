package com.ellipticalcode.mc.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by crono on 1/22/2017.
 */
@Controller
public class LoginController {

    @RequestMapping("/admin/login")
    public String login(Model model) {
        return "login/login";
    }

}
