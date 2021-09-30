package com.company.axiosproject.controller;

import com.company.axiosproject.dto.Application;
import com.company.axiosproject.service.ApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MainRestController {
    private ApplicationService service;

    public MainRestController() {
        service = new ApplicationService();
    }

    @GetMapping("/get")
    public String get() {
        return "This is main menu";
    }

    @PostMapping("/create")
    public void create(@RequestBody Application application) {
        System.out.println(application);
        service.create(application);
    }

    @GetMapping("/list")
    public List<Application> getList() {
        return service.getList();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Integer id) {
       service.delete(id);
    }
}
