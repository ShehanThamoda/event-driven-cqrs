# event-driven-cqrs
Using Axon dependency and implemented the separate projects for each insertion/updating parts and data retrieving part. In here use the mongo db instead of Axon server for data storing part. Query Service using the Redis server to retrieving the data.

Order-Service -> This service implemented for handling the insertion and update APIs.
Order-Service-Query -> This service implemented for handling the Get APIs.
