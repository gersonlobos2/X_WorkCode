import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.*;

import javax.swing.*;
import java.awt.event.*;


public class work extends JFrame implements ActionListener 
{
	//JFrame myFrame= new JFrame();
	JPanel windowPanel= new JPanel(); 
	JPanel holdAll= new JPanel();
	//JPanel windowDown =new JPanel();
	JMenuBar menuBar=new JMenuBar();
	JMenu menu= new JMenu("color");
	JMenu menu2=new JMenu("auto");
	
	
	
	JMenuItem yellow= new JMenuItem("yellow");
	JMenuItem red= new JMenuItem("red");
	JMenuItem blue= new JMenuItem("blue");
	
	
	public work()
	{
		//window.add(windowUp);
		//window.add(menuBar);
		
		menuBar.add(menu);
		menuBar.add(menu2);
		menu.add(yellow);
		menu.add(red);
		menu.add(blue);
		//windowPanel.add(new BorderLayout());
		
		windowPanel.add(menuBar);
		windowPanel.add(menu);
		holdAll.setLayout(new BorderLayout());
		holdAll.add(windowPanel, BorderLayout.CENTER);
		//myFrame.add(menuBar);
		
	}

	public static void main(String[] args)
	  {
		//javax.swing.SwingUtilities.invokeLater(doRun)
	    work myApplication = new work();
	    myApplication.setLocation(300, 300);
	    myApplication.setSize(200, 250);
	    
	    myApplication.setVisible(true);
	    
	  }
	   
	
}
