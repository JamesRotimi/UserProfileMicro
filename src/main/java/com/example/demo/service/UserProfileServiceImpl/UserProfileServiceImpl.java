package com.example.demo.service.UserProfileServiceImpl;

import com.example.demo.controller.exception.ApiRequestException;
import com.example.demo.controller.exception.EmailValidator;
import com.example.demo.controller.exception.ReplicatedEmailException;
import com.example.demo.controller.requestJson.UserAppointmentCreationData;
import com.example.demo.controller.requestJson.UserProfileCreationData;
import com.example.demo.controller.responseJson.UserProfileResponseJson;

import com.example.demo.model.UserAppointment;
import com.example.demo.model.UserProfile;
import com.example.demo.repository.UserAppointmentRepository;
import com.example.demo.repository.UserProfileRepository;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserAppointmentRepository userAppointmentRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    private final EmailValidator emailValidator;

    public UserProfileServiceImpl(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    @Override
    public UserProfileResponseJson createUserProfileFrom(UserProfileCreationData userProfileCreationData) {

        UserProfile newUserProfile = new UserProfile(userProfileCreationData.getEmailAddress(),userProfileCreationData.getFirstName(),userProfileCreationData.getLastName());

        if (!emailValidator.test(userProfileCreationData.getEmailAddress())) {
            throw new ApiRequestException(userProfileCreationData.getEmailAddress() + " is not valid");
        }

        if (userProfileRepository.findByEmailAddress(newUserProfile.getEmailAddress()) != null) {
            throw new ReplicatedEmailException();
        }

        UserProfile userProfile =  userProfileRepository.save(newUserProfile);

        addUserAppointmentsToUser(userProfileCreationData.getUserAppointments(), userProfile);

        return new UserProfileResponseJson(userProfile);
    }



    private void addUserAppointmentsToUser(List<UserAppointmentCreationData> userAppointmentCreationData, UserProfile userProfile) {

        if (userAppointmentCreationData != null) {
            userAppointmentCreationData.forEach(UserAppointmentDetails -> {
                UserAppointment newUserAppointment = new UserAppointment();
                newUserAppointment.setRoleId(UserAppointmentDetails.getRoleId());
                newUserAppointment.setRoleDescription(UserAppointmentDetails.getRoleDescription());
                newUserAppointment.setOrganisationName(UserAppointmentDetails.getOrganisationName());
                newUserAppointment.setUserprofile(userProfile);

                userAppointmentRepository.save(newUserAppointment);

                userProfile.addUserAppointment(newUserAppointment);

            });
        }
    }


}
