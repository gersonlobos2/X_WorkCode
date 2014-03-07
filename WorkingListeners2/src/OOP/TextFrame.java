package OOP;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;
import javax.swing.event.*;


public class TextFrame extends JFrame implements ChangeListener
{
	JButton boton = new JButton();
	Data listdata;
	 JTextField[] fieldList;
	 public TextFrame(Data d)
	 {
		 listdata = d;
		 final Container contentPane = this.getContentPane();
		 setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		 ArrayList<Double> a = listdata.getData();
		 fieldList = new JTextField[a.size()];
		 ActionListener Listen = new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 JTextField c = (JTextField) e.getSource();
				 int i = 0;
				 int count = fieldList.length;
				 while (i < count && fieldList[i] != c)
					 i++;
				 String text = c.getText().trim();
				 try
				 {
					 double value = Double.parseDouble(text);
					 listdata.update(i, value);
				 }
				 catch (Exception exc)
				 {
					 c.setText("Error. No update");
				 	}
			 }
		 };
		 final int FIELD_WIDTH = 11;
		 for (int i = 0; i < a.size(); i++)
		 {
			 JTextField textField = new JTextField(a.get(i).toString(),FIELD_WIDTH);
			 textField.addActionListener(Listen);
			 add(textField);
			 fieldList[i] = textField;
			 }

		 final BarGraph bar = new BarGraph(d);
		 listdata.attach(bar);
		 JPanel panel = new JPanel();
		 
		 boton = new JButton("ON|OFF");
		 
		 panel.add(boton);
		 
		 add(panel);
		 
		 /* this will add the action of changing color to the button.
		  * 
		  * */
		 boton.addActionListener(new 
	    		  ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//it will continually change the state of button between true or false;
			 bar.setButton(!bar.GetChangeButtonn());
			 bar.repaint();
			}
	    	  
	      });
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 pack();
		 setVisible(true);
	 }
	 /**
	  * Updates the state
	  * @param e the event to update with
	  */
	 public void stateChanged(ChangeEvent e)
	 {
		 ArrayList<Double> values = listdata.getData();
		 for (int i = 0; i < values.size(); i++)
		 {
			 fieldList[i].setText(values.get(i).toString());
		 }
	 }
	}