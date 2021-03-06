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

To run the tests, run the ```  TestSuite  ``` and all 16 tests should run and pass. I used a test  test suite which would make it easier to upgrade the framework.
You can also see the program running in the main, by running the method ``` demoCount(); ```

### Test Cases

Should I have a description of each test case here? @Vlad

```
Give an example
```

### And coding style tests

What style did I use?  @Vlad

```
Give an example
```
## Why you tested your word counter the way you did?
To test the  ``` WordCounter  ``` class , all of its methods must be tested to ensure all the all the code works as intended. With my approach, I wrote the Junit tests as I wrote the program, as opposed to writing the tests after developing the program. This helped me define the acceptance criteria and allowed me to validate my code as I wrote it.This is my first time using JUnit in a professional context so I would apprciate  feedback on my approach, I'm not afraid of making mistakes because thats how you learn.

My workflow was as follows:
* Add a test
* Run all tests and see if the new one fails
* Write some code
* Run tests
* Refactor code
* Repeat

Each test case had the following format with  a set of attributes, forcing me to think about each test would work as I wrote it.
*  Test ID: 
*  Description : 
*  Prerequisites : 
*  Expected Output : 
*  Actual : 
*  Status :

As I wrote the  ``` WordCounter  ```  class I wrote tests in parallel to validate any point in the code where I could use an ```assertEquals Method```  to validate an expected output.  So I'd write the test then focus soley on that test until it passed, breaking the program into smaller junks rather than one whole application. I could then incrementally build on passing tests  instead of constantly refactoring code, which could introduce  new bugs.Once my tests were passing it was safer to refactor. When testing the word counting functionality I tried to vary the testing scenarios. I would include words with varying punctuation.I also tried to include double UTF-8 characters in some of the text files like so ```??``` , to ensure the counter skipped such characters. 

I also tested all possible  ``` IOExceptions   ```   that could be thrown from the from the ```WordCounter``` class functions. 
If an non-existing file or invalid directory is passed into the ```WordCounter``` an IOException is thrown. To test this I simply passed  an invalid directory for test 13 and a non-existing file for test 14 , as seen below.

```
    @Test(expected=NullPointerException.class,timeout = 2500)
    public void wordCounter_Exception_Invalid_Directory() 
    {
    	WordCounter Book1 = new WordCounter(A_Non_Existed_Directory);
    	Book1.countWords();
    	
    }
```

Further testing can be done in this scenario, an ``` IOExceptions   ``` is thrown if the file is invalid but a message is also given to the user.

```
 The following directory 
 C:\Users\Conor\workspace\Bina_Test\Binnaaa\ThisDoesNotExist.txt 
 Does not contain the file:  ThisDoesNotExist.txt


```

 Even though the exception is thrown and the message is printed I tested to see if a file or directory exists as seen below.
 
 ```
 
    @Test
    public void wordCounter_NullFile_Check () {
    WordCounter Book1 = new WordCounter(thisDoesntExist_FilePath);
    Path file_Path = Paths.get(Book1.getPathName().toString());
    	
    boolean actualResult = Files.exists(file_Path);
    assertEquals(false,actualResult);
    }
 
```

## Why you think your testing is sufficient for your code to be merged?
No Idea @Vlad

## Comment on additional testing you would consider beyond this JUnit test suite after your code is merged
While unit test cases are great for throughly testing each line of code, further testing is necessary.

### User Acceptance 

Real world scenarios must be tested , with real users. So user acceptance testing must pass.

### System Testing

To ensure the application runs efficently on a system level tests such as stress,performance, security and recovery tests must pass. So the entire application end-to-end is tested.


### Servlet Testing?

?



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

