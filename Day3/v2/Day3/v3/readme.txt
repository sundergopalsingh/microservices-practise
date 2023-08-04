This demonstration uses OpenFeign, Eureka, Api gateway
Dynamically assigning ports are good for scaling up and scaling down, but while accessing from client we must give 
- a constant fixed url

To exactly solve this problem, we use api gateway

Api gateway is used to route request from clients to microservices
Also microservices communication should be routed via api gateway.
We will be just exposing port and ip of api gateway to client application.
If we want to run common code for all MS, we will be writing that in Api gateway.(logging, authorization, authentication)
Api gateway can also be used as load balancer.

Steps for api gateway
1. Create a new springboot project
2. Add appropriate dependencies(eureka discovery client, gateway)
3. Add appropriate properties in application.properties
