package com.locked.me;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BusinessOperations {

	//Bubble sort to sort file in ascending order
	protected static String[] sort_sub(String array[], int size){
		String temp = "";
		for(int i=0; i<size; i++){
			for(int j=1; j<(size-i); j++){
				if(array[j-1].compareToIgnoreCase(array[j])>0){
					temp = array[j-1];
					array[j-1]=array[j];
					array[j]=temp;
				}
			}
		}
		return array;
	}
	

	
	//File listing function
	protected static void listFiles() {
		
		int fileCount = 0;
	    ArrayList<String> filenames = new ArrayList<String>();
	
		File directoryPath = new File(System.getProperty("user.dir"));
		File[] listOfFiles = directoryPath.listFiles();
		fileCount = listOfFiles.length;
		
		
		System.out.println("Files in ascending fashion: ");
		for (int i = 0; i < fileCount; i++) {
		  if (listOfFiles[i].isFile()) {
		    filenames.add(listOfFiles[i].getName());
		  } 
		}
		
		String[] str = new String[filenames.size()];
		 
	    for (int i = 0; i < filenames.size(); i++) {
	        str[i] = filenames.get(i);
	    }
		
	    String[] sorted_filenames = sort_sub(str, str.length);
		
		for(String currentFile: sorted_filenames) {
			System.out.println(currentFile);
		}

	}
	
	//File delete function
	protected static void deleteFile(String fileToBeDeleted) {
		
		File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeDeleted );
		
		if(file.exists()) {
			if ( file.delete() ) {
				System.out.println("Hoorah! File deleted successfully!");
			}
		} else {
			System.out.println("Sorry, File wasn't deleted (File Not Found)");
		}
	}
	
	//File search function
	protected static void searchFile(String fileToBeSearched) {
	        
		File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeSearched );
		
		//Check whether file whether file exists or not.
		//If yes then display associated message
		if(file.exists()) {
			System.out.println("Yep! File found!");
		} else {
			System.out.println("Sorry, File is not here (File Not Found)");
		}	PrintWriter pw;  
        try {  
            pw = new PrintWriter(fileToBeSearched); //may throw exception   
            pw.println("saved");  
        }  
        // providing the checked exception handler  
        catch (FileNotFoundException e) {  
              
            System.out.println(e);  
        } 
	}

	//File creation function
	protected static void createFile (String fileToBeCreated) {
		File file = new File( (System.getProperty("user.dir") ) + "\\" + fileToBeCreated );
		
		try {
			if (file.createNewFile() ) {
				System.out.println("File Created!");
			} else {
				System.out.println("File already exists :(");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
