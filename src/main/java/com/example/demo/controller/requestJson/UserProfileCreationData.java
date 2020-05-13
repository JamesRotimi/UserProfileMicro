package com.example.demo.controller.requestJson;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@Builder
public class UserProfileCreationData {


    @NotNull
    @NotEmpty

    private String emailAddress;

    private String firstName;

    private String lastName;

    private List<UserAppointmentCreationData> userAppointments;

    @JsonCreator
    public UserProfileCreationData(
            @JsonProperty("emailAddress") String emailAddress,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("userAppointments") List<UserAppointmentCreationData> userAppointments) {

        this.emailAddress = StringUtils.isBlank(emailAddress) ? emailAddress : emailAddress.toLowerCase();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAppointments = userAppointments;
    }
}