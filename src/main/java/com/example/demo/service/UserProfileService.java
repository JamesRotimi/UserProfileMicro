package com.example.demo.service;

import com.example.demo.controller.requestJson.UserProfileCreationData;
import com.example.demo.controller.responseJson.UserProfileResponseJson;

public interface UserProfileService {

    UserProfileResponseJson createUserProfileFrom(UserProfileCreationData userProfileCreationData);

}
