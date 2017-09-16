# Description
A simple backend project uses Jersey 

Endpoint:
http://127.0.0.1:1234/user/{user_id}/info

Example:
$ curl http://127.0.0.1:1234/user/1/info
{"id":1,"name":"user_1"}


# Dependencies
- maven
- Java 8
- mysql


# Setup (on ubuntu 16.04)

### install maven
```
$ sudo apt-get install maven
```

### install mysql
```
$ sudo apt-get install mysql-server

```

### how to populate database
```
( Replace all 'new_user' to your database user name in populate.sh and DbUtil.java)

- Go to project directory
$ ./populate.sh
```


# Build instructions:


### How to build:

```
$ mvn clean package
```

### How to run the project
```
# go to project directory
$ java -jar target/simple-jersey-project.jar

```