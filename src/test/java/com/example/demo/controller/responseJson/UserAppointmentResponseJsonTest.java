package com.example.demo.controller.responseJson;

import com.example.demo.model.UserAppointment;
import com.example.demo.model.UserProfile;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserAppointmentResponseJsonTest {

    @Test
    public void make_user_appointment_response() {


        long RoleId = 8;
        String RoleDescription = "Tennis";
        String OrganisationName = "Wimbledon";

        final UserProfile userProfile = new UserProfile();
        final UserAppointment userAppointment = new UserAppointment(8, "Tennis", "Wimbledon", userProfile);

        UserAppointmentResponseJson userAppointmentResponse = new UserAppointmentResponseJson(userAppointment);

        assertThat(userAppointmentResponse.getRoleId()).isEqualTo(RoleId);
        assertThat(userAppointmentResponse.getRoleDescription()).isEqualTo(RoleDescription);
        assertThat(userAppointmentResponse.getOrganisationName()).isEqualTo(OrganisationName);

    }

}