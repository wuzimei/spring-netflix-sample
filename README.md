# spring-netflix-sample
this is a sample for spring cloud netflix

It has following sub modules:<br/>
*  spring-cloud-eureka-server
*  service-core
*  service-word-segment
*  command-line-server
*  zuul-gateway

## spring-cloud-eureka-server
This is a microservice registry and discovery server using netflix eureka. It runs on port 8761.

## service-core
This is a common library and interface definations for other modules(service-word-segment, command-line-server etc).

## service-word-segment
This is a microservice which function is to seperate a sentence to word segments. It runs on port 7000.

## command-line-server
This is a server that you can input some command, and the server will call other microservice to do some business and return the result to user. It runs on port 9000.

## zuul gateway
This is an API gateway. It runs on port 8080.

## install & RUN
```Bash
# build jars
cd spring-netflix-sample
mvn clean package
```
```Bash
# start eureka server
java -jar spring-cloud-eureka-server/target/xxx.jar
```
```Bash
# start service-word-segment
java -jar service-word-segment/target/xxx.jar
```
```Bash
# start command-line-server
java -jar command-line-server/target/xxx.jar
```
```Bash
# start zuul-gateway
java -jar zuul-gateway/target/xxx.jar
```


## Check server status
![](https://github.com/wuzimei/spring-netflix-sample/blob/master/eureka_cap.png)

## Test with postman
![](https://github.com/wuzimei/spring-netflix-sample/blob/master/postman_cap.png)  
