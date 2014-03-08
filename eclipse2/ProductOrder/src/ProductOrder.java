import javax.swing.*;
import javax.swing.event.*; 
import java.awt.*;
import java.util.*;
import java.lang.*;
import java.lang.reflect.Method;





public class ProductOrder
{
   static //-----------------------------------------------------------------
   //  Sets up a frame containing a tabbed pane. The panel on each
   //  tab demonstrates a different layout manager.
   //-----------------------------------------------------------------
	
   public void main(String[] args)
   {	
      //Catalog page
      JFrame frame = new JFrame ("Too Cool For School Product Catalog");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      JTabbedPane tp = new JTabbedPane();
      ProductInfoPanel panel = new ProductInfoPanel();
      JPanel composite = new JPanel();
      composite.setLayout(new BorderLayout());
      composite.add(new SplitPanel(panel).getSplitPane(), BorderLayout.CENTER);
      composite.add(panel, BorderLayout.SOUTH);
      tp.addTab ("Catalog", composite);

      //OrderForm Page
      JPanel composite2 = new JPanel(new BorderLayout());
      JPanel orderForm = new JPanel(new BorderLayout());
      JPanel customerForm = new JPanel(new BorderLayout());

      tp.addTab ("Order", composite2);
      orderForm.add(new OrderInfoPanel(), BorderLayout.NORTH);
      customerForm.add(new CustomerInfoPanel(), BorderLayout.SOUTH);
      composite2.add(customerForm, BorderLayout.NORTH);
      composite2.add(orderForm, BorderLayout.SOUTH);
      
      //SalesForm Page
      JPanel salesOrder = new JPanel();

      tp.addTab ("SalesOrder", salesOrder);
      salesOrder.add(new SalesInfoPanel());

      frame.getContentPane().add(tp);
      frame.pack();
      frame.setVisible(true);
   }
}


//SplitPaneDemo itself is not a visible component.
class SplitPanel extends JPanel
                          implements ListSelectionListener {
    private JLabel picture;
    private JList list;
    private JSplitPane splitPane;
    private String[] imageNames = { "ATV", "jetski", "mountainbike", "powerboat", "snowmobile",
	  "surfboard", "unicycle"};
	 private int itemNum = 0;
	 public ProductInfoPanel panel;
	 
    public SplitPanel(ProductInfoPanel input)
	 {
        //Create the list of images and put it in a scroll pane.
        list = new JList(imageNames);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
       
        JScrollPane listScrollPane = new JScrollPane(list);
        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        
        JScrollPane pictureScrollPane = new JScrollPane(picture);

        //Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                                   listScrollPane, pictureScrollPane);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

        //Provide minimum sizes for the two components in the split pane.
        Dimension minimumSize = new Dimension(100, 50);
        listScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);

        //Provide a preferred size for the split pane.
        splitPane.setPreferredSize(new Dimension(400, 200));
        updateLabel(imageNames[list.getSelectedIndex()]);
    }
    
    //Listens to the list
    public void valueChanged(ListSelectionEvent e) {
        list = (JList)e.getSource();
		  if(list.getLeadSelectionIndex() == 0)
		  {
		 // setInfoPanel();
		  }
		  if(list.getLeadSelectionIndex() == 1)
		  {
		 // setInfoPanel();
		  }
        updateLabel(imageNames[list.getSelectedIndex()]);
        
        // i gonna work here****************************************************
       switch(list.getSelectedIndex()){
       case 0:{
    	  panel.setItemName("ATV");
    	  break;
       }
       case 1:{
    	   panel.setItemName("Jetski");
    	   break;
    	   }
       default: break;
       }
       }
    
    //Renders the selected image
    protected void updateLabel (String name) {
        ImageIcon icon = createImageIcon("images/" + name + ".jpeg");
        picture.setIcon(icon);
        if  (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
    }

    //Used by SplitPaneDemo2
    public JList getImageList() {
        return list;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }

   
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
       java.net.URL imgURL = SplitPanel.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
class ProductInfoPanel extends JPanel
{
 	  JTextField  item;
	  JTextField manu;
	  JTextField pr;
	  JTextField wt;
	  JTextField dim;
	
	//constructor for inner class
	public ProductInfoPanel()
	{
		JLabel itemnumber = new JLabel("item number");
		item      = new JTextField();
		JLabel manufacturer = new JLabel("manufacturer");
		manu       = new JTextField();
		JLabel price  = new JLabel("price");
		pr       = new JTextField();
		JLabel weight = new JLabel("weight");
		wt       = new JTextField();
		JLabel dimensions = new JLabel("dimensions");
		dim       = new JTextField();
	
		setLayout(new GridLayout(5,2));
		add(itemnumber);
		add(item);
		add(manufacturer);
		add(manu);
		add(price);
		add(pr);
		add(weight);
		add(wt);
		add(dimensions);
		add(dim);
	}
	//***********************************************************
	public  void setItemName(String name)
	{
	// im working here on this function to return a JTextField****************
		item.setText(name);
	}
	public void setManu(String name)
	{
		manu.setText(name);
	}
	public void setPr(int price)
	{
		//String num = "$"+price;
		String num=Integer.toString(price);
     pr.setText(num);
	}
	public void setwt(int W)
	{
		String num=Integer.toString(W);
	     pr.setText(num);
	}
	
	//********************************************
	
	//sets the fields in the InfoPanel to currently selected item.
	public void setInfoPanel()
	{
		item.setText("5");
	}
}     
 
 class CustomerInfoPanel extends JPanel
{        
        //constructor for Customer page
        public CustomerInfoPanel()
        {
            	String myStates[ ] = {"AL", "AK","AZ","AR","CA","CO","CT","DE","FL","GA","GU",
                "HI","ID","IL","IN","IA","KS","KY","LA","MA","MD","MS","MI","MN","MI","MO",
                "MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","RI",
                "SC","SD","TN","TX","UT","VT","VI","VA","WA","WV","WI","WY"};
                
                JLabel firstName = new JLabel("First Name: ");
                JTextField fName = new JTextField(20);
                JLabel lastName = new JLabel("Last Name: ");
		JTextField lName = new JTextField(20);
		JLabel addressUno = new JLabel("Address 1: ");
                JTextField address1 = new JTextField(20);
                JLabel addressDos = new JLabel("Address 2: ");
		JTextField address2 = new JTextField(20);
                JLabel usStates = new JLabel("State");
		JComboBox states = new JComboBox(myStates);
                JLabel phoneNum = new JLabel("Phone: ");
		JTextField phone1 = new JTextField(12);
                JLabel spam = new JLabel("email address: ");
		JTextField email = new JTextField(20);
               
		
                setLayout(new GridLayout(7,3));
                add(firstName);
                add(fName);
               
                add(lastName);
		add(lName);
             
                add(addressUno);
		add(address1);
                
                add(addressDos);
		add(address2);
               
                add(usStates);
		add(states);
              
                add(phoneNum);
		add(phone1);
              
                add(spam);
		add(email);            
        }
}      
class OrderInfoPanel extends JPanel
{
     //constructor for OrderInfo
     OrderInfoPanel()
     {
        String[] productNames = { "ATV", "jetski", "mountainbike",
                                      "powerboat", "snowmobile",
                                      "surfboard", "unicycle"};    		
    
        Integer [ ]nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
            
                
        JButton deleteButt = new JButton("Delete This Item");

        JButton addButt = new JButton("Add Item");
        JLabel pNames = new JLabel("Products");
        JComboBox products = new JComboBox(productNames);
        JLabel quant = new JLabel("Qty");
        JLabel rmks = new JLabel("Remarks");
        JComboBox qty = new JComboBox(nums);
        JTextArea remarks = new JTextArea(3,20);
        JScrollPane spRemarks = new JScrollPane(remarks);
        
        setLayout(new GridLayout(4,2));     
        add(deleteButt);
       add(addButt);
        add(pNames);
        add(products);
        add(quant);
        add(qty);
       // setLayout(new FlowLayout());
        add(rmks);
        add(spRemarks);
     }
}

class SalesInfoPanel extends JPanel
{
   SalesInfoPanel()
   {
      JLabel sales = new JLabel("Sales Results");
      JTextArea salesTA = new JTextArea(20,30);
      setLayout(new GridLayout(1,2));
      add(sales);
      add(salesTA);
   }
}
