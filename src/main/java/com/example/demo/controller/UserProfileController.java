package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/up")
@RestController
public class UserProfileController {

    @GetMapping(path = "/hello")
    public String getHello(){
        return "Hello";
    }
}
