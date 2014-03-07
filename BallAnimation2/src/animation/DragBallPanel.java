package animation;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class DragBallPanel extends JPanel implements MouseListener, MouseMotionListener{

	private int ballsize = 40;
	//ball cordinates
	private int ballX = 50;
	private int ballY = 50;
	//position of the mouse to drag the mouse
	private int dragFromX =0;
	private int dragFromY =0;
	
	//if it is true it means we can drag the ball when we press
	private boolean candrag = false;
	
	/**
	 * @param args
	 */
	public DragBallPanel(){
		setForeground(Color.red);//the color of the ball
		//adding mouse listener 
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	 }//end DragballPanel constructor
	//making paint componenet
	
	public void paintComponenet(Graphics g){
		super.paintComponent(g);
		//draw the ball
		g.fillOval(ballX,ballY,ballsize,ballsize);
	}//end paintComponenet

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(candrag){
			//change ball position
			ballX= e.getX() - dragFromX;
			ballY= e.getY() - dragFromY;
			
			//dont move ball of the screen
			ballX = Math.max(ballX, 0);
			ballX = Math.min(ballX, getWidth()-ballsize);
			
			ballY = Math.max(ballY, 0);
			ballY = Math.min(ballY, getHeight()-ballsize);
			this.repaint();
		}
	}//end mouse drag

	
	//stop draging if mouse exits panel
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		candrag = false;
	}//end mouseExited

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		if(x >= ballX && x <= (ballX + ballsize) && y >= ballY && y <= (ballY+ballsize)){
			candrag = true;
			dragFromX = x - ballX;
			dragFromY = y - ballY;
		}else{
			candrag=false;
		}
		
	}//end mousePressed

	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	
	
	
	
	
	
	

}
