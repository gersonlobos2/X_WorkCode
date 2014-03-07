package OOP;
import java.util.*;

/**
   A class for testing an implementation of the Observer pattern.
*/
public class ObserverTester extends Observable
{
   /**
      Creates a DataModel and attaches barchart and textfield listeners
      @param args unused
   */
   public static void main(String[] args)
   {
      ArrayList<Double> listData = new ArrayList<Double>();

      listData.add(new Double(33.0));
      listData.add(new Double(44.0));
      listData.add(new Double(28.0));
      listData.add(new Double(22.0));

      Data model = new Data(listData);
      TextFrame frame = new TextFrame(model);
      model.attach(frame);
      
   }
}