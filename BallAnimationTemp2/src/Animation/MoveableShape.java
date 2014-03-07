package Animation;

import java.awt.*;
public interface MoveableShape
{

   void draw(Graphics2D g2);
   void translate(int dx, int dy);
   void moveShape(int x, int y);
}
