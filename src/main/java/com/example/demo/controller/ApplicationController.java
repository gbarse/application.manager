package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/showNewApplicationForm")
    public String showNewApplicationForm(Model model) {
        Application application = new Application();
        model.addAttribute("application", application);
        return "new_application";
    }

    @PostMapping("/saveApplication")
    public String saveApplication(@ModelAttribute("Application")Application application){
        //save application to the database;
        ApplicationService.saveApplication(application);
        return "redirect:/";
    }

    @GetMapping("/deleteApplication/{id}" )
    public String deleteApplication(@PathVariable(value = "id")long id){
        // call delete employee method
        this.ApplicationService.deleteApplicationByID(id);
        return "redirect:/";
    }
}