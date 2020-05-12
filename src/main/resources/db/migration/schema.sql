create table user_profile(
    user_id bigint,
    email_address varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    created_date timestamp,
    last_updated timestamp,
    UNIQUE (email_address),
    constraint up_pk primary key (user_id)
);

create table user_appointments(
    id bigint,
    user_profile_id bigint,
    role_id bigint,
    role_description varchar(255),
    organisation_name varchar(255),
constraint appointment_pk primary key (id)
);

alter table user_appointments add constraint fk_user_identifier foreign key (user_profile_id) references user_profile (id);
