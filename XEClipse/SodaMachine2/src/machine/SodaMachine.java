package machine;

import java.util.ArrayList;
import java.util.Scanner;

public class SodaMachine extends InventoryItem{

	private ArrayList<InventoryItem> Stock=new ArrayList<InventoryItem>();
	
	public SodaMachine(String id, String n, int initialQIS, int price) {
		super(id, n, initialQIS, price);
		// TODO Auto-generated constructor stub
	}
	public int getInvetorySize(){
		return Stock.size();
	}
	public void addSodaMachine(){
		
		Stock.add(new InventoryItem("s0","COLA", 3,75));
		Stock.add(new InventoryItem("s1","ORANGE", 3,75));
		Stock.add(new InventoryItem("s2","SPRITE", 3,75));
		Stock.add(new InventoryItem("s3","GINGER_ALE", 3,75));
		Stock.add(new InventoryItem("s4","DIET_COLA", 3,75));
	}
	public InventoryItem getElementInMachine(int index){
		return Stock.get(index);
	}
	public int numOfElementesInStock(){
		return Stock.size();
	}
	public void displayInventory(){
		for(int i=0;i<Stock.size();++i){
			System.out.println(Stock.get(i).getItemInfo());//it will return a string of inventory item info
		}
	}
	public String getElementID(int index){
		return Stock.get(index).getID();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input="";
		// TODO Auto-generated method stub
		SodaMachine machine= new SodaMachine("0","cola", 3,75);//i dont get this??????
		machine.addSodaMachine();
	 selectionHandler handler=new selectionHandler(machine);
	
	 
		//while(true){
	 System.out.println("Inventory");
			machine.displayInventory();
			handler.run(machine);
			
		//}
	}

}
