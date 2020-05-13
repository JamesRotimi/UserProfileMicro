package com.example.demo.controller.requestJson;

import com.example.demo.controller.responseJson.UserAppointmentResponseJson;
import com.example.demo.model.UserAppointment;
import com.example.demo.model.UserProfile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserAppointmentCreationDataTest {

    UserProfile userProfile = new UserProfile();
    UserAppointment userAppointment = new UserAppointment(6, "Tennis", "Wimbledon", userProfile);
    UserAppointmentResponseJson userAppointmentResponseJson = new UserAppointmentResponseJson(userAppointment);

    @Test
    public void make_user_appointments() {
        final long roleId = 6;
        final String roleDescription = "Tennis";
        final String organisationName = "Wimbledon";

        assertThat(userAppointmentResponseJson.getRoleId()).isEqualTo(roleId);
        assertThat(userAppointmentResponseJson.getRoleDescription()).isEqualTo(roleDescription);
        assertThat(userAppointmentResponseJson.getOrganisationName()).isEqualTo(organisationName);
    }

}