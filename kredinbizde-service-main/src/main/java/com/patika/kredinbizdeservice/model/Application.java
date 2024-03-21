package com.patika.kredinbizdeservice.model;


import com.patika.kredinbizdeservice.enums.ApplicationStatus;

import java.time.LocalDateTime;

public class Application {
 
    private Product product;
    private User user;
    private LocalDateTime localDateTime;
    private ApplicationStatus applicationStatus;

    public Application(Product product, User user, LocalDateTime localDateTime) {
        this.product = product;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
    } 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        return "Application{" +
                "product=" + product +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
