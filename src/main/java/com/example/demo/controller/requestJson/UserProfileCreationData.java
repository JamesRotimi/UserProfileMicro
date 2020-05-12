package com.example.demo.controller.requestJson;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@Builder
public class UserProfileCreationData {


    @NotBlank(message = "firstName must not be null or blank")
    private String firstName;

    @NotBlank(message = "LastName must not be null or blank")
    private String lastName;

    @NotBlank(message = "emailAddress must not be null or blank")
    private String emailAddress;

    private List<UserAppointmentCreationData> userAppointments;

    @JsonCreator
    public UserProfileCreationData(
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("email") String emailAddress,
            @JsonProperty("userAppointments") List<UserAppointmentCreationData> userAppointments) {


        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = StringUtils.isBlank(emailAddress) ? emailAddress : emailAddress.toLowerCase();
        this.userAppointments = userAppointments;
    }
}