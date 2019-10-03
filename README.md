
Coding Challenge package

This is the Java implementation of the ZIP code simplification challenge.  The challenge package 
contains a util package with most of the logical components.  

The main entry class (org.ziprange.Main)  takes in the input, parses it with ZipCodeParser,
 and processes that result with RangeListSimplifier.  
 ZipCodeRange is a model class holding the ranges (pairs of low,high zip codes).
 
RangeListSimplifier performs the simplification routine on the structured list of zipcode ranges.  That's where
the real algorithm work is done.

You can run the Unit tests from the command line as follows
## compile the projest
$ mvn compile
## package and generate the jar 
$ mvn package
## run the tests along
$ mvn test 

## Run your own set of zipcode ranges using the jar directly...

`$ java -jar target/wschallenge-1.0-SNAPSHOT.jar  [94133,94133] [94200,94299] [94600,94699]`

`[94133,94133] [94200,94299] [94600,94699]`

`$ java -jar target/wschallenge-1.0-SNAPSHOT.jar  [94133,94133] [94200,94299] [94226,94399]`

`[94133,94133] [94200,94399]`

The unit tests RangeListSimplifierTest.testChallengeFirstSampleValue and RangeListZImplifierTest.testChallengeSecondSampleValue
  also perform tests on the two input examples described in the challenge.ß
  
Coding notes:
I've used Java 1.5-compatible code, which is pretty old.  When I got to the joining of the ZipCodeRange elements 
in the result (main method)  I did decide to try a map / collect pattern from the newer Java 1.8 code, instead of importing 
an apache text utility, or implementing the space joining by hand.  It seemed appropriate at the time, and interesting
to try.

I did my coding in IntelliJ, built it as a maven project, using Junit library for testing. 

Thanks for your consideration.  It's been a good exercise, and I look forward to speaking with you.
 
