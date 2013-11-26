Notes:

I implemented this exercise using Acceptance TDD.
I first turned your specifications into acceptance tests using Concordion. (see /src/test/specs/**)
For each acceptance test I wrote unit tests to describe the behavior. The tests where written using a mockist style approach.
After each test passed, I did refactorings in order to remove duplication and improve readability.
The biggest duplication that had to be removed was the one where both "retrieveDvd" and "getDvdSummary" where checking for errors in the input.
This behavior has been encapsulated into a DvdRepository decorator and the tests that described the behavior where moved accordingly.
Finally, an integration test was added to cover the bindings between objects.

Cheers,
  Julian
