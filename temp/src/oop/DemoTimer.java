package oop;

/*
 *  ====================================================\\\\\=============
 *  DemoTimer.java : This applet flashes the text label "Swing can flash!"
 *  in a variety of colors. The applet has control buttons to start,
 *  restart, and stop the flashing, and slider bars to contol the 
 *  delay to firing events and time between color changes. 
 * 
 *  Adapted from : Pantham S., Pure JFC Swing, 1999.
 *  Modified by : Mark Austin                             March, 2001
 *  =================================================================
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.*;

public class DemoTimer extends JApplet {
    Container container = null;
    Timer timer     = null;
    JLabel label    = null;
    JSlider slider1 = null;
    JSlider slider2 = null;
    Color[] color = {  Color.blue,    Color.green, Color.red,
                     Color.yellow, Color.lightGray  };

    public void init() {

        // 1. Get the handle on the applet's content pane.

        container = this.getContentPane();

        // 2. Create a label and attach it to the applet.

        label = new JLabel("Swing can flash!", JLabel.CENTER);
        label.setBackground(Color.white);
        label.setFont(new Font("Dialog", Font.BOLD, 40));
        label.setOpaque(true);
        container.add(label);

        // 3. Create a horizontal box and attach it at the
        // bottom portion of the content pane.

        Box box = Box.createHorizontalBox();
        container.add(box, BorderLayout.SOUTH);

        // 4. Create a vertical box and add it to the horizontal box.

        Box vbox1 = Box.createVerticalBox();
        box.add(vbox1);

        // 5. Create labels and sliders and attach them to
        //    a vertical box.

        JLabel initDelay = new JLabel("Initial Delay", JLabel.CENTER);
        initDelay.setPreferredSize(new Dimension(200, 25));
        vbox1.add(initDelay);
        slider1 = new JSlider(JSlider.HORIZONTAL, 0, 60000, 0);
        slider1.addChangeListener(new SliderListener());
        vbox1.add(slider1);

        JLabel delay = new JLabel("Timer Delay", JLabel.CENTER);
        delay.setPreferredSize(new Dimension(200, 25));
        vbox1.add(delay);
        slider2 = new JSlider(JSlider.HORIZONTAL, 0, 2000, 1000);
        slider2.addChangeListener(new SliderListener());
        vbox1.add(slider2);

        // 6. Create another vertical box and add it to the
        //    horizontal box.

        Box vbox2 = Box.createVerticalBox();
        box.add(vbox2);

        // 7. Create a Swing panel with grid layout and add it to
        //    the vertical box created in Snippet 6.

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,5,5));
        vbox2.add(panel);

        // 8. Create Start, Stop, and Restart buttons, and add them
        //    to the panel.

        String[] buttonLabels = {"Start", "Stop", "Restart"};
        for (int i=0; i<buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.addActionListener(new ButtonListener());
            panel.add(button);
        }

        // 9. Add a toggle button to the panel.

        JToggleButton toggleButton = new JToggleButton("Coalesce");
        toggleButton.setSelected(true); // since coalesced by default
        toggleButton.addActionListener(new ToggleButtonListener());
        panel.add(toggleButton);

        // 10. Create a timer object with prescribed delay and
        //     initial delay retrieved from the corresponding
        //     slider objects.

        timer = new Timer(slider2.getValue(), new TimerListener());
        timer.setInitialDelay(slider1.getValue()); //initial delay
    }

    // 11. Listener class that implements the "action code."

    class TimerListener implements ActionListener {
        int i;

        public void actionPerformed(ActionEvent e) {
            if (i == color.length) {
                i = 0;
                label.setForeground(color[i]);
            }
            else {
                label.setForeground(color[i]);
            }
            label.repaint();
            i++;
        }
    }

    // 12. Button listener that is used to start, stop, or
    // restart the timer.

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();

            if (button.getText() == "Start") {
                timer.start();
            }
            else if (button.getText() == "Stop") {
                timer.stop();
            }
            else if (button.getText() == "Restart") {
                timer.restart();
            }
        }
    }

    // 13. Toggle button listener to change coalescing status.

    class ToggleButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (timer.isCoalesce() == false)
                timer.setCoalesce(true);
            else if (timer.isCoalesce() == true)
                timer.setCoalesce(false);
        }
    }

    // 14. Slider listener to alter the initial delay or
    //     timer delay.

    class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();

            if (slider == slider1) {
                timer.setInitialDelay(slider1.getValue());
            }
            else if (slider == slider2) {
                timer.setDelay(slider2.getValue());
            }
        }
    }
}