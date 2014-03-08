 class Counter{

	int counter = 1;
	
	public int getCounter(){
	return counter;
	}
	
	public void setCounter(int counter){
	
		this.counter += counter;
	}
	
}



 public class Odd extends Thread{

     Counter counter;
	  
	  public Odd(Counter counter){
	  
		this.counter = counter;
	   
	  }

	public void run(){
	
	
		try{
			for(int i= 1;i<=11;i++)
			{
			int valueCounter;

			 synchronized(counter){
			valueCounter = counter.getCounter();
			Thread.sleep(120);
			counter.setCounter(2);
			System.out.print(valueCounter +",");
			}
						
			
					
		}
		}catch (InterruptedException m){}
	
	
	}
}