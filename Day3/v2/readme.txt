This demonstration uses Openfeign , eureka server
Hardcoding URL in Feign Client is a bad design choice as it tightly couples to 1 specific instance of microservice
which means scaling up and scaling down won't work.
In microservice architecture that is very common to spin up multiple instances of a microservice if needed and spin down 
if the need is over and hence you can not keep track of port numbers of all the instances it is running on.

Exactly to solve this problem we have a design pattern, Service Discovery.

The idea is each microservice registers itself with service discovery with some unique name.
The client microservice can just use the logical name as it is registered with discovery service to connect to that
microservice.

One of the most popular and respected service discovery is Eureka from Netflix.

Steps to use Eureka Server:-
- Create a new Spring boot project
- Add appropriate dependencies(eureka-server)
- Enable Eureka server by annotating application class with @EnableEurekaServer
- Change the port to 8761(not mandate but recommended)

To test Eureka Server running hit following url
http://localhost:8761/ in browser

Note:- By default Eureka Clients registers themselves with UNKNOWN name

Steps for Eureka Client
- Add appropriate dependencies(eureka-discovery-client)
- Add a property in application.properties to give appropriate name to each microservice
- Add a property in application.properties to specify url of Eureka server.
- Annotate application class with @EnableEurekaClient(this is optional step, but recommended for better readability)

It is very common to spin up multiple instances of multiple MS and to spin down. Hence it is practically impossible to keep 
track of port numbers and change them manually by visiting application.properties file.

To dynamically assign the unused ports, we have to follow steps given below:-
- In application.properties of each microservice, write server.port = 0
By default, every instance has 1 ID associated with it while registering with eureka. We need to make sure that
the ID is unique froo every instance. To do that , we have to add the following property in application.properties file:-
eureka.instance.instance-id=${spring.application.name}:${random.value}

