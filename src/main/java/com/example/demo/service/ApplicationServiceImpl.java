package com.example.demo.service;

import com.example.demo.model.Application;
import com.example.demo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public void saveApplication(Application application) {
        this.applicationRepository.save(application);
    }

    @Override
    public void deleteApplicationByID(long id) {
        this.applicationRepository.deleteById(id);
    }

    @Override
    public Application getApplicationByID(long id) {
        Optional<Application> optional = applicationRepository.findById(id);
        Application application = null;
        if (optional.isPresent()) {
            application = optional.get();
        } else {
            throw new RuntimeException("Application not found for id : :" + id);
        }
        return application;
    }
}
