package com.patika.kredinbizdeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.kredinbizdeservice.service.ApplicationService;
import com.patika.kredinbizdeservice.model.Application;

import java.util.List;

@RestController
@RequestMapping("api/applications")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;


    @GetMapping("/{email}")
    public List<Application> getApplications(String email) {
        return applicationService.getApplications(email);
    }
}
