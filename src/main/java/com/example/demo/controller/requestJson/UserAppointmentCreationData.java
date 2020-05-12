package com.example.demo.controller.requestJson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAppointmentCreationData {

    private long roleId;

    private String roleDescription;

    private String organisationName;

    @JsonCreator
    public UserAppointmentCreationData(
            @JsonProperty("roleId") long roleId,
            @JsonProperty("roleDescription") String roleDescription,
            @JsonProperty("organisationName") String organisationName) {

        this.roleId = roleId;
        this.roleDescription = roleDescription;
        this.organisationName = organisationName;
    }
}