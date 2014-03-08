class Totals{
   
	int  total= 3;
	public int getTotals(){
	return total;
	}
	
	public void setTotals(int total){
	
		this.total += total;
	}
	
}







public class Sum extends Thread{

    Totals total;
	  
	  public Sum( Totals total){
	  
		this.total = total;
	   
	  }

   public void run(){
		try {
		for(int y=0;y<=10;++y)
			{
			 int entotal;
			synchronized(total){			
			entotal = total.getTotals();
			Thread.sleep(130);
			total.setTotals(4);
		 	System.out.print(entotal+ ",");
			}
			}		  			
			} catch (InterruptedException e) {}
   
}
}
