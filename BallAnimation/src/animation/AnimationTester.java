package animation;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.*;



public class AnimationTester
 {
	    private static final int ICON_WIDTH = 800;
	    private static final int ICON_HEIGHT = 800;
	    private static final int CAR_WIDTH = 300;
	    private static Point mousePoint;
	    private static MoveableShape shape2;
	    private static Queue<MoveableShape> ShapeHolder=new LinkedList<MoveableShape>();
	   // private static Queue<Integer> QueueHolderY=new LinkedList<Integer>();
	   // private static Queue<Integer> QueueHolderX2=new LinkedList<Integer>();
	    //private static Queue<Integer> QueueHolderY2=new LinkedList<Integer>();
	   // private static ArrayList<Integer> ArrayListX2 = new ArrayList<Integer>();
	    //private static ArrayList<Integer> ArrayListY2 = new ArrayList<Integer>();

	    
    public static void main(String[] args)
    {
        final JFrame frame = new JFrame();
 
       final MoveableShape shape= new BallShape(0,0,CAR_WIDTH);
       
       ShapeIcon icon = new ShapeIcon(shape,ICON_WIDTH, ICON_HEIGHT);
 
       final JLabel label = new JLabel(icon);
       
       //frame.setLayout(new FlowLayout());
       frame.add(label);
       
       
 
      
 
       label.addMouseListener(new
    	         MouseAdapter()
    	         {
    	            public void mousePressed(MouseEvent event)
    	            {
    	               mousePoint = event.getPoint();
    	               if (!shape.contains(mousePoint))
    	                  mousePoint = null;
    	            }
    	         });

       label.addMouseMotionListener(new
    	         MouseMotionAdapter()
    	         {
    	            public void mouseDragged(MouseEvent event)
    	            {
    	               if (mousePoint == null) return;
    	               Point lastMousePoint = mousePoint;
    	               mousePoint = event.getPoint();

    	               
    	               double dx = mousePoint.getX() - lastMousePoint.getX();
    	               double dy = mousePoint.getY() - lastMousePoint.getY();
    	             
    	               // ShapeIcon icon = new ShapeIcon(shape,ICON_WIDTH+10, ICON_HEIGHT+20);
    	               // final JLabel label = new JLabel(icon);
    	               // final MoveableShape shape= new BallShape(0,0,CAR_WIDTH);
    	                //frame.setLayout(new FlowLayout());
    	              //  frame.add(new JLabel(new ShapeIcon(shape,ICON_WIDTH, ICON_HEIGHT)));
    	            	   shape.translate((int)dx, (int)dy);
    	            	  
        	               label.repaint();
        	              
    	               
    	               //shape.translate((int) dx, (int) dy);
    	               //label.repaint();
    	            }
    	         });
       
       
       
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
       /*
       final int DELAY = 100;
       // Milliseconds between timer ticks
       
       
       Timer t = new Timer(DELAY, new
          ActionListener()
          {
             public void actionPerformed(ActionEvent event)
             {
                shape.translate(1, 0);
                label.repaint();
             }
          });
       t.start();
       */
    }
    
    
 
   
 }