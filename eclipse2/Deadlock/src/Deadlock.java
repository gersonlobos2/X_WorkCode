//Gerson Lobos
public class Deadlock { 
	static public int counterodd;
	static public int countereven;
	static public int sum;
	
	public Deadlock()
	{
		counterodd=1;
		countereven=2;
		sum=counterodd+countereven;	
	}
	//*****************************************************************
	public static int getCounterodd() {
		return counterodd;
	}


	public static void setCounterodd(int counterodd) {
		Deadlock.counterodd += counterodd;
	}


	public static int getCountereven() {
		return countereven;
	}


	public static void setCountereven(int countereven) {
		Deadlock.countereven += countereven;
	}


	public static int getSum() {
		
		return sum;
	}


	public static void setSum(int sum) {
		Deadlock.sum = sum;
	}
//***********************************************************************************

	public static void main(String[] args) {
		// These are the two resource objects we'll try to get locks for 
		//final Integer countereven = 2; 
		//final Integer sum = 0;
		final Deadlock source1=new Deadlock();
		final Deadlock source2=new Deadlock();
		final Deadlock source3=new Deadlock();
		// Here's the first thread. It tries to lock resource1 then resource2 then resource3
		
		 Thread t1 = new Thread() {
			public void run() { 
				// Lock resource 1 
				
				synchronized(source1) {
					//while (true)
					for(int x=0;x<5;++x)
					{
					  System.out.println("odd= "+getCounterodd());
					  setCounterodd( 2);
					
					  try {
						Thread.sleep(125);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				     // counterodd = counterodd + 2;
					//Thread.yield();
					//try { Thread.sleep(50); } catch (InterruptedException e) {}
					}
				}
			}
		};

		// Here's the second thread. It tries to lock resource2 then resource1 then resource3
		Thread t2 = new Thread() {
			public void run() { 
				// Lock resource 2
				synchronized(source2) {
					//while (true)
					for(int i=0;i<6;++i)
					{
					  System.out.println("even= "+getCountereven());
					  setCountereven(2);
					  try {
						Thread.sleep(130);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Thread.yield();
					//try { Thread.sleep(50); } catch (InterruptedException e) {}
					}
			}
			}
		};
		
		// Here's the third thread. It tries to lock resource3 then resource2 then resource1
		Thread t3 = new Thread(){
			public void run(){
				// Lock resource 3
				synchronized(source3){
					//while (true)
					for(int y=0;y<6;++y)
					{
						
					  System.out.println("sum= "+getSum());
					  setSum(getCounterodd()+getCountereven());
					  
					 try {
						Thread.sleep(135);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  //countereven= countereven + 2;
				     //Thread.yield();
					//try { Thread.sleep(50); } catch (InterruptedException e) {}
					}
			}
				
			}
		};
		
		// Start the three threads. If all goes as planned, deadlock will occur, 
		// and the program will never exit. 
		t1.start();
		 t2.start();
		t3.start();
	}
}




