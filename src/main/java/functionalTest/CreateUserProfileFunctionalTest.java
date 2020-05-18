package functionalTest;

import com.example.demo.DemoApplication;
import com.example.demo.controller.requestJson.UserAppointmentCreationData;
import com.example.demo.controller.requestJson.UserProfileCreationData;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.flywaydb.core.Flyway;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;


import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CreateUserProfileFunctionalTest {

    @ClassRule
    public static PostgreSQLContainer container = FunctionalContainers.getInstance();

    @Value("http://localhost:${local.server.port}")
    String baseUrl;

    @BeforeClass
    public static void setUp() throws Exception {
        Flyway flyway = Flyway.configure().dataSource(container.getJdbcUrl(), container.getUsername(), container.getPassword()).load();
        flyway.migrate();

        System.out.println(container.getLogs());
    }

    private RequestSpecification givenHeaders() {
        return RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(baseUrl)
                .header("Content-Type", APPLICATION_JSON_VALUE)
                .header("Accepts", APPLICATION_JSON_VALUE);
    }

    private Response userProfilePostEndpoint(UserProfileCreationData data) {
        Response response = givenHeaders()
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("/api/v1/userprofile")
                .andReturn();

        return response;
    }

    private UserProfileCreationData createUserProfile(String emailAddress) {
        List<UserAppointmentCreationData> appointments = new ArrayList<>();
        UserAppointmentCreationData appointment = new UserAppointmentCreationData(1, "Player", "Sports");

        appointments.add(appointment);

        UserProfileCreationData data = UserProfileCreationData.builder()
                .emailAddress(emailAddress)
                .firstName("Exam")
                .lastName("User")
                .userAppointments(appointments)
                .build();

        return data;
    }

    @Test
    public void user_profile_creation() {

         String emailAddress = randomAlphabetic(3)   + "@testing.com";

        UserProfileCreationData data = createUserProfile(emailAddress);

        Response response = userProfilePostEndpoint(data);

        response.then()
                .assertThat()
                .statusCode(201)
                .assertThat()
                .extract()
                .path("emailAddress")
                .equals(emailAddress);

        ArrayList userAppointmentResponse = response.then()
                .assertThat()
                .extract()
                .path("userAppointments");

        assertThat(userAppointmentResponse.size()).isEqualTo(1);
    }

    @Test
    public void emailAddress_cannot_be_empty_or_null() {

        UserProfileCreationData data = createUserProfile(null);

        Response response = userProfilePostEndpoint(data);

        response.then()
                .assertThat()
                .statusCode(400)
                .assertThat()
                .extract()
                .path("message")
                .equals("Email Address cannot be empty or blank");
    }


    @Test
    public void replicated_emailAddress_cannot_create_new_user_profile() {

        final String emailAddress =  "test@testing.com";

        UserProfileCreationData data = createUserProfile(emailAddress);

        Response response = userProfilePostEndpoint(data);

        Response response2 = userProfilePostEndpoint(data);

        response2.then()
                .assertThat()
                .statusCode(500)
                .assertThat()
                .extract()
                .path("message")
                .equals("Email Taken");
    }

}