# Game Store (POC)

## Overview

This project is a designed solution for problem:

Game Store with a lot of traffic and big catalog of games.

+ Exist a client provide browse, search, add games to a shopping cart possibility. If cart is not empty user can go to order finalization, as registered user.
+ Admin panel where employees can manage games catalog, adjust prices etc, and they do it quite often - they work on drafts, change it many times, and then publish the changes.

### Documentation tools

To make easier the reading and writing of this documentation, the following tools have been used:

+ [Github diagrams tools](https://docs.github.com/en/get-started/writing-on-github/working-with-advanced-formatting/creating-diagrams)
+ [Markdown Linter](https://marketplace.visualstudio.com/items?itemName=DavidAnson.vscode-markdownlint)
+ [Mermaid diagrams](https://mermaid-js.github.io/mermaid/#/) + [Mermaid Preview for Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=bierner.markdown-mermaid)

### Development environment

This is description of development environment used to develop this app

+ JAVA: 17.0.5-oracle
+ GRADLE: 7.5.1
+ Docker: 14.3.0
+ Visual Studio Code

Project starter generated by: <https://start.spring.io/>
More information about generated base: [HELP.md](./docs/HELP.md)

### How to build and start app

The Java Spring application build process is defined in file **build.gradle**.

The docker-compose file for developing purposes is located in docker folder. **./docker/dev-docker-compose.yaml**

To start docker containers required to start application use command:

```bash
docker compose -f ./docker/dev-docker-compose.yaml up
```

To start app on MacOs you need to have installed JAVA and GRADLE and use terminal command:

```bach
gradle bootRun
```

After this command app will be listening on address [http://localhost:8080](http://localhost:8080).

You can always check the status of app on address: [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)

---

## Proposed Solution

Proposed solution should provide 3 main application:

+ Backend - Java Spring
+ Client Frontend - React
+ Admin Panel Frontend - React

Consider combining frontend applications into one common application.

The applications communicate with each other using the Rest API.

### Backend

Backend application should provide good possibility of browsing and searching. To increase performance of system and make response time shorter consider the cache layer.

Proposed tools and libraries:

+ [**Java Spring Boot**](https://spring.io/projects/spring-boot) as Java Backend framework
+ [**Redis**](https://redis.io/) as cache layer
+ [**PostgreSQL**](https://www.postgresql.org/) database - Object Relational Database
+ [**Liquibase**](https://www.liquibase.org/) Version control for database.
+ [**Logback**](https://logback.qos.ch/) - logging
+ [**Actuator**](https://www.baeldung.com/spring-boot-actuators) - for monitoring endpoints
+ [**Project Lombok**](https://github.com/projectlombok/lombok/wiki) - for code readability

### Frontend

---

## Architecture decisions

This part describe the architecture decision process.

### Data Base

More information about database selection process available in documentation file: [DB-docs.md](./docs/DB-docs.md)

#### Additional materials

+ <https://www.integrate.io/blog/the-sql-vs-nosql-difference/>
+ <https://developer.okta.com/blog/2019/07/19/mysql-vs-postgres>
+ <https://www.fivetran.com/blog/postgresql-vs-mysql>
+ <https://www.guru99.com/postgresql-vs-mysql-difference.html>
