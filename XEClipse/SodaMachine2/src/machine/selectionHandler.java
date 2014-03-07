package machine;

import java.util.ArrayList;
import java.util.Scanner;

public class selectionHandler {

	private Scanner scan;
	private boolean sold=false;
	private String input="";
	private ArrayList<String> inputs = new ArrayList<String>();
	
	private AdminMode admin;
	private changeMechanism changeBox= new changeMechanism();
	/**
	 * @param args
	 */
	public selectionHandler(SodaMachine temp){
		inputs.add("a"); //0
		inputs.add("5");  //1
		inputs.add("10");  //2
		inputs.add("25");
		for(int i=0;i<temp.numOfElementesInStock();++i ){
			inputs.add(temp.getElementID(i));
		}
	}
	public void addAnotheSelectionHandler(String next){
		inputs.add(next);
	}
	public void showSelections()
	{
		System.out.println("this are the posible inputs");
		for(int i=0; i<inputs.size();++i){
			System.out.print(inputs.get(i)+"   ");
		}
		System.out.println("\n"); 
	}
	public void showInventory(SodaMachine machine){
		System.out.println("----------------------------------------------------");
		for(int i=0; i<machine.getInvetorySize();++i){
			System.out.println(machine.getElementInMachine(i).getItemInfo());
		}
		System.out.println("----------------------------------------------------");
	}
	public void run(SodaMachine machine){
		//sold is declared on top used to check if you have the right amount to buy
		boolean isthere=false;//tocheck if correct input is there.
		
		
		showSelections();
		while(true)
		{
			if(sold==true){
				try
				{
				    Thread.sleep(4000); // Sleep for 4 seconds
				}
				catch (InterruptedException e)
				{
				    Thread.currentThread().interrupt();
				}
				
				showInventory(machine);
				showSelections();
				sold=false;
			}
			
				scan= new Scanner(System.in);
				input=scan.next();
				
				for(int x=0;x<inputs.size();++x){
					if(input.equals(inputs.get(x))){
						
						 entry(x,machine);
						
						//System.out.println("input:"+input);
						isthere = true;
					}
					
				}//end for loop
				
				if (isthere == false){
					System.out.println("incorrect input");
					showSelections();
				}
				isthere=false;//set it to false in order to use it again.
				
		
		} //end while loop;
		//return input;
	}
	public void entry(int indexInput,SodaMachine machine){
		admin = new AdminMode(machine);
		switch(indexInput){
		case 0:
			//case a
			//call admin mode.
			admin.runAdmin(machine,changeBox);
			showInventory(machine);
			showSelections();
			
			break;
		case 1:  //if input is 5 cents
			changeBox.addChange(5);
			System.out.println("money: "+changeBox.Amount_entered);
			
			break;
		case 2: //if input is 10 cents
			changeBox.addChange(10);
			System.out.println("money: "+changeBox.Amount_entered);
			
			break;
		case 3: //if input is 25 cents
			changeBox.addChange(25);
			System.out.println("money: "+changeBox.Amount_entered);
			break;
		default: //if input is any of the selections
			//if selections are S1, S2...n  
			//                  4,  5,...n
			int price=machine.getElementInMachine(indexInput-4).getPrice();
			//-4 bc the selection for elements start from 4
			int amountEntered=changeBox.getAmountEntered();
			
			
			if(amountEntered>=price){
				if(machine.getElementInMachine(indexInput-4).getQIS()>0){
					//if there are items in stock you decement.
					
				machine.getElementInMachine(indexInput-4).decrementInventory();//selling one
				System.out.println("dispensing...");
				System.out.println(machine.getElementInMachine(indexInput-4).getItemInfo());
				sold=true;
				changeBox.getChange(amountEntered-price);
				}
				else{
					System.out.println("there are no more in stock.");
					System.out.println("make other selection.");
				}
			}
			else{
				System.out.println("not suficient faunds.");
			}
			
			
			//getElementID(indexInput-4);
			
			break;
		}
		
	}
}
