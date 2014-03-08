import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
public class TestEditor {
	JFrame Frame;
	//Panels
	JPanel holdAll;
	JPanel panelButtons;
	 // JPanel panelText;
	JPanel panelBar;
	JScrollPane panelText;
	//buttons
	JButton Button_New;
	JButton Button_Open;
	JButton Button_Save;
	JButton Button_SaveAs;
	
	
	//text Area
	JTextArea TextArea;
	
	JProgressBar Bar;
	Border raisedBorder = BorderFactory.createRaisedBevelBorder();

	TestEditor()
	{
		Frame = new JFrame();
		
		//setting panels
		holdAll = new JPanel();
		panelButtons = new JPanel();
		// panelText = new JScrollPane();
		panelBar= new JPanel();
		
		//seting buttons
		Button_New = new JButton("  New  ");
		Button_Open= new JButton(" Open  ");
		Button_Save= new JButton(" Save  ");
		Button_SaveAs=new JButton("SaveAs");
		
		//sting the borders
		Button_New.setBorder(raisedBorder);
		Button_Open.setBorder(raisedBorder);
		Button_Save.setBorder(raisedBorder);
		Button_SaveAs.setBorder(raisedBorder);
		
		//adding buttons to panelButtons
		panelButtons.setBorder(raisedBorder);
		panelButtons.add(Button_New);
		panelButtons.add(Button_Open);
		panelButtons.add(Button_Save);
		panelButtons.add(Button_SaveAs);
		
		//adding the text to panelText
		TextArea = new JTextArea("This is a test", 50, 80);
		
		TextArea.setBorder(raisedBorder);
		
		panelText = new JScrollPane(TextArea);
		panelText.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelText.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelText.setBorder(raisedBorder);
	
		//adding the jBar to textBar
		Bar = new JProgressBar();
		
		
		Bar.setBorder(raisedBorder);
		
		panelBar.add(Bar);
		panelBar.setBorder(raisedBorder);
		
		holdAll.setLayout(new BorderLayout());
		holdAll.add(panelButtons,BorderLayout.NORTH);
		holdAll.add(panelText,BorderLayout.CENTER);
		holdAll.add(panelBar,BorderLayout.SOUTH);
		
		
		//holdAll.setLayout(new BoxLayout(holdAll, 20));
		
		Frame.add(holdAll);
		
		
		Frame.setSize(500, 500);
		
		Frame.setVisible(true);
		
	}
	public static void main(String[] args)
	{
		TestEditor show = new TestEditor();
		
	}
}
