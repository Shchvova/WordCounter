# Bina Word Counter Tests

This program counts the number of words in a text file.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You will need the following files and folders in your workspace to ensure all tests run and pass succesfully
* foreignText.txt
* Numerics.txt
* punctuationOnly.txt
* punctuationWords.txt
* foreignText.txt
* Seven_Words.txt
* Zero_Words.txt
* DifferentDirectory.txt
* DifferentDirectory\ 

### Installing

Your workspace should contain the project ``` Bina_Test```  like mine below

```
C:\Users\Conor\workspace\Bina_Test
```

I can only test the directories for windows 

```
C:\Users\YOURUSERNAME\workspace\Bina_Test
```



## Running the tests

To run the tests, run the ```  TestSuite  ``` and all 14 tests should run and pass
You can also see the program running in the main, by running the method ``` demoCount(); ```

### H

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```
## Why you tested your word counter the way you did?
To test the  ``` WordCounter  ``` class , all of its methods must be test to ensure all the all the code works as intended. With my approach, I wrote the Junit tests as I wrote the program, as opposed to writing the tests after developing the program. This helped me define the acceptance criteria and allowed me to validate my code as I wrote it.This is my first time using JUnit in a professional context so I would apprciate  feedback on my approach, I'm not afraid of making mistakes because thats how you learn.

My workflow was as follows:
* Add a test
* Run all tests and see if the new one fails
* Write some code
* Run tests
* Refactor code
* Repeat

Each test case had a set of attributes, forcing me to think about each test would work as I wrote it.
*  Test ID: 
*  Description : 
*  Prerequisites : 
*  Expected Output : 
*  Actual : 
*  Status :

As I wrote the  ``` WordCounter  ```  class I would write tests to validate any point in the code where I could use an ```Assert Method```  to validate an expected output.  So I'd write the test then focus soley on that test until it passed, breaking the program into smaller junks rather than one whole application. I could then incrementally build on passing tests  instead of constantly refactoring code leading to new bugs.Once your tests are passing is safer to refactor. 

I also tested all possible  ``` IOExceptions   ```   that could be thrown from the from the ```WordCounter``` class functions. 
If an non-existing file or invalid directory is passed into the ```WordCounter``` an IOException is thrown. To test this I simply passed  an invalid directory for test 13 and a non-existing file for test 14 , as seen below.


    @Test(expected=NullPointerException.class,timeout = 2500)
    public void wordCounter_Exception_Invalid_Directory() 
    {
    	WordCounter Book1 = new WordCounter(A_Non_Existed_Directory);
    	Book1.countWords();
    	
    }


Further testing can be done in this scenario, an ``` IOExceptions   ``` is thrown but a message is also given to the user.


```  The following directory 
 C:\Users\Conor\workspace\Bina_Test\Binnaaa\ThisDoesNotExist.txt 
 Does not contain the file:  ThisDoesNotExist.txt
 ```




 
 


## Why you think your testing is sufficient for your code to be merged?
To run the tests, run the ```  TestSuite  ``` and all 14 tests should run and pass
You can also see the program running in the main, by running the method ``` demoCount(); ```

## Comment on additional testing you would consider beyond this JUnit test suite after your code is merged
To run the tests, run the ```  TestSuite  ``` and all 14 tests should run and pass
You can also see the program running in the main, by running the method ``` demoCount(); ```

## Include the time you spent on the entire exercise 
* 9-10 Hours(this includes research and planning)

## Built With

* Core JDK
* Eclipse
* Sublime Text 3



## Authors

* **Conor Hynes** 
* Contact : conorhynes18@gmail.com

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hungry to learn
* Inspiration
* Code2Cure

