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
git clone https://github.com/OKaluzny/spring-boot-docker-postgres.git
Build the maven project:
mvn clean install
Now run:
docker-compose up
Appendix A.

All commands should be run from project root (where docker-compose.yml locates)

Guide for using endpoint the app:

Go to http://localhost:8080/demo/api/automobiles to test and would specify basic authorization a username: user and password: user or username: admin and password: admin

GET request to /api/automobiles/ returns a list of "automobiles";
GET request to /api/automobiles/1 returns the "automobile" with ID 1;
POST request to /api/automobiles/ with a "automobile" object as JSON creates a new "automobile";
PUT request to /api/automobiles/3 with a "automobile" object as JSON updates the "automobile" with ID 3;
DELETE request to /api/automobiles/4 deletes the "automobile" with ID 4;
DELETE request to /api/automobiles/ deletes all the "automobiles".
or use Swagger API http://localhost:8080/demo/swagger-ui.html

and generation API docks http://localhost:8080/demo/v3/api-docs.yaml

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