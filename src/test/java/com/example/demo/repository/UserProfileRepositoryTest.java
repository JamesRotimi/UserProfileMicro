package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

import com.example.demo.model.UserProfile;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = { UserProfileRepositoryTest.Initializer.class })
public class UserProfileRepositoryTest {

    @ClassRule
    public static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:latest")
            .withDatabaseName("cogupdb")
            .withUsername("postgres")
            .withPassword("password");

    @Autowired
    UserProfileRepository userProfileRepository;


    @Test
    public void findByEmailTest() {

        UserProfile userProfile = userProfileRepository.save(new UserProfile("test@test.com","test","tester"));

        UserProfile user = userProfileRepository.findByEmailAddress(userProfile.getEmailAddress());

        UserProfile persistedUser = userProfileRepository.findByEmailAddress("test@test.com");

        assertThat(user.getEmailAddress()).isEqualTo("test@test.com");
        assertThat(user.getUserId()).isNotNegative();
    }

    @Test
    public void storedUserProfiles() {
        userProfileRepository.save(new UserProfile("Tennis@test.com", "Roger", "Fed"));
        userProfileRepository.save(new UserProfile("Basketball@test.com", "Kobe", "Bean"));

        List<UserProfile> user = userProfileRepository.findAll();

        assertThat(user).isNotEmpty();
    }


    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgres.getJdbcUrl(),
                    "spring.datasource.username=" + postgres.getUsername(),
                    "spring.datasource.password=" + postgres.getPassword())
                    .applyTo(configurableApplicationContext.getEnvironment());
        }
    }

}
