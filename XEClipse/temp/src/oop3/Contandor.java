package oop3;

import javax.swing.JTextArea;

public class Contandor extends WordCounter {

	private JTextArea tArea;
	private int Totalcount=0;
	public Contandor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void includeingTextArea(JTextArea _tArea){
		tArea =_tArea;
	}
	public void incrementTWC(){
		Totalcount+=1;
		tArea.setText(""+Totalcount);
	}
	/**
	 * @param args
	 */
	
	
	
	

}
