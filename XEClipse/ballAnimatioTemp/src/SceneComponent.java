import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

/**
   A component that shows a scene composed of shapes.
*/
public class SceneComponent extends JComponent
{
   public SceneComponent()
   {
      shapes = new ArrayList<SceneShape>();

      addMouseListener(new
         MouseAdapter()
         {
            public void mousePressed(MouseEvent event)
            {
               mousePoint = event.getPoint();
               for (SceneShape s: shapes)
               {
                  if (s.contains(mousePoint)){
                     s.setSelected(!s.isSelected());
                  }
               }
               repaint();
               
               
            }
         });

      addMouseMotionListener(new
         MouseMotionAdapter()
         {
            public void mouseDragged(MouseEvent event)
            {
            	double dx=0;
            	double dy=0;
               Point lastMousePoint = mousePoint;
               mousePoint = event.getPoint();
              // shapes.add(new CarShape(5,5,80));//here i worked on adding more shapes
               /*
               for (SceneShape s : shapes)
               {
                 // if (s.isSelected())
                 // {
                      
                     double dx = mousePoint.getX() - lastMousePoint.getX();
                     double dy = mousePoint.getY() - lastMousePoint.getY();
                     s.translate((int) dx, (int) dy);

                 // }
               }
	//int z = bc.getTail(); z != bc.getHead(); z--
               repaint(); */
               
               for(int i=0; i<shapes.size();++i){
            	    dx = mousePoint.getX() - lastMousePoint.getX();
                    dy = mousePoint.getY() - lastMousePoint.getY();
            	   shapes.get(i).translate((int)dx,(int) dy);
               }
               repaint();
                shapes.add(new CarShape((int) dx,(int)dy,80));//here i worked on adding more shapes

               
            }
         });
   }

   /**
      Adds an shape to the scene.
      @param s the shape to add
   */
   public void add(SceneShape s)
   {
      shapes.add(s);
      repaint();
   }

   /**
      Removes all selected shapes from the scene.
   */
   public void removeSelected()
   {
      for (int i = shapes.size() - 1; i >= 0; i--)
      {
         SceneShape s = shapes.get(i);
         if (s.isSelected()) shapes.remove(i);
      }
      repaint();
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (SceneShape s : shapes)
      {
         s.draw(g2);
         if (s.isSelected())
            s.drawSelection(g2);
      }
   }

   private ArrayList<SceneShape> shapes;
   private Point mousePoint;
}
