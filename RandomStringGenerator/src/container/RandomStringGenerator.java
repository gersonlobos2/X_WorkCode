package container;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.*;
import org.apache.commons.cli.*;



public class RandomStringGenerator  {
	ArrayList<Range> Lista= new ArrayList<Range>();

	/**
	 * @param args
	 */
	public RandomStringGenerator() //constructor
	{
	}
	
	public void addRange(char s1, char s2)
	{
		Lista.add(new Range(s1,s2));
	}
	private int  getRangeIndex()
//This is repeatedly called by RandomStringGenerator.nextString(int)
	//to decide which range object to use to retrieve the next character.
	{
		
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(Lista.size()) + 0;
		
		return index;//it returns the index of the ranges in the list. we will use.
	}
	public void nextString(int numLength)
	//to decide which range object to use to retrieve the next character.
	{
		String word="";
		
		for(int i=0;i<numLength;++i)
		{
			word += (Lista.get(getRangeIndex())).getRandomCharacter();
			//it gets the range and from that range gets the character.
		}
		System.out.println(word);
	}
	public void nextString(String A){
		/*
		 * will accept a string made up of the characters 'c', 'C' and 'd'. 
		 * It will then iterate through this string and add a lowercase
		 *  letter to its output string for each 'c' encountered, an uppercase
		 *   letter for each 'C' encountered and a digit for each 'd' encountered.
		 *    For example, RandomStringGenerator.nextString('CdddcC) might 
		 *    return 'X481aW'.
		 * */
		String NewWord="";
		//needs to have a output display with the world;
		char temp;
		for(int i=0;i< A.length(); ++i){
			
			//System.out.println("---this is the character at "+i+ A.charAt(i) );
			
				if(A.charAt(i) =='c')
				{
					NewWord += (Lista.get(0)).getRandomCharacter();
				}
				else if(A.charAt(i) =='C')
				{
					NewWord += (Lista.get(1)).getRandomCharacter();
				}
				if(A.charAt(i) =='d')
				{
					NewWord += (Lista.get(2)).getRandomCharacter();
				}
		}//end of for loop.
		
		System.out.println(NewWord);
	
	}
	/*
	public static void main(String[] args) {
		
		String temp1,temp2,ask;
		RandomStringGenerator Generator = new RandomStringGenerator();
		Scanner scan = new Scanner(System.in);
		boolean check=false;
		
		while (check==false){
			
		System.out.println("enter a range");
		System.out.println("from range: ");
		temp1= scan.next();
		System.out.println("range to: ");
		temp2 = scan.next();
		
		Generator.addRange(temp1.charAt(0), temp2.charAt(0));
		System.out.println("do you want to add more ranges? yes(y),no(n)");
		ask=scan.next();
		
		if(ask.endsWith("no")||ask.endsWith("n"))
		{
		check=true;
		}//end if
		
		}//end while
		
		System.out.println("this is a random character:");
		Generator.nextString(5);
		
		
		//****************************************************
		RandomStringGenerator Generator2= new RandomStringGenerator();
		Generator2.addRange('a', 'm');
		Generator2.addRange('E', 'R');
		Generator2.addRange('3', '8');
		System.out.println("this is the new string");
		
		Generator2.nextString("CdddcC");
		
		
		System.out.println("done");
	}//end main
	*/

}//end class
