package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;


@NoArgsConstructor
@Data
@Entity(name = "user_profile")
@SequenceGenerator(name = "user_profile_id_seq", sequenceName = "user_profile_id_seq", allocationSize = 1)
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_profile_id_seq" )
    private long userId;

    @Column(name = "email_address")
    @Size(max = 255)
    private String emailAddress;

    @Column(name = "first_name")
    @Size(max = 255)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 255)
    private String lastName;

    @Column(name = "created_date")
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "userprofile")
    private List<UserAppointment> userAppointments = new ArrayList<>();

    public void addUserAppointment(UserAppointment userAppointment) {
        userAppointments.add(userAppointment);
    }

    public List<UserAppointment> getUserAppointments() {
        return userAppointments;
    }

    public UserProfile(String emailAddress, String firstName, String lastName) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}