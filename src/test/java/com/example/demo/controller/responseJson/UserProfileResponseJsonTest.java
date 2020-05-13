package com.example.demo.controller.responseJson;

import com.example.demo.model.UserAppointment;
import com.example.demo.model.UserProfile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserProfileResponseJsonTest {

    @Test
    public void make_user_response() {
        final String EmailAddress = "foo@bar.com";
        final String FirstName = "Ken";
        final String LastName = "Ben";


        UserProfile userProfile = new UserProfile(EmailAddress, FirstName, LastName);
        UserAppointment userAppointment = new UserAppointment(6, "Med", "Nhs", userProfile);
        userProfile.addUserAppointment(userAppointment);

        UserProfileResponseJson userProfileResponseJson = new UserProfileResponseJson(userProfile);

        assertThat(userProfileResponseJson.getUserAppointments().size()).isEqualTo(1);
        assertThat(userProfileResponseJson.getFirstName()).isEqualTo(FirstName);
        assertThat(userProfileResponseJson.getLastName()).isEqualTo(LastName);
        assertThat(userProfileResponseJson.getEmailAddress()).isEqualTo(EmailAddress);


    }

}