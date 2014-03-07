package oop3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
   Counts and reports the number of words in each of a group of files.
   Each count is done in a separate thread.
*/
public class WordCounter extends Thread
{
	
	private String filename;
	private int count;
	private JTextArea tArea;
	private JLabel label;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
     Contandor TOTAL_COUNT;
    /*
   public WordCounter(String filename)
   {
      this.filename = filename;
      label= new JLabel(filename);
   }
   */
   public WordCounter(){
	   
   }
   public void setContandor(Contandor _TOTAL_COUNT){
	   TOTAL_COUNT= _TOTAL_COUNT;
   }
   
   public void setFilename(String filename){
	   this.filename = filename;
	      label= new JLabel(filename);
   }
   
   public void Count()
   {
      count += 1;
   }
   public String getFileName()
   {
      return filename;
   }
   public int getCount()
   {
      return count;
   }
   
   public void setTextarea( JTextArea _tArea){
	   tArea = _tArea;
   }
   
 public JTextArea getTextarea(){
	 return tArea;
 }
 public JLabel getJLabel(){
	 return label;
 }

   public void run()
   {
      count =0;

      try
      {
         Scanner in = new Scanner(new File(filename));

                	  while (in.hasNext())
                      { 
                		  lock.lock();
                          try{
                		  
                	 in.next();
                     ++count;
                     
                    // System.out.println(filename + ": " + count);
                	 tArea.setText(""+count);
                	 TOTAL_COUNT.incrementTWC();

       }
                          finally{
                         	 lock.unlock();
                         	 
                          }
                	 
                      }//end while
         
        // System.out.println(filename + ": " + count);
      }
      catch (FileNotFoundException e)
      {
         System.out.println(filename + " not found!");
      }
      }
   
 
}