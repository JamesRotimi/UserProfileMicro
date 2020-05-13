package com.example.demo.controller.requestJson;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class UserProfileCreationDataTest {

    UserProfileCreationData userProfileCreationData;
    private List<UserAppointmentCreationData> userAppointments = new ArrayList<>();
    private UserAppointmentCreationData userAppointment = new UserAppointmentCreationData(1, "Tennis", "Wimbledon");
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private String emailAddress = "testing@test.com";
    private String firstName = "fistName";
    private String lastName = "lastName";

    @Test
    public  void make_a_user_profile_request() {
        userAppointments.add(userAppointment);
        userProfileCreationData = new UserProfileCreationData(emailAddress, firstName, lastName, userAppointments);
        assertThat(userProfileCreationData.getEmailAddress()).isEqualTo(emailAddress);
        assertThat(userProfileCreationData.getFirstName()).isEqualTo(firstName);
        assertThat(userProfileCreationData.getLastName()).isEqualTo(lastName);
        assertThat(userProfileCreationData.getUserAppointments()).isNotEmpty();
    }

    @Test
    public void build_Method_Test() {
        userAppointments.add(userAppointment);

        userProfileCreationData = UserProfileCreationData.builder()
                .emailAddress(emailAddress)
                .firstName(firstName)
                .lastName(lastName)
                .userAppointments(userAppointments)
                .build();

        assertThat(userProfileCreationData.getEmailAddress()).isEqualTo(emailAddress);
        assertThat(userProfileCreationData.getFirstName()).isEqualTo(firstName);
        assertThat(userProfileCreationData.getLastName()).isEqualTo(lastName);
        assertThat(userProfileCreationData.getUserAppointments()).isNotEmpty();
    }

    @Test
    public void has_mandatory_field() {
        userProfileCreationData = UserProfileCreationData.builder()
                .emailAddress(emailAddress)
                .firstName(null)
                .lastName(null)
                .userAppointments(userAppointments)
                .build();

        Set<ConstraintViolation<UserProfileCreationData>> violations = validator.validate(userProfileCreationData);
        assertThat(violations.size()).isEqualTo(0);
    }

}