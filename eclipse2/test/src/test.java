import javax.swing.*;
import java.awt.*;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class test {
	
	public static void main(String[] args){
		
		
		JFrame frame = new JFrame("calculator");
		frame.setSize(600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel(new GridBagLayout());
		frame.add(panel);
		
		GridBagConstraints c = new GridBagConstraints();
	
		JButton button= new JButton(" 1 ");
		c.gridx=0;
		c.gridy=0;
		c.insets = new Insets(1,1,1,1);
		panel.add(button,c);
		JButton button2= new JButton(" 2 ");
		c.gridx=1;
		c.gridy=0;
		panel.add(button2,c);
		
		JButton button3= new JButton(" 3 ");
		c.gridx=2;
		c.gridy=0;
		panel.add(button3,c);
		
		JButton button4= new JButton(" 4 ");
		c.gridx=3;
		c.gridy=0;
		panel.add(button4,c);
		
		JButton button5= new JButton(" 5 ");
		c.gridx=4;
		c.gridy=0;
		panel.add(button5,c);
		//******************************************
		JButton button6= new JButton(" 6 ");
		c.gridx=0;
		c.gridy=1;
		panel.add(button6,c);
		JButton button7= new JButton(" 7 ");
		c.gridx=1;
		c.gridy=1;
		panel.add(button7,c);
		
		JButton button8= new JButton(" 8 ");
		c.gridx=2;
		c.gridy=1;
		panel.add(button8,c);
		
		JButton button9= new JButton(" 9 ");
		c.gridx=3;
		c.gridy=1;
		panel.add(button9,c);
		
		JButton button0= new JButton(" 0 ");
		c.gridx=4;
		c.gridy=1;
		panel.add(button0,c);
		
		JLabel label= new JLabel("Gerson Lobos");
		c.gridx=3;
		c.gridy=5;
		panel.add(label,c);
		
		JFormattedTextField yup = new JFormattedTextField();
		c.gridx=1;
		c.gridy=4;
		panel.add(yup,c);
		
	
		
		
	}
}
