package src.AnnotedCode;
import src.AnnotedCode.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;

import org.checkerframework.checker.index.qual.*;
import org.checkerframework.common.value.qual.*;
import org.checkerframework.checker.nullness.qual.*;

public class Validate {
	private final static int defaultWordLength = 3;
	private final static String[] defaultDelimiters = {".","!","?"};
	
	
	
	public static double validateInput(String file,String receivedWordLength,HashSet<String> receivedDelimiters) {
		FileInputStream fin;
		int wordLength;
		if(file.endsWith(".txt")){
			try {
				fin = new FileInputStream(file);
			} 
			catch(FileNotFoundException e) {
				System.out.println("File Not Found\n");
				return -1;
			}
		}
		else {
			System.out.println("File is not in .txt format\n");
			return -1;
		}
		
		if(receivedWordLength != null) {
			try {
				wordLength = Integer.parseInt(receivedWordLength);
			}
			catch(NumberFormatException e){
				System.out.println("Word Length should be an integer");
				return -1;
			}
		}
		else {
			wordLength = defaultWordLength;
		}
		for(String s : defaultDelimiters) {
			receivedDelimiters.add(s);
		}
		return InformationProcessor.processor(fin,wordLength,receivedDelimiters);
	}
}
