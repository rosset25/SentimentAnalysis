# Sentiment Analysis

This program is a simple phrase classifier (positives or negatives), based on Bayes' theorem. To train this classifier we used three different databases with positive and negative sentences.


## Getting Started

Clone the repository and open the project with Intellij. You can also use another IDE, such a Eclipse. How running the program and the tests are shown in the sections below.


### Prerequisites

Java SE Development Kit 8 installation is required. 

### Installing

To install the JDK: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html?ssSourceSiteId=otnes

## Running the test

The following steps explain how configure JUnit 5.0 for Intellij. If you are using another IDE, such Eclipse, please search the pertinent information and configure it before running the tests.
Remember, our program uses JUnit 5.0 version. 

  * Open the project
  * Press ``` Control+Alt+Mayus+S``` or ```File -> Project Stucture```
  * Select ```Libraries```
  * Press ```+``` and select ```From Maven...```
  * Search ```org.junit.jupiter:junit-jupiter-api:5.0.0``` and then OK
  
Now you are ready to run *NaiveBayesTest* class. As we said before, our project uses three different databases that are saved in the *resources* folder. However, feel free to change and use other databases with [*(sentence).  (pos/neg)*] schema, such the following one:

```Wow... Loved this place.	1```
```Crust is not good.	0 ```

