
import java.util.*;// vector is in util
import java.io.*;
import java.lang.*;
import ClassNodes.BTNode; //it is including the file with the class BTNode

public class iofiles {
	
	static BTNode<String> CreatingThree(String line2)
	{
		String digits = ""; //used to store the string of nums to be converted to int
		
		BTNode<String> ThreeNode;
		BTNode<String> LeftNode;
		BTNode<String> RightNode;
		Stack<BTNode> BTHolder= new Stack<BTNode>();
		
		for(int i=0; i< line2.length(); ++i)
		{
			
			if( (Character.isDigit(line2.charAt(i)) ) == true || line2.charAt(i)=='.')
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
				}     // end of while loop
				
				
				//********************  CREATING NODES
				ThreeNode = new BTNode<String>(digits,null,null);  //Creating the node
				
				BTHolder.push(ThreeNode);  //pushing node into the stack.
				
				
				digits="";  //this has to go after putting it into the node

			}
			
			else
			{
				switch(line2.charAt(i))
				{
					case '+':
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("+",LeftNode,RightNode);

						BTHolder.push(ThreeNode);
						break;
						
					case '-':
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("-",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						break;
						
					case '*':
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("*",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '/':
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("/",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
					
						break;
						
						
					case'%':
						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("%",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						break;
					case '_':
						
						
						RightNode = BTHolder.peek();
						BTHolder.pop();					
						
						ThreeNode = new BTNode<String>("_", null ,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '#':

						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("#", null ,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '^':
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("^",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);

						break;
						
					case '=':
						
						i++;  // i++ because it has two character of == 
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("==",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '&':

						i++; //to increase i because there are 2 &.
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("&&",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '|':  
							
						i++; //to increase i because there are 2 |.
						
						RightNode = BTHolder.peek();
						BTHolder.pop();
						LeftNode = BTHolder.peek();
						BTHolder.pop();
						
						ThreeNode = new BTNode<String>("||",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '!':
						if(line2.charAt(i+1)== '=')
						{

							i++; //to increment i because two characters ! and =
							
							
							RightNode = BTHolder.peek();
							BTHolder.pop();
							LeftNode = BTHolder.peek();
							BTHolder.pop();
							
							ThreeNode = new BTNode<String>("!=",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
						}
						else if(line2.charAt(i+1) != '=')
						{	
							RightNode = BTHolder.peek();
							BTHolder.pop();
				
							
							ThreeNode = new BTNode<String>("!",null,RightNode);
							
							BTHolder.push(ThreeNode);
						}
						
						break;
						
					case '>':
						if(line2.charAt(i+1)== '=')
						{
							++i;  // increasing i because 2 char, > and =
							
							RightNode = BTHolder.peek();
							BTHolder.pop();
							LeftNode = BTHolder.peek();
							BTHolder.pop();
							
							ThreeNode = new BTNode<String>(">=",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
						}
						else if(line2.charAt(i+1) != '=')
						{

							RightNode = BTHolder.peek();
							BTHolder.pop();
							LeftNode = BTHolder.peek();
							BTHolder.pop();
							
							ThreeNode = new BTNode<String>(">",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
							
						}
						
						break;
							
							
					case '<':
						if(line2.charAt(i+1)== '=')
						{

							++i;  // increasing i because 2 char, > and =
							
							RightNode = BTHolder.peek();
							BTHolder.pop();
							LeftNode = BTHolder.peek();
							BTHolder.pop();
							
							ThreeNode = new BTNode<String>("<=",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
						}
						else if(line2.charAt(i+1) != '=')
						{

							RightNode = BTHolder.peek();
							BTHolder.pop();
							LeftNode = BTHolder.peek();
							BTHolder.pop();
							
							ThreeNode = new BTNode<String>("<",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
							
						}
						
						break;
					
					default:
						break;
				
				}//end of switch statement
			}//end of else statement
		}//end of for loop

		return BTHolder.peek();
	}
	
	static double computation(String line2)
	{
		
		String digits = ""; //used to store the string of nums to be converted to int
		double numdigits = 0;
		double num1,num2;
		boolean bool1, bool2;
		Stack<Double> bag= new Stack<Double>();
		
		for(int i=0; i< line2.length(); ++i)
		{
			
			if( (Character.isDigit(line2.charAt(i)) ) == true || line2.charAt(i)=='.')
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

				numdigits= Double.parseDouble(digits);  //to convert string into integer   **********   CHECK
				
				digits="";
				
				bag.push(numdigits); //to convert the int numdigits into double and store it in stack
				
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
						
					case '=':
						
						num2= bag.peek();
						bag.pop();
						num1= bag.peek();
						bag.pop();
						
						
						if((num1 == num2)==true){
							bag.push(1.0);
							
						}
						else
							bag.push(0.0);
						
						i++;  // i++ because it has two character of == 
						
						break;
						
					case '&':
						 
						num2= bag.peek();  
						bag.pop();
						num1= bag.peek();
						bag.pop();
						
						if(num2==0.0 || num2 == 0)
							bool2 = false;
						else
							bool2 = true;
						
						if(num1 == 0.0 || num1 == 0)
							bool1 = false;
						else
							bool1 = true;
						
						if((bool1 && bool2) == true)
							bag.push(1.0);
						else
							bag.push(0.0);
						
							
						i++; //to increase i because there are 2 &.
						
						break;
						
					case '|':
						
						num2= bag.peek();  
						bag.pop();
						num1= bag.peek();
						bag.pop();
						
						if(num2==0.0 || num2 == 0)
							bool2 = false;
						else
							bool2 = true;
						
						if(num1 == 0.0 || num1 == 0)
							bool1 = false;
						else
							bool1 = true;
						
						if((bool1 || bool2) == true)
							bag.push(1.0);
						else
							bag.push(0.0);
							
						i++; //to increase i because there are 2 |.
				
						break;
						
					case '!':
						if(line2.charAt(i+1)== '=')
						{
							num2= bag.peek();  
							bag.pop();
							num1= bag.peek();
							bag.pop();
							
							if((num1 != num2) == true)
								bag.push(1.0);
							else
								bag.push(0.0);

							i++; //to increment i because two characters ! and =
						}
						else if(line2.charAt(i+1) != '=')
						{
							num1 = bag.peek();
							bag.pop();
							
							if(num1 == 1.0)
								bag.push(0.0); // pushing the opposite because it is negating
							else if(num1 ==0.0)
								bag.push(1.0);
							
						}
						
						break;
						
					case'%':
						num2= bag.peek();  
						bag.pop();
						num1= bag.peek();
						bag.pop();
						
						bag.push(num1 % num2);
						
						break;
						
					case '>':
						if(line2.charAt(i+1)== '=')
						{
							num2= bag.peek();  
							bag.pop();
							num1= bag.peek();
							bag.pop();
							
							if((num1 >= num2)==true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
							++i;  // increasing i because 2 char, > and =
							
						}
						else if(line2.charAt(i+1) != '=')
						{
							num2= bag.peek();  
							bag.pop();
							num1= bag.peek();
							bag.pop();
							
							if((num1 > num2) == true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
						}
						
						break;
							
					case '<':
						if(line2.charAt(i+1)== '=')
						{
							num2= bag.peek();  
							bag.pop();
							num1= bag.peek();
							bag.pop();
							
							if((num1 <= num2)==true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
							++i;  // increasing i because 2 char, > and =
							
						}
						else if(line2.charAt(i+1) != '=')
						{
							num2= bag.peek();  
							bag.pop();
							num1= bag.peek();
							bag.pop();
							
							if((num1 < num2) == true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
						}
						
						break;
					
					default:
						break;
				
				}//end of switch statement
			}//end of else statement	
		}//end of for loop
		
		return bag.peek();
	}
	
	 public static void ShowInfixParenthesice(BTNode<String> root)
	   {
		 if ( root != null )
	      {
	         // Note:  do NOT parenthesize leaf nodes
	         if ( ! root.isLeaf() )
	            System.out.print ("( ");        // Pre-order position
	         ShowInfixParenthesice ( root.getLeft() );
	         System.out.print ( root.getData() + " " );   // In-order position
	         ShowInfixParenthesice ( root.getRight() );
	         if ( ! root.isLeaf() )                 // Post-order position
	            System.out.print (") ");
	      }
	   }
	public static void main(String[] args) {
		
		String filename;
		double result; 
		BTNode<String> ThreeNode;
		int height;
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
			System.out.println(line);      //Displaying every line from the file
			}
			
		}catch (FileNotFoundException e) {
			System.err.format("File does not exist \n");
		}
	
		//there are two for loops one that goes through the character in each line ane the other that
		//goes through each line in the vector
//		 try{
//			  // Create file 
//			  FileWriter fstream = new FileWriter("in.dat");
//			  BufferedWriter outTo = new BufferedWriter(fstream);
//			  
//			  outTo.write("Hello! This is a postfix expression calculator."+"\n");
			  
		for(int x=0;x<LinesContainer.size();++x)
		{
		 result = computation(LinesContainer.elementAt(x));
		 ThreeNode= CreatingThree(LinesContainer.elementAt(x));
		 
		 
		 System.out.print("\n");
		System.out.print("The value of \""+LinesContainer.elementAt(x)+"\"  is "+result+"\n");
	//	outTo.write("The value of \""+LinesContainer.elementAt(x)+"\"  is "+result+"\n");
		
		System.out.print("this is inorder : ");
		ThreeNode.inorderPrint();
		System.out.print("\n");
		
		System.out.print("this is pretorder : ");
		ThreeNode.preorderPrint();
		System.out.print("\n");
		
		System.out.print("this is postorder : ");
		ThreeNode.postorderPrint();
		System.out.print("\n");
		
		System.out.print("Parenthesise expresion: ");
		System.out.print("\n");
		ShowInfixParenthesice(ThreeNode);
		
		height= ThreeNode.TreeHeight(ThreeNode);
		System.out.print("\n");
		
		ThreeNode.print2(height);
		
		
	System.out.print("\n");
	System.out.print("Press enter to continue..."+ "\n");
	in= new Scanner(System.in); 
	in.nextLine();
		
		//System.out.print(ThreeNode.getData());
		
		
		}//end of for loop
		//---------writing to  file
		System.out.print("End Main."+ "\n");
		
		  //Close the output stream
//		  outTo.close();
//		
//		 }catch(Exception e){//Catch exception if any
//			  System.err.println("Error: heyy " + e.getMessage());
//			  }
	
	}//ends main
	
}// ends class
