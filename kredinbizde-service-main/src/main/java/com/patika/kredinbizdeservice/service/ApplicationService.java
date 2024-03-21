package com.patika.kredinbizdeservice.service;
 
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patika.kredinbizdeservice.factory.LoanFactory;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Loan;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {

    private ApplicationRepository applicationRepository = new ApplicationRepository();

    @Autowired
    private IUserService userService;

    @Autowired
    public ApplicationService(IUserService userService) {
        this.userService = userService;
    }
    
    public Application createNewLoanApplication(Loan loan, String email) {
        User user = userService.getByEmail(email);

        if(user == null) {
            return null;
        }

        Application application = new Application(loan, user, LocalDateTime.now());
        applicationRepository.addApplication(application);
        
        return application;
    }

    public List<Application> getApplications(String email) {
        User user = userService.getByEmail(email);

        if(user == null) {
            return List.of();
        }

        List<Application> apps =  applicationRepository.getAll();
        return apps.stream().filter(application -> application.getUser().getEmail().equals(email)).toList();
    }
}
