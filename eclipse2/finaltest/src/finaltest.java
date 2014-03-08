import javax.swing.*; //for the gui
						//if i want a change listener i need swing.event.*
import java.awt.BorderLayout;
import java.awt.event.*; //action listener

public class finaltest implements ActionListener
{
	JButton Button1;
	JButton Button2;
	JButton Button3;
	JButton Button4;
	JButton Button5;
	JButton Button6;
	JButton Button7;
	JButton Button8;
	JButton Button9;
	JButton ButtonEquals;
	JButton ButtonMinus;
	JButton ButtonPlus;
	JButton ButtonDivision;
	JButton ButtonMultiplication;
	JButton ButtonClear;
	
	JTextField TArea;
	//JTextArea TArea;
	
	JPanel pane1;
	JPanel pane2;
	
	JFrame HoldAll;

	public finaltest()
	{
		Button1 = new JButton("1");
		Button2 = new JButton("2");
		Button3 = new JButton("3");
		Button4 = new JButton("4");
		Button5 = new JButton("5");
		Button6 = new JButton("6");
		Button7 = new JButton("7");
		Button8 = new JButton("8");
		Button9 = new JButton("9");
		ButtonEquals = new JButton("=");
		ButtonMinus = new JButton("-");
		ButtonPlus = new JButton("+");
		ButtonMultiplication = new JButton("*");
		ButtonDivision = new JButton("/");
		ButtonClear = new JButton("C");
		
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		 Button4.addActionListener(this);
		 Button5.addActionListener(this);
		 Button6.addActionListener(this);
		 Button7.addActionListener(this);
		 Button8.addActionListener(this);
		 Button9.addActionListener(this);
		 ButtonEquals.addActionListener(this);
		 ButtonMinus.addActionListener(this);
		 ButtonPlus.addActionListener(this);
		 ButtonDivision.addActionListener(this);
		 ButtonMultiplication.addActionListener(this);
		 ButtonClear.addActionListener(this);
		
		TArea = new JTextField();
		
		pane1 = new JPanel();
		pane2 = new JPanel();
		
		pane1.add(TArea,BorderLayout.NORTH);
		pane1.add(Button1);
		pane1.add(Button2);
		pane1.add(Button3);
		pane1.add(Button4);
		pane1.add(Button5);
		pane1.add(Button6);
		pane1.add(Button7);
		pane1.add(Button8);
		pane1.add(Button9);
		pane1.add(ButtonEquals);
		pane1.add(ButtonMinus);
		pane1.add(ButtonPlus);
		pane1.add(ButtonDivision);
		pane1.add(ButtonMultiplication);
		pane1.add(ButtonClear);
		pane1.add(TArea);
		
		//pane2.add(TArea,BorderLayout.SOUTH);
		
		HoldAll = new JFrame();
		
		HoldAll.add(pane1);
		//HoldAll.add(pane2,BorderLayout.NORTH);
		
		HoldAll.setSize(500, 500);
		HoldAll.setVisible(true);
		
		
	}
	public static void main(String[] args)
	{
		
		finaltest passed = new finaltest();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		JButton source =  (JButton)e.getSource();
		
		if(source==Button1)
		{
			TArea.setText("you pressed button #1");
		}
		if(source==Button2)
		{
			TArea.setText("you pressed button #2");
		}
		if(source==Button3)
		{
			TArea.setText("you pressed button #3");
		}
		
		
	}
	
}
