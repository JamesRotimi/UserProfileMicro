
# Userprofile-api

  HR Project


## Purpose

Provides a post request client to applications.  Implemented as a Java/SpringBoot application.

### Prerequisites

To run the project you will need to have the following installed:

* Java 8
* Docker 



## How it works:
 
  1. Docker. First you need to install docker

Download Docker Here. Hint: Enable Hyper-V feature on windows and restart;
Then open powershell and check:
docker info
or, and you see versions docker & docker compose

   docker -v
   docker-compose -v

  2. Clone the repository:
    ``` git clone : https://github.com/JamesRotimi/UserProfileMicro.git```
  3. Build the maven project:
       ``` mvn clean install ```

  4. Now run:
     ``` docker-compose up ```
     This will provide a container ID ex. [e17tucjkdihdfsc]

  5. Connect to the [cogupdb] database using this command

  6. ```winpty docker exec -it [Docker container-name] bash; ```

  7. ```psql -U postgres```

  8. ```connect to database cogupdb```
  
   8. ```start Springboot application in IDE.```

### Testing in Postman

Send a POST request to http://localhost:8080/api/v1/userprofile object as JSON creates a new "userprofile";

```
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
```

