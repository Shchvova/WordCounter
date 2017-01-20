
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	 /*
	 * 	This class counts the number of words in a text file
	 * 	Author: Conor Hynes
	 */

public class WordCounter 
{
	private int count=0;
	private String file;
	private Path file_Path;

	public WordCounter() // Default Constructor
	{

	}
		
	public WordCounter(final String filePath) // Constructor that takes a file path as an parameter
	{	
		this.setPathName(filePath);
	
	}
	
	public void countWords() // Function to count the number of words in a file
	{
		try{
			
		    FileReader fr = new FileReader (file);    //File reader object to read file
		    BufferedReader br = new BufferedReader (fr); //Reads text from a character-input stream
		    String line = br.readLine(); //Store each line as a string,so we can iterate through the text file
		    while (line != null) //While there is a line
		    {
		    	String []parts = line.split(" "); // parse the strings between the spaces	    	
		    	
		    	for( String word : parts) //Loop through array of words using an enhanced for loop
		    	{
		    		if(isNumeric(word)!=true && isValidWord(word)==true && isValidCharacter(word) == true ) // Lets check if the string is not a number and is a valid word
		    		{
		    			count++; // Count the words
		    		}
		    	}
		    	line = br.readLine(); //Read the next line
		   }
		   closeFile(br); //Close the text file  
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	/*
	 *  Use Java's built-in java.text.NumberFormat object to see if, 
	 *  after parsing the string the parser position is at the end of the string.
	 * 	If it is, we can assume the entire string is numeric:
	 * 
	 */
	
	public boolean isNumeric(String word) // This function checks is the string a number
	{
		// Checks number formats
		NumberFormat formatter = NumberFormat.getInstance(); 
		 // Keeps track of the current position during parsing
		
		ParsePosition pos = new ParsePosition(0); 
		// Parse the string,so the parser is at the end of the string
		formatter.parse(word, pos);
		
		//Check if it is, if so,its a numeric
		return word.length() == pos.getIndex(); 
	}	

	public void closeFile(BufferedReader fileToClose)
	{
		try 
		{
			fileToClose.close();		
		} 
		catch (IOException e)
		{	
			e.printStackTrace();
			System.out.println("File wasn't Closed");
		}
	}
	
	public boolean isValidWord(String word) //Checks if the word is a valid word, for all languages 
	{
		Pattern p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);  // Pattern.UNICODE_CHARACTER_CLASS  enables the Unicode version of the predefined character classes 
		Matcher match = p.matcher(word);
	    return match.find();
	}
	
	public boolean isValidCharacter(String word) // Checks if words don't start with a punctuation char such as ?? or !! 
	{
		int i;
		boolean isValidCharacter=true;
		String [] punctuation = {"." , "," , ";" , ":", "?" , "!" ,"<" , "\"" , ")" , "(","_","{","}"};
		for (i = 0; i < punctuation.length;i++)
		{

			if(word.startsWith(punctuation[i]) && word.endsWith(punctuation[i]) )
			{
				isValidCharacter = false;
			}

		}
		  return isValidCharacter;
	}

	public int getNumWords() // Returns the number of words
	{	
		return count;
	}
	
	public String getFileName()  // Returns the name of the file
	{
		return file;
	}

	public Path getPathName() //Get path name
	{
		return file_Path;
	}
	
	public void setPathName(String pathForFile) //Set the path for the file
	{	
		file_Path = Paths.get(pathForFile); // We can use our file_Path variable for checking if the directory or file exists 

		if (Files.exists(file_Path)==true ) 
		{
			file = file_Path.getFileName().toString(); 
		}
		else
		{	
			System.out.println("\n The following directory \n "+file_Path+" \n Does not contain the file: " +" "+file_Path.getFileName().toString());
		}
	}

}
