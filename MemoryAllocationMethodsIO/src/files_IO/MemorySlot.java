package files_IO;

public class MemorySlot {

	/**
	 * @param args
	 */
	int AddressStart;
	int AddressEnd;
	int OcccupiedBy; //the proccess number using it or 0 if free.
	int sizeSlot;
	
	public MemorySlot(int _AddressStart,int _AddressEnd,int _OcccupiedBy){
		AddressStart= _AddressStart;
		AddressEnd= _AddressEnd;
		OcccupiedBy= _OcccupiedBy;
		sizeSlot=AddressEnd-AddressStart;
	}
	
	public int getAddressStart(){
		return AddressStart;
	}
	public int getAddressEnd(){
		return AddressEnd;
	}
	public int getOcccupiedBy(){
		return OcccupiedBy;
	}
	
	public void setAddressStart(int _AddressStart){
		AddressStart=_AddressStart;
	}
	public void setAddressEnd(int _AddressEnd){
		AddressEnd=_AddressEnd;
	}
	public void setOcccupiedBy(int _OcccupiedBy){
		OcccupiedBy=_OcccupiedBy;
	}
	
	
	public void printMemorySlot(){
		System.out.println(AddressStart+" "+AddressEnd+" "+OcccupiedBy);
	}
	public String printMemorySlotString(){
		return AddressStart+" "+AddressEnd+" "+OcccupiedBy;
	}
}//end class
