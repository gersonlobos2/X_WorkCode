package oop;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

/**
   A component that draws a car shape.
*/
public class HouseBean extends JComponent
{
   /**
      Constructs a default car bean.
   */
   public HouseBean()
   {
      x = 20;
      y = 20;
      width = DEFAULT_HOUSE_WIDTH;
      height = DEFAULT_HOUSE_HEIGHT;  
      
   }
   public void setColot(int _color){
	   color=_color;
   }
   public void setWidth(int _width){
	   width=_width;
	   repaint();
   }
   public void setHeight(int _height){
	   height=_height;
	   repaint();
   }
   public void startPlace(){
	   x=0;
	   y=20;
   }
   public void translate(int _x,int _y){
	   x+=_x;
	   y+=_y;
   }
   public void translateback(int _x,int _y){
	   x-=_x;
	   y-=_y;
   }
   
   public void putX(int _x){
	   x=_x;
   }
   public void putY(int _y){
	   y=_y;
   }
   /**
      Sets the x property.
      @param newValue the new x position
   */
   public void setX(int newValue)
   {
      x = newValue;
      repaint();
   }

   /**
      Gets the x property.
      @return the x position
   */
   
   public int getX()
   {
      return x;
   }

   /**
      Sets the y property.
      @param newValue the new y position
   */
   public void setY(int newValue)
   {
      y = newValue;
      repaint();
   }

   /**
      Gets the y property.
      @return the y position
   */
   public int getY()
   {
      return y;
   }

   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      Rectangle2D.Double base 
      = new Rectangle2D.Double(x, y + width, width, width);

   // The left bottom of the roof
   Point2D.Double r1
      = new Point2D.Double(x, y + width);
   // The top of the roof
   Point2D.Double r2
      = new Point2D.Double(x + width / 2, y);
   // The right bottom of the roof
   Point2D.Double r3
      = new Point2D.Double(x + width, y + width);

   Line2D.Double roofLeft
      = new Line2D.Double(r1, r2);
   Line2D.Double roofRight
      = new Line2D.Double(r2, r3);

   g2.draw(base);
  
   switch (color){
   case 1:
	   g2.setColor(Color.RED);
	   g2.fill(	base);
	   break;
   case 2:
	   g2.setColor(Color.BLUE);
	   g2.fill(	base);
	   break;
   case 3:
	   g2.setColor(Color.GREEN);
	   g2.fill(	base);
	   break;
   }
   
   
   g2.draw(roofLeft);
   g2.draw(roofRight);
   
   }

   public Dimension getPreferredSize() 
   { 
      return new Dimension(DEFAULT_PANEL_WIDTH, 
         DEFAULT_PANEL_HEIGHT);
   }

   private int x;
   private int y;
   private int width;
   private int height;
   int color=1;
   
   private static final int DEFAULT_HOUSE_WIDTH = 100;//60
   private static final int DEFAULT_HOUSE_HEIGHT = 60;//30
   private static final int DEFAULT_PANEL_WIDTH = 160;
   private static final int DEFAULT_PANEL_HEIGHT = 130;
}
