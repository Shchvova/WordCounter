import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class ReadingFileTests {

	/*
	*	These test cases check if NullPointerExceptions are thrown, in a case where there is an invalid directory or non-existed file
	*
	*	All file paths are in string format below
	*   Author: Conor Hynes
	*/
	
	
	
	String thisDoesntExist_FilePath = Paths.get("thisDoesntExist.txt").toAbsolutePath().toString(); // This file does not exist
	String A_Non_Existed_Directory = Paths.get("Binnaaa","ThisDoesNotExist.txt").toAbsolutePath().toString(); // This path does not exist


	/* 
	*  Test ID: 13
	*  Description : Test the "countWords()" function. To test and see if an exception is thrown when a file that doesn't exist is given to the "WordCounter(final String filePath)" Constructor
	* 	
	*  Prerequisites : A directory that doesn't have the specified file
	*  Expected Output : fileDictory+"Bina_Test\\7Words.txt"
	*  Actual : fileDictory+"Bina_Test\\7Words.txt"
	*  Status : Pass
	*/
	
    @Test(expected=NullPointerException.class,timeout = 2000)
    public void wordCounter_Exception_NullFile() 
    {
        WordCounter WC = new WordCounter(thisDoesntExist_FilePath);
		WC.countWords();   
    }
    
	/* 
	*  Test ID: 14
	*  Description : Test the "countWords()" function. To test and see if an exception is thrown when an invalid directory is given  to the "WordCounter(final String filePath)" Constructor
	*  Prerequisites : An invalid directory such as Binaa_Test\\7words.txt" instead of  Bina_Test\\7words.txt
	*  Expected Output : Exception thrown
	*  Actual : Exception is thrown
	*  Status : Pass
	*/
	
    @Test(expected=NullPointerException.class,timeout = 2500)
    public void wordCounter_Exception_Invalid_Directory() 
    {
    	WordCounter WC = new WordCounter(A_Non_Existed_Directory);
		WC.countWords();
    }
}
