This demonstration uses OpenFeign,Secured Eureka, Api gateway, spring cloud load balancer, resilience4j,sleuth,zipkin, Config Servers, Spring Cloud Bus

Eureka is very important and essential application in MS architecture, hence we have to take care of following 2 things:-
1. Security of Eureka - The idea is each microservice trying to register itself must authenticate with Eureka first. If authentication is successfull, then only Eureka allows MS to register with itself.
2. To avoid single point of failure, we must have cluster of Eureka servers.

Steps to do this:-
- Add security dependency in Eureka application(spring-security)
- Add appropriate username/password
- Write Configuration class
- Each Ms must be passing username and password while connecting to Eureka

