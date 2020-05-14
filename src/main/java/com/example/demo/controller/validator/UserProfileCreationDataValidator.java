package com.example.demo.controller.validator;

import com.example.demo.controller.exception.ApiRequestException;
import com.example.demo.controller.requestJson.UserAppointmentCreationData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
public class UserProfileCreationDataValidator {

    private UserProfileCreationDataValidator() {
    }


    public static List<UserAppointmentCreationData> validateAppointment(List<UserAppointmentCreationData> appointments) {

        if (CollectionUtils.isEmpty(appointments)) {
            log.error("No user appointment(s) provided");
            throw new ApiRequestException("No appoint(s) provided");
        }

        return appointments;
    }
}

