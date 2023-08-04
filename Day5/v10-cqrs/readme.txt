CQRS - Command Query Responsibility Segregation

The idea is very simple , we should divide our app into 2 parts
1. Command - responsible for altering state of object
2. Query- Responsible for retrriving state of object

The idea is to have 2 independent separate applications with 2 independent separate databases. One which is finetuned for write operations and the second one for
optimizing the read operations.
For eg - coupon-command-service, coupon-query-service
----
Command
Command is combination of intent (what we want to be done) as well as the information required to do that action based on the intent.

Naming convention for command is -
verb in imperative mode followed by entity we are dealing with followed by "command" -> Eg. CreateCouponCommand

Query
Query express the desire of information.
Naming Convention - 
Verb followed by entity we are dealing with ,followed by query word eg. FindCouponQuery

Axon Framework:-
It is used to simplify event driven MS based on CQRS
It can be used with spring boot by adding 1 dependency

Steps:
- Download Axon server
- Run it
- Add appropriate dependency (axon-springboot-starter and google guava)

Aggregated Object
This object is responsible for raising the event.

Aggregate Object also provides Command Handler

Event
Event is an object that describes something has happened or occured in the app. Source of event is aggregate.

Convention for event is - entity name + verb in past tense form + event eg, CouponCreatedEvent