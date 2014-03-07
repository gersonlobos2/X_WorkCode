package machine;

public class InventoryItem {

	/**
	 * @param args
	 */
	String ID;
	String name;
	int QIS;
	int Price;
	int MaxQIS=8;
	
	public InventoryItem(String id,String n, int initialQIS,int price){
		ID=	id;
		name=n;
		QIS=initialQIS;
		Price=price;
	}
	
	public String getID(){
		return ID;
	}
	public String getName(){
		return name;
	}
	public int getQIS(){
		return QIS;
	}
	public int getPrice(){
		return Price;
	}
	public void setID(String id){
		ID=id;
	}
	public void setName(String n){
		name=n;
	}
	public void setQISfull(){
		QIS=MaxQIS;
	}
	public void setPrice(int p){
		Price=p;
	}
	public void addToInventory(int q){
		
		if(QIS==MaxQIS){
			System.out.println("Item has its max Quantity in stock.");
		}
	    else if((QIS+q)<=MaxQIS){
			QIS+=q;
		}
	}
	public boolean decrementInventory(){
		if(QIS>0){
		--QIS;
		return true;
		}
		return false;
	}
	public String getItemInfo()
	{
		return "ID: "+ID+"  "+name+"    "+Price+"c";
	}
	public String getItemInfoForAdmin()
	{
		return "ID: "+ID + "  QIS:"+QIS  +"  "+Price+"c" +"  "+name+"    ";
	}
	public void refieldQIS(){
		QIS=MaxQIS;
	}

	
}//end of class
