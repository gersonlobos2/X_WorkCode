package machine;

import javax.xml.bind.ParseConversionEvent;

public class changeMechanism {

	/**
	 * @param args
	 */
	int numOf_q=10;
	int numOf_d=10;
	int numOf_n=10;
	
	int temp_q=0; 
	int temp_d=0;
	int temp_n=0;
	
	int return_q=0;
	int return_d=0;
	int return_n=0;
	int totalchange=0;
	

	int max_q=40; //40 quarters equivalent to 10 dollars
	int max_d=100;//equivalent to 10 dollars
	int max_n=100; //equivalent to 5 dollars.
	
	double change_box=(numOf_q*(25)+numOf_d*(10)+numOf_n*(5))/100; //total amount in dollars in box
	int Amount_entered;
	
	public changeMechanism() //constructor
	{}
	
	public void resetAmountEntered()
	{
		 temp_q=0;
		 temp_d=0;
		 temp_n=0;
		 Amount_entered=0;
	}
	
	public void addChange(int num){
		if(num==25){
			temp_q+=1;
			Amount_entered+=num;
		}
		else if(num==10){
			temp_d+=1;
			Amount_entered+=num;
		}
		else if(num==5){
			temp_n+=1;
			Amount_entered+=num;
		}
	}
	
	public int getAmountEntered(){
		return Amount_entered;
	}
	public void getchange2(int change){
		
		
		if(numOf_q>0 && change >=25){
			numOf_q-=1;
			return_q+=1;
			change-=25;
			getchange2(change);
		}
		else if(numOf_d >0 && change >=10){
			numOf_d-=1;
			return_d+=1;
			change-=10;
			getchange2(change);
		}
		else if(numOf_n >0 && change >=5){
			numOf_n-=1;
			return_n+=1;
			change-=5;
			getchange2(change);
		}
		else if(change==0){
			totalchange=(return_q*25)+(return_d*10)+(return_n*5);
			System.out.println("your change is: "+totalchange);
			System.out.println("#q:"+return_q+"#d:"+return_d+"#n:"+return_n);

		} 
		
		
	}
	public String getChange(int n){   //// n is the price of soda
		
		numOf_q += temp_q;
		numOf_d += temp_d;
		numOf_n += temp_n; //this will the inserted quarters to machine box
		
		getchange2(n);
	
		return ""+totalchange;
	}
	public void removeAllCoins(){
		double total=((numOf_q*25)+(numOf_d*10)+(numOf_n*5) )/100;
		
		System.out.println("--------------------------------------------");

		System.out.println("removing coins...");
		System.out.println("quarters removed: "+numOf_q);
		System.out.println("dimes removed: "+numOf_d);
		System.out.println("niquels removed: "+numOf_n);
		System.out.println("total amount removed: $"+total);
		System.out.println("--------------------------------------------");

	}

}
