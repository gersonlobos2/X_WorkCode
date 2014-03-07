
import java.util.*;// vector is in util
import java.io.*;
import java.lang.*;


public class iofiles {
	
	static double computation(String line2){
		//the first line from the file is passed
		
		String digits = ""; //used to store the string of nums to be converted to int
		double numdigits=0;
		double num1,num2;
		Stack<Double> bag= new Stack<Double>();
		
		for(int i=0; i< line2.length(); ++i)
		{
			if( (Character.isDigit(line2.charAt(i)) ) ==true || line2.charAt(i)=='.')
			{
				
				while(Character.isDigit(line2.charAt(i))==true || line2.charAt(i)=='.')
				{
					if(line2.charAt(i)== '.')
					{
						digits += line2.charAt(i);
						++i;
					}
					
				digits += line2.charAt(i);
				++i;
				}
				
				numdigits= Double.parseDouble(digits);  //to convert string into integer
				
				
				digits="";
				
				bag.push(numdigits); //to convert the int numdigits into double and store it in stack
				//System.out.print("the digit is ="+ bag.peek()+ "\n");
			}
			
			else
			{
				switch(line2.charAt(i))
				{
					case '+':
						num2= bag.peek();
						bag.pop();
						num1= bag.peek();
						bag.pop();
						bag.push(num1+num2);
						//System.out.print("this is goint to the stack now after + ="+bag.peek()+"\n");
						break;
						
					case '-':
						num2= bag.peek();
						bag.pop();
						num1= bag.peek();
						bag.pop();
						bag.push(num1-num2);
						//System.out.print("this is goint to the stack now after - ="+bag.peek()+"\n");
						break;
						
					case '*':
						num2= bag.peek();
						bag.pop();
						num1= bag.peek();
						bag.pop();
						bag.push(num1*num2);
						break;
						
					case '/':
						num2= bag.peek();
						bag.pop();
						num1= bag.peek();
						bag.pop();
						bag.push(num1/num2);
						//System.out.print("this is goint to the stack now after / ="+bag.peek()+"\n");
						break;
						
					case '_':
						
						num1= bag.peek();
						bag.pop();
						bag.push(num1-(num1*2));
						//System.out.print("this is goint to the stack now after _ ="+bag.peek()+"\n");
						break;
						
					case '#':
						num1= bag.peek();
						bag.pop();
						bag.push(Math.sqrt(num1));
						break;
						
					case '^':
						num2= bag.peek();
						bag.pop();
						num1= bag.peek();
						bag.pop();
						bag.push(Math.pow(num1, num2));
						//System.out.print("this is goint to the stack now after ^ ="+bag.peek()+"\n");
						break;
						
					default:
						break;
				
				}//end of switch statement
				
			}//end of else statement
			
		}//end of for loop
		
		
		
		
		return bag.peek();
	}
	
	
	public static void main(String[] args) {
		
		
		String filename;
		
		Vector<String> LinesContainer= new Vector<String>();
		
		
		 // holds the line to be check for character
		
		//--------reading from a file
		System.out.print("Hello! This is a postfix expression calculator."+"\n");
		System.out.println("What is the name of the File to read from:");
		Scanner in= new Scanner(System.in); 
		filename= in.next();
		
		java.io.File file= new java.io.File(filename); //creates a file named from string filename
		
		try{
			
			Scanner input = new Scanner(file);
			while(input.hasNext()){
			String line = input.nextLine(); //gets the line from file and puts in string
			LinesContainer.add(line);       //stores the lines into the container
			System.out.println(line);
			}
			
		}catch (FileNotFoundException e) {
			System.err.format("File does not exist \n");
		}
	
		
		//there are two for loops one that goes through the character in each line ane the other that
		//goes through each line in the vector
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter("in.dat");
			  BufferedWriter outTo = new BufferedWriter(fstream);
			  
			  outTo.write("Hello! This is a postfix expression calculator."+"\n");
			  
		for(int x=0;x<LinesContainer.size();++x)
		{
		double result = computation(LinesContainer.elementAt(x));	
		System.out.print("The value of \""+LinesContainer.elementAt(x)+"\"  is "+result+"\n");
		outTo.write("The value of \""+LinesContainer.elementAt(x)+"\"  is "+result+"\n");
		}//end of second for loop
		//---------writing to  file
		
		
		  //Close the output stream
		  outTo.close();
		
		 }catch(Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	
		 /* example to write to a file
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter("out.txt");
			  BufferedWriter out = new BufferedWriter(fstream);
			  
			  out.write("Hello Java");
			  //Close the output stream
			  out.close();
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		 */
		 
		 //-----------
		 
		 
	}//ends main
	
}// ends class
