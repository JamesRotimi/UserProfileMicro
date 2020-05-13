package com.example.demo.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class UserProfileTest {

    private String firstName = "Foo";
    private String lastName = "Bar";
    private String emailAddress = "Foo@bar.com";
    UserProfile userProfileMock;

    @Before
    public void setUp() {
        userProfileMock = new UserProfile(firstName, lastName, emailAddress);
    }

    @Test
    public void userProfile_creation() {

        userProfileMock.setFirstName(firstName);
        userProfileMock.setLastName(lastName);
        userProfileMock.setEmailAddress(emailAddress);

        assertThat(userProfileMock.getFirstName()).isEqualTo(firstName);
        assertThat(userProfileMock.getLastName()).isEqualTo(lastName);
        assertThat(userProfileMock.getEmailAddress()).isEqualTo(emailAddress);
        assertThat(userProfileMock.getUserId()).isEqualTo(0);
    }

    @Test
    public void make_timestamps() {
        userProfileMock.setCreatedDate(LocalDateTime.now());
        userProfileMock.setLastUpdatedDate(LocalDateTime.now());

        assertThat(userProfileMock.getCreatedDate()).isNotNull();
        assertThat(userProfileMock.getLastUpdatedDate()).isNotNull();
    }

    @Test
    public void adds_appointments_to_userProfile() {
        UserAppointment userAppointment = mock(UserAppointment.class);
        userProfileMock.addUserAppointment(userAppointment);

        assertThat(userProfileMock.getUserAppointments()).contains(userAppointment);
    }


}