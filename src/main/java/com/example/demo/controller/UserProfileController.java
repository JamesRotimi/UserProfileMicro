package com.example.demo.controller;

import com.example.demo.controller.requestJson.UserProfileCreationData;
import com.example.demo.controller.responseJson.UserProfileResponseJson;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "/up")
@RestController
public class UserProfileController {

    @Autowired
    protected UserProfileService userProfileService;

    @GetMapping(path = "/hello")
    public String getHello(){
        return "Hello";
    }


    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserProfileResponseJson> addUser(@RequestBody @Valid UserProfileCreationData userProfileCreationData) {

        UserProfileResponseJson userProfileResponseJson = userProfileService.createUserProfileFrom(userProfileCreationData);

        return ResponseEntity
                .status(201)
                .body(userProfileResponseJson);
    }
}




