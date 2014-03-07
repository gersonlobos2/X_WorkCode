package oop;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class WordCountTester 
{
	
	 static JFrame frame = new JFrame("Word Counter");
	 static JTextArea area;
	 static JTextField textfield = new JTextField();
	 
	 static  JPanel panel = new JPanel();
	 static  JPanel panel3 = new JPanel();
	 static Vector<String> hold;
	 static Vector<JLabel> labels;
 	 static Thread[] threads;
 	 GridLayout experimentLayout = new GridLayout(0,2);
 	static JTextArea[] Tarea;
	 
 public static void main(String args[])throws InterruptedException
   {
	   
	 
	   Tarea= new JTextArea[args.length];
	   WordCounter[] counTrack = new WordCounter[args.length]; //size of array is the number of arguments
	   int total = 0;
	   
	   JTextArea tAreaSouth=new JTextArea();
	 Contandor subTotalCount=new Contandor();
	  subTotalCount.includeingTextArea(tAreaSouth);
	  
	  panel3.add(new JLabel("Allfiles"));
	  panel3.add(tAreaSouth);
	  
	   panel.setLayout(new GridLayout(0,2));
	   
	   for(int i=0;i<args.length; ++i){
		   counTrack[i] = new WordCounter();
		   counTrack[i].setFilename(args[i]);
		   counTrack[i].setContandor(subTotalCount);
	
	    	  panel.add(new JLabel(args[i]));
	    	  Tarea[i]=new JTextArea(" ");
	    	  panel.add(Tarea[i]);
	    	  counTrack[i].setTextarea( Tarea[i]);
	   }

		   
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		      frame.add(panel, BorderLayout.NORTH);
		
		      //frame.add(panel2, BorderLayout.CENTER);
		      frame.add(panel3, BorderLayout.SOUTH);
		      frame.setSize(360, 360);
		      frame.setVisible(true);
	      
	      
	      
		   
	      
	   
	   for (int x = 0; x < args.length; ++x) {
		  
	    	  counTrack[x].start();
	    	  Thread.sleep(1000);
	    	  Thread.yield();
 
	   }
	   /*
	   for (WordCounter mycounter : counTrack) {
	        mycounter.join();
	        total += mycounter.getCount();
	        textfield.setText(""+total);
	   }
	    */
	   
	  
	  
   }
}