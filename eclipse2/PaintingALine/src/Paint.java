import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;

public class Paint extends JPanel implements Runnable //, MouseListener
{
	int X1,Y1,X2,Y2;
	Graphics drawline; 
	Line2D line;
	
	public Paint()
	{
		setBackground(Color.white);
		
		
		

	}
	public void run()
	{
		repaint();
	}
	public void paint(Graphics g)
	{
		super.paintComponent(g);
		g.drawLine(X1, Y1, X2, Y2);
		g.setColor(Color.white);
	}

	public static void main(String[] args)
	{
	JFrame f= new JFrame();
	f.setSize(800,800);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.add(BorderLayout.CENTER,new Paint());
	f.setVisible(true);
	}
	

}
