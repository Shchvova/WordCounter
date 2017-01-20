import static org.junit.Assert.*;


import java.nio.file.Path;
import java.nio.file.Paths;


import org.junit.Test;

public class WordCounterTests {


	/*
	*	These test cases test all the Unit Test cases for the WordCounter class.
	*   It comprises of the test conditions to test the software code and assess its feasibility.
	*   The code is compiled and run according to the test case and every line of code is tested thoroughly.
	*
	*	All file paths are in string format below.
	*	Author: Conor Hynes
	*/
	
	
	
	
	String Seven_Words_FilePath = Paths.get("Seven_Words.txt").toAbsolutePath().toString();
	String Zero_Words_FilePath = Paths.get("Zero_Words.txt").toAbsolutePath().toString();
	String Punctuation_FilePath = Paths.get("punctuationWords.txt").toAbsolutePath().toString();
	String Punctuation_Only_FilePath = Paths.get("punctuationOnly.txt").toAbsolutePath().toString();
	String foreignText_FilePath = Paths.get("foreignText.txt").toAbsolutePath().toString();
	String Numerics_FilePath = Paths.get("Numerics.txt").toAbsolutePath().toString();
	String DifferentDirectory_FilePath = Paths.get("DifferentDirectory","DifferentDirectory.txt").toAbsolutePath().toString();
	

	
	/* 
	*  Test ID: 01
	*  Description : Test the "countWords()" function with  7 words and one UTF 8 Character
	*  Prerequisites : Seven_Words.txt file must be present in the following directory :  Bina_Test\Seven_Words.txt
	*  Expected Output : 7
	*  Actual : 7
	*  Status : Pass
	*/
	
	@Test
	public void count_Seven_Words()
	{	
		WordCounter Book1 = new WordCounter(Seven_Words_FilePath);
		Book1.countWords();
		int result = Book1.getNumWords();
		assertEquals(7,result);
	}

	/* 
	*  Test ID: 02
	*  Description : Test the "countWords()" function with  0 words 
	*  Prerequisites : Zero_Words.text file must be present in the following directory :  Bina_Test\Zero_Words.txt
	*  Expected Output : 0
	*  Actual : 0
	*  Status : Pass
	*/

	@Test
	public void count_Zero_Words()  
	{
		WordCounter Book1 = new WordCounter(Zero_Words_FilePath);
		Book1.countWords();
		int result = Book1.getNumWords();
		assertEquals(0,result);
	}
	
	/* 
	*  Test ID: 03
	*  Description : Test the "countWords()" function with 10 words,4 of which have punctuation 
	*  Prerequisites : punctuationWords.text file must be present in the following directory :  Bina_Test\punctuationWords.txt
	*  Expected Output : 10
	*  Actual : 10
	*  Status : Pass
	*/
	
	@Test
	public void count_Words_With_Punctuation() 
	{
		WordCounter Book1 = new WordCounter(Punctuation_FilePath);
		Book1.countWords();
		int result = Book1.getNumWords();
		assertEquals(10,result);
	}
	
	/* 
	*  Test ID: 04
	*  Description : Test the "isValidCharacter()" function by passing a txt file with 5 UTF 8 Characters into the "WordCounter" constructor, it should return 0 as these characters are not valid  words
	*  Prerequisites : The punctuationOnly.text file must be present in the following directory :  Bina_Test\punctuationOnly.txt
	*  Expected Output : 0
	*  Actual : 0
	*  Status : Pass
	*/
	
	@Test
	public void count_Punctuation() 
	{
		WordCounter Book1 = new WordCounter(Punctuation_Only_FilePath);
		Book1.countWords();
		int result = Book1.getNumWords();
		assertEquals(0,result);
	}
	
	/* 
	*  Test ID: 05
	*  Description : Test  the "isValidWord()" function by passing a txt file with 6 different words from foriegn languages and 2 UTF 8 Characters.
	   The counter will count 6 words and skip the UTF 8 characters
	*  Prerequisites : The foreignText.text file must be present in the following directory :  Bina_Test\foreignText.txt
	*  Expected Output : 0
	*  Actual : 0
	*  Status : Pass
	*/
	
	@Test
	public void count_Non_English_Words() 
	{
		WordCounter Book1 = new WordCounter(foreignText_FilePath);
		Book1.countWords();
		int result = Book1.getNumWords();
		assertEquals(6,result);
	}
	
	/* 
	*  Test ID: 06
	*  Description : Test the "isNumeric()" , but by passing by value instead of  passing a file path into the "WordCounter(final String filePath)" constructor
	*  Prerequisites : None
	*  Expected Output : True
	*  Actual : True
	*  Status : Pass
	*/
	
	@Test
	public void check_Is_Numeric() 
	{
		WordCounter Book1 = new WordCounter();
		boolean result = Book1.isNumeric("12");
		assertTrue(result);
	}
	
	/* 
	*  Test ID: 07
	*  Description : Test the "isNumeric()" function, in the context of reading through a file. For this test case, our expect result will be 0.
	*  Since the text file in this test case only contains  the numerics "12" and not a valid sentence but is a numeric
	*  
	*  Prerequisites : The Numerics.text file must be present in the following directory :  Bina_Test\Numerics.txt
	*  Expected Output : 0
	*  Actual : 0
	*  Status : Pass
	*/
	
	@Test
	public void check_Is_Numeric_From_File() 
	{
		WordCounter Book1 = new WordCounter(Numerics_FilePath);
		Book1.countWords();
		int result = Book1.getNumWords();
		assertEquals(0,result);
	}
	
	/* 
	*  Test ID: 08
	*  Description : Test the "getNumWords()" function, after the countWords() 
	*  function counts the number of words in the text file, the getNumWords will return the number of words
	*  
	*  Prerequisites : The Seven_Words.txt file must be present in the following directory :  Bina_Test\Seven_Words.txt
	*  Expected Output : 7
	*  Actual : 7
	*  Status : Pass
	*/
	
	@Test
	public void get_Num_Words_From_File() 
	{
		WordCounter Book1 = new WordCounter(Seven_Words_FilePath);
		Book1.countWords();
		int result = Book1.getNumWords(); 
		assertEquals(7,result);
	}

	/* 
	*  Test ID: 09
	*  Description : Test the "getFileName()" function. We pass in the directory for the  "Seven_Words.txt" file into  the "WordCounter(final String filePath)" constructor.
	*  Prerequisites : The Seven_Words.txt file must be present in the following directory :  Bina_Test\Seven_Words.txt
	*  Expected Output : "Seven_Words.txt" 
	*  Actual : "Seven_Words.txt" 
	*  Status : Pass
	*/

	@Test
	public void get_File_Name() 
	{
		WordCounter Book1 = new WordCounter(Seven_Words_FilePath);
		String result = Book1.getFileName(); 
		assertEquals("Seven_Words.txt",result);
	}
	
	/* 
	*  Test ID: 10
	*  Description : Test the "getPathName()" function. We pass in the directory for the  "Seven_Words.txt" file into  the "WordCounter(final String filePath)" constructor.
	*  Prerequisites : The Seven_Words.txt file must be present in the following directory :  Bina_Test\Seven_Words.txt
	*  Expected Output : C:\Users\Conor\workspace\Bina_Test\Seven_Worlds.txt for my system or Seven_Words_FilePath for any others
	*  Actual : C:\Users\Conor\workspace\Bina_Test\Seven_Worlds.txt for my system or Seven_Words_FilePath for any others
	*  Status : Pass
	*/
	
	@Test
	public void get_Path_Name() 
	{
		WordCounter Book1 = new WordCounter(Seven_Words_FilePath);
		Book1.countWords();
		Path pathResult = Book1.getPathName();
		String result = pathResult.toString(); 
		String expected = Seven_Words_FilePath;
		assertEquals(expected,result);
	}
	
	/* 
	*  Test ID: 11
	*  Description : Test the "setPathName()" function. Instead of passing the directory into the our constructor ,
	*  we use a default constructor and use the "setPathName" function to set the path name.
	*  Prerequisites : The Seven_Words.txt file must be present in the following directory :  Bina_Test\Seven_Words.txt
	*  Expected Output : C:\Users\Conor\workspace\Bina_Test\Seven_Worlds.txt for my system or Seven_Words_FilePath for any others
	*  Actual : C:\Users\Conor\workspace\Bina_Test\Seven_Worlds.txt for my system or Seven_Words_FilePath for any others
	*  Status : Pass
	*/
	
	@Test
	public void set_Path_Name() 
	{
		WordCounter Book1 = new WordCounter();
		Book1.setPathName(Seven_Words_FilePath);
		Book1.countWords();
		
		Path pathResult = Book1.getPathName();
		String result = pathResult.toString(); 
		String expected = Seven_Words_FilePath;
		assertEquals(expected,result);
	}

	/* 
	*  Test ID: 12
	*  Description : Test the "getFileName()" function.
	   We'll use a different location from the usual one,to expand our test cases
	*  Prerequisites : The DifferentDirectory.text file must be present in the following directory :  Bina_Test\DifferentDirectory\DifferentDirectory.txt"
	*  Expected Output : C:\Users\Conor\workspace\Bina_Test\DifferentDirectory\DifferentDirectory.txt for my system or DifferentDirectory_FilePath for any others
	*  Actual : C:\Users\Conor\workspace\Bina_Test\DifferentDirectory\DifferentDirectory.txt for my system or DifferentDirectory_FilePath for any others
	*  Status : Pass
	*/
    
    @Test
    public void read_File_From_Foreign_Directory() 
    {
    	WordCounter Book1 = new WordCounter(DifferentDirectory_FilePath);
        String result = Book1.getFileName();
        String expected = "DifferentDirectory.txt";
        assertEquals(expected, result);
    }

}
