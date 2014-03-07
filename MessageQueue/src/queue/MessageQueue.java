package queue;

import java.util.NoSuchElementException;


/**
    A first-in, first-out bounded collection of messages.
*/
import queue.Message;

public class MessageQueue
{
	
	   private Message[] elements;
	   private int head;
	   private int tail;
	   private int count;
   /**
       Constructs an empty message queue.
       @param capacity the maximum capacity of the queue
       @precondition capacity > 0
   */
	
	
	
   public MessageQueue(int capacity)
   {
      elements = new Message[capacity];
      count = 0;
      head = 0;
      tail = 0;
   }
   public int returnLength(){
	   return elements.length;
   }
   /**
       Remove message at head.
       @return the message that has been removed from the queue
       @precondition size() > 0
   */
   public Message remove()
   {
	   
	   if( elements[head]==null){ //this means that there are no elements.
		   return null;
	   }
	   else{
      Message r = elements[head];
      elements[head]=null;  //this is removing the element at head
      head = (head + 1) % elements.length;
      count--;
      
      return r;
	   }
	//   return elements[head];
   }
   
   public void doubleSizeOfQueue(){
	   
	   Message [] elements2 = new Message[(elements.length)*2];
	   int oldHead=head;
	   
	   for(int i=0;i<elements.length;++i){
		   elements2[i]=elements[oldHead];
		   oldHead=(oldHead+1) % elements.length;
	   }//end of for loop
	   head=0;
	   tail=elements.length;
	   elements= elements2;// this will set the bigger pointer equals the smaller
   }//end of doubleSizeOfQueue 
   /**
       Append a message at tail.
       @param aMessage the message to be appended
       @precondition !isFull();
   */
   public void add(Message aMessage)
   {
	   //check if queue is not full
	  if(tail==head && elements[head]!=null){ //it will do it if head = tail to check if it is full
		  								//and that the head that is compared to is not empty.
		  						
		  
		  doubleSizeOfQueue(); //this will call the method that will double the size of the queue;
		  
		  elements[tail] = aMessage;
	      tail = (tail + 1) % elements.length;
	      count++;
	  }
	  else{
      elements[tail] = aMessage;
      tail = (tail + 1) % elements.length;
      count++;
	  }
	  
   }
   /**
       Get the total number of messages in the queue.
       @return the total number of messages in the queue
   */
   public int size()
   {
	  
      return count;
   }
   /**
       Checks whether this queue is full
       @return true if the queue is full
   */
   public boolean isFull()
   {
      return count == elements.length;
   }
   /**
       Get message at head.
       @return the message that is at the head of the queue
       @precondition size() > 0
   */
   public Message peek()
   {
      return elements[head];
   }
   
 
}
