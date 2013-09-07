package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: anand
 * Date: 9/7/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class Beep extends JPanel implements WindowListener, ActionListener {

    /**
     * @param args
     */
    JButton button;
    static int count=0;
    JTextPane text;
    static ArrayList<Long> interv = new ArrayList<Long>();

    public Beep(){
        super(new BorderLayout()); /*A border layout lays out a container, arranging and resizing its components to fit in five regions:
									north, south, east, west, and center. Each region may contain no more than one component,
									and is identified by a corresponding constant: NORTH, SOUTH, EAST, WEST, and CENTER.
									When adding a component to a container with a border layout, use one of these five constants*/

        button = new JButton("Click Me");
        text = new JTextPane();
        button.setPreferredSize(new Dimension(160, 60));
        add(button, BorderLayout.CENTER); // adds button to the container specifying its position in the container.
        button.addActionListener(this); /*The listener interface for receiving action events. The class that is interested in processing
											an action event implements this interface, and the object created with that class is registered
											with a component, using the component's addActionListener method. When the action event occurs,
											that object's actionPerformed method is invoked.*/
        text.setText(String.valueOf(count));
        add(text, BorderLayout.SOUTH);
    }

    public static ArrayList<Long> getInterv() {
        return interv;
    }

    public static void setInterv(ArrayList<Long> interv) {
        Beep.interv = interv;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

        interv.add(System.currentTimeMillis());
        count++;
        text.setText(String.valueOf(count));


    }



    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(getParent(), interv);
        GUI_Main.clickOver = true;

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowOpened(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}
