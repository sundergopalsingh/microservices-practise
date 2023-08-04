This demonstration uses OpenFeign,Eureka, Api gateway, spring cloud load balancer, resilience4j,sleuth,zipkin, Config Servers

In microservice architecture there are a lot MS, each MS has its own configuration. Also we need different configs for different environments
Changing these configs by visiting application.properties file for that microservice is practically impossible, hence we would like to keep these config details
at central location and separate from each microservice which can be managed by operation team may be.
To exactly do this spring cloud offers Config Server
The idea is we are going to keep this configuration information at one location centrally(local file system or git repo)
By default config server would search for git repository

Config server would take the responsibility of reading the central config and exposing standard rest endpoints.
http://localhost:8888/application/default

Steps to use config server-
- Create new spring boot project
- Add appropriate dependencies(config-server,eureka-client)
- Enable config server by annotating application class with @EnableConfigServer
- Add appropriate properties

Once config server is setup, we need to configure MSs so that they can pick values from config server.
To do this each MS should act as a client to config server

Steps to define config server client
- add appropriate dependencies in each MS.
- add appropriate properties in application.properties file

Making any changes to any configuration at cetral repository won't be picked up dynamically by microservice. In order for those changes to reflect
microservice needs to restart

this is impractical and hence we want changes to be picked up dynamically. To do this we have to follow below steps:-
- Add actuator dependency in microservice
- Expose refresh endpoint using application.properties
- Annotate the class which is using this property with @RefreshScope
- Hit post request to http://localhost:<port of microservice>/actuator/refresh