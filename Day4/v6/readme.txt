This demonstration uses OpenFeign,Eureka, Api gateway, spring cloud load balancer, resilience4j,sleuth,zipkin

Because MS architecture is distributed, tracing a specific request would be a challange
In order to keep track of distributed tracing , spring cloud offers sleuth
The idea is that each request has specific ID across all the microservices and within a microservice and by default sleuth logs that on console with these 2 ids 
and application name

Steps to use Sleuth
1. Add appropriate dependency in each of the microservice along with the Api Gateway
 [order-service,305fa64d9513a0f8,e8a93e88470395f7] -> service name, trace id, span Id
 [coupon-service,305fa64d9513a0f8,99e2502971bad717] -> service name, trace id, span Id

Trace id is unique across all the microservices.
Span Id is unique for each request within that MS

Logs are generated and we want to consolidate them and show them at central location in GUI form. To exactly do this, we have Zipkin.

Steps to use Zipkin
- Download Zipkin server
- Run Zipkin server
- Add approp depend in each MS
- Add proeprty that specify zipkin url in each MS

If we are going with defaults, writing this property is optional:=-
spring.zipkin.base-url=http://localhost:9411