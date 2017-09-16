# Description
A sample backend project uses Jersey 

Endpoint:
http://127.0.0.1:1234/user/{user_id}/info

Example:
$ curl http://127.0.0.1:1234/user/1/info
{"id":1,"name":"user_1"}


# Dependencies
- maven
- Java 8
- mysql


# Setup

### install maven
```
$ sudo apt-get install maven
```

### install mysql
```
$ sudo apt-get install mysql-server

```
### if you are not login as root user, add a new user to mysql
```
$ sudo mysql -u root

# add new user
mysql> create user 'new_user'@'localhost'; 

# grant user all access to the database
mysql> grant all privileges on * . * to 'new_user'@'localhost';

```

### how to populate database
```
- Replace all 'new_user' to your user name (in populateg.sh and database.DbUtil)

- Go to project directory and run
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
java -jar target/simple-jersey-project.jar

```