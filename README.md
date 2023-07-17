
This is a demo project to test some spring-boot feature such as:
* Mysql
* Hibernate
* Relationship between objects
* Swagger
* Graphql
* Spring AOP
* Spring Security
* Load Sample data using Spring Batch 
* Load Sample data using ApplicationRunner
* Use of MapStruct to load DTO.
* Use lombok

Steps to configure the project:
1. Navigate to the root folder of the project and execute the following command: docker-compose -f docker-compose-mysql.yml up
This command will start a mysql container that will contain the database.

The database configuration is the following:
db.name= clientdb
db.user= root
db.pwd = root

2. Execute the maven install goal to download and install all the dependencies that the project will need, using the following command:
   mvn install -Dmaven.plugin.validation=VERBOSE


3. Execute the 2 SQL files located on /resources/spring-batch/ folder.

4. Start the server and access: http://localhost:8080/

The available project APIs:
All users: http://localhost:8080/users/all
All posts: http://localhost:8080/posts/all

Swagger:
http://localhost:8080/clientapp-documentation
http://localhost:8080/clientapp-api-docs

Graphql:
http://localhost:8080/graphiql

Queries:

query userDetails {
  getUser(id: 2) {
    id
    name
  }
}

query usersDetails {
  getAllUsers {
    id
    name
  }
}

query postsDetails {
  getAllPosts {
    id
    title
    content
  }
}

query postDetails {
  getPost(id:1) {
    id
    title
    content
  }
}

Mutations:

mutation {
  createUser(name: "sample-name") {
    id
    name
  }
}

TODO:
* add javadoc
* Automatic drop and add schema for spring batch
* Add Test
