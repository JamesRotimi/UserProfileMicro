package com.example.demo.controller.responseJson;

import com.example.demo.model.UserProfile;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class UserProfileResponseJson {

        @JsonProperty
        private final String firstName;

        @JsonProperty
        private final String lastName;

        @JsonProperty
        private final String emailAddress;

        @JsonProperty
        private final List<UserAppointmentResponseJson> userAppointments;

        public UserProfileResponseJson(UserProfile userProfile) {
            this.emailAddress = userProfile.getEmailAddress();
            this.firstName = userProfile.getFirstName();
            this.lastName = userProfile.getLastName();
            this.userAppointments = userProfile.getUserAppointments()
                    .stream()
                    .map(userAppointment -> new UserAppointmentResponseJson (userAppointment))
                    .collect(toList());
        }
    }

