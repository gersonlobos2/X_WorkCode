package animation;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class DragBall extends JFrame {

	/**
	 * @param args
	 */
	
	public DragBall(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//creating an object of 
		DragBallPanel p = new DragBallPanel();
		p.setBackground(Color.white);
		
		JFrame db= new JFrame("Drag Ball");
		db.setSize(400,200);
		db.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		db.add(p);
		
		db.setVisible(true);

	}//end main

}//end class
