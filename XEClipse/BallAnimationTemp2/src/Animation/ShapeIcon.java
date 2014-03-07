package Animation;

import java.awt.*;
import javax.swing.*;

public class ShapeIcon implements Icon
{
	   private int width;
	   private int height;
	   private MoveableShape shape;
	   
   public ShapeIcon(MoveableShape _shape,int _width, int _height)
   {
      shape = _shape;
      width = _width;
      height = _height;
   }
   
   public int getIconWidth()
   {
      return width;
   }
 
   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      shape.draw(g2);
   }
}//end class Shape Icon
