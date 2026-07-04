# JP Morgan Chase Advanced Software Engineering
### Virtual Experience Program — Forage

---

## Overview

This project was completed as part of the **JP Morgan Chase & Co. Advanced Software Engineering** virtual experience program on Forage. The program simulates real-world backend engineering tasks at a large financial institution.

The focus was on building **Midas Core** — a backend service responsible for receiving, validating, and recording high-volume financial transactions at scale.

---

## Tech Stack

| Technology        |          Purpose                   |
----------------------------------------------------------
|                   |                                    |
|   Java 17         |   Core programming language        |
| Spring Boot 3.2.5 |       Backend framework            |
| Apache Kafka      | Message streaming for transactions |
| H2 Database       |     In-memory SQL database         |
| Spring Data JPA   |      Database ORM layer            |
| Maven             |  Build and dependency management   |
| Testcontainers    |  Integration testing with Kafka    |
----------------------------------------------------------

## Tasks Completed

### Task 1 — Project Setup
- Configured local Java 17 + Maven development environment
- Forked and cloned the Midas Core project scaffold
- Added all required Spring Boot, Kafka, H2, and testing dependencies to `pom.xml`
- Configured `application.yml` with Kafka topic settings
- Built the project and ran automated tests successfully

### Task 2 — Kafka Integration
- Implemented a Kafka consumer to receive incoming financial transactions
- Validated and processed transaction messages from the `trader-updates` topic
- Stored valid transactions in the H2 database using Spring Data JPA

### Task 3 — Database Integration
- Designed and implemented `TransactionRecord` entity
- Set up `TransactionRecordRepository` using Spring Data JPA
- Integrated transaction validation logic with database persistence

### Task 4 — Incentive API Integration
- Connected to an external REST incentive API
- Traced user balances and applied incentive calculations
- Consumed API responses and integrated results into transaction processing

### Task 5 — REST API Development
- Built a `GET /balance` REST controller on a custom port
- Exposed processed transaction data via a RESTful endpoint
- Implemented `BalanceController` with proper response formatting

---

## Project Structure

```
forage-midas/
├── src/
│   ├── main/
│   │   ├── java/com/jpmc/midascore/
│   │   │   ├── component/          # Kafka listeners
│   │   │   ├── controller/         # REST endpoints
│   │   │   ├── entity/             # JPA entities
│   │   │   ├── foundation/         # Core transaction models
│   │   │   └── repository/         # Database repositories
│   │   └── resources/
│   │       └── application.yml     # App configuration
│   └── test/
│       └── java/com/jpmc/midascore/
│           ├── TaskOneTests.java
│           ├── TaskTwoTests.java
│           ├── TaskThreeTests.java
│           ├── TaskFourTests.java
│           └── TaskFiveTests.java
├── services/                       # External service configs
├── pom.xml                         # Maven dependencies
└── README.md
```

---

## How to Run

### Prerequisites
- Java 17
- Maven 3.9+
- Git

### Steps

```bash
# Clone the repository
git clone https://github.com/tirzahshulamite-coder/forage-midas.git
cd forage-midas

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

# Run tests
mvn test
```

---

## Key Learnings

- How enterprise backend systems handle **high-volume financial transactions**
- Building and configuring **Kafka consumers** in a Spring Boot application
- **Spring Data JPA** for database persistence with H2
- Consuming and integrating **external REST APIs**
- Writing and running **integration tests** with Testcontainers
- Working with a real-world **project scaffold** as a software engineer would in industry

---

## Certificate

Completed the **JP Morgan Chase Advanced Software Engineering** virtual experience program via [Forage](https://www.theforage.com).

---

*Built as part of portfolio development for software engineering placements.*
