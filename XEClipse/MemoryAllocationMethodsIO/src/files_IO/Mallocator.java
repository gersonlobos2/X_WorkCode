package files_IO;



import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Vector;

public class Mallocator {

	static int NumOfProcesses;
	static Vector<String> LinesContainerP= new Vector<String>();
	static Vector<Process> ListProcess = new Vector<Process>();
	
	static Vector<Process> FFListProcess = new Vector<Process>();
	static Vector<Process> BFListProcess = new Vector<Process>();
	static Vector<Process> WFListProcess = new Vector<Process>();
	/**
	 * @param args
	 */
	static int NumOfMemorySlots;
	static Vector<String> LinesContainerM= new Vector<String>();
	static Vector<MemorySlot> ListMemorySlots = new Vector<MemorySlot>();
	
	static Vector<MemorySlot> FFListMemorySlots = new Vector<MemorySlot>();
	static Vector<MemorySlot> BFListMemorySlots = new Vector<MemorySlot>();
	static Vector<MemorySlot> WFListMemorySlots = new Vector<MemorySlot>();
	
	
	
	
	public static void main(String[] args){
		
		System.out.println("------------------------------------------ EXAMPLE # 1");

		//------------------------------------------ first example
		readFile( "process.data",  LinesContainerP);
		decodeDataFromFileProcess();
		
		readFile( "memory.data",  LinesContainerM);
		decodeDataFromFileMemory();
		
		FirstFit( FFListProcess,  FFListMemorySlots);
		BestFit(BFListProcess, BFListMemorySlots);
		WorstFit( WFListProcess,  WFListMemorySlots);
		
		
		writeToFileProcess("FFprocess.data", FFListProcess );
		writeToFileMemorySlot("FFmemory.data", FFListMemorySlots );
		
		writeToFileProcess("BFprocess.data", BFListProcess );
		writeToFileMemorySlot("BFmemory.data", BFListMemorySlots );
		
		writeToFileProcess("WFprocess.data", WFListProcess );
		writeToFileMemorySlot("WFmemory.data", WFListMemorySlots );
		System.out.println("------------------------------------------ EXAMPLE # 2");
		//------------------------------------------ second example
		emtyTheVectors();
		
		readFile( "process2.data",  LinesContainerP);
		decodeDataFromFileProcess();
		
		readFile( "memory2.data",  LinesContainerM);
		decodeDataFromFileMemory();
		
		FirstFit( FFListProcess,  FFListMemorySlots);
		BestFit(BFListProcess, BFListMemorySlots);
		WorstFit( WFListProcess,  WFListMemorySlots);
		
		
		writeToFileProcess("FFprocess2.data", FFListProcess );
		writeToFileMemorySlot("FFmemory2.data", FFListMemorySlots );
		
		writeToFileProcess("BFprocess2.data", BFListProcess );
		writeToFileMemorySlot("BFmemory2.data", BFListMemorySlots );
		
		writeToFileProcess("WFprocess2.data", WFListProcess );
		writeToFileMemorySlot("WFmemory2.data", WFListMemorySlots );
		
		//System.out.println("------------------------------------------ EXAMPLE # 3");

		//------------------------------------------ third example
		/*
		emtyTheVectors();
		
		readFile( "process3.data",  LinesContainerP);
		decodeDataFromFileProcess();
		
		readFile( "memory3.data",  LinesContainerM);
		decodeDataFromFileMemory();
		
		FirstFit( FFListProcess,  FFListMemorySlots);
		BestFit(BFListProcess, BFListMemorySlots);
		WorstFit( WFListProcess,  WFListMemorySlots);
		
		
		writeToFileProcess("FFprocess3.data", FFListProcess );
		writeToFileMemorySlot("FFmemory3.data", FFListMemorySlots );
		
		writeToFileProcess("BFprocess3.data", BFListProcess );
		writeToFileMemorySlot("BFmemory.data", BFListMemorySlots );
		
		writeToFileProcess("WFprocess3.data", WFListProcess );
		writeToFileMemorySlot("WFmemory3.data", WFListMemorySlots );
		
		*/
		
		
	}//end main
	public static void emtyTheVectors(){
		LinesContainerP.removeAllElements();
		ListProcess.removeAllElements();
		FFListProcess.removeAllElements();
		BFListProcess.removeAllElements();
		WFListProcess.removeAllElements();
		
		LinesContainerM.removeAllElements();
		ListMemorySlots.removeAllElements();
		FFListMemorySlots.removeAllElements();
		BFListMemorySlots.removeAllElements();
		WFListMemorySlots.removeAllElements();
		
	}
	public static void writeToFileProcess(String filename, Vector<Process> ProcessList ){
		int size=ProcessList.size();
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter(filename);
			  BufferedWriter outTo = new BufferedWriter(fstream);
			  
			  outTo.write(size+"\n");
			  
		for(int x=0;x<size;++x)
		{
		//double result = computation(LinesContainer.elementAt(x));	
		//System.out.print("The value of \""+LinesContainer.elementAt(x)+"\"  is "+result+"\n");
			
		outTo.write(ProcessList.get(x).PrintProcessString()+"\n");
		}//end of second for loop
		//---------writing to  file
		  //Close the output stream
		  outTo.close();
		
		 }catch(Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	public static void writeToFileMemorySlot(String filename, Vector<MemorySlot>  MemorySlotList){
		int size=MemorySlotList.size();
		 try{
			  // Create file 
			  FileWriter fstream = new FileWriter(filename);
			  BufferedWriter outTo = new BufferedWriter(fstream);
			  
			  outTo.write(size+"\n");
			  
		for(int x=0;x<size;++x)
		{
		//double result = computation(LinesContainer.elementAt(x));	
		//System.out.print("The value of \""+LinesContainer.elementAt(x)+"\"  is "+result+"\n");
			
		outTo.write(MemorySlotList.get(x).printMemorySlotString()+"\n");
		}//end of second for loop
		//---------writing to  file
		  //Close the output stream
		  outTo.close();
		
		 }catch(Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
	}
	
	public static void BestFit(Vector<Process> ProcessList, Vector<MemorySlot>  MemorySlotList){
		boolean inserted;
		int Mstart = 0, Mend=0,Psize,MendP=0;
		int Mstart2 = 0, Mend2=0,Psize2,MendP2=0;
		int MinSize,minsize2=1000;
		int TempXindex = 0;
		
		for(int i=0;i<ProcessList.size();++i){
			
			if(ProcessList.get(i).AlocatedAt == -1){
				Psize=ProcessList.get(i).Size;
				inserted=false;
				
				for(int x=0; x < MemorySlotList.size(); ++x){
					
					Mstart = MemorySlotList.get(x).AddressStart;
					Mend = MemorySlotList.get(x).AddressEnd;
					
					if(MemorySlotList.get(x).OcccupiedBy == 0 && (Mend-Mstart+1) >= Psize){
						
						MinSize=(Mend-Mstart+1)-Psize;
						
						if(MinSize == 0 && inserted==false){
							MemorySlotList.get(x).OcccupiedBy=ProcessList.get(i).ID;
							
							ProcessList.get(i).AlocatedAt = MemorySlotList.get(x).AddressStart;
							inserted=true;
						}
						else{

							if(minsize2>MinSize){
								minsize2=MinSize;
								TempXindex=x;
							}
							
						}
						
					}//end if MemorySlotList.get(x).OcccupiedBy == 0 && (Mend-Mstart+1) >= Psize
					
				}//end for x
				if(inserted==false)
				{
					//System.out.println("id="+ProcessList.get(i).ID);
					Mstart2=MemorySlotList.get(TempXindex).AddressStart;
					Mend2=MemorySlotList.get(TempXindex).AddressEnd;
					Psize2=ProcessList.get(i).Size;
					
					ProcessList.get(i).AlocatedAt = Mstart2;;
					MemorySlotList.get(TempXindex).OcccupiedBy = ProcessList.get(i).ID;
					
					
					MemorySlotList.get(TempXindex).AddressEnd = Mstart2 + Psize2 - 1;
					
					MemorySlotList.add(new MemorySlot((Mstart2 + Psize2),Mend2,0));
					sort('B');
					inserted=true;
					
				}
				
				
				
				
			}//end if -1
			minsize2=1000;
			
		}//end for i
		
		System.out.println("-------------- Best Fit MemorySlot List-------------");
		for(int z=0;z<MemorySlotList.size();++z){
			MemorySlotList.get(z).printMemorySlot();
		}
		System.out.println("-------------- Best Fit Process List-------------");
		for(int z=0;z<ProcessList.size();++z){
			ProcessList.get(z).PrintProcess();
		}
		
	}//end Best fit 
	

	public static void WorstFit(Vector<Process> ProcessList, Vector<MemorySlot>  MemorySlotList){
		boolean inserted;
		int Mstart = 0, Mend=0,Psize,MendP=0;
		int Mstart2 = 0, Mend2=0,Psize2,MendP2=0;
		int MaxSize=0;
		int TempXindex = 0;
		
		for(int i=0;i<ProcessList.size();++i){
			
			if(ProcessList.get(i).AlocatedAt == -1){
				Psize=ProcessList.get(i).Size;
				
				for(int x=0; x<MemorySlotList.size();++x){
					Mstart=MemorySlotList.get(x).AddressStart;
					Mend=MemorySlotList.get(x).AddressEnd;
					
					if(MemorySlotList.get(x).OcccupiedBy == 0 && (Mend-Mstart) > Psize){
						
						if( MaxSize < ((Mend-Mstart)-Psize)  ){
							MaxSize = ((Mend-Mstart)-Psize); // max size left after checking with Psize.
							TempXindex=x;
							//System.out.println("the index: "+(TempXindex+1)+" The Max size:"+MaxSize);
						}
					}//end if

				}//end for x
				
				if(MaxSize != 0 ){
					Mstart2=MemorySlotList.get(TempXindex).AddressStart;
					Mend2=MemorySlotList.get(TempXindex).AddressEnd;
					Psize2=ProcessList.get(i).Size;
					
					ProcessList.get(i).AlocatedAt = Mstart2;;
					MemorySlotList.get(TempXindex).OcccupiedBy = ProcessList.get(i).ID;
					
					
					MemorySlotList.get(TempXindex).AddressEnd = Mstart2 + Psize2 - 1;
					
					MemorySlotList.add(new MemorySlot((Mstart2 + Psize2),Mend2,0));
					sort('W');
					
					//inserted=true;
					
					MaxSize=0;
				}

			
			}//end if AlocatedAt== -1
		}//end for i
		
		System.out.println("-------------- Worst Fit MemorySlot List-------------");
		for(int z=0;z<MemorySlotList.size();++z){
			MemorySlotList.get(z).printMemorySlot();
		}
		System.out.println("-------------- Worst Fit Process List-------------");
		for(int z=0;z<ProcessList.size();++z){
			ProcessList.get(z).PrintProcess();
		}
		
	}//end Worst fit 
	
	public static void FirstFit(Vector<Process> ProcessList, Vector<MemorySlot> MemorySlotList){
		boolean inserted;
		int Mstart, Mend,Psize,MendP;
		
		for(int i=0;i<ProcessList.size();++i){
			
			if(ProcessList.get(i).AlocatedAt==-1){
				Psize=ProcessList.get(i).Size;
				inserted=false;
				
				for(int x=0; x<MemorySlotList.size();++x){
					Mstart=MemorySlotList.get(x).AddressStart;
					Mend=MemorySlotList.get(x).AddressEnd;
					
					if(MemorySlotList.get(x).OcccupiedBy==0 && inserted == false && (Mend-Mstart) > Psize){
						ProcessList.get(i).AlocatedAt=MemorySlotList.get(x).AddressStart;
						MemorySlotList.get(x).OcccupiedBy=ProcessList.get(i).ID;
						MemorySlotList.get(x).AddressEnd = Mstart+Psize-1;
						
						MemorySlotList.add(new MemorySlot(Mstart+Psize,Mend,0));
						sort('F');
						inserted=true;
					}
					
					
				}//end for x
			}//end if (process.AlocatedAt = -1)
			
		}//end for i
		
		
		
		System.out.println("-------------- First Fit Memory List-------------");
		for(int z=0;z<MemorySlotList.size();++z){
			MemorySlotList.get(z).printMemorySlot();
		}
		System.out.println("-------------- First Fit Process List-------------");
		for(int i=0; i<FFListProcess.size();++i)
		{
			FFListProcess.get(i).PrintProcess();
		}

		
	}//end method
	//-------------------------------------------------------------------
	public static void readFile(String filename, Vector<String> LinesContainer2){
		//pre: the name of a file is passed to read from
				//post: lines in the file are stored in the vector
				java.io.File file= new java.io.File(filename); //opens the file named filename
				System.out.println("-------- read from file: "+filename +"--------");

				try{
					
					Scanner input = new Scanner(file);
					while(input.hasNext()){
					String line = input.nextLine(); //gets the line from file and puts in string
					LinesContainer2.add(line+"  ");       //stores the lines into the vector container 
							//i added a space becasue of a bug when there is no space after line
							//error is when going through the line (cant see how to fix it :( )
					System.out.println(line);
					}
					System.out.println("----------------------------------------------");
				}catch (FileNotFoundException e) {
					System.err.format("File does not exist \n");
				}
	}//end of readFile
	
	public static void decodeDataFromFileProcess(){
		int NCount=0;//used to count each number from the 3 expected in the line.
		int ID=0;
		int SizeP=0;
		int ALocated=-1; //-1 meaning no allocation
		Process temp;
		Process temp1;
		Process temp2;
		Process temp3;
		
		
		String digits="";//this will hold the integer and integers with more than one digit like 12
		
		

		for(int i=0;i<LinesContainerP.size();++i){//this goes to the vector to get the lines

			for(int x=0; x< LinesContainerP.get(i).length(); ++x)//gets the string from vector index and looks for numbers
			{//this goes through the string.
				if(LinesContainerP.get(i).charAt(x)=='-'){
					ALocated=-1;
					NCount=0;//this will set NCounts = 0 because is the last num expected 
					//now it can go to next line starting from 0 to start count again
					//because this is the last number expected i can insert into the array process
				temp=new Process(ID,SizeP,ALocated);
				temp1=new Process(ID,SizeP,ALocated);
				temp2=new Process(ID,SizeP,ALocated);
				temp3=new Process(ID,SizeP,ALocated);
				//     temp.PrintProcess();                       //here i am printing process list
				ListProcess.add(temp);	
				FFListProcess.add(temp1);
				BFListProcess.add(temp2);
				WFListProcess.add(temp3);
				}
				if( (Character.isDigit(LinesContainerP.get(i).charAt(x))) ==true  )
				{

					//this while loop will make sure we get numbers with more than one digit
					while(Character.isDigit(LinesContainerP.get(i).charAt(x))==true  ){

					digits += LinesContainerP.get(i).charAt(x);
					

					++x;//to increment the x index in the string in case of int with more than 1 digit
					
					}//end while loop
					

					
					

		//--------------------------------------
					 //we have to separate the first 2 lines that contain only info 
					if(i==0){ //this means we are on the first line
						NumOfProcesses = Integer.parseInt(digits);//converts the String into an integer
						//now i know the number of processes i have
					
					}
					
					else{ //this is the lines that come where 3 numbers or 2 numbers and a (-) are expected.
						if(NCount==0){
							ID=Integer.parseInt(digits);
							NCount++; //this will increment NCount for the next int

						}
						else if(NCount==1){
							SizeP=Integer.parseInt(digits);
							NCount++; //this will increment NCount for the next int
						}
						else if(NCount==2){
							
									ALocated=Integer.parseInt(digits);
								
								NCount=0;//this will set NCounts = 0 because is the last num expected 
										//now it can go to next line starting from 0 to start count again
								//because this is the last number expected i can insert into the array process
								temp=new Process(ID,SizeP,ALocated);
								temp1=new Process(ID,SizeP,ALocated);
								temp2=new Process(ID,SizeP,ALocated);
								temp3=new Process(ID,SizeP,ALocated);
								
								//        temp.PrintProcess();    //here i am printing process list
								ListProcess.add(temp);
								//FFListProcess.add(new Process(ID,SizeP,ALocated));
								//BFListProcess.add(new Process(ID,SizeP,ALocated));
								//WFListProcess.add(new Process(ID,SizeP,ALocated));
								
								FFListProcess.add(temp1);
								BFListProcess.add(temp2);
								WFListProcess.add(temp3);
						}//end of else if (NCount==2)
						
					}//end of else that will take all the processes. 
				

					digits="";//to reset the string num holder to null	
				}//end of if statement checking if integer
			
			
			}//end of 2nd forloop
			
		}//end of first forloop
		//for(int i=0;i<)
		
	}//end of decodeDataFromFile
	//*****************************************************************************************************
	
	public static void decodeDataFromFileMemory(){
		int NCount=0;//used to count each number from the 3 expected in the line.
		int AddressStart=0;
		int AddressEnd=0;
		int OccupiedBy=0; // 0 meaning is free and no occupied. 
		MemorySlot temp;
		MemorySlot temp1;
		MemorySlot temp2;
		MemorySlot temp3;
		
		
		String digits="";//this will hold the integer and integers with more than one digit like 12
		
		

		for(int i=0;i<LinesContainerM.size();++i){//this goes to the vector to get the lines

			for(int x=0; x< LinesContainerM.get(i).length(); ++x)//gets the string from vector index and looks for numbers
			{//this goes through the string.
				
				if( (Character.isDigit(LinesContainerM.get(i).charAt(x))) ==true  )
				{

					//this while loop will make sure we get numbers with more than one digit
					while(Character.isDigit(LinesContainerM.get(i).charAt(x))==true  ){

					digits += LinesContainerM.get(i).charAt(x);
					

					++x;//to increment the x index in the string in case of int with more than 1 digit
					
					}//end while loop
					

					
					

		//--------------------------------------
					 //we have to separate the first 2 lines that contain only info 
					if(i==0){ //this means we are on the first line
						NumOfMemorySlots = Integer.parseInt(digits);//converts the String into an integer
						//now i know the number of processes i have
					
					}
					
					else{ //this is the lines that come where 3 numbers or 2 numbers and a (-) are expected.
						if(NCount==0){
							AddressStart=Integer.parseInt(digits);
							NCount++; //this will increment NCount for the next int

						}
						else if(NCount==1){
							AddressEnd=Integer.parseInt(digits);
							NCount++; //this will increment NCount for the next int
						}
						else if(NCount==2){
							
								
							OccupiedBy=Integer.parseInt(digits);
								
								NCount=0;//this will set NCounts = 0 because is the last num expected 
										//now it can go to next line starting from 0 to start count again
								//because this is the last number expected i can insert into the array process
								temp = new MemorySlot(AddressStart,AddressEnd,OccupiedBy);
								temp1 = new MemorySlot(AddressStart,AddressEnd,OccupiedBy);
								temp2 = new MemorySlot(AddressStart,AddressEnd,OccupiedBy);
								temp3 = new MemorySlot(AddressStart,AddressEnd,OccupiedBy);
								
								
								//      temp.printMemorySlot();  			//here i am printing memory slot list
								ListMemorySlots.add(temp);
								//FFListMemorySlots.add( new MemorySlot(AddressStart,AddressEnd,OccupiedBy));
								//BFListMemorySlots.add( new MemorySlot(AddressStart,AddressEnd,OccupiedBy));
								//WFListMemorySlots.add( new MemorySlot(AddressStart,AddressEnd,OccupiedBy));
								
								FFListMemorySlots.add( temp1);
								BFListMemorySlots.add( temp2);
								WFListMemorySlots.add( temp3);
								
						}//end of else if (NCount==2)
						
					}//end of else that will take all the processes. 
				

					digits="";//to reset the string num holder to null	
				}//end of if statement checking if integer
			
			
			}//end of 2nd forloop
			
		}//end of first forloop
		//for(int i=0;i<)
		
	}//end of decodeDataFromFile Memory
	
 public static void sort(char Listchoise){
		
		switch(Listchoise){
		case 'F':
			bubbleSort( FFListMemorySlots);
			break;
			
		case 'B':
			bubbleSort( BFListMemorySlots);
			break;
		case 'W':
			bubbleSort( WFListMemorySlots);
			break;
			
		default:
			break;
		}
	}

public static void bubbleSort( Vector<MemorySlot> data )
{
     int j;
     boolean flag = true;   // set flag to true to begin first pass
     MemorySlot temp;   //holding variable

     while ( flag )
     {
            flag= false;    //set flag to false awaiting a possible swap
            for( j=0;  j < data.size() -1;  j++ )
            {
                   if ( data.elementAt(j).AddressStart > data.elementAt(j+1).AddressStart )   // change to > for ascending sort
                   {
                           temp = new MemorySlot(data.elementAt(j).AddressStart,data.elementAt(j).AddressEnd,data.elementAt(j).OcccupiedBy);
                                        //swap elements
                           

                           data.elementAt(j).AddressStart= data.elementAt(j+1).AddressStart;
                           data.elementAt(j).AddressEnd= data.elementAt(j+1).AddressEnd;
                           data.elementAt(j).OcccupiedBy= data.elementAt(j+1).OcccupiedBy;

                           data.elementAt(j+1).AddressStart = temp.AddressStart;
                           data.elementAt(j+1).AddressEnd = temp.AddressEnd;
                           data.elementAt(j+1).OcccupiedBy = temp.OcccupiedBy;
                           
                          flag = true;              //shows a swap occurred  
                  } 
            } 
      }
     /*
     System.out.println("----------------Vector");

       for(int x=0;x<data.size();++x){//putting everything into a queue
       	
       	data.elementAt(x).printMemorySlot();
       }
       */
} //end bubble sort method
//*****************************************************************************************************
	
	

}//end class TestMain
