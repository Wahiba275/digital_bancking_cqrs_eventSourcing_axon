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
# application.properties








