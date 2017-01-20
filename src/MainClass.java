
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
public class MainClass 
{

/*
 *   Driver program for an example of the program
 * 
 */
	public static void main(String[] args) throws IOException 
	{
		demoCount(); // 
		
	}
	
	
	public static void demoCount()
	{
		
		String Seven_Words_FilePath_Main = Paths.get("Seven_Words.txt").toAbsolutePath().toString(); // Get the path for the file we want to read
		
		WordCounter Book1 = new WordCounter(Seven_Words_FilePath_Main); // Pass it into our constructor
		Book1.countWords(); // Count the words
		
		// Use our WordCounter getters to get the file name and the number of words in the file
		System.out.println("The File: \n"+Book1.getFileName()+"\n"+"Has a total of "+Book1.getNumWords()+" words in it\n");
		
		
	}
}
