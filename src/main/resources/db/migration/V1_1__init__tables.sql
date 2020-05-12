create table user_profile(
    user_id bigint,
    email_address varchar(255) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    created_date timestamp,
    last_updated timestamp,
    UNIQUE (email_address),
    constraint up_pk primary key (user_id)
);

create table user_appointments(
    app_id bigint,
    user_profile_id bigint,
    role_id bigint,
    role_description varchar(255),
    organisation_name varchar(255),
    constraint user_appointment_pk primary key (app_id)
);

alter table user_appointments add constraint fk_user_id foreign key (user_profile_id) references user_profile (user_id);
