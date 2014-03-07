package oop;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class main {

	  static JSlider width = new JSlider(JSlider.HORIZONTAL, 1, 150, 75);
	   static JSlider height = new JSlider(JSlider.VERTICAL, 1, 150, 75);
	   static CarBean carro=new CarBean();
	   // static  JPanel panel = new JPanel();
	    static JLabel dynamicLabel = new JLabel();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y;
		x=width.getValue();
		y=height.getValue();
		
		carro.putX(x);
		carro.putY(y);
		
	      dynamicLabel.add(carro);
	      //panel.add(carro);
		
	    width.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent ev) {
			      int xaxis =width.getValue();
			      carro.setX(xaxis);
		    }
	    });
	    
	    height.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent ev) {
			      int yaxis =height.getValue();
			      carro.setY(yaxis);
		    }
	    });
		

		JFrame frame = new JFrame();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	     
	      
	      
	      
	      frame.add(width, BorderLayout.SOUTH);
	      frame.add(height, BorderLayout.EAST);
	      frame.add(carro, BorderLayout.CENTER);
	      frame.setSize(310, 310);
	      frame.setVisible(true);
	      
	      
	      
	      //frame.add(panel, BorderLayout.NORTH);
	      //frame.setSize(300, 300);
	     // frame.setVisible(true);
	}

	
	
}//end class
