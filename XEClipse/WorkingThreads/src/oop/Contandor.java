package oop;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JTextArea;

public class Contandor extends WordCounter {

	private JTextArea tArea;
	private volatile int Totalcount=0;
	Lock lock = new ReentrantLock();
	public Contandor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void includeingTextArea(JTextArea _tArea){
		tArea =_tArea;
	}
	public void incrementTWC(){
		lock.lock();
		try{
		Totalcount+=1;
		tArea.setText(""+Totalcount);
		}finally{
			lock.unlock();
		}
		
	}
	/**
	 * @param args
	 */
	
	
	
	

}
