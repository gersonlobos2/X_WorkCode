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

public class ProductOrder2 implements ListSelectionListener {
	//labels
	JLabel itemnumber;
	JLabel manufacturer;
	JLabel price;
	JLabel weight;
	JLabel dimensions;
	
	//text fields
	 JTextField item;
	 JTextField manu;
	 JTextField pr;
	 JTextField wt;
	 JTextField dim;
	 
	 
	// Frames
	 JFrame frame;
	
	//Taps
	 JTabbedPane Tabs;
	//Panels
	 JPanel composite;  //holds all
	 
	 JSplitPane splitPane; //holds list and pictures
	 JPanel ProductInfoPanel;
	
	
	//this is what goes in the split panel
	 JLabel picture;
	 JList list;
	
	JScrollPane pictureScrollPane;
	JScrollPane listScrollPane;
	
	
	 String[] imageNames={"ATV","jetski","mountainbike","powerboat",
		"snowmobile","surfboard","unicycle"};
	
	
	public ProductOrder2()
	{
		frame=new JFrame("Too cool for school Product Catalog");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Tabs=new JTabbedPane();
		
		composite.setLayout(new BorderLayout());
		
		//split pane part
		//create the list of images and put them in a scroll pane
		
		list = new JList(imageNames);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);  //add listener
		
		listScrollPane= new JScrollPane(list);
		
		picture =new JLabel();
		picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
		picture.setHorizontalAlignment(JLabel.CENTER);
		
		pictureScrollPane = new  JScrollPane(picture);
		
		splitPane= new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,listScrollPane,pictureScrollPane);
		
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		
		Dimension minimunSize= new Dimension(100,50);
		listScrollPane.setPreferredSize(minimunSize);
		pictureScrollPane.setPreferredSize(minimunSize);
		
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
		//   setting the composite layout
		splitPane.setPreferredSize(new Dimension(400,200));
		
		composite.setLayout(new BorderLayout());
		composite.add(splitPane, BorderLayout.CENTER);
		composite.add(ProductInfoPanel,BorderLayout.SOUTH);
		
		Tabs.addTab("Information", composite);
		
		//frame.getContentPane().add(Tabs);
		//frame.pack();
		frame.add(ProductInfoPanel);
		frame.setVisible(true);
		
		
	}
	public static void main(String[] args)
	{
		ProductOrder2 show = new ProductOrder2();
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		list=(JList)e.getSource();
		
		updateLabel(imageNames[list.getSelectedIndex()]);
	}
	private void updateLabel(String name) {
		// TODO Auto-generated method stub
		ImageIcon icon=createImageIcon("images/"+name+".jpeg");
		picture.setIcon(icon);
		if(icon==null){
			picture.setText(null);}
		else{
			picture.setText("image not found");
		}
		
		
	}
	private ImageIcon createImageIcon(String path) {
		// TODO Auto-generated method stub
		 try {
	           img = ImageIO.read(new File(path));
	       } catch (IOException e) {
	       }
		return null;
	}


}
