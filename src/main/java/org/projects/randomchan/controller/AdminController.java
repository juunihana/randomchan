package org.projects.randomchan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

//    @PostMapping("/login")
//    public String login() {
//        return "admin";
//    }
//
//    @PostMapping("/logout")
//    public String logout() {
//        return "admin";
//    }
}
