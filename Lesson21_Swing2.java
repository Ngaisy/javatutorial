package javatutorial; /**
 * Created by Shawn on 3/6/16.
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

import java.awt.event.*;

public class Lesson21_Swing2 extends JFrame{

    JButton button1;
    JTextField textField1;
    JTextArea textArea1;
    int buttonClicked;

    public static void main(String[] args){

        new Lesson21_Swing2();

    }

    public Lesson21_Swing2(){
        this.setSize(400, 400);

        Toolkit tk = Toolkit.getDefaultToolkit();
        // Toolkit is a the super class for the Abstract Window Toolkit
        // Allows us to ask questions of the OS

        Dimension dim = tk.getScreenSize();

        int xPos = (dim.width / 2) - (this.getWidth()/2);
        int yPos = (dim.height/ 2) - (this.getHeight()/2);
        //define the x,y position of the frame
        this.setLocation(xPos,yPos);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("My First Frame");
        JPanel thePanel = new JPanel();

        //Create a click button
        button1 = new JButton("Click Here");

        // Handling events
        // Button action listener
        ListenForButton lForButton = new ListenForButton();
        button1.addActionListener(lForButton);
        thePanel.add(button1);

        // Text field action listener
        textField1 = new JTextField("Type Here", 15);
        ListenForKeys lForkeys = new ListenForKeys();
        textField1.addKeyListener(lForkeys);
        thePanel.add(textField1);

        // Text area action listener
        textArea1 = new JTextArea(15, 20);
        textArea1.setText("Tracking Events\n");
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        JScrollPane scrollbar1 = new JScrollPane(textArea1,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollbar1);
        this.add(thePanel);

        ListenForWindow lForWindow = new ListenForWindow();
        this.addWindowListener(lForWindow);


        // Mouse action listener
        ListenForMouse lForMouse = new ListenForMouse();
        this.addMouseListener(lForMouse);

        this.setVisible(true);
    }


    private class ListenForButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //check if the source of the event was the button
            if(e.getSource() == button1){
                buttonClicked++;
                textArea1.append("Button Clicked " + buttonClicked +" times\n");
                // e.getSource().toString returns information on the button
                // and the event that occurred

            }
        }
    }

    private class ListenForKeys implements KeyListener{

        // Handle the key typed event from the text field.
        public void keyTyped(KeyEvent e) {
            textArea1.append("Key Hit: " + e.getKeyChar() + "\n");

        }

        // Handle the key-pressed event from the text field.
        public void keyPressed(KeyEvent e) {

        }

        // Handle the key-released event from the text field.
        public void keyReleased(KeyEvent e) {

        }
    }

    private class ListenForWindow implements WindowListener{


        public void windowOpened(WindowEvent e) {
            textArea1.append("Window Created \n");
        }

        // Called when window is closed using dispose
        // this.dispose(); can be used to close a window
        public void windowClosed(WindowEvent e) {

        }

        // Called when the window is closed from the menu
        public void windowClosing(WindowEvent e) {

        }

        // Called when the window goes from normal to a minimized state
        public void windowIconified(WindowEvent e) {
            textArea1.append("Window Minimized\n");

        }

        // Called when the window goes from minimized to a normal state
        public void windowDeiconified(WindowEvent e) {
            textArea1.append("Window in Normal State");

        }

        // Called when Window is the active window
        public void windowActivated(WindowEvent e) {
            textArea1.append("Window Activated\n");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            textArea1.append("Window Deactivated\n");
        }
    }

    private class ListenForMouse implements MouseListener{

        // Called when a mouse button is clicked
        public void mouseClicked(MouseEvent e) {
            textArea1.append("Mouse Panel Pos: " + e.getX() + " " + e.getY() + "\n");
            textArea1.append("Mouse Screen Pos: " + e.getXOnScreen() + " " + e.getYOnScreen() + "\n");
            textArea1.append("Mouse Button: " + e.getButton() + "\n");
            textArea1.append("Mouse Clicks: " + e.getClickCount() + "\n");
        }

        // Mouse button pressed
        public void mousePressed(MouseEvent e) {

        }

        // Mouse button released
        public void mouseReleased(MouseEvent e) {

        }

        // Called when the mouse enters the component assigned the MouseListener
        public void mouseEntered(MouseEvent e) {

        }

        // Called when the mouse leaves teh component assigned the MouseListener
        public void mouseExited(MouseEvent e) {

        }
    }
}
