package com.example.demo.service;

import com.example.demo.model.Application;
import com.example.demo.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
