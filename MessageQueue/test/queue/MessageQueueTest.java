package queue;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class MessageQueueTest extends TestCase{

	@Test
	public void testadd() {
		MessageQueue elements = new MessageQueue(4);
		
		int size1=elements.returnLength();
		int size2;
		
		for(int i=0; i<5;++i){
			elements.add(new Message("hello"));
		}
		
		size2=elements.returnLength();
		//System.out.println("size1="+size1+"size2="+size2+"elements="+elements.size());
		assertEquals(size1*2,size2); //this means that the size2 is double than size1
		
	}//end of testadd
	
	@Test
public void testremove(){
	MessageQueue elements2 = new MessageQueue(3);
	
	assertEquals(elements2.remove(),null);//try to remove when queue is empty
	for(int i=0; i < 3;++i){
		elements2.add(new Message("hello"+i));
	}
	String word1=elements2.remove().getText();
	
	assertEquals(word1,"hello0");
	word1=elements2.remove().getText();
	assertEquals(word1,"hello1");
	word1=elements2.remove().getText();
	assertEquals(word1,"hello2");
	assertEquals(elements2.remove(),null); //this is trying to remove more than what is in the queue
	
}//end of testremove
	
	@Test
	public void testisFull(){
		MessageQueue elements2 = new MessageQueue(3);
	
			elements2.add(new Message("hello"));
			elements2.add(new Message("hello"));
			elements2.add(new Message("hello"));
		//System.out.println(elements2.size());
		
		assertEquals(elements2.isFull(),true);
	}//end of testisFull
	@Test
	public void testpeek(){
		MessageQueue elements = new MessageQueue(3);
		elements.add(new Message("Gerson"));
		
		assertEquals(elements.peek().getText(),"Gerson");
		
	}//end of testpeek
	@Test
	public void testsize(){
		MessageQueue elements = new MessageQueue(3);
		elements.add(new Message("Gerson"));//one element added 
		
		assertEquals(elements.size(),1);//checks if there is only one element in queue

	}//end of testsize
	


}//end of class MessageQueueTest
