How it works:
1. Docker. First you need to install docker

Download Docker Here. Hint: Enable Hyper-V feature on windows and restart;
Then open powershell and check:
docker info
or, and you see versions docker & docker compose

docker -v
docker-compose -v
2. Spring boot app

Clone the repository:
git clone : https://github.com/JamesRotimi/UserProfileMicro.git
Build the maven project:
mvn clean install
Now run:
docker-compose up
Appendix A.

All commands should be run from project root (where docker-compose.yml locates)

Guide for using endpoint the app:

Go to http://localhost:8080/api/v1/ to test and would specify basic authorization a username: user and password: user or username: admin and password: admin

POST request to /api/v1/ with a "userprofile" object as JSON creates a new "userprofile";

using client to post Json - Example below:

{
  "emailAddress": "test@test.com",
  "firstName": "Jenny",
  "lastName": "Franicis",
  "userAppointments": [
    {
    "roleId": 3211 , 
    "roleDescription": "Disk Jockey", 
    "organisationName": "Choice Fm"
     }
     ,{
    "roleId": 3342, 
    "roleDescription": "Footie", 
    "organisationName": "Wembley"
     }
  ]
}

3. Docker control commands

Check all the images you have:
docker images
If you have to want see running containers:
docker ps
4. End stop app

Stop containers:
docker-compose down
Remove old stopped containers of docker-compose
docker-compose rm -f