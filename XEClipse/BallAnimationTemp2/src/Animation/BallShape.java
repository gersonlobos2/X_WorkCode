package Animation;

import java.awt.*;
import java.awt.geom.*;

public class BallShape implements MoveableShape
{
	   private int x;
	   private int y;
	   private int width;
	   private QueueCordenadas bag;

   public BallShape(int _x, int _y, int _width, QueueCordenadas _bag)
   {
	  x = _x;
      y = _y;
      width = _width;
      bag = _bag;
   }

   public void translate(int dx, int dy)
   {
     x += dx;
     y += dy;
   }
   
   public void draw(Graphics2D g2)
   {
	  int Color = 0;
	  bag.add(new Cordenadas(x, y, width));
      Ellipse2D.Double ball;
      
      try{
      for(int z = bag.getTail()-1; z != bag.getHead(); z--){
    	  ball = new Ellipse2D.Double(bag.getX(z), bag.getY(z) , bag.getD(z), bag.getD(z));
    	  g2.setColor(new Color(Color));
          g2.fill(ball);
          if(Color<255)
              Color+=5;
          else
              Color = 0;
          
      }//end of for loop
      }catch(NullPointerException e){}
   }
   public void moveShape(int x, int y){
	  this.x = x;
	  this.y = y;
   }
}//end class BallShape
