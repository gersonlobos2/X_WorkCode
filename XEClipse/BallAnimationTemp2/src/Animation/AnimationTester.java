package Animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 

public class AnimationTester
 {
	private static final int ICON_WIDTH = 800;
	   private static final int ICON_HEIGHT = 800;
	   private static final int BALL_WIDTH = 50;
	   
    public static void main(String[] args)
    {
       JFrame frame = new JFrame();
       final QueueCordenadas bag = new QueueCordenadas();
       final MoveableShape shape = new BallShape(200, 200, BALL_WIDTH, bag);
       	
       ShapeIcon icon = new ShapeIcon(shape,ICON_WIDTH, ICON_HEIGHT);
 
       final JLabel label = new JLabel(icon);
       frame.setLayout(new FlowLayout());
       frame.add(label);
 
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
      
       label.addMouseMotionListener(new MouseMotionListener(){
    	   public void mouseDragged(MouseEvent e){
    		   bag.add(e.getX(), e.getY());//going to the queue of cordinadas.
    		   shape.moveShape(e.getX(), e.getY());
    		   label.repaint();
    	   }
    	   public void mouseMoved(MouseEvent e){}//do noting when mouse moved
       });//end listener
    }//end of main  
}//end class animation tester