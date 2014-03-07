
import java.util.*;// vector is in util
import java.io.*;
import java.lang.*;
import ClassNodes.BTNode; //it is including the file with the class BTNode

public class iofiles {
	
	static void computation(String line2)
	{
		
		String digits = ""; //used to store the string of nums to be converted to int
		double numdigits = 0;
		double num1,num2;
		boolean bool1, bool2;
		Stack<Double> bag= new Stack<Double>();
		int height;
		//----------Tree nodes
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
				}

				numdigits= Double.parseDouble(digits);  //to convert string into integer   **********   CHECK
				
				
				bag.push(numdigits); //to convert the int numdigits into double and store it in stack
				
				//********************  CREATING NODES
				ThreeNode = new BTNode<String>(digits,null,null);  //Creating the node
				
				BTHolder.push(ThreeNode);  //pushing node into the stack.
				digits="";  // to set the string that is holding the numbers back to empty

				
			}
			
			else
			{
				switch(line2.charAt(i))
				{
					case '+':
						num2= bag.pop();
						num1= bag.pop();
						bag.push(num1+num2);
						//System.out.print("this is goint to the stack now after + ="+bag.peek()+"\n");
							
						// putting into the tree
						RightNode = BTHolder.pop();
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("+",LeftNode,RightNode);

						BTHolder.push(ThreeNode);
						
						
						break;
						
					case '-':
						num2= bag.pop();
						num1= bag.pop();
						bag.push(num1-num2);
						//System.out.print("this is goint to the stack now after - ="+bag.peek()+"\n");
						
						//puting it into the tree
						RightNode = BTHolder.pop();
						
						
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("-",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '*':
						num2= bag.pop();
						num1= bag.pop();
						bag.push(num1*num2);
						
						//puting it into the tree
						RightNode = BTHolder.pop();
						
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("*",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '/':
						num2= bag.pop();
						num1= bag.pop();
						bag.push(num1/num2);
						//System.out.print("this is goint to the stack now after / ="+bag.peek()+"\n");
						
						//puting it into the tree
						RightNode = BTHolder.pop();
						
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("/",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						break;
						
					case '_':
						
						num1= bag.pop();
						bag.push(num1-(num1*2));
						//System.out.print("this is goint to the stack now after _ ="+bag.peek()+"\n");

						//puting it into the tree
						RightNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("_", null ,RightNode);
						
						BTHolder.push(ThreeNode);
						break;
						
					case '#':
						num1= bag.pop();
						bag.push(Math.sqrt(num1));

						//putting it into a tree
						RightNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("#", null ,RightNode);
						
						BTHolder.push(ThreeNode);
						break;
						
					case '^':
						num2= bag.pop();
						num1= bag.pop();
						bag.push(Math.pow(num1, num2));
						//System.out.print("this is goint to the stack now after ^ ="+bag.peek()+"\n");

						//puting it into the tree
						RightNode = BTHolder.pop();
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("^",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						break;
						
					case '=':
						
						num2= bag.pop();
						num1= bag.pop();						
						
						if((num1 == num2)==true){
							bag.push(1.0);
							
						}
						else
							bag.push(0.0);
						
						i++;  // i++ because it has two character of == 
						
						RightNode = BTHolder.pop();						
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("==",LeftNode,RightNode);
						BTHolder.push(ThreeNode);
						
						break;
						
					case '&':
						 
						num2= bag.pop();  
						num1= bag.pop();
						
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
						
						//putting it into the tree
						RightNode = BTHolder.pop();
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("&&",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '|':
						
						num2= bag.pop();  
						num1= bag.pop();
						
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
						
						//puting it into the tree
						
						RightNode = BTHolder.pop();
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("||",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
				
						break;
						
					case '!':
						if(line2.charAt(i+1)== '=')
						{
							num2= bag.pop();  
							num1= bag.pop();
							
							if((num1 != num2) == true)
								bag.push(1.0);
							else
								bag.push(0.0);

							i++; //to increment i because two characters ! and =
							
							//puting it into the tree
							RightNode = BTHolder.pop();
							LeftNode = BTHolder.pop();
							
							ThreeNode = new BTNode<String>("!=",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
						}
						else if(line2.charAt(i+1) != '=')
						{
							num1 = bag.pop();
							
							if(num1 == 1.0)
								bag.push(0.0); // pushing the opposite because it is negating
							else if(num1 ==0.0)
								bag.push(1.0);
							
							RightNode = BTHolder.pop();				
							
							ThreeNode = new BTNode<String>("!",null,RightNode);
							
							BTHolder.push(ThreeNode);
							
						}
						
						break;
						
					case'%':
						num2= bag.pop();  
						num1= bag.pop();
						
						bag.push(num1 % num2);
						
						//putting into thr tree
						RightNode = BTHolder.pop();						
						LeftNode = BTHolder.pop();
						
						ThreeNode = new BTNode<String>("%",LeftNode,RightNode);
						
						BTHolder.push(ThreeNode);
						
						break;
						
					case '>':
						if(line2.charAt(i+1)== '=')
						{
							num2= bag.pop();  
							num1= bag.pop();
							
							if((num1 >= num2)==true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
							++i;  // increasing i because 2 char, > and =
							
							//puting it into the tree
							RightNode = BTHolder.pop();
							LeftNode = BTHolder.pop();
							
							ThreeNode = new BTNode<String>(">=",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
							
						}
						else if(line2.charAt(i+1) != '=')
						{
							num2= bag.pop();  
							num1= bag.pop();
							
							if((num1 > num2) == true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
							//putting it into the tree
							RightNode = BTHolder.pop();
							LeftNode = BTHolder.pop();
							
							ThreeNode = new BTNode<String>(">",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
						}
						
						break;
							
					case '<':
						if(line2.charAt(i+1)== '=')
						{
							num2= bag.pop();  
							num1= bag.pop();
							
							if((num1 <= num2)==true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
							++i;  // increasing i because 2 char, > and =
							
							//putting it into the tree
							RightNode = BTHolder.pop();
							LeftNode = BTHolder.pop();
							
							ThreeNode = new BTNode<String>("<=",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
							
						}
						else if(line2.charAt(i+1) != '=')
						{
							num2= bag.pop();  
							num1= bag.pop();
							
							if((num1 < num2) == true)
								bag.push(1.0);
							else
								bag.push(0.0);
							
							//putting it into the tree
							RightNode = BTHolder.pop();
							LeftNode = BTHolder.pop();
							
							ThreeNode = new BTNode<String>("<",LeftNode,RightNode);
							
							BTHolder.push(ThreeNode);
							
						}
						
						break;
					
					default:
						break;
				
				}//end of switch statement
			}//end of else statement	
		}//end of for loop
		
		
		//----------- displaying everything 
		
		System.out.print("operation: " + line2 +" is equals to:  "+ bag.peek()+"\n");
		
		ThreeNode=BTHolder.peek();  //setting the ThreeNode equals the last node in the stack node holder
		
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
		  
		for(int x=0;x<LinesContainer.size();++x)
		{
		  computation(LinesContainer.elementAt(x));
		
		 
		 
		 System.out.print("\n");
		 
		 System.out.print("Press enter to continue...");
		 in= new Scanner(System.in); 
		 filename= in.nextLine(); //to hold the program for a momment. 
		

		
		}//end of for loop
		
		System.out.print("End Main."+ "\n");
		

	}//ends main
	
}// ends class
