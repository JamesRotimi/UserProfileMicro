package com.example.demo.controller.responseJson;

import com.example.demo.model.UserAppointment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class UserAppointmentResponseJson {

    @JsonProperty("roleId")
    private long roleId;

    @JsonProperty("roleDescription")
    private String roleDescription;

    @JsonProperty("organisationName")
    private String organisationName;

    public UserAppointmentResponseJson(UserAppointment userAppointment) {
        this.roleId = userAppointment.getRoleId();
        this.roleDescription = userAppointment.getRoleDescription();
        this.organisationName = userAppointment.getOrganisationName();
    }
}

