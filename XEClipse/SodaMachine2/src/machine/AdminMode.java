package machine;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMode {

	private ArrayList<String> adminInputs=new ArrayList<String>();
	Scanner scan;
	String input=""; //used for scanner
	int checkSelection;
	boolean quit=false;
	/**
	 * @param args
	 */
	public AdminMode(SodaMachine machine){
		String newEntry="";
		adminInputs.add("q"); //quit admin mode
		adminInputs.add("d");//display inventory in stock and price
		adminInputs.add("r");//remove coins; 
		
		for(int i=0;i<machine.numOfElementesInStock(); ++i){ //this is for refill sodas
			newEntry="R"+machine.getElementID(i);
			adminInputs.add(newEntry);
		}
		
	}//end constructor
	public void displayAdminMode(){
		System.out.print("******************** Administrator");
		System.out.print("********************\n");
	}
	public void displaySelections(SodaMachine machine){
		for(int i=0;i<adminInputs.size();++i){
			if(adminInputs.get(i).equals("q")){
				System.out.println(adminInputs.get(i)+"(quit admin)");
			}
			else if(adminInputs.get(i).equals("d")){
				System.out.println(adminInputs.get(i)+"(display inventory)");
			}
			else if(adminInputs.get(i).equals("r")){
				System.out.println(adminInputs.get(i)+"(remove coins)");
			}
			else if(adminInputs.get(i).equals("d")){
				System.out.println(adminInputs.get(i)+"(display inventory)");
			}
			else if(adminInputs.get(i).equals("R"+machine.getElementID(i-3))){//-3 b/c getting element at 0 in machine and i is index for inputs
				System.out.println(adminInputs.get(i)+"(refield)");
			}
			
		}//end for loop

	}//end display selection
	public void displayinventory(SodaMachine machine){
		System.out.println("******************************************************");

		for(int i=0;i<machine.getInvetorySize();++i){
			System.out.println(machine.getElementInMachine(i).getItemInfoForAdmin());//returns info about item
		}
		System.out.println("******************************************************");
		try
		{
		    Thread.sleep(4000); // Sleep for 4 seconds
		}
		catch (InterruptedException e)
		{
		    Thread.currentThread().interrupt();
		}

	}
		
	public void quitAdminMode(){
		System.out.print("********************");
		System.out.print("quit admin mode..");
		System.out.print("********************\n");
	}
	public int validateInput(String input){
		//pre condition: the input that is a selection 
		//post condition: returns an index of the selection or -1 if not correct selection
		
		for(int i=0;i<adminInputs.size();++i){
			if(adminInputs.get(i).equals(input)){
				System.out.println("input in admin mode:"+input);
				System.out.println("this is returned:"+i);
				return i;
			}
			
		}
		
		return -1; //if the input is not there.
	}
	public void selectionHandler(int selection,SodaMachine machine,changeMechanism changeBox){
		
		switch (selection)
		{
			case 0: //quit admin
				
				quitAdminMode();
				
				break;
			case 1: //display inventory
				displayinventory(machine);
				
				break;
			case 2: //remove coins
				changeBox.removeAllCoins();
				try
				{
				    Thread.sleep(4000); // Sleep for 3 seconds
				}
				catch (InterruptedException e)
				{
				    Thread.currentThread().interrupt();
				}
				
				break;
				
			default:
				System.out.println("---------------------------------------------");
				System.out.println("refilling soda ID:"+machine.getElementInMachine(selection-3).getID());
				machine.getElementInMachine(selection-3).refieldQIS();
				System.out.println(machine.getElementInMachine(selection-3).getItemInfoForAdmin());
				System.out.println("---------------------------------------------");
				try
				{
				    Thread.sleep(4000); // Sleep for 3 seconds
				}
				catch (InterruptedException e)
				{
				    Thread.currentThread().interrupt();
				}
				break;
				
		}
		
	}
	
	
	public void runAdmin(SodaMachine machine,changeMechanism changeBox){
		
		displayAdminMode();
		
		while(quit==false){
			displaySelections(machine);
			
			scan= new Scanner(System.in);
			input=scan.next();
			
			checkSelection = validateInput(input);
			//System.out.println("hey we are here and selection was:"+checkSelection);
			if(checkSelection>=0){ //it will only be numbers according to available selections -1 if not valid 
			selectionHandler(checkSelection,machine,changeBox );
				if(checkSelection==0){//it means selection to quit was entered.
					quit=true;
				}
			}
			else{
				System.out.println("incorrect selection...");
				
			}
		
		}//end while loop
		
		
	} //end runAdmin
	    
}//end class

