import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*; //for actionlistener, changelistener and keylistener
//import java.util.*;
//import java.lang.reflect.Array; //for getting array length
import java.awt.Font;		//For system fonts


public class SliderDemo extends JFrame implements ActionListener,ChangeListener,KeyListener
{
	
	
	 static final int FONT_MIN = 0;
	 static final int FONT_MAX = 30;
	 static final int FONT_INIT = 15;
	  JTextArea TArea = new JTextArea(15,15);
	JTextField TField = new JTextField(5);
	 JSlider slider=new JSlider(JSlider.HORIZONTAL,FONT_MIN,FONT_MAX,FONT_INIT);
	 int currentFontSizeAndSliderValue;
	public SliderDemo()
	{
	JFrame window = new JFrame("Slider");
	
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	
	
	
	GraphicsEnvironment ge= GraphicsEnvironment.getLocalGraphicsEnvironment();
	
	Font[] fonts= ge.getAllFonts();
	JComboBox drop = new JComboBox(fonts);
	
	

	 
	TArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
	
	slider.setMajorTickSpacing(10);
	slider.setMinorTickSpacing(1);
	slider.setPaintTicks(true);
	slider.setPaintLabels(true);
	
	
	//listeners
	drop.addActionListener(this);
	slider.addChangeListener( this);
	TField.addKeyListener(this);
	
	
	TField.setText(Integer.toString(FONT_INIT));
	
	setText();
	TArea.setSize(100, 100);
	panel1.add(drop);
	panel1.add(TField);
	panel2.add(TArea);
	panel3.add(slider);
	
	window.setLayout(new BorderLayout());
	
	window.add(panel1,BorderLayout.NORTH);
	window.add(panel2,BorderLayout.CENTER);
	window.add(panel3,BorderLayout.SOUTH);
	
	window.setVisible(true);
	window.setSize(850, 500);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JComboBox CB = (JComboBox)e.getSource();
		Font font = (Font)CB.getSelectedItem();
		TArea.setFont(new Font(font.getFontName(),font.getStyle(),24));
		
	}
	 public void setText() {
			TArea.setText("Gerson Lobos \n Java \n Prof. Ramos");
			
			}
	
	public static void main(String[] args) {
		
	SliderDemo window=new SliderDemo();
		
		

	}


	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider source=(JSlider)e.getSource();
		 if (!source.getValueIsAdjusting()) {

		int Textsize=(int)source.getValue();
		String tsize;
	   tsize=Integer.toString(Textsize);
	   TField.setText(tsize);
		//TArea.setFont(new Font(font.getFontName(),font.getStyle(),24));
		//String text= TArea.getText();
	   Font oldFont = TArea.getFont(); //Get the font currently set to text area.
		float newFsize = (float)Textsize;	//new font re-size must be a float type.
		Font newFont = oldFont.deriveFont(newFsize); //deriveFont scales font size(SEE API). Uses a float argument.
		TArea.setFont(newFont);		//set the new Font to the text area.
		 }
	}


	@Override
	public void keyPressed(KeyEvent e) {
		displayInfo(e, "KEY TYPED: ");
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		displayInfo(e, "KEY PRESSED: ");
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		displayInfo(e, "KEY RELEASED: ");
		
	}
	  private void displayInfo(KeyEvent e, String keyStatus){
	        
	        //You should only rely on the key char if the event
	        //is a key typed event.
	        int id = e.getID();
	        String keyString;
	        if (id == KeyEvent.KEY_TYPED) {
	            char c = e.getKeyChar();
	            keyString = "key character = '" + c + "'";
	        } else {
	            int keyCode = e.getKeyCode();
	            keyString = "key code = " + keyCode
	                    + " ("
	                    + KeyEvent.getKeyText(keyCode)
	                    + ")";
	        }
	        
	        int modifiersEx = e.getModifiersEx();
	        String modString = "extended modifiers = " + modifiersEx;
	        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
	        if (tmpString.length() > 0) {
	            modString += " (" + tmpString + ")";
	        } else {
	            modString += " (no extended modifiers)";
	        }
	        
	        String actionString = "action key? ";
	        if (e.isActionKey()) {
	            actionString += "YES";
	        } else {
	            actionString += "NO";
	        }
	        
	        String locationString = "key location: ";
	        int location = e.getKeyLocation();
	        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
	            locationString += "standard";
	        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
	            locationString += "left";
	        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
	            locationString += "right";
	        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
	            locationString += "numpad";
	        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
	            locationString += "unknown";
	        }
	           
		
		String typed = TField.getText();
		slider.setValue(currentFontSizeAndSliderValue);
	                if(!typed.matches("\\d+") || typed.length() > 3) {//sets limit on number of keys typed.
	                   return;
	                }
	                int value = Integer.parseInt(typed);//get the number typed in the textSize field(parse the string).
	     					if(value < FONT_MIN)	{	//limits min input to specified FONT_MIN size.
	     						slider.setValue(FONT_MIN);
							}
							else if(value > FONT_MAX)	{//limits min input to specified FONT_MAX size.
								slider.setValue(FONT_MAX);
							}        
						  else
							  slider.setValue(value);	//assign the int value
		}

}
