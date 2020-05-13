package com.example.demo.controller;

import com.example.demo.controller.requestJson.UserProfileCreationData;
import com.example.demo.controller.responseJson.UserProfileResponseJson;
import com.example.demo.service.UserProfileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserProfileControllerTest {


    @Mock
    private UserProfileCreationData userProfileCreationDataMock;

    @Mock
    private UserProfileResponseJson userProfileResponseJsonMock;

    @Mock
    private UserProfileService userProfileServiceMock;

    @InjectMocks
    private UserProfileController userProfileController;

    @Before
    public void setUp() {
        when(userProfileServiceMock.createUserProfileFrom(userProfileCreationDataMock)).thenReturn(userProfileResponseJsonMock);
    }

    @Test
    public void testCreateUserProfile() {

        final HttpStatus expectedHttpStatus = HttpStatus.CREATED;

        ResponseEntity actual = userProfileController.addUser(userProfileCreationDataMock);

        verify(userProfileServiceMock, times(1)).createUserProfileFrom(any(UserProfileCreationData.class));
        assertThat(actual).isNotNull();
        assertThat(actual.getStatusCode()).isEqualTo(expectedHttpStatus);

    }

}