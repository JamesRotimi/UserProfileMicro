//package com.example.demo.service.UserProfileServiceImpl;
//
//        import static org.assertj.core.api.Assertions.assertThat;
//        import com.example.demo.controller.requestJson.UserAppointmentCreationData;
//        import com.example.demo.controller.requestJson.UserProfileCreationData;
//        import com.example.demo.controller.responseJson.UserProfileResponseJson;
//        import com.example.demo.model.UserAppointment;
//        import com.example.demo.model.UserProfile;
//        import com.example.demo.repository.UserAppointmentRepository;
//        import com.example.demo.repository.UserProfileRepository;
//        import org.junit.Before;
//        import org.junit.Test;
//        import org.junit.runner.RunWith;
//        import org.mockito.InjectMocks;
//        import org.mockito.Mock;
//        import org.mockito.junit.MockitoJUnitRunner;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//        import static org.mockito.ArgumentMatchers.any;
//        import static org.mockito.Mockito.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserProfileServiceImplTest {
//
//    @Mock
//    UserAppointmentRepository userAppointmentRepositoryMock;
//
//    @Mock
//    UserProfileRepository userProfileRepositoryMock;
//
//    UserProfile userProfileMock;
//
//    UserAppointment userAppointmentMock;
//
//    private UserProfileCreationData userProfileCreationData = CreateUserProfileTestDataBuilder.buildCreateUserProfileData();
//
//    UserAppointmentCreationData userAppointmentCreationData;
//
//    @InjectMocks
//    UserProfileServiceImpl sut;
//
//    @Before
//    public void setUp() {
//
//        List<UserAppointmentCreationData> userAppointments = new ArrayList();
//        userProfileCreationDataMock = new UserProfileCreationData("test@test.com", "test", "tester", userAppointments);
//        userAppointmentCreationData = new UserAppointmentCreationData(1, "tester", "cog");
//        userAppointments.add(userAppointmentCreationData);
//
//        when(userProfileRepositoryMock.save(any(UserProfile.class))).thenReturn(userProfileMock);
//        when(userAppointmentRepositoryMock.save(any(UserAppointment.class))).thenReturn(userAppointmentMock);
//        when(userProfileRepositoryMock.findByEmailAddress(any())).thenReturn(userProfileMock);
//
//    }
//
//
//    @Test
//    public void testSavesAnOrganisation() {
//
//        UserProfileResponseJson userProfileResponseJson = sut.createUserProfileFrom(userProfileCreationDataMock);
//
//        assertThat(userProfileResponseJson).isNotNull();
//
//        verify(userProfileRepositoryMock, times(1)).save(any(UserProfile.class));
//        verify(userAppointmentRepositoryMock, times(1)).save(any(UserAppointment.class));
//    }
//
//    @Test(expected = EmptyResultDataAccessException.class)
//    public void throwsEmptyResultDataAccessException() {
//        Organisation testOrganisation = new Organisation();
//        testOrganisation.setId(UUID.randomUUID());
//        String testOrganisationId = testOrganisation.getOrganisationIdentifier();
//
//        when(organisationRepository.findByOrganisationIdentifier(any())).thenReturn(null);
//        sut.retrieveOrganisation(testOrganisationId);
//    }
//
//    private void assertExpectedOrganisationResponse(OrganisationResponse organisationResponse) {
//        final int orgIdLength = 7;
//        assertThat(organisationResponse).isNotNull();
//        assertThat(organisationResponse.getOrganisationIdentifier()).isNotNull();
//        assertThat(organisationResponse.getOrganisationIdentifier().length()).isEqualTo(orgIdLength);
//    }
//}
//
//
//
