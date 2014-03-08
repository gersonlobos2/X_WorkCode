import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import  java.util.List;


public class ProgressBarDemo extends JPanel implements ActionListener, PropertyChangeListener
{
	private JProgressBar progressBar;
	private JButton StartButton;
	private JTextArea taskOutput;
	private Task task;
	private int sum = 0;
	
	
	class Task extends SwingWorker<Void,Integer>
	{
		public Void doInBackground()
		{
			int progress = 0;
			setProgress(progress);
			for(int i=1;i<11;i++)
			{
				sum+=i;
				try{Thread.sleep(1000);} catch(InterruptedException e){}
				progress++;
				setProgress(progress);
				publish(new Integer(sum));
				}
			return null;
	}	
			protected void process(List<Integer>list)
			{
				taskOutput.append("intermediate sum = "+list.get(0)+"\n");
			}
			public void done()
			{
				Toolkit.getDefaultToolkit().beep();
				StartButton.setEnabled(true);
				setCursor(null);
				taskOutput.append("Done n");
				
			}
}		
	

	public ProgressBarDemo()  //constructor
	{
		super(new BorderLayout());
		//create the GUI
		StartButton = new JButton("START");
		StartButton.setActionCommand("START");
		StartButton.addActionListener(this);
		
		progressBar = new JProgressBar(0,10);
		progressBar.setValue(0);
		progressBar.setStringPainted(true); //it will display the number under the progress bar
		
		taskOutput = new JTextArea(5,20);
		taskOutput.setMargin(new Insets(5,5,5,5));
		taskOutput.setEditable(false);
		
		JPanel panel = new JPanel();
		panel.add(StartButton);
		panel.add(progressBar);
		
		add(panel,BorderLayout.PAGE_START);
		add(new JScrollPane(taskOutput),BorderLayout.CENTER);//adds a panel to a panel in center
		setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		StartButton.setEnabled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();
	}
	public void PropertyChange(PropertyChangeEvent e)
	{
		if("progress" == e.getPropertyName())
		{
			int progress=(Integer)e.getNewValue();
			progressBar.setValue(progress);
		}
	}
	private static void createAndShowGUI()
	{
		JFrame frame= new JFrame("Progress Bar Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new ProgressBarDemo();
		newContentPane.setOpaque(true); 
		frame.setContentPane(newContentPane);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				createAndShowGUI();
				
			}
			
		}
		);
		
	}
}
