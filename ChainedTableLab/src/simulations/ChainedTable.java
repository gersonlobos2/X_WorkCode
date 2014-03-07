
package simulations;


/******************************************************************************
* A <CODE>ChainedTable</CODE> is a chained hash table.
* The implementation isn't given here since it is an assignment in a typical
* data structures class. In general,
* programs should  use java.util.HashTable
* rather than this ChainedTable.
*
* <dt><b>Outline of Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/ChainedTable.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/ChainedTable.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version
*   Jan 24, 1999
******************************************************************************/

public class ChainedTable
{
   private ChainedHashNode[ ] table;

   public class ChainedHashNode
   {
     public Object element;
     public Object key;
     public ChainedHashNode link;
   
      }

   /**
   * Initialize an empty ChainedTable with a specified table size.
   * @param <CODE>tableSize</CODE>
   *   the table size for this new chained hash table
   * <dt><b>Precondition:</b><dd>
   *   <CODE>tableSize > 0</CODE>
   * <dt><b>Postcondition:</b><dd>
   *   This ChainedTable is empty and has the specified table size.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the specified table size. 
   * @exception IllegalArgumentException
   *   Indicates that tableSize is not positive.
   **/   
   public ChainedTable(int tableSize)
   {
      if (tableSize <= 0)
	   throw new IllegalArgumentException("Table size must be positive.");
      
      if (tableSize == 0 )
    	  throw new OutOfMemoryError("Insufficient memory for the table");
       
        table = new ChainedHashNode[tableSize];
   }
   
   /**
    * Determines whether a specified key is in this ChainedTable.
    * @param <CODE>key</CODE>
    *   the non-null key to look for
    * <dt><b>Precondition:</b><dd>
    *   <CODE>key</CODE> cannot be null.
    * @return
    *   <CODE>true</CODE? (if this ChainedTable contains an object with the specified 
    *   key); <CODE>false</CODE> otherwise. Note that <CODE>key.equals( )</CODE>
    *   is used to compare the <CODE>key</CODE> to the keys that are in the 
    *   ChainedTable.
    * @exception NullPointerException
    *   Indicates that <CODE>key</CODE> is null.
    **/

   public boolean containsKey(Object key)
   {
       if(key != null) 
       {
           ChainedHashNode cursor; //creates a temp holder of of node
           cursor = table[hash(key)]; // gets node depending on the key index

           if(table[hash(key)] != null && key.equals(cursor.key)){
               return true ; 
           }
           else if(table[hash(key)] != null )
           {      
              do{ 
                   if(key.equals(cursor.key))
                       return true;
                   cursor= cursor.link;
               } while(cursor != null);// it will go through the nodes while it isnt null
           }   
           else  
        	   return false; 
       }
       else 
    	   return false; //if key equals null means it isnt there 
       
       return false;
   }

   /** Retrieves an object for a specified key.
    * @param <CODE>key</CODE>
    *   the non-null key to look for
    * <dt><b>Precondition:</b><dd>
    *   <CODE>key</CODE> cannot be null.
    * @return
    *   a reference to the object with the specified <CODE>key</CODE (if this 
    *   ChainedTable contains an such an object);  null otherwise. Note that 
    *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
    *   to the keys that are in the ChainedTable.
    * @exception NullPointerException
    *   Indicates that <CODE>key</CODE> is null.
    **/
   public Object get(Object key)
   {
	   ChainedHashNode cursor  = new ChainedHashNode(); // creates temp node
	   
       if(key != null){
           cursor = table[hash(key)]; //gets the index node 
           if( containsKey(key)) //checks if the it contains the key we look for
           {
               if(key.equals(cursor.key))// if the keys match, it returns the node
                   return cursor;
               else {
                  do{
                       if(key.equals(cursor.key))
                           return cursor;
                       cursor= cursor.link;
                   } while(cursor != null); //it will keep on doing the loop until it finds it
                  
               }
           }
       }
       return null;
   }

   
   private int hash(Object key){
       return Math.abs(key.hashCode( )) % table.length;
   }

   /**
    * Add a new element to this ChainedTable, using the specified key.
    * @param <CODE>key</CODE>
    *   the non-null key to use for the new element
    * @param <CODE>element</CODE>
    *   the new element that's being added to this ChainedTable
    * <dt><b>Precondition:</b><dd>
    *   Neither <CODE>key</CODE> nor </CODE>element</CODE> is null.
    * <dt><b>Postcondition:</b><dd>
    *   If this ChainedTable already has an object with the specified <CODE>key</CODE>,
    *   then that object is replaced by </CODE>element</CODE>, and the return 
    *   value is a reference to the replaced object. Otherwise, the new 
    *   </CODE>element</CODE> is added with the specified <CODE>key</CODE>
    *   and the return value is null.
    * @exception NullPointerException
    *   Indicates that <CODE>key</CODE> or <CODE>element</CODE> is null.   
    **/
   public Object put(Object key, Object val)
   {
       ChainedHashNode cursor = null;
       Object answer = null;

       cursor = table[hash(key)];
       
       while(cursor != null){
           if(key.equals(cursor.key))
               break;
           cursor = cursor.link;  //getting the key until cursor == null
       }
       if (cursor == null)
       {  
           int i = hash(key);
           cursor = new ChainedHashNode( );
           cursor.element = val;
           cursor.key = key;
           cursor.link = table[i];
           table[i] = cursor;
       }
       else
       { 
           answer = cursor.element;
           cursor.element = val;
       }
       return answer;
   }

   /**
    * Removes an object for a specified key.
    * @param <CODE>key</CODE>
    *   the non-null key to look for
    * <dt><b>Precondition:</b><dd>
    *   <CODE>key</CODE> cannot be null.
    * <dt><b>Postcondition:</b><dd>
    *   If an object was found with the specified </CODE>key</CODE>, then that
    *   object has been removed from this ChainedTable and a copy of the removed object
    *   is returned; otherwise, this ChainedTable is unchanged and the null reference
    *   is returned.  Note that 
    *   <CODE>key.equals( )</CODE> is used to compare the <CODE>key</CODE>
    *   to the keys that are in the ChainedTable.
    * @exception NullPointerException
    *   Indicates that </CODE>key</CODE> is null.
    **/
   public Object remove(Object key)
   {
       int index = hash(key);
	   ChainedHashNode temp= table[index]; //first finds the index
	   ChainedHashNode previous = null;
	   
	 		  while(temp != null) //go through nodes to find it
	 		  {
	 			  if((temp.key).equals(key)) //if keys match delete by changing the link
	 			  { 
	 				if(previous == null) // it is done if it is the head node
	 					table[index] = temp.link;
	 				else 
	 					previous.link = temp.link;
	 			  }
	 			  previous = temp;
	 			  temp = temp.link;
	 		  }
       return null;
   }
  
   
 // Display method   
   
   public void show(){
       int CounterInc =0; 
       ChainedHashNode cursor = new ChainedHashNode();
       String line= "-------------------------------";
       
       System.out.print(line+line+ "\n");
       System.out.print("Index"+"   Key"+"    Data"+"\n");
       System.out.print(line+line+ "\n");
       Object key = 0;
       int index = hash(key);
      
       for(int i  = 0; i <= CounterInc; i ++ ){
    	   while(CounterInc < table.length ){
    		   System.out.print((index+ i ++) + "\n" );
           if(table[CounterInc] != null){
        	 cursor = table[CounterInc];
        	 System.out.println("    "+convert(cursor));
               while(cursor.link != null){
            	   cursor = cursor.link;
                 System.out.println("    "+ convert(cursor));
               }
           }
           CounterInc++;
       }
       }
       System.out.print(line+line+ "\n");
       System.out.print(line+line+ "\n");
   }
   
   public String convert(ChainedHashNode c){
	   return  "   " + "" + c.key.toString() + "   " + c.element.toString();
   }
}
