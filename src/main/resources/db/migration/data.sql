Insert into user_profile (user_id, email_address, first_name, last_name, created_date, last_updated) values (1, 'test@test.com', 'peter', 'jones', '01-05-2020', '02-05-2020');
Insert into user_profile (user_id, email_address, first_name, last_name, created_date, last_updated) values (2, 'yeah@test.com', 'James', 'rare', '01-05-2020', '03-05-2020');

Insert into user_appointments (id, user_profile_id, role_id, role_description, organisation_name ) values (1, 1, 1, 'Test', 'Tennis');
Insert into user_appointments (id, user_profile_id, role_id, role_description, organisation_name ) values (2, 2, 2, 'Vest', 'Football');