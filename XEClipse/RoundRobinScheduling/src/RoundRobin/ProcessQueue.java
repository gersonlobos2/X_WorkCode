package RoundRobin;


	public class ProcessQueue {

	   private Process[] elements;
	   private int head;
	   private int tail;
	   private int count;
	/**
	 * @param args
	 */
	public ProcessQueue(int capacity){
		elements = new Process[capacity];
	      count = 0;
	      head = 0;
	      tail = 0;
	}
	 public int returnLength(){
		   return elements.length;
	   }
	
	 public Process remove()
	 {
	   
	   if( elements[head]==null){ //this means that there are no elements.
		   return null;
	   }
	   else{
		   Process r = elements[head];
    elements[head]=null;  //this is removing the element at head
    head = (head + 1) % elements.length;
    count--;
    
    return r;
	   }
	
 }//end removr method
 
 	public void doubleSizeOfQueue(){
	   
	 Process [] elements2 = new Process[(elements.length)*2];
	   int oldHead=head;
	   
	   for(int i=0;i<elements.length;++i){
		   elements2[i]=elements[oldHead];
		   oldHead=(oldHead+1) % elements.length;
	   }//end of for loop
	   head=0;
	   tail=elements.length;
	   elements= elements2;// this will set the bigger pointer equals the smaller
 }//end of doubleSizeOfQueue 
 

 	public void add(Process aMessage)
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
	
	}//end of add

	public int size(){
	return count;
	}
	public boolean isFull(){
	   return count == elements.length;
	}
	
	public Process peek(){
	   return elements[head];
	}


}//end class ProcessQueue
