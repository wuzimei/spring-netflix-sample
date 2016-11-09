# spring-netflix-sample
this is a sample for spring cloud netflix

It has following sub modules:<br/>
*  spring-cloud-eureka-server
*  service-core
*  service-word-segment
*  command-line-server

## spring-cloud-eureka-server
This is a microservice registry and discovery server using netflix eureka. It runs on port 8761.

## service-core
This is a common library and interface definations for other modules(service-word-segment, command-line-server etc).

## service-word-segment
This is a microservice which function is to seperate a sentence to word segments. It runs on port 7000.

## command-line-server
This is a server that you can input some command, and the server will call other microservice to do some business and return the result to user. It runs on port 9000.
