package Animation;

public class Cordenadas {

	/**
	 * @param args
	 */
	 int x;	//x-axis
	 int y;	//y-axis
	 int d; //diameter
	public Cordenadas(int _x, int _y, int _d) {
		// TODO Auto-generated method stub
		x=_x;
		y=_y;
		d=_d;
	}
	public void setX(int _x){
		x=_x;
	}
	public void setY(int _y){
		y=_y;
	}
	public void setD(int _d){
		d=_d;
	}
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public int getD(){
		//return d;//error keeps holding in the queue
		return d--; //decreasing size
	}
	
}//end class
