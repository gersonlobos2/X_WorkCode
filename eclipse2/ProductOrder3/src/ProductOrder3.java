import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.*;

import java.io.*;
import javax.imageio.*;

public class ProductOrder3 extends JApplet implements ListSelectionListener{
	JFrame Frame;
	JTabbedPane Tabs;
	JPanel holdAll;
	JPanel ProductInfoPanel;
	JSplitPane splitPane;
	JScrollPane leftSplit;
	JPanel rightSplit;
	//   JLabels
	JLabel itemnumber;
	JLabel manufacturer;
	JLabel price;
	JLabel weight;
	JLabel dimensions;
	
	JButton button;
	JLabel labpic;
	
	//text fields
	 JTextField item;
	 JTextField manu;
	 JTextField pr;
	 JTextField wt;
	 JTextField dim;
	 //list
	 String[] imageNames={"ATV","jetski","mountainbike","powerboat",
				"snowmobile","surfboard","unicycle"};
	 JList list;

	 //***********************************************************
	 //images buttons

	 Image myimage1= getToolkit().createImage("images/ATV.jpeg");
	 Image myimage2= getToolkit().createImage("images/jetski.jpeg");
	 Image myimage3= getToolkit().createImage("images/mountainbike.jpeg");
	 Image myimage4= getToolkit().createImage("images/powerboat.jpeg");
	 Image myimage5= getToolkit().createImage("images/snowmobile.jpeg");
	 Image myimage6= getToolkit().createImage("images/surfboard.jpeg");
	 Image myimage7= getToolkit().createImage("images/unicycle.jpeg");
	
	 ImageIcon myIcon1= new ImageIcon(myimage1);
	 ImageIcon myIcon2= new ImageIcon(myimage2);
	 ImageIcon myIcon3= new ImageIcon(myimage3);
	 ImageIcon myIcon4= new ImageIcon(myimage4);
	 ImageIcon myIcon5= new ImageIcon(myimage5);
	 ImageIcon myIcon6= new ImageIcon(myimage6);
	 ImageIcon myIcon7= new ImageIcon(myimage7);
	 //***********************************************************
	
	 
	 
	 
	ProductOrder3()
	{	
		
		Frame=new JFrame();
		holdAll=new JPanel();
		ProductInfoPanel=new JPanel();
		
		
		
		//************************ setting the stuff in the split pane
		
		list = new JList(imageNames);
		leftSplit = new JScrollPane(list);
		list.addListSelectionListener(this);
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		
		
		//***********************
		
		
		button = new JButton();
	    button.setIcon(myIcon1);
	   
	    button.setPreferredSize(new Dimension(300, 300));
		
		rightSplit = new JPanel();
	   
		
		//rightSplit.setOpaque(false);
		rightSplit.add(button);
		
		//************************************************************************
		//rightSplit.add(labpic);
		
		splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftSplit,rightSplit);
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
	
		
		Tabs =new JTabbedPane();
		//************************
	//  setting the information
		itemnumber=new JLabel("Item Number");
		item=new JTextField();
		manufacturer=new JLabel("Manufacturer");
		manu=new JTextField();
		price=new JLabel("Price");
		pr=new JTextField();
		weight=new JLabel("weight");
		wt=new JTextField();
		dimensions=new JLabel("Dimentions");
		dim=new JTextField();
		
		ProductInfoPanel= new JPanel();
		ProductInfoPanel.setLayout(new GridLayout(5,2));
		ProductInfoPanel.add(itemnumber);
		ProductInfoPanel.add(item);
		ProductInfoPanel.add(manufacturer);
		ProductInfoPanel.add(manu);
		ProductInfoPanel.add(price);
		ProductInfoPanel.add(pr);
		ProductInfoPanel.add(weight);
		ProductInfoPanel.add(wt);
		ProductInfoPanel.add(dimensions);
		ProductInfoPanel.add(dim);
		
		holdAll.setLayout(new BorderLayout());
		holdAll.add(splitPane,BorderLayout.CENTER);
		holdAll.add(ProductInfoPanel,BorderLayout.SOUTH);
		//************************
		
		Tabs.addTab("info", holdAll);
		Frame.getContentPane().add(Tabs);
		Frame.setSize(500, 500);
		Frame.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		ProductOrder3 show=new ProductOrder3();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		//JList temp= (JList)e.getSource();
		 
		 	if(list.getSelectedIndex()==list.getFirstVisibleIndex()){
		 			item.setText("ATV");
		 			manu.setText("yoCompany");
		 			pr.setText("$2300");
		 			wt.setText("200lb");
		 			dim.setText("5x4ft");
		 			  button.setIcon(myIcon1);
		 	//updateLabel(imageNames[list.getSelectedIndex()]);
		 		}
		 	if(list.getSelectedIndex()==1){
		 		item.setText("Jetski");
	 			manu.setText("yoCompany");
	 			pr.setText("$4000");
	 			wt.setText("300lb");
	 			dim.setText("6x4ft");
	 			  button.setIcon(myIcon2);
	    	   }
		 	if(list.getSelectedIndex()==2){
		 		item.setText("MountainBike");
	 			manu.setText("yoCompany1");
	 			pr.setText("$2500");
	 			wt.setText("$150");
	 			dim.setText("jetski");
	 			  button.setIcon(myIcon3);
		    	   }
		 	if(list.getSelectedIndex()==3){
		 		item.setText("powerboat");
	 			manu.setText("yoCompany2");
	 			pr.setText("$25,000");
	 			wt.setText("3ton");
	 			dim.setText("60x10ft");
	 			  button.setIcon(myIcon4);
		    	   }
		 	if(list.getSelectedIndex()==4){
		 		item.setText("snowmobile");
	 			manu.setText("yoCompany3");
	 			pr.setText("$4000");
	 			wt.setText("500lb");
	 			dim.setText("idk");
	 			  button.setIcon(myIcon5);
		    	   }
		 	if(list.getSelectedIndex()==5){
		 		item.setText("surfboard");
	 			manu.setText("yoCompany4");
	 			pr.setText("$4000");
	 			wt.setText("500lb");
	 			dim.setText("idk");
	 			  button.setIcon(myIcon6);
		    	   }
		 	if(list.getSelectedIndex()==6){
		 		item.setText("unicycle");
	 			manu.setText("yoCompany3");
	 			pr.setText("$4000");
	 			wt.setText("500lb");
	 			dim.setText("idk");
	 			  button.setIcon(myIcon7);
		    	   }   
	}

}

