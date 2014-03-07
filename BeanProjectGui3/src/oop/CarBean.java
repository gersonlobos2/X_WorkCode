package oop;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   A component that draws a car shape.
*/
public class CarBean extends JComponent
{
   /**
      Constructs a default car bean.
   */
   public CarBean()
   {
      x = 0;
      y = 20;
      width = DEFAULT_CAR_WIDTH;
      height = DEFAULT_CAR_HEIGHT;      
   }
   
   public void setWidth(int _width){
	   width=_width;
   }
   public void setHeight(int _height){
	   height=_height;
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
      Rectangle2D.Double body= new Rectangle2D.Double(x, y + height / 3, width - 1, height / 3);
      
      Ellipse2D.Double frontTire= new Ellipse2D.Double(x + width / 6, y + height * 2 / 3, height / 2, height / 2);
     // Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3,  y + height * 2 / 3, height / 3, height / 3);
      Ellipse2D.Double rearTire = new Ellipse2D.Double(x + width * 2 / 3,  y + height * 2 / 3, height / 2, height / 2);

      // The bottom of the front windshield
      Point2D.Double r1= new Point2D.Double(x + width / 3, y + height / 3);
      // The front of the roof
      Point2D.Double r2= new Point2D.Double(x + width / 3, y);
      // The rear of the roof
      Point2D.Double r3= new Point2D.Double(x + width * 2 / 3, y);
      // The bottom of the rear windshield
      Point2D.Double r4= new Point2D.Double(x + width * 5 / 6, y + height / 3);

      Line2D.Double frontWindshield
         = new Line2D.Double(r1, r2);
      Line2D.Double roofTop
         = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield
         = new Line2D.Double(r3, r4);

      g2.draw(body);
      
      
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);
      g2.draw(roofTop);
      g2.draw(rearWindshield);
     
      g2.setColor(Color.GREEN);
      g2.fill(body);
      
      g2.setColor(Color.BLACK);
      g2.fill(frontTire);
      
      g2.setColor(Color.BLACK);
      g2.fill(rearTire);
   
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
   
   private static final int DEFAULT_CAR_WIDTH = 100;//60
   private static final int DEFAULT_CAR_HEIGHT = 60;//30
   private static final int DEFAULT_PANEL_WIDTH = 160;
   private static final int DEFAULT_PANEL_HEIGHT = 130;
}
