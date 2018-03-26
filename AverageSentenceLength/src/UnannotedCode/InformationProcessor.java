package src.UnannotedCode;
import src.UnannotedCode.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;

public class InformationProcessor {
	public static double processor(FileInputStream fin,int wordLength,HashSet<String> delimiters) {
		double averageSentenceLength = 0.0;
		int noOfWords = 0;
		int noOfSentences = 0;
		int i;
		char ch;
		int wordLengthCount = 0;
		int wordCountBetweenDelimiters = 0;
		boolean checkFlagSentence = false;
		boolean checkFlagWord = false;
		try {
			do {
				i = fin.read();
				if(i != -1) {
					ch = (char)i;
					if(ch == ' '||ch == '\n' || ch == '\t') {
						if(wordLengthCount >= wordLength) {
							noOfWords++;
							wordCountBetweenDelimiters++;
						}
						checkFlagWord = true;
						wordLengthCount = 0;
					}
					else if(delimiters.contains(Character.toString(ch))) {
						if(wordLengthCount >= wordLength) {
							noOfWords++;
							wordCountBetweenDelimiters++;
						}
						wordLengthCount = 0;	
						checkFlagSentence = true;
						if(wordCountBetweenDelimiters > 0)	{
								noOfSentences++;
								wordCountBetweenDelimiters = 0;
							}
					}
					else {
						wordLengthCount ++;
						checkFlagWord = false;
						checkFlagSentence = false;
					}
				}
			} while(i != -1);
		} 
		catch(IOException e) {
			System.out.println("Error Reading File");
		}
		try {
			fin.close();
		}
		catch(IOException e) {
			System.out.println("Error Closing File");
		}
		if(checkFlagWord == false && wordLengthCount != 0)	noOfWords++;
		if(checkFlagSentence == false)	noOfSentences++;
		averageSentenceLength = (double)noOfWords/noOfSentences;
		//to round off the averageSentenceLength to two decimal places
		averageSentenceLength = Double.valueOf(new DecimalFormat("#.##").format(averageSentenceLength));
		return averageSentenceLength;
	}
}
