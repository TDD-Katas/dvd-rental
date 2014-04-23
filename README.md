  DVD rental store
=====================

In this problem you are required to provide an implementation of the DvdService interface, a simple service that contains two methods:
```java
retrieveDvd(String dvdReference) throws DvdNotFoundException
getDvdSummary(String dvdReference) throws DvdNotFoundException
```

<h3>General requirements</h3>

The following DVDs are stored within a test repository [reference in brackets]:

| Reference      | Name           | Description           | 
| -------------- | -------------- |  -------------------- |
| DVD-TG423	 | Topgun	  | All action film  |
| DVD-DD878	 | Dirty Dancing  | Nobody leaves baby in the corner |
| DVD-S765	 | Shrek	  | Big green monsters, they're just all the rage these days, what with Hulk, Yoda, and that big ugly troll thingy out of the first Harry Potter movie. But Shrek, the flatulent swamp-dwelling ogre with a heart of gold (well, silver at least), is more than capable of rivalling any of them. |

The method `retrieveDvd(String dvdReference) throws DvdNotFoundException`:
* Should retrieve a DVD by its reference
* Ensure that the dvdReference is prefixed by ‘DVD-‘
* Throw a DvdNotFoundException where appropriate

The second method `getDvdSummary(String dvdReference) throws DvdNotFoundException`:
* Ensure that the dvdReference is prefixed by ‘DVD-‘
* Throw a DvdNotFoundException where appropriate
* Provide a DVD summary that concatenates the reference, the title, and the first ten words of the review followed by ‘...’

<h3>Scenarios</h3>

**retrieveDvd(String dvdReference)**

| Input                               | Expected Output   | 
| ----------------------------------- | ----------------- |
| INVALID-TEXT	 | Exception: Invalid reference syntax, it should begin with DVD |
| DVD-999	 | Exception: The DVD was not found |
| DVD-TG423	 | Topgun |


**getDvdSummary(String dvdReference)**

| Input                               | Expected Output   | 
| ----------------------------------- | ----------------- |
| INVALID-TEXT	| Exception: Invalid reference syntax, it should begin with DVD |
| DVD-TG423	| [DVD-TG423] Topgun - All action film |
| DVD-S765	| [DVD-S765] Shrek - Big green monsters, they're just all the rage these days, what with Hulk, Yoda, and that big ugly troll thingy out of the first Harry Potter movie. But Shrek, the flatulent swamp-dwelling ogre with a heart of gold (well, silver at least), is more than capable of rivalling any of them. |
