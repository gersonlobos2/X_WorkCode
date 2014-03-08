 class Counts{

	int counts = 2;
	
	public int getCounts(){
	return counts;
	}
	
	public void setCounts(int counts){
	
		this.counts += counts;
	}
	
}






public class Even extends Thread{

     Counts counts;
	  
	  public Even( Counts counts){
	  
		this.counts = counts;
	   
	  }

	public void run(){
	
	
		try{
			for(int i= 0;i<=10;i++)
			{
			 int MxCounts;

			 synchronized(counts){
			MxCounts = counts.getCounts();
			Thread.sleep(125);
			counts.setCounts(2);
			System.out.print(MxCounts +",");
			}
						
			
					
		}
		}catch (InterruptedException m){}
	
	
	}
}