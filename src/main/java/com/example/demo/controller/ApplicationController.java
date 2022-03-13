package com.example.demo.controller;

import com.example.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @Autowired
    private ApplicationService ApplicationService;
    // display list of applications
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listApplications", ApplicationService.getAllApplications());
        return "index";
    }

}
