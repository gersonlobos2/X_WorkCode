package Animation;

public class QueueCordenadas {

	/**
	 * @param args
	 * circular queue of cordenadas inserting from tail and 
	 * removing from head.
	 */
	private Cordenadas[] elements;
	private final int capacity = 10000;
	private int head;
	private int tail;
	private int count;
	
	public QueueCordenadas() {
		// TODO Auto-generated method stub
		elements = new Cordenadas[capacity];
		count = 0;
		head = 0;
		tail = 0;
	}//end constructor
	
	public Cordenadas remove(){
		  
		Cordenadas r = elements[head];
	      head = (head + 1) % elements.length;
	      count--;
	      return r;
	   }
	
	 public void add(Cordenadas data) //used for BallShape. adding from Ballshape
	   {
	       elements[tail] = data;
	       tail = (tail + 1) % elements.length;
	       count++;
	   }
	 public void add(int x, int y) //used for animationTester. adding from Animation Tester
	   {
	       elements[tail] = new Cordenadas(x, y, 10);
	       tail = (tail + 1) % elements.length;//finds the new tail but if tail ==head means full
	       count++;
	   }
	   
	   public Cordenadas peek()
	   {
	      return elements[head];
	   }
	   
	   public int getTail(){
		   return tail;
	   }
	   
	   public int getHead(){
		   return head;
	   }
	   public double getX(int index){
		   return elements[index].getX();
	   }
	   
	   public double getY(int index){
		   return elements[index].getY();
	   }
	   
	   public int getD(int index){
		   return elements[index].getD();
	   }
	   public int size()
	   {
	      return count;
	   }
}//end class
