package com.example.demo.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class UserAppointmentTest {

    private long roleId = 1;
    private String roleDescription = "Tennis Player";
    private String organisationName = "The 02";
    UserProfile userProfileMock;
    UserAppointment userAppointmentMock;

    @Before
    public void setUp() {
        userProfileMock = mock(UserProfile.class);
        userAppointmentMock = new UserAppointment(roleId, roleDescription, organisationName, userProfileMock);
    }

    @Test
    public void make_userAppointment() {
        assertThat(userAppointmentMock.getAppId());
        assertThat(userAppointmentMock.getRoleDescription()).isEqualTo(roleDescription);
        assertThat(userAppointmentMock.getOrganisationName()).isEqualTo(organisationName);
        assertThat(userAppointmentMock.getUserprofile()).isEqualTo(userProfileMock);
        assertThat(userAppointmentMock.getRoleId()).isEqualTo(roleId);
    }

}