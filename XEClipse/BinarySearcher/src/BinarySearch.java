

import java.util.*;
public class BinarySearch
{	
   public static void main(String[ ] args)
   {
      final int Low=1,High=1000000;
      boolean continuar = true;
      String Answer;
      Scanner in;
      
      while(continuar == true)
      {
      System.out.println("Lets play a game of guessing numbers"+"\n");
      System.out.println("Think of a number between "+ Low +" and "+ High +"\n");
      System.out.println("Ready?");
      
      try {     // pauses the program for 5 seconds
    	  Thread.sleep(5000);
    	  } catch(InterruptedException e) {
    	  } 
      
      bisSearch(High, Low);  
      
     
      System.out.println("do you want to play again? ");
      in=new Scanner(System.in);
      Answer = in.next();
      while( !Answer.equals("y") && !Answer.equals("n") && !Answer.equals("yes") & !Answer.equals("no"))
	   {
		   System.out.println("wrong input. Enter yes (y) or no (n):");
	   in = new Scanner(System.in);
	   Answer = in.next();
	   }
      
      if(Answer.equals("n")||Answer.equals("no"))
      {
    	  continuar=false;
      }
      System.out.print("It was nice playing, have nice day.");
      
      }//end while loop
   }//end main
   public static void bisSearch(int High, int Low)
   {
	   String Answer;
	   int middle = (Low + High)/2;
	   Scanner in;
	   
	   System.out.print("is this your number:  "+middle+ "\n");
	   in = new Scanner(System.in);
	   Answer = in.next();
	   
	   while( !Answer.equals("y") && !Answer.equals("n") && !Answer.equals("yes") & !Answer.equals("no"))
	   {
		   System.out.println("wrong input. Enter yes (y) or no (n):");
	   in = new Scanner(System.in);
	   Answer = in.next();
	   }
	   
	   if(High==Low && Answer.equals("n"))
	   {
		   System.out.println("if this isnt your number then you missed on question ");
		   return ;
	   }
	   
	  // System.out.println("this is in scanner: "+ Answer);
	   
	   if(Answer.equals("y")||Answer.equals("yes"))
	   {
		   System.out.println("good game!!!!!!");
	   }
	   else if(Answer.equals("n")||Answer.equals("no"))
	   {
		   System.out.print("is your number higher or lower? ");
		   in = new Scanner(System.in);
		   Answer = in.next();
		   
		   while( !Answer.equals("h") && !Answer.equals("l") && !Answer.equals("higher") & !Answer.equals("lower"))
		   {
			   System.out.println("wrong input. Enter higher (h) or lower(l)g:");
		   in = new Scanner(System.in);
		   Answer = in.next();
		   }
		   
		   if(middle==Low && Answer.equals("l"))  //if it starts from 0 this will work
		   {
			   System.out.println("your number cant be less than "+ middle);
			   return;
		   }
		   
		   if(Answer.equals("h")||Answer.equals("high"))
		   {
			   bisSearch(High,middle+1);
		   }
		   else if(Answer.equals("l")||Answer.equals("low") )
			   bisSearch(middle-1,Low);
	   }    
   }//end function
}//end class
