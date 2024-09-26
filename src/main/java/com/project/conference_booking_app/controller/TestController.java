package com.project.conference_booking_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testEndpoint() {
        return "The application is running!";
    }
}
