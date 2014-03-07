package RoundRobin;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Scheduler {
	//*********************************************************

	// this are the variables that will hold data.
	static String filename;
	static int quantumN;
	static int Checknumber; //0 (not RR nor preemptive) 1 for Round Robbin other numbers for other schedulers
	 static Vector<String> LinesContainer= new Vector<String>();
	 static ProcessQueue CircularQueue;
	 static int NProcesses,NCount=0;
	 static int AT,BT,P;
	 static int TotalBT; //holds the total time of BT
	 static Process[] ProcessList;  // this will hold the processes they will be unOrdered 
	 static Queue<Process> QueueHolder=new LinkedList<Process>();// we will order them according to the arriving time. 
	 static Queue<String> QueueStringHolder=new LinkedList<String>();
	 static int CountProcess=0; 
	 
	
	
	
	//*********************************************************File scanned will have this structure (input format)
	/* 
	   ￼10 (number of processes)
		0 (not RR nor preemptive) 2 (quantum)
		3 (arriving time for P1) 12(burst time) 2(priority) 
		...
		0 (arriving time for P10) 7(burst time) 5(priority)
	
	//*********************************************************(output Format)
	0(start) 7(end) 10(process #) 
	0(start) 7(end) 10(process #) 
	0(start) 7(end) 10(process #)
	//*********************************************************(output Format)
	 */
	 public static void selectionsort(Process[ ] data, int first, int n)
     {
        int i, j; // Loop control variables
        int big;  // Index of largest value in data[first]...data[first+i]
        Process temp; // Used during the swapping of two array values
        for (i = n-1; i > 0; i--)
        {  
           // Calculate big as the index of the largest value in data[first]...data[first+i]:
           big = first;
           
           for (j = first+1; j <= first+i; j++)
              if (data[big].getArrivingTime() < data[j].getArrivingTime())
                 big = j;
        
           // swap data[first+i] with data[big]:
           
           temp = data[first+i];
           data[first+i] = data[big];
           data[big] = temp;
        }
        
    	System.out.println("----------------queue");

        for(int x=0;x<data.length;++x){//putting everything into a queue
        	QueueHolder.add(data[x]);
        	data[x].printProcessInfo();
        }
        
     } 
	 public static void bubbleSort( Process [ ] data )
	 {
	      int j;
	      boolean flag = true;   // set flag to true to begin first pass
	      Process temp;   //holding variable

	      while ( flag )
	      {
	             flag= false;    //set flag to false awaiting a possible swap
	             for( j=0;  j < data.length -1;  j++ )
	             {
	                    if ( data[ j ].ArravingTime > data[j+1].ArravingTime )   // change to > for ascending sort
	                    {
	                            temp = data[ j ];                //swap elements
	                            data[ j ] = data[ j+1 ];
	                            data[ j+1 ] = temp;
	                           flag = true;              //shows a swap occurred  
	                   } 
	             } 
	       }
	      
	      System.out.println("----------------queue");

	        for(int x=0;x<data.length;++x){//putting everything into a queue
	        	QueueHolder.add(data[x]);
	        	data[x].printProcessInfo();
	        }
	 } 
	 //**********************************************  average waiting calculation
	 public static void CalculateTotalAverage(){
		 int total = 0;
		 
		 for(int i=0;i<ProcessList.length;++i){
			 total+=ProcessList[i].getAverage();
			 System.out.print(ProcessList[i].Pname+": "+ProcessList[i].getAverage()+" ");
			 
		 }
		 System.out.println("total average waiting Time: "+(total/ProcessList.length));
	 }
	
	 //**********************************************
	public static  void ReadFromFile(String filename){
		//pre: the name of a file is passed to read from
		//post: lines in the file are stored in the vector
		java.io.File file= new java.io.File(filename); //opens the file named filename
		System.out.println("-------- read from file: "+filename +"--------");

		try{
			
			Scanner input = new Scanner(file);
			while(input.hasNext()){
			String line = input.nextLine(); //gets the line from file and puts in string
			LinesContainer.add(line+"  ");       //stores the lines into the vector container 
					//i added a space becasue of a bug when there is no space after line
					//error is when going through the line (cant see how to fix it :( )
			System.out.println(line);
			}
			
		}catch (FileNotFoundException e) {
			System.err.format("File does not exist \n");
		}
		
		
	}//end of ReadFromFile
	public static void decodeDataFromFile(){
		ProcessList= new Process[LinesContainer.size()-2];
		//it is -2 because the first 2 lines only give me info and not the processes. 
		String digits="";//this will hold the integer and integers with more than one digit like 12
		//int counter=0; //this counter will tell me what number in the line i am reading
		
		

		for(int i=0;i<LinesContainer.size();++i){//this goes to the vector to get the lines

			for(int x=0; x< LinesContainer.get(i).length(); ++x)//gets the string from vector index and looks for numbers
			{

				if( (Character.isDigit(LinesContainer.get(i).charAt(x))) ==true  )
				{

					//this while loop will make sure we get numbers with more than one digit
					while(Character.isDigit(LinesContainer.get(i).charAt(x))==true  ){

					digits += LinesContainer.get(i).charAt(x);

					++x;//to increment the x index in the string in case of int with more than 1 digit
					
					}//end while loop


					 //we have to separate the first 2 lines that contain only info 
					if(i==0){ //this means we are on the first line
						NProcesses = Integer.parseInt(digits);//converts the String into an integer
						//now i now the number of processes i can create the array.
						ProcessList=new Process[NProcesses];//array of Process, size NProcesses.

					}
					else if(i==1){
						//in the second line 2 numbers are expected
						if(NCount==0){//this will take the first number that is to check if 0 or 1 to run
							Checknumber= Integer.parseInt(digits);
							NCount++;//to count that one num was already taken							

						}
						else if(NCount==1){//second line second number 
							quantumN=Integer.parseInt(digits);
							NCount=0;//last num expected, it is 0 to start again
						}
					}//end of else if i==1 to checking the second line 
					else{
						if(NCount==0){
							AT=Integer.parseInt(digits);
							NCount++; //this will increment NCount for the next int

						}
						else if(NCount==1){
							BT=Integer.parseInt(digits);
							TotalBT+=BT;
							NCount++; //this will increment NCount for the next int
						}
						else if(NCount==2){
							P=Integer.parseInt(digits);
							NCount=0;//this will set NCounts = 0 because is the last num expected 
									//now it can go to next line starting from 0 to start count again
							//because this is the last number expected i can insert into the array process
							
							//ProcessList[i-2] = new Process("P"+(i-1),AT,BT,P);

							ProcessList[i-2] = new Process(""+(i-1),AT,BT,P);//this is process with # without p
							
							//ProcessList[i-2].printProcessInfo();
							
						}
						
					}//end of else that will take all the processes. 
				
					
					
					digits="";//to reset the string num holder to null	
				}//end of if statement checking if integer
			
			
			}//end of 2nd forloop
			
		}//end of first forloop
		//for(int i=0;i<)
		
	}//end of decodeDataFromFile
	public static void QueueAgregate(int i){//i is the time
		while(!QueueHolder.isEmpty() &&QueueHolder.peek().ArravingTime<=i){
			//System.out.println(i+")"+QueueHolder.peek().Pname +"added to the circular queue.");

			CircularQueue.add(QueueHolder.remove());
			
		}
	}
	
	public static void processing(){
		int count=0;
		CircularQueue= new ProcessQueue(ProcessList.length);
		Process ProcessTemp;
		int check;
		boolean stop;
		System.out.println("this is the total BT: "+TotalBT);
		for(int i=0;i<=TotalBT;){
			//System.out.println("Time"+i);
			//make a counter and in it an if statement if counter == head of queue list == counter 
				//add while head of queue list == counter
			/*
			while(!QueueHolder.isEmpty() &&QueueHolder.peek().ArravingTime<=i){
				System.out.println(i+")"+QueueHolder.peek().Pname +"added to the circular queue.");

				CircularQueue.add(QueueHolder.remove());
			}*/
			QueueAgregate( i);
			
			if(CircularQueue.size()!=0){
				ProcessTemp=CircularQueue.remove();
				ProcessTemp.setStartTime(i);
				ProcessTemp.calculateAverage();//this will calculate the averageTime with new start tame - old end time
											
				check = ProcessTemp.decrementBurstTime(quantumN);
				
				if(check==100){
					//System.out.println(i+" "+(i+quantumN)+" "+ProcessTemp.Pname+"(Size"+CircularQueue.size()+")");
					i+=quantumN; //means that the process is done with no time left
								//no need to add again.
					QueueAgregate( i);
					ProcessTemp.setEndTime(i);
					ProcessTemp.setCompleteTime(i);
					ProcessTemp.printWorkingProces();
					QueueStringHolder.add(ProcessTemp.StringFinalInfo());
					//System.out.println("hey hey ==-1");
					
				}
				else if(check<quantumN){
					//System.out.println(i+" "+(i+quantumN-check)+" "+ProcessTemp.Pname+"(Size"+CircularQueue.size()+")");
					i+=check;
					QueueAgregate( i);
					ProcessTemp.setEndTime(i);
					ProcessTemp.setCompleteTime(i);
					ProcessTemp.printWorkingProces();
					QueueStringHolder.add(ProcessTemp.StringFinalInfo());
					//System.out.println("yo yo check<quantumN");


				}
				else if(check==200){
					//System.out.println("hey yo hello more are adding");
					//System.out.println(i+" "+(i+quantumN)+" "+ProcessTemp.Pname+"(Size"+CircularQueue.size()+")");
					i+=quantumN;
					QueueAgregate( i);
					ProcessTemp.setEndTime(i);
					ProcessTemp.printWorkingProces();
					QueueStringHolder.add(ProcessTemp.StringFinalInfo());
					CircularQueue.add(ProcessTemp);
					//CircularQueue.peek().StartTime=i;
					//System.out.println("hellllo ==0");

					
				}
				
			}//end if
			else{
				i++;
			}
			
		}//end for loop
		
		
	}//end of processing()
	public static void OutToFile(){
		int size=QueueStringHolder.size();
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter("out.txt");
			  BufferedWriter outTo = new BufferedWriter(fstream);
			  
			  outTo.write("Hello! Round Robbin."+"\n");
			  
		for(int x=0;x<size;++x)
		{
		//double result = computation(LinesContainer.elementAt(x));	
		//System.out.print("The value of \""+LinesContainer.elementAt(x)+"\"  is "+result+"\n");
		outTo.write(QueueStringHolder.remove()+"\n");
		}//end of second for loop
		//---------writing to  file
		  //Close the output stream
		  outTo.close();
		
		 }catch(Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("What is the name of the File to read from:");
		Scanner in= new Scanner(System.in); 
		filename= in.next();
		
		ReadFromFile(filename);
		decodeDataFromFile();
		System.out.println("---------------------------------TotalBT="+TotalBT);
		//selectionsort(ProcessList, 0,ProcessList.length );
		bubbleSort(ProcessList);
		processing();
		OutToFile();
		System.out.println("out.txt has been created..");

		
		

	}

}
