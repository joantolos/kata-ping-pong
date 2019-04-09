# kata-ping-pong

POC for explore the possibilities of using acceptance, functional and performance tests on the same level of the production code.

- WORK IN PROGRESS - 

# Ping pong service 

The service exposes three operations, which we can divide into two basic features:

* Feature MOVE:
    * **/ping** -> Returns Ping...
    * **/pong** -> Returns Pong...

* Feature PLAY:
    * **/play** -> Returns Ping... or Pong... randomly
    
So, if the service is working properly, the following acceptance criteria must be met:

![Behaviour Tests](behaviourTest.png)

# Implementing the feature **MOVE**

Let's suppose, that we have the following JIRA task:

    **LS-00001: Make Ping move**

    As a user of the Ping Pong game, I want to make a ping move. 
    Once the operation /ping of the service is executed, the service responds with a Ping move.

    Acceptance criteria:

    When /ping operation is executed, the service responds "Ping..."
    
The steps to implement the task would be:

1. Developer makes feature branch LS-00001.
2. Developer implements the task with BDD, including the acceptance tests to meet the acceptance criteria. (That can include mock services, mock data, start the service "embedded mode" etc).
3. Developer merge the feature branch with developer and puts the story "READY TO TEST".
4. QA pull changes from develop to test branch.
5. QA Optionally extends/adjust/improve the acceptance test for the story.
6. QA adds functional testing. (This is against the real service deployed on SNAPSHOT).
7. QA merge the test branch with develop branch and the code can be promoted to STABLE or higher.

This is the diagram for the example proposed:


![Behaviour Tests](featureMove.png)

# Test coverage

The principal problem about the frameworks creating test coverage is the multi-module problem. Normally, they only calculate the coverage for the module that you compile, one at a time. 

Using JACOCO as a test coverage tool, you can execute the following gradle task:

    ./gradlew jacocoRootReport
    
And the coverage report will be generated under: /build/jacoco/reports/jacocoRootReport/html/index.html

and looks something like this:

![Coverage](coverage.png)

What is interesting about that, is that it is taking into account all the tests in all the modules. So, the lines that the acceptance test cover, are included on the report. That is specially important because some little pieces of code are kind of silly to test with unit test, but using the generic approach of the acceptance tests, no line gets uncovered.
 
With this approach you can really apply the following premise:

If some line is not covered by test:
1. The code is missing tests
2. The line is not needed

# Building the code

All the modules of the project, including the tests ones (acceptance, functional and lib), but it only RUN the tests on demand.

* Compile the code, runs acceptance tests:
    
        ./gradlew clean build

* Compile the code, runs functional tests:

        ./gradlew -DwithFunctional=snapshot clean build

* Compile the code, runs acceptance and functional tests:

        ./gradlew -PwithAcceptance -DwithFunctional=snapshot clean build
        
If you choose to run the functional test, you have to specify which environment:

1. snapshot
2. stable

# Acceptance testing

Once you run the acceptance tests, Cucumber generates a report under the folder:

    1p-ping-pong-test/build/reports/acceptance-test-html-report/index.html

And looks something like that:

![Coverage](acceptance.png)

# Functional testing

The functional testing is using the actual service deployed on SNAPSHOT or STABLE. And creates the same kind of report than the acceptance does but at the location:

    1p-ping-pong-test/build/reports/functional-test-html-report/index.html

You have to configure the information about the service on the file **config.properties** located at: 1p-ping-pong-test/1p-ping-pong-test-lib/src/main/resources/config.properties

    #Eureka
    eureka.url=http://ec2-54-71-108-86.us-west-2.compute.amazonaws.com:8080/eureka/v2/apps/1ppingpong
    
    #Service host
    service.port=7001
    
    #Service endpoints
    service.end.point.ping=/ping
    service.end.point.pong=/pong
    service.end.point.play=/play
    
Remember to specify the environment variable -DwithFunctional=snapshot or -DwithFunctional=stable

## Cherry picking features

By default, if you run the build with the functional tests, it will run all the features for every scenario.

If you want to run specific features, or build some report (for the Jenkins plugin for example), you have to go to /1p-ping-pong-test/1p-ping-pong-functional and run:

    gradle runTags -DwithFunctional=snapshot -Dcucumber.tags=@Functional

This will execute the functional tests and generate the json file for the report, for ALL features and scenarios

    gradle runTags -DwithFunctional=snapshot -Dcucumber.tags=@LS-00001
    
This will execute the functional tests and generate the json file for the report, for the feature with the tag @LS-00001. The features can be separated by commas:

    gradle runTags -DwithFunctional=snapshot -Dcucumber.tags=@LS-00001,@LS-00003
    
The output of the execution is on /1p-ping-pong-test/1p-ping-pong-test-functional/build/reports/ where you can find the json files that will be consumed by the Jenkins Plugin.
    
# Performance testing

The performance testing is using the actual service deployed on SNAPSHOT or STABLE. And creates a Gatling record with all the specifics of your performance testing.

    1p-ping-pong-test/build/reports/functional-test-html-report/index.html

You have to configure the information about the service on the file **config.properties** located at: 1p-ping-pong-test/1p-ping-pong-test-lib/src/main/resources/config.properties

    #Eureka
    eureka.url=http://ec2-54-71-108-86.us-west-2.compute.amazonaws.com:8080/eureka/v2/apps/1ppingpong
    
    #Service host
    service.port=7001
    
    #Service endpoints
    service.end.point.ping=/ping
    service.end.point.pong=/pong
    service.end.point.play=/play
    
Remember to specify the environment variable -DwithPerformance=snapshot or -DwithPerformance=stable and the gradle task for running gatling simulation: **runPerformanceSimulation**

    ./gradlew -DwithFunctional=stable -DwithPerformance=stable clean build runPerformanceSimulation
    
The performance behaviour is defined on the Scala class: **PingPongPerformanceTest**