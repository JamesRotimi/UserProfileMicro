package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.AUTO;

@Data
@NoArgsConstructor
@Entity(name = "user_appointments")
@SequenceGenerator(sequenceName = "user_app_id_seq", name = "appIdSequence", allocationSize = 1)
public class UserAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appIdSequence")
    private long appId;

    @Column(name = "role_id")
    private long roleId;

    @Column(name = "role_description")
    @Size(max = 255)
    private String roleDescription;

    @Column(name = "organisation_name")
    @Size(max = 255)
    private String organisationName;

    @ManyToOne
    @JoinColumn(name = "userProfile_id")
    private UserProfile userprofile;

    public UserAppointment(long roleId, String roleDescription, String organisationName, UserProfile userprofile) {
        this.roleId = roleId;
        this.roleDescription = roleDescription;
        this.organisationName = organisationName;
        this.userprofile = userprofile;
    }
}