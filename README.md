# Technical test

Required first technical test on selection process.

## Description

REST API with endpoint to retrieve specific information from database, based on given params.

## Getting Started

### Dependencies

* Maven project. See [pom.xml](pom.xml)

### Installing

* Clone present git repository.

### Executing program

* Run program from: [TestApplication](src/main/java/com/zara/technical/TestApplication.java)

## Authors

Oriol Ballesteros - ballesterosoriol@gmail.com

## Comments

* Import [Postman collection](src/main/resources/postman.json) for manual testing.

* Archicture: [Hexagonal Architecture](https://herbertograca.com/2017/11/16/explicit-architecture-01-ddd-hexagonal-onion-clean-cqrs-how-i-put-it-all-together/)

* Principles: 
  * [SOLID](https://www.baeldung.com/solid-principles)
  * [KISS](https://www.baeldung.com/java-clean-code)

* Using JUnit for testing due to simplicity reasons. In a real case scenario, following refactor might be changing it to [Groovy Spock](https://spockframework.org/) as an equally powerfull and simple testing framework.

* [Lombok's API](https://projectlombok.org/) usage was evaluated. While super-simple, yet powerful, and straightforward to use, for such a project it was considered unnecessary.