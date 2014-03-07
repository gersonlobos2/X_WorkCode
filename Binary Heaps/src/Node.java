/*
 * Gerson Enrique Lobos Aguilar
 */
import java.io.*;
import java.util.*;

class Node
{
private int Data;          

public Node(int key) // constructor of the data that will be in the Queue
{ 
	   Data = key; 
}

public void setKey(int ID) //this function will change the data. used for the change number function.
{ 
	   Data = ID;
}

public int getKey()  // this will return the data
{ 
	   return Data; 
}



}  // end class Node

//**************************  Main *****************************
class HeapQueue
   {
	   public static String getString() throws IOException
	      {
	      InputStreamReader isr = new InputStreamReader(System.in);
	      BufferedReader br = new BufferedReader(isr);
	      String s = br.readLine();
	      return s;
	      }
	//-------------------------------------------------------------
	   public static char getChar() throws IOException
	      {
	      String s = getString();
	      return s.charAt(0);
	      }
	//-------------------------------------------------------------
	   public static int getInt() throws IOException
	      {
	      String s = getString();
	      return Integer.parseInt(s);
	      }
	//-------------------------------------------------------------
	
	
   public static void main(String[] args) throws IOException    // This is the main......
      {
      int value, value2, RandomNum;
      int a[]={48,37,44,19,28,22,30,17,43};
      
      Heap theHeap = new Heap(31);  // creating the heap queue with a maximum size of 31
      boolean success;
     
	 Random randomGenerator = new Random();
    for (int Count = 0; Count < 9; ++Count)
    {
    // RandomNum = randomGenerator.nextInt(100);
    	
     theHeap.insert(a[Count]);  
     theHeap.DisplayTree();
	} 
    //System.out.println("This program created 20 random numbers. ");
     
    theHeap.DisplayTree();	// displays the three at the beginning. 

      while(true) 
         {
         System.out.print("-What would you like to do to the three; show three, insert number,"+"\n");
         System.out.print(" remove number or change number:");
         int choice = getChar();
         
         switch(choice)
            {
            case 's':                        // show the three
               theHeap.DisplayTree();
               break;
            case 'i':                        // inserting a number
               System.out.print("Enter value to insert: ");
               value = getInt();
               success = theHeap.insert(value);
               if( !success ){
                  System.out.println("The number cant be inserted because the heap is full");
                  break;
               }
               theHeap.DisplayTree();
               break;
            case 'r':                        // remove a number
               if( !theHeap.isEmpty() ){
                  theHeap.remove();
                  theHeap.DisplayTree();
               }
               else
                  System.out.println("The number can't be removed because the heap is empty...");
               break;
            case 'c':                        // change
               System.out.print("Enter current index of the number: ");
               value = getInt();
               System.out.print("Enter new number: ");
               value2 = getInt();
               success = theHeap.change(value, value2);
               if( !success )
                  System.out.println("Invalid index");
               break;
            default:
               System.out.println("Invalid entry \n");
            }  // end switch
         }  // end while
      }  // end main
//-------------------------------------------------------------

  }  // end class HeapApp


class Heap
   {
   private Node[] HeapArray;
   private int MaximunSize; 
   private int SizeArray;

   public Heap(int max)            // constructor
      {
      MaximunSize = max;
      SizeArray = 0;
      HeapArray = new Node[MaximunSize];  // create array
      }
// -------------------------------------------------------------
   public boolean isEmpty()
      { return SizeArray==0; }
// -------------------------------------------------------------
   public boolean insert(int key)
      {
      if(SizeArray==MaximunSize)
         return false;
      Node newNode = new Node(key);
      HeapArray[SizeArray] = newNode;
      FixWayUp(SizeArray++);
      return true;
      }  // end insert()
// -------------------------------------------------------------
   public void FixWayUp(int Index)
      {
      int Parent = (Index-1) / 2;
      Node LastNode = HeapArray[Index];

      while( Index > 0 && HeapArray[Parent].getKey() < LastNode.getKey() )
         {
         HeapArray[Index] = HeapArray[Parent];  // move it down
         Index = Parent;
         Parent = (Parent-1) / 2;
         }  // end while loop
      HeapArray[Index] = LastNode;
      }  
// -------------------------------------------------------------
   public Node remove()          
      {                         
      Node root = HeapArray[0];
      HeapArray[0] = HeapArray[--SizeArray];
      FixWayDown(0);
      return root;
      } 
// -------------------------------------------------------------
   public void FixWayDown(int index)
      {
      int largerChild;
      Node top = HeapArray[index];       // save root
      while(index < SizeArray/2)       // while node has at
         {                               //    least one child,
         int leftChild = 2 * index +1;
         int rightChild = leftChild + 1;
                                         // find larger child
         if(rightChild < SizeArray && HeapArray[leftChild].getKey() < HeapArray[rightChild].getKey())
            largerChild = rightChild;
         else
            largerChild = leftChild;
                                         // top >= largerChild?
         if( top.getKey() >= HeapArray[largerChild].getKey() )
            break;
                                         // shift child up
         HeapArray[index] = HeapArray[largerChild];
         index = largerChild;            // go down
         }  // end while
      HeapArray[index] = top;            // root to index
      }  // end trickleDown()
// -------------------------------------------------------------
   public boolean change(int index, int newValue)
      {
      if(index < 0 || index >= SizeArray)
         return false;
      int oldValue = HeapArray[index].getKey(); // remember old
      HeapArray[index].setKey(newValue);  // change to new

      if(oldValue < newValue)             // if raised,
         FixWayUp(index);                // trickle it up
      else                                // if lowered,
         FixWayDown(index);              // trickle it down
      return true;
      }  // end 
// -------------------------------------------------------------
   public void DisplayTree()
      {

     
                                          // heap format
      int nBlanks = 40;
      int itemsPerRow = 1;
      int column = 0;
      int Counter = 0;                          // current item
      
      System.out.println("");
      System.out.println("---------------------------------------------------------------------");
    

      do              // for each heap item
         {
         if(column == 0)                  // first item in row?
            for(int k=0; k<nBlanks; k++)  // preceding blanks
               System.out.print(' ');      
                                          // display item
         System.out.print(HeapArray[Counter].getKey());

         if(++Counter == SizeArray)           // done?
            break;

         if(++column == itemsPerRow)        // end of row?
            {
            nBlanks = nBlanks/2;                 // half the blanks
            itemsPerRow = itemsPerRow * 2;             // twice the items
            column = 0;                   // start over on
            System.out.println();         //  new row
            }
         else                             // next item on row
            for(int k=0; k<nBlanks*2-2; k++)
               System.out.print(' ');     // interim blanks
         }while(SizeArray > 0);  // end for
      
      System.out.println("\n");
      System.out.println("");
      
      }  // end displayHeap()
// -------------------------------------------------------------
   }  // end class Heap
