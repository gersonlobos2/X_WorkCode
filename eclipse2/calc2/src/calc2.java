import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.lang.Integer;

import java.lang.*; 









public class  calc2  implements ActionListener

{

	// static variables

	 public static JButton[] buttons = new JButton [16];// creates an array of 1 buttons   

	 public static JTextArea text;       

	 public static JFrame frame;

	 public static Container numbers;

	 public static int num1,num2,result; // is more effective to change it to a double

	 public static int add=0,sub=0,mult=0,div=0;  //this can not change

  	public void calc2(){

    		

	}  

	 

	 public static void main(String [] args)

	 {

	 

	 

	   

	 

	 	// Create the frame

		String title = "Calculator ";

		frame = new JFrame(title);          //creating a window 

		frame.setDefaultLookAndFeelDecorated(true); 

		frame.setSize(400, 150);  // size of the window

		numbers = frame.getContentPane();

		numbers.setBackground(Color.white); // color of the window

		numbers.setLayout(new GridBagLayout());  // it sets the pattern for the buttons

		GridBagConstraints e = new GridBagConstraints();

		

		e.fill = GridBagConstraints.HORIZONTAL;

		

		 				

		

		// this is for the text box 

		 text = new JTextArea(1,5);

		 e.gridx = 0;

		 e.gridy =0;

		 numbers.add(text,e);

     // the patterns in  the window for the buttons

		buttons[0] = new JButton("0");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 0;

		e.gridy = 1;

		numbers.add(buttons[0], e);

		

		buttons[1] = new JButton("1");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 1;

		e.gridy = 1;

		numbers.add(buttons[1], e);

		

		buttons[2] = new JButton("2");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 2;

		e.gridy = 1;

		numbers.add(buttons[2], e);

		

		buttons[3] = new JButton("3");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 3;

		e.gridy = 1;

		numbers.add(buttons[3], e);

		

		buttons[4] = new JButton("4");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 4;

		e.gridy = 1;

		numbers.add(buttons[4], e);

		

		buttons[5] = new JButton("5");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 0;

		e.gridy = 2;

		numbers.add(buttons[5], e);

		

		buttons[6] = new JButton("6");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 1;

		e.gridy = 2;

		numbers.add(buttons[6], e);

		

		buttons[7] = new JButton("7");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 2;

		e.gridy = 2;

		numbers.add(buttons[7], e);

		

		buttons[8] = new JButton("8");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 3;

		e.gridy = 2;

		numbers.add(buttons[8], e);

		

		buttons[9] = new JButton("9");

		e.fill = GridBagConstraints.HORIZONTAL;

		e.gridx = 4;

		e.gridy = 2;

		numbers.add(buttons[9], e);

		

		 buttons[10] = new JButton("+");

 		e.fill = GridBagConstraints.HORIZONTAL;

 		e.gridx = 5;

 		e.gridy = 1;

 		numbers.add(buttons[10], e);

       

 		buttons[11] = new JButton("=");

 		e.fill = GridBagConstraints.HORIZONTAL;

 		e.gridx = 5;

 		e.gridy = 2;

 		numbers.add(buttons[11], e);

		

		buttons[12] = new JButton("-");

 		e.fill = GridBagConstraints.HORIZONTAL;

 		e.gridx = 1;

 		e.gridy = 3;

 		numbers.add(buttons[12], e);



      buttons[13] = new JButton("*");

 		e.fill = GridBagConstraints.HORIZONTAL;

 		e.gridx = 2;

 		e.gridy = 3;

 		numbers.add(buttons[13], e);



		

		buttons[14] = new JButton("/");

 		e.fill = GridBagConstraints.HORIZONTAL;

 		e.gridx = 3;

 		e.gridy = 3;

 		numbers.add(buttons[14], e);

		

		buttons[15] = new JButton("Clear");

 		e.fill = GridBagConstraints.HORIZONTAL;

 		e.gridx = 4;

 		e.gridy = 3;

 		numbers.add(buttons[15], e);







 // the action lister input the number into the Table which input into the text box

   buttons[0].addActionListener(new calc2());  

    buttons[1].addActionListener(new calc2());

    buttons[2].addActionListener(new calc2());

    buttons[3].addActionListener(new calc2());

    buttons[4].addActionListener(new calc2());

   buttons[5].addActionListener(new calc2());

	buttons[6].addActionListener(new calc2());

    buttons[7].addActionListener(new calc2());

		buttons[8].addActionListener(new calc2());

   buttons[9].addActionListener(new calc2());

	buttons[10].addActionListener(new calc2());

	buttons[11].addActionListener(new calc2());

	buttons[12].addActionListener(new calc2());

	buttons[13].addActionListener(new calc2());

	buttons[14].addActionListener(new calc2());

	buttons[15].addActionListener(new calc2());

			frame.addWindowListener(new QuitListener());

    	frame.setVisible(true);  // to make the frame visible

	 }

	 

	





	 

	 

	 

public void actionPerformed(ActionEvent M)

  {

        Object source = M.getSource();

    // the if and else stament to get the numbers 

       

		 if(source == buttons[15])

		  {

		    num1 = 0;

			 num2 = 0;

			 text.setText("");

		  }

		 

		  if (source == buttons[0])

		  {

		     text.append("0"); 

		  }

		  if (source == buttons[1])

		  {

		     text.append("1"); 

		  }

			if (source == buttons[2])

		  {

		     text.append("2"); 

		  }

			if (source == buttons[3])

		  {

		     text.append("3"); 

		  }

		if (source == buttons[4])

		  {

		     text.append("4"); 

		  }

			if (source == buttons[5])

		  {

		     text.append("5"); 

		  }

			if (source == buttons[6])

		  {

		     text.append("6"); 

		  }



			if (source == buttons[7])

		  {

		     text.append("7"); 

		  }

		  if (source == buttons[8])

		  {

		     text.append("8"); 

		  }

			if (source == buttons[9])

		  {

		     text.append("9"); 

		  }



       if(source == buttons[10])

	 	{

		  num1 = numberReader();

		  text.setText("");

		  add =1;

		  sub =0;

		  mult =0;

		  div = 0;

		}

		

		if(source == buttons[12])

	 	{

		  num1 = numberReader();

		  text.setText("");

		  add =0;

		  sub =1;

		  mult =0;

		  div = 0;

		}

		if(source == buttons[13])

	 	{

		  num1 = numberReader();

		  text.setText("");

		  add =0;

		  sub =0;

		  mult =1;

		  div = 0;

		}

		if(source == buttons[14])

	 	{

		  num1 = numberReader();

		  text.setText("");

		  add =0;

		  sub =0;

		  mult =0;

		  div = 1;

		}







		

	 if (source == buttons[11])

	 {

	     num2 = numberReader();

		  if(add>0)

		  {

		    result = num1+num2;

			 text.setText (Integer.toString(result));//change into a double is efficient  

			 

		  } 

	     if(sub>0)

		  {

		    result = num1-num2;

			 text.setText (Integer.toString(result));//change into a double is efficient  

			 



			 

		  } 



	     if(mult>0)

		  {

		    result = num1*num2;

			 text.setText (Integer.toString(result));//change into a double is efficient  

			 



			 

		  } 

		  if(div>0)

		  {

		    result = num1/num2;

			 text.setText (Integer.toString(result)); //change into a double is efficient  

			 



			 

		  } 





	 

	 }	

		

		

		  }

public int numberReader()

{

   int number;

	String s;

	

	s = text.getText();

	number  = Integer.parseInt(s); //change into a double is efficient 

    

	return number; 

}









}

