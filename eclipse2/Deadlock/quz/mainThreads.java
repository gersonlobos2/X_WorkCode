public class mainThreads{

	public static void main(String[] args){
	     
		 
	      Counter counts = new Counter();
			Counts cont	= new Counts();	
			Totals sumal= new Totals();			
			Odd First = new Odd(counts);
			Even second = new Even(cont);
			Sum Third= new Sum(sumal);
			First.start();
			second.start();
			Third.start();
	}

}