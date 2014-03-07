package files_IO;

public class Process {

	/**
	 * @param args
	 */
	 int ID;
	 int Size;
	 int AlocatedAt;
	
	public Process(int _ID,int _Size,int _AlocatedAt ){
		ID=_ID;
		Size=_Size;
		AlocatedAt= _AlocatedAt;
	}
	
	public int getID(){
		return ID;
	}
	public int getSize(){
		return Size;
	}
	public int getAlocatedAt(){
		return AlocatedAt;
	}
	public void PrintProcess(){
		if(AlocatedAt==-1){
		System.out.println(ID+" "+Size+" "+"-");
		}
		else{
		System.out.println(ID+" "+Size+" "+AlocatedAt);

		}
	}
	public String PrintProcessString(){
		if(AlocatedAt==-1){
		return ID+" "+Size+" "+"-";
		}
		else{
		return ID+" "+Size+" "+AlocatedAt;

		}
	}

}//end class
