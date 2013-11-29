        UNATTENDED PROGRAMMING EXERCISE DVD RENTAL STORE

COMPILING AND RUNNING

The project uses Maven for build and requires at least Java 6. 
To build the project you should run:
> mvn clean install
This command will compile and run all tests.

THE TESTS

The project has three types of tests: unit, integration and acceptance. 
Apart from testing the system, they have also the role of being a living documentation.

*Unit tests*
The unit tests describe the smallest behavior of the application. 
All the unit test are isolated from others using stubs.
The unit tests can be found in the folder ./src/test/java and their filename ends with *Test.java 
These tests can be run using:
> mvn test

*Integration test*
Because the unit test use stubs, the default constructors are usually not touched by them. 
The integration tests are responsible for testing the default bindings between objects.
The Integration tests can be found in the folder ./src/test/java  and their filename ends with *IT.java 
These tests can be run using:
> mvn verify

*Acceptance test*
These test show that the system does what is supposed to do from the business point of view. 
They can be viewed as testing by example. While unit tests and integration test are aware of the internal implementation, acceptance test only care about inputs and output.
The Acceptance tests tests can be found in the folder ./src/test/specs
These tests can be run using:
> mvn verify
The acceptance test have been implemented using Concordion. The output of running the test is an .html file located at:
/target/specs/com/sky/dvdstore/DvdService.html

TECHNIQUE

I implemented this exercise using Acceptance TDD. So, I first turned your specifications into acceptance tests using Concordion. (see /src/test/specs/**)
Concentrating on passing one acceptance test at a time, I wrote unit tests to describe the desired behavior. The tests where written using a mockist style approach.
After each test passed, I did refactorings in order to remove duplication and improve readability.
The biggest duplication that had to be removed was the one where both "retrieveDvd" and "getDvdSummary" where checking for errors in the input.
This behavior has been encapsulated into a DvdRepository decorator and the tests that described the behavior where moved accordingly.
Finally, an integration test was added to cover the bindings between objects.

OTHER THOUGHTS

As you suggested, I used the provided DvdRepositoryStub tor testing the system. 
In a normal application I would not do that. Here is why. As the repository stub if part of the test fixtures, you never want to hide its implementation inside a class. The tests should always be as clear as possible.
They should clearly show the initial state of the system, the action that they are performing and what is the expected state after the action.
In my acceptance test, to overcome this, I have exposed the DVDs contained inside the stub. This makes the tests more clear.


