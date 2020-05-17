package integrationTest;


import com.example.demo.controller.exception.ApiRequestException;
import com.example.demo.controller.requestJson.UserAppointmentCreationData;
import com.example.demo.controller.requestJson.UserProfileCreationData;
import com.example.demo.controller.validator.UserProfileCreationDataValidator;
import com.example.demo.repository.UserAppointmentRepository;
import com.example.demo.repository.UserProfileRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CreateNewUserProfileTest {

    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    UserAppointmentRepository userAppointmentRepository;

    private UserProfileCreationData userProfileCreationData;
    private UserAppointmentCreationData userAppointmentCreationData;
    private UserProfileCreationDataValidator userProfileCreationDataValidator;
    List<UserAppointmentCreationData> userAppointments;
    private UserAppointmentCreationData userAppointment = new UserAppointmentCreationData(1, "Tennis", "Wimbledon");

    public CreateNewUserProfileTest() {
    }

    @Before
    public void setUp() {
        userAppointments = new ArrayList<>();
        userAppointments.add(userAppointment);
        userProfileCreationData = UserProfileCreationData.builder()
                .firstName("someName")
                .lastName("someLastName")
                .emailAddress("somenewuser@email.com")
                .userAppointments(userAppointments)
                .build();
    }

    @Test
    public void create_new_user_profile() {
        userAppointments = new ArrayList<>();
        userAppointments.add(userAppointment);

        userProfileCreationData = UserProfileCreationData.builder()
                .firstName("someName")
                .lastName("someLastName")
                .emailAddress("somenewuser@email.com")
                .userAppointments(userAppointments)
                .build();
    }
}
//    @Test
//    public void should_return_400_when_mandatory_fields_are_null_while_creating_new_user_profile() {
//            List<UserAppointmentCreationData> noUserAppointment = new ArrayList<>();
//
//            userProfileCreationDataValidator.validateAppointment(noUserAppointment);
//        }
//    }

