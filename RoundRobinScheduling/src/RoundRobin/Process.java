package RoundRobin;

public class Process {

	String Pname;
	int ArravingTime;
	int BurstTime,TimeLeft; //burst time is the one that will be decremented until it is 0
	int Priority; //not used in this Round Robbin but it will be here just to hold it
	int StartTime=0,EndTime=0,CompleteTime;
	int averageWaiting;
	
	
	/**
	 * @param args
	 */
	
	public Process(String name,int Atime,int Btime){
		Pname=name;
		ArravingTime=Atime;
		BurstTime=TimeLeft=Btime;
		Priority=0;//this is not used 
	}//end constructor
	public Process(String name,int Atime,int Btime,int priority){
		Pname=name;
		ArravingTime=Atime;
		BurstTime=TimeLeft=Btime;
		Priority = priority;
	}//end 2constructor 
	
	public void calculateAverage(){
		
		if(EndTime>StartTime){
			averageWaiting+= (EndTime-StartTime);
		}
		else if(StartTime>EndTime){
			averageWaiting+=StartTime;
		}
	}
	public int getAverage(){
		return averageWaiting;
	}
	public String getName(){
		return Pname;
	}//end getname

	public int getArrivingTime(){
		return ArravingTime;
	}
	
	public int getBurstTime(){
		return BurstTime;
	}
	public int getTimeLeft(){
		return TimeLeft;
	}
	public int getPriority(){
		return Priority;
	}
	
	public int decrementBurstTime(int QTime){
		
		//?????????? i have to keep on decrementing BurstTime by QTime
		//but when it hits 0 or passes to negative should i return time left
		//provably 0 if it decrements all QTime 
		//and return time left if QTime > BurstTime
		if(QTime > TimeLeft){
			int temp=TimeLeft;
			TimeLeft=0;
			//return Math.abs(temp-QTime); //it will return the time left
			return temp; //i return time left;
		}
		else if(QTime==TimeLeft){
			TimeLeft-=QTime;
			return 100;
		}
		else{
			//System.out.println(" more time needed for" +Pname);
			TimeLeft-=QTime; //decremented by QTime
			return 200;
			
		}
		
	}
	public void printProcessInfo(){
		System.out.println("PName="+Pname +" AT="+ArravingTime+" BT="+BurstTime+" Priority="+Priority);
	}
	public String StringFinalInfo(){
	return StartTime+" "+EndTime+" "+ Pname;
	}
	public void printWorkingProces(){
		System.out.println(StartTime+" "+EndTime+" "+Pname);
	}
	public void setStartTime(int i){
		StartTime=i;
	}
	public void setEndTime(int i){
		EndTime=i;
	}
	public void setCompleteTime(int i){
		CompleteTime=i;
	}
}//end class
