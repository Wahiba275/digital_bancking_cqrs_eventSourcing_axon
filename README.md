# CQRS Event Sourcing Application with Spring Boot and Axon Framework
# Overview 
This application serves as a practical example of implementing Command Query Responsibility Segregation (CQRS) and Event Sourcing principles.
It features a straightforward REST API through which users can establish a bank account and perform transactions such as deposits and withdrawals.
Crafted in Java, the application utilizes the Spring Boot framework for its infrastructure, along with the Axon Framework to facilitate its event-driven architecture.
# Dependencies
![Java](https://img.shields.io/badge/Java-red?style=for-the-badge&logo=java)
![Spring](https://img.shields.io/badge/Spring-green?style=for-the-badge&logo=spring)
![Axon](https://img.shields.io/badge/Axon-blue?style=for-the-badge)
![Framework](https://img.shields.io/badge/Framework-darkblue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-blue?style=for-the-badge&logo=mysql)

# Project Structure
```
digital_banking_cqrs_eventSourcing_axon
├── .idea
├── .mvn
└── src
    └── main
        ├── java
        │   └── ma
        │       └── enset
        │           └── digital_banking_cqrs_eventsourcing_axon
        │               ├── commandapi
        │               │   ├── commands
        │               │   │   ├── BaseCommand.java
        │               │   │   ├── CreateAccountCommand.java
        │               │   │   ├── CreditAccountCommand.java
        │               │   │   └── DebitAccountCommand.java
        │               │   └── dto
        │               │       ├── CreateAccountRequestDTO.java
        │               │       ├── CreditAccountRequestDTO.java
        │               │       └── DebitAccountRequestDTO.java
        │               ├── enums
        │               │   ├── AccountStatus.java
        │               │   └── OperationType.java
        │               └── events
        │                   ├── AccountActivatedEvent.java
        │                   ├── AccountCreatedEvent.java
        │                   ├── AccountCreditedEvent.java
        │                   └── AccountDebitedEvent.java
        └── query
            ├── exceptions
            │   ├── AmountNegativeException.java
            │   └── BalanceNotSufficientException.java
            ├── queries
            │   ├── GetAccountByIdQuery.java
            │   └── GetAllAccountQuery.java
            └── commands
                ├── aggregates
                │   └── AccountAggregate.java
                ├── controllers
                │   └── AccountCommandController.java
                ├── query
                │   └── Controllers
                │       └── QueryAccountController.java
                ├── entities
                │   ├── Account.java
                │   └── Operation.java
                ├── repositories
                │   ├── AccountRepository.java
                │   └── OperationRepository.java
                ├── services
                │   └── AccountServiceHandler.java
                └── DigitalBankingCqrsEventSourcingAxonApplication.java
    └── resources
        └── application.properties
```
# Axon Framework
Axon Framework is a Java-based framework for building scalable, extensible, and maintainable applications by supporting the implementation of CQRS (Command Query Responsibility Segregation) and Event Sourcing patterns. Axon Framework provides the building blocks for message handling components, allowing developers to focus on the core business logic rather than the boilerplate code required to implement an event-driven microservices architecture. This simplifies development and supports clean, domain-focused code that can evolve over time with the business needs.
## Key Concepts and Components of Axon Framework
The Axon Framework is built on several foundational principles:
1. **Domain-Driven Design (DDD):** Axon aligns closely with DDD principles, which emphasize the importance of basing the design on the underlying domain of the business.
2. **CQRS:** This pattern separates the handling of command messages (which modify state) from query messages (which read state). This separation allows you to scale read and write workloads independently and optimize the architecture for each function.
3. **Event Sourcing:** This is a storage pattern used to persist the state of a business entity. Instead of storing just the current state, all changes to the state are stored as a sequence of events. These events are immutable and represent a fact of change in the system.
4. **Event-driven architecture:** Axon facilitates the design of a system where the flow of the program is determined by events.
5. **Sagas:** A saga is a sequence of events that can span multiple aggregate boundaries and is managed by the framework, ensuring that the eventual consistency is maintained in distributed systems.
6. **Aggregates:** These are clusters of domain objects that are treated as a single unit for the purpose of data changes. In Axon, commands are targeted towards aggregates.
7. **Event Store:** Axon can be configured to use an event store that persists events to a storage mechanism, allowing the application to reconstruct an aggregate's state by replaying events.
8. **Event Store:** Axon can be configured to use an event store that persists events to a storage mechanism, allowing the application to reconstruct an aggregate's state by replaying events.
9. **Axon Server:**
   Axon Framework often employs Axon Server as an event store and message router for commands, events, and queries. It's a robust standalone server that can be deployed for basic development environments or scaled to cater to intricate application demands.

   To set up Axon Server on your machine, follow these steps:

   1. **Download Axon Server:**
      - Visit the [AxonIQ download page](https://developer.axoniq.io/download) to get the latest version of Axon Server.
      - Choose the Standard Edition for a free version or the Enterprise Edition if you have a subscription.

   2. **Run Axon Server:**
      - After downloading, unzip the Axon Server ZIP file to a directory of your choice.
      - Open your terminal or command prompt and navigate to that directory.

   3. **Start Axon Server:**
      - On Windows, execute the following command:
        ``` java -jar axonserver.jar ```
        This command will start Axon Server, and you should see output in the terminal that indicates the server is running. By default, Axon Server will listen on port `8024` for the HTTP API and port `8124` for the gRPC interface.

## Axon Server Management Interface Overview
1. **web interface of Axon Server** 
![Alt text](URL_to_image "Optional title")
2. **Axon Server dashboard's sections for "Commands" and "Queries"**
In these sections, you typically see the list of command and query message types that have been processed by the server.
![Alt text](URL_to_image "Optional title")
![Alt text](URL_to_image "Optional title")

# Testing 
1. Testing the creation of an account
   ![Alt text](URL_to_image "Optional title")
2. Testing the creation of an account with negative initial balance
   ![Alt text](URL_to_image "Optional title")
3. Fetching event from event store
   ![Alt text](URL_to_image "Optional title")
4. Testing the credit of an account
   - **Postman**:
     ![Alt text](URL_to_image "Optional title")
   - **Directly from Event Store**
     ![Alt text](URL_to_image "Optional title")
5. Testing the debit of an account
   - **Postman**:
     ![Alt text](URL_to_image "Optional title")
   - **Directly from Event Store**
     ![Alt text](URL_to_image "Optional title")
6. Testing the debit of an account with insufficient balance
    ![Alt text](URL_to_image "Optional title")


































