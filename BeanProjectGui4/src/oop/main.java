package oop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class main {

	/**
	 * @param args
	 */
	static JSlider ReSize = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
	   //static JSlider height = new JSlider(JSlider.VERTICAL, 1, 100, 50);
	
	static JButton boton1 = new JButton("RED");
	static JButton boton2 = new JButton("BLUE");
	static JButton boton3 = new JButton("Green");
	static JPanel panel= new JPanel();
	
	
	static HouseBean casa;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		casa= new HouseBean();
		ReSize.setPaintLabels(true);
		ReSize.setPaintTicks(true);
		ReSize.setMajorTickSpacing(10);
		ReSize.setMinorTickSpacing(5);
		
		
		boton1.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
		            JButton button = (JButton) e.getSource();
		            
		            casa.setColot(1);
		            casa.repaint();
		            
		        }
		}
				
				);
		boton2.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
		            JButton button = (JButton) e.getSource();
		            
		            casa.setColot(2);
		            casa.repaint();
		            
		        }
		}
				
				);
		boton3.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
		            JButton button = (JButton) e.getSource();
		            
		            casa.setColot(3);
		            casa.repaint();
		            
		        }
		}
				
				);
		ReSize.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent ev) {
			      int xaxis =ReSize.getValue();
			      //casa.setX(xaxis);
			      casa.setWidth(xaxis);
		    }
	    });
	    /*
	    height.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent ev) {
			      int yaxis =height.getValue();
			      //casa.setY(yaxis);
			      casa.setHeight(yaxis);
		    }
	    });
	    */
	    
		JFrame frame = new JFrame();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      panel.add(boton1);
	      panel.add(boton2);
	      panel.add(boton3);
	      frame.add(ReSize, BorderLayout.SOUTH);
	      frame.add(panel, BorderLayout.NORTH);
	      
	      //frame.add(height, BorderLayout.EAST);
	      frame.add(casa, BorderLayout.CENTER);
	      frame.setSize(310, 310);
	      frame.setVisible(true);

	}

}
