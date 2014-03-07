package OOP;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 A class that implements an Observer object that displays a barchart view of
 a data model.
*/
public class BarGraph extends JFrame implements ChangeListener
{
	 private ArrayList<Double> a;
	 private final Data dataModel;
	 private static final int ICON_WIDTH = 200;
	 private static final int ICON_HEIGHT = 200;
	 public boolean changeColor=true;
 /**
 Constructs a BarFrame object
 @param dataModel the data that is displayed in the barchart
 */
	 public BarGraph(Data dataModel)
	 {
		 this.dataModel = dataModel;
		 a = dataModel.getData();
		 setLocation(0,200);
		 setLayout(new BorderLayout());
		 final Icon barIcon = new Icon()
		 {
			 public int getIconWidth() { return ICON_WIDTH; }
			 public int getIconHeight() { return ICON_HEIGHT; }
			 public void paintIcon(Component c, Graphics g, int x, int y)
			 {
				 Graphics2D g2 = (Graphics2D) g;
				 //changing color depending if true or falce. 
				 //if button pressed or not
			     g.setColor(changeColor? Color.GREEN:Color.RED); 
				 
				 double max = (a.get(0)).doubleValue();
				 for (Double v : a)
				 {
					 double val = v.doubleValue();
					 if (val > max)
						 max = val;
				 }
				 double barHeight = getIconHeight() / a.size();
				 int i = 0;
				 for (Double v : a)
				 {
					 double value = v.doubleValue();
					 double barLength = getIconWidth() * value / max;
					 Rectangle2D.Double rectangle = new Rectangle2D.Double(0, barHeight * i, barLength, barHeight);
					 i++;
					 g2.fill(rectangle);
				 }
			 }
		 };
		 add(new JLabel(barIcon));
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 pack();
		 this.addMouseListener(new MouseAdapter()
		 {
			 public void mousePressed(MouseEvent e)
			 {
				 double barHeight = barIcon.getIconHeight() / a.size();
				 int i = (int) ((e.getY() - barHeight / 2) / barHeight);
				 double max = (a.get(0)).doubleValue();
				 for (Double v : a)
				 {
					 double val = v.doubleValue();
					 if (val > max)
						 max = val;
				 }
				 double value = e.getX() * max / barIcon.getIconWidth();
				 BarGraph.this.dataModel.update(i, value);
			 }
		 });
		 setVisible(true);
	 }
 /**
 Called when the data in the model is changed.
 @param e the event representing the change
 */
	 public void stateChanged(ChangeEvent e)
 		{
 			a = dataModel.getData();
 			repaint();
 		}
	 
	 public void setButton(boolean change){
		 changeColor = change;
		 }  
	 
	 public boolean GetChangeButtonn(){
		 return changeColor;
}
 
}