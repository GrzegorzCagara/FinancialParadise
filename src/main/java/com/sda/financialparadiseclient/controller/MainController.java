package com.sda.financialparadiseclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainPage(HttpServletRequest httpServletRequest) {
        Principal userPrincipal = httpServletRequest.getUserPrincipal();
        if(userPrincipal == null){
            return "mainPage";
        }


        String user = userPrincipal.getName();


        if(!user.equals("admin")) {
            return "customer-panel";
        }
        return "admin-panel";
    }

    @RequestMapping("/admin/panel")
    public String adminPanel() {
        return "admin-panel";
    }
}
