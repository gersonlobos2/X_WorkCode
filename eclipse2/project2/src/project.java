import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
//import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.lang.Math;

//import javax.swing.JFormattedTextField;
 
/**
 * A very simple java swing application. 
 * Contains button and checkbox. Responds
 * to manipulations with these controls by
 * changing text in the main text area.
 * 
 * @author audriusa
 */
public class project extends JFrame implements ActionListener
{
  /**
   * The button.
   */ 
	
  JButton myButton1 = new JButton("1");

  JButton myButton2 = new JButton("2");
  JButton myButton3 = new JButton("3");
  JButton myButton4 = new JButton("4");
  JButton myButton5 = new JButton("5");
  JButton myButton6 = new JButton("6");
  JButton myButton7 = new JButton("7");
  JButton myButton8 = new JButton("8");
  JButton myButton9 = new JButton("9");
  JButton myButton0 = new JButton("0");
  JButton myButtonPluss = new JButton(" + ");
  JButton myButtonEquals = new JButton("Equals");
  /**
   * The the checkbox.
   */
  //JCheckBox myCheckBox = new JCheckBox("Check");
 
  /**
   * The text area.
   */
  JTextArea myText = new JTextArea("My text");
 
  /**
   * The bottom panel which holds button.
   */ 
  JPanel bottomPanel = new JPanel();
 
  /**
   * The top level panel which holds all.
   */
  JPanel holdAll = new JPanel();
 
  /**
   * The constructor.
   */
  public project()
  {
    //bottomPanel.setLayout(new FlowLayout());
    
   // bottomPanel.add(myCheckBox);
    GridBagConstraints c = new GridBagConstraints();
    c.gridx=0;
    c.gridy=1;
    bottomPanel.add(myButton1,c);
    bottomPanel.add(myButton2);
    bottomPanel.add(myButton3);
    bottomPanel.add(myButton4);
    bottomPanel.add(myButton5);
    bottomPanel.add(myButton6);
    bottomPanel.add(myButton7);
    bottomPanel.add(myButton8);
    bottomPanel.add(myButton9);
    bottomPanel.add(myButton0);
    bottomPanel.add(myButtonPluss);
    bottomPanel.add(myButtonEquals);
 // this is what i was going to fix. by puting all in holdall.
    holdAll.setLayout(new BorderLayout());
    holdAll.add(bottomPanel, BorderLayout.CENTER);
    holdAll.add(myText, BorderLayout.NORTH);
    
 
    getContentPane().add(holdAll, BorderLayout.CENTER);
 
    myButton1.addActionListener(this);
    myButton2.addActionListener(this);
    myButton3.addActionListener(this);
    myButton4.addActionListener(this);
    myButton5.addActionListener(this);
    myButton6.addActionListener(this);
    myButton7.addActionListener(this);
    myButton8.addActionListener(this);
    myButton9.addActionListener(this);
    myButton0.addActionListener(this);
    myButtonPluss.addActionListener(this);
    myButtonEquals.addActionListener(this);
   
    
    //myCheckBox.addActionListener(this);
 
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
  }
 
 
  public static void main(String[] args)
  {
    project myApplication = new project();
 
    // Specify where will it appear on the screen:
    myApplication.setLocation(300, 300);
    myApplication.setSize(200, 250);
 
    // Show it!
    myApplication.setVisible(true);
  }
 
  /**
   * Each non abstract class that implements the ActionListener
   * must have this method.
   * 
   * @param e the action event.
   */
  public void actionPerformed(ActionEvent e)
  {
	  int a=0;
	  int b=0;
	  
	  
	  String x,y;
    if (e.getSource() == myButton1)
      myText.setText(" 1 ");
    else if (e.getSource() == myButton2)
        myText.setText("2");
    else if (e.getSource() == myButton3)
        myText.setText("3");
    else if (e.getSource() == myButton4)
        myText.setText("4");
    else if (e.getSource() == myButton5)
        myText.setText("5");
    else if (e.getSource() == myButton6)
        myText.setText("6");
    else if (e.getSource() == myButton7)
        myText.setText("7");
    else if (e.getSource() == myButton8)
        myText.setText("8");
    else if (e.getSource() == myButton9)
        myText.setText("9");
    else if (e.getSource() == myButton0)
        myText.setText("0");
    else if (e.getSource()== myButtonPluss)
    {
    	a= Integer.parseInt(myText.getSelectedText());
       x=String.valueOf(a);
      myText.setText(x+"+");
    }
    
    
    if (e.getSource()==myButtonEquals)
    {
    	
     b= Integer.parseInt(myText.getSelectedText());
    
    // int c = a+b;
     
     y = String.valueOf(a+b);
     myText.setText(y);
    }
    	//**************************
    //i couldnt do what i was trying. it kept on giving me an error when i do the int c = a+b;
    
  }
}