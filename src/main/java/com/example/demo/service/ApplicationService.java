package com.example.demo.service;

import com.example.demo.model.Application;

import java.util.List;

public interface ApplicationService {
    List<Application> getAllApplications();
    void saveApplication(Application application);
    void deleteApplicationByID(long id);
    Application getApplicationByID(long id);
}
