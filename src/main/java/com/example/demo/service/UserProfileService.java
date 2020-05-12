package com.example.demo.service;

import com.example.demo.controller.requestJson.UserProfileCreationData;
import com.example.demo.controller.responseJson.UserProfileResponseJson;
import com.example.demo.model.UserAppointment;
import com.example.demo.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    UserProfileResponseJson createUserProfileFrom(UserProfileCreationData userProfileCreationData);

    List<UserProfile> getUserProfiles();

    List<UserAppointment> getAllUserAppointmentsForUser(long UserId);

    public void updateUserProfile(long userId, UserProfile userprofile);

    public void deleteUserProfile(long userId);
}
