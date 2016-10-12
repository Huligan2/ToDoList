package java.Schneider.Utilities;

import java.Schneider.Definitions.Constants;
import java.Schneider.Definitions.SchneiderFile;
import java.io.ByteArrayOutputStream;
import java.io.File;;

// Package for company wide utilities  

// Wrapper for simplifying writing and reading files
public class FileHandler {
	
	

	public ByteArrayOutputStream readFile(SchneiderFile file){
		// code here to read data from file
		ByteArrayOutputStream content = new ByteArrayOutputStream();
		
		return content;
		
	};

	public int writeFile(SchneiderFile file){
		// code here to write data direct to file
		
		
		return Constants.success;
		
	};
	
}
