package oop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class main {

	  static JSlider width = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);
	  
	  //static JSlider height = new JSlider(JSlider.VERTICAL, 1, 150, 75);
	   static CarBean carro=new CarBean();
	    static  JPanel panel = new JPanel();
	    static JLabel dynamicLabel = new JLabel();
	    //static JButton boton=new JButton("Stop");
	    static Timer t     = null;
	    static int totaltime;
	    static boolean front,down,back,up;
	    static int temp;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		width.setPaintLabels(true);
		width.setPaintTicks(true);
		width.setMajorTickSpacing(2);
		width.setMinorTickSpacing(1);
		
		// TODO Auto-generated method stub
		int x,y;
		x=width.getValue();
		
		carro.putX(x);
		
	      dynamicLabel.add(carro);
	      
	    width.addChangeListener(new ChangeListener(){
	    	public void stateChanged(ChangeEvent ev) {
			      
	    		int DELAY = 0;
	    		
	    		  temp= width.getValue();
	    		carro.startPlace();
	    		
	    		
	    	switch (temp){
	    	case 0:
	    		DELAY=0000;
	    		 TimerDelay(DELAY);
	    		 t.stop();
	    		break;
	    	case 1:
	    		DELAY=1000;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 2:
	    		DELAY=900;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 3:
	    		DELAY=800;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 4:
	    		DELAY=700;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 5:
	    		DELAY=600;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 6:
	    		DELAY=500;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 7:
	    		DELAY=400;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 8:
	    		DELAY=300;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 9:
	    		DELAY=200;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	case 10:
	    		DELAY=100;
	    		 TimerDelay( DELAY);
	    		 t.start();
	    		break;
	    	}		
	    	//System.out.println("Value from slider: "+temp);
    		//System.out.println("DELAY: "+DELAY);
    
		    }
	    });
	    
		JFrame frame = new JFrame();
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	      
	      panel.add(width);
	      frame.add(panel, BorderLayout.SOUTH);
	      frame.add(carro, BorderLayout.CENTER);
	      frame.setSize(360, 360);
	      frame.setVisible(true);   
	}

	
	public static void TimerDelay(int DELAY){
			
		front=true;
		down=back=up=false;
		 t = new Timer(DELAY, 
  				 new ActionListener(){
  			public void actionPerformed(ActionEvent e) {
  				if(temp==0){
  					((Timer)e.getSource()).stop();
  				}
  				else{
  					if( front==true && temp!=0){
  	  					if(carro.getX() <=100){
  		   					carro.translate(1,0);
  			   				carro.repaint();
  			   				
  			   				if(carro.getX() ==100){front=false; down=true;}
  	  					}
  	  				}
  	  				else if(down==true ) {
  	  					if(carro.getY()<=100){
  		   					carro.translate(0,1);
  			   				carro.repaint();
  			   				

  			   				if(carro.getY()==100){down=false; back=true;}
  		   				}
  	  				}
  	  				else if(back==true ){
  	  					if(carro.getX()>=0){
  	  						carro.translateback(1, 0);
  	  						carro.repaint();
  			   				totaltime--;

  	  						if(carro.getX()==0){back=false; up=true;}
  	  					}
  	  				}
  	  				else if(up==true ){
  	  					if(carro.getY()>=20){
  	  						carro.translateback(0, 1);
  	  						carro.repaint();
  			   				

  	  						if(carro.getY()==20){up=false; front=true;}
  	  					}
  	  				}
	
  				}//end else
  			
  			
  			
  			}//end method cation performed

  		 });//end action listener
   		
  		
	}//end class
}//end class

