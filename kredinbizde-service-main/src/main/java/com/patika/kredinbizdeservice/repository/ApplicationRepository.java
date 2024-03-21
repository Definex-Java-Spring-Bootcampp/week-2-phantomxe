package com.patika.kredinbizdeservice.repository;

import java.util.ArrayList;
import java.util.List;

import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.Product;


public class ApplicationRepository {
    private List<Application> applications = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    public void addApplication(Application app) {
        applications.add(app);
    }

    public List<Application> getAll() {
        return applications;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
