import simulation.Averager; 
import simulation.BooleanSource;
import simulation.Washer;
import java.util.*;

public class CarWash
{
   
   public static void main(String[ ] args)
   {
	   // car wash program --------------------------------
	   int option = 0;
	   Scanner in;
	   System.out.print("Press 1 to simulate CarWash, and 2 for AirPort"+"\n");
	   in = new Scanner(System.in);
	   option = in.nextInt();
	   
	   if (option == 1)
	   {
	  final int WASHTIME = 240;
      final double ARRIVALPROB = 0.0025;
      final int TOTALTIME = 6000;
      
      carWashSimulate(WASHTIME, ARRIVALPROB, TOTALTIME);
	   }
	   else
	   {
	   // airport program --------------------------------
	   final int LandingTime = 4;
	   final int TakeOffTime = 2;
	   final int TotalSimulation = 6000;
	   final int MaxTimeWaiting = 2;
	   final double  AverageArrivalToLanding=0.05;
	   final double AverageArrivalToTakeOff=0.05;
	   
	
	   //call the function here
	   airPortSimulate(LandingTime,TakeOffTime,AverageArrivalToLanding,
		 AverageArrivalToTakeOff,  MaxTimeWaiting,TotalSimulation);
	 
	   }// end of else statement
   }//End of Main
    
   public static void airPortSimulate
   (int LandingTime, int TakeOffTime, double AverageArrivalToLanding,
	double AverageArrivalToTakeOff, int MaxTimeWaiting,
	int TotalSimulation)
   {
	   int time=0;
	   int PlainsCrashed=0;
	   
		
	   Queue<Integer> LandingTimes= new LinkedList<Integer>();
	   Queue<Integer> TakeOffTimes= new LinkedList<Integer>();
	   
	   Washer TakingOff = new Washer(TakeOffTime);
	   Washer Landing	= new Washer(LandingTime);
	   
	   BooleanSource AverageTakeOff=new BooleanSource(AverageArrivalToTakeOff);
	   BooleanSource AverageLanding=new BooleanSource(AverageArrivalToLanding);
   
	   
	
	Averager LandingAverageCalculator = new Averager();
	
	Averager TakingOffAverageCalculator=new Averager();
	   
	   if(TotalSimulation <= 0 || AverageArrivalToTakeOff > 1 
	    || AverageArrivalToLanding > 1 || MaxTimeWaiting <= 0
	    ||LandingTime <=0 || TakeOffTime <= 0)
	   {
		   throw new IllegalArgumentException("Values out of range");
	   }
	   
	   for(int CurrentSecond = 0; CurrentSecond < TotalSimulation; ++CurrentSecond)
	   {
		   //this statements check for the provability of a plane
		   //landing or taking off and records the time.
		   if(AverageTakeOff.query())
			   TakeOffTimes.add(CurrentSecond);
		   if(AverageLanding.query())
			   LandingTimes.add(CurrentSecond);
		   
		   if((!Landing.isBusy()) && (!LandingTimes.isEmpty()) && (!TakingOff.isBusy()))
		   //if there are no planes landing, but there are planes waiting,
			   //and there are no planes taking off
			   //then the priority that is landing will occur.
		   {
			   time = LandingTimes.remove();
			 
			   if((CurrentSecond-time) < MaxTimeWaiting)
				   //this will check if the plain didn't run out of time and crashed
			   {
				   LandingAverageCalculator.addNumber(CurrentSecond - time);//Averager
				   Landing.startWashing();//means to start landing
			   }
			   else
			   {
				   PlainsCrashed++;
			   }
			 
		   }//end of checking landing
		   else if((!TakingOff.isBusy()) && (!TakeOffTimes.isEmpty()) && (!Landing.isBusy()))
		   //if no planes landing, and no planes taking off, 
			   //and planes waiting to take off, then take off
			   //(it wont be done if plain waiting to land)
		   {
			   time = TakeOffTimes.remove(); //Queue
			   
			   TakingOffAverageCalculator.addNumber(CurrentSecond - time);
			   TakingOff.startWashing();
		   }
		   
			//reducing the time of Take Off and Landing   
		   TakingOff.reduceRemainingTime(); //machine
		   Landing.reduceRemainingTime();//machine
	   }//end of for loop
	   
	   System.out.print("Plaines that Took Off   = "+ TakingOffAverageCalculator.howManyNumbers() +"\n");
	   System.out.print("Plaines that Landed     = "+LandingAverageCalculator.howManyNumbers()+"\n");
	   System.out.print("Number of Planes Crashed= "+PlainsCrashed+"\n");
	   if(TakingOffAverageCalculator.howManyNumbers() > 0)
	   {
		   System.out.print("Average Take Off time= "+TakingOffAverageCalculator.average()+" min \n");
	   }
	   if(LandingAverageCalculator.howManyNumbers() > 0)
	   {
		   System.out.print("Average Landing time = "+LandingAverageCalculator.average()+" min \n");
	   }
	   
	   
   }//end of the function
   
   public static void carWashSimulate
   (int washTime, double arrivalProb, int totalTime)
   {
      Queue<Integer> arrivalTimes = new LinkedList<Integer>( );  
      int next;
      BooleanSource arrival = new BooleanSource(arrivalProb);
      Washer machine = new Washer(washTime);
      Averager waitTimes = new Averager();
      int currentSecond;
  
      // Write the parameters to System.mck the precondition:
      if (washTime <= 0 || arrivalProb < 0 || arrivalProb > 1 || totalTime < 0)
         throw new IllegalArgumentException("Values out of range"); 

      for (currentSecond = 0; currentSecond < totalTime; currentSecond++)
      {  // Simulate the passage of one second of time.

         // Check whether a new customer has arrived.
         if (arrival.query( ))
            arrivalTimes.add(currentSecond);
  
         // Check whether we can start washing another car.
         if ((!machine.isBusy( ))  &&  (!arrivalTimes.isEmpty( )))
         {
            next = arrivalTimes.remove( );
            waitTimes.addNumber(currentSecond - next);
            machine.startWashing( );
         }

         // Subtract one second from the remaining time in the current wash cycle.
         machine.reduceRemainingTime( );
      }

      // Write the summary information about the simulation.
      System.out.println("Customers served: " + waitTimes.howManyNumbers( )); 
      if (waitTimes.howManyNumbers( ) > 0)
         System.out.println("Average wait: " + waitTimes.average( ) + " sec");
   }
    
}