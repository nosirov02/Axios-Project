package com.company.axiosproject.service;

import com.company.axiosproject.dto.Application;

import java.util.LinkedList;
import java.util.List;

public class ApplicationService {
    private List<Application> applicationList;
    private static Integer id;

    public ApplicationService() {
        applicationList = new LinkedList<>();
        id = 1;
        applicationList.add(new Application(id++, "Name - 1", "Title - 1", "Content - 1"));
        applicationList.add(new Application(id++, "Name - 2", "Title - 2", "Content - 2"));
    }

    public void create(Application application) {
        application.setId(id++);
        applicationList.add(application);
    }

    public List<Application> getList() {
        return applicationList;
    }

    public void delete(int id) {
        for (Application app : applicationList) {
            if (app.getId().equals(id)){
                applicationList.remove(id-1);
            }
        }
    }
}
