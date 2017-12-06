package com.sda.financialparadiseclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainPage() {
        return "mainPage";
    }

    @RequestMapping("/logout")
    public String login(){
        return "redirect:/customers/find/all";
    }


}
