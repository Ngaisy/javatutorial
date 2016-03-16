package javatutorial;
// Swing allows you to create Graphical User Interfaces
// You need the Swing library to create GUI Interfaces
import java.awt.*;

import javax.swing.*;

// You must extend the JFrame class to make a frame

/**
 * Created by Shawn on 3/4/16.
 */
public class LessonTwenty extends JFrame{
    public static void main(String[] args){
        new LessonTwenty();
    }

    public LessonTwenty(){
        //Define the size of the frame
        this.setSize(400, 400);

        // Opens the frame in the middle of the screen
        // You can also define positon based on a componet
        // this.setLocationRelativeTo(null);

        // Toolkit is the super class for the Abstract Window Toolkit
        // It allows us to ask questions of the OS

        Toolkit tk = Toolkit.getDefaultToolkit();

        //Call for width and height of the screen
        Dimension dim = tk.getScreenSize();

        // dim.width returns the width of the screen
        // this.getWidth returns the width of the frame you are making

        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);

        // Define the x,y position of the frame.

        this.setLocation(xPos,yPos);

        // Define if user can resize the table
        this.setResizable(false);

        // Define how the user exits the program as they click the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //---------------------------------------------------------------------
        //Edit frame content
        //---------------------------------------------------------------------
        //Define title for the frame
        this.setTitle("My first Frame");

        // The JPanel contains all of the component for your frame
        JPanel thePanel = new JPanel();

        // create a label
        JLabel label1 = new JLabel("Tell me something");
        // change the text of label
        label1.setText("New Text");
        // create a tool tip for the label
        label1.setToolTipText("Doesn't do anything");
        // Add the label to the panel
        thePanel.add(label1);

        // create a button
        JButton button1 = new JButton("Send");
        // hide the button border (Default True)
        button1.setBorderPainted(true);
        // change the text for the label
        button1.setText("New Button");
        // create a tool tip for the label
        button1.setToolTipText("Doesn't do anything either");
        thePanel.add(button1);

        // add a textfield
        JTextField textField1 = new JTextField("Type Here", 15);
        // change the initial value of the text field
        textField1.setColumns(10);
        // change the initial value of the text field
        textField1.setText("New Text Here");
        // change the tool tip for the text field
        textField1.setToolTipText("More of Nothing");
        thePanel.add(textField1);

        // add a text area
        JTextArea textArea1 = new JTextArea(15,20);
        // set the default text for the text area
        textArea1.setText("Just a whole bunch of text that is important\n");
        // If text doesn't fit on a line, jump to the next
        textArea1.setLineWrap(true);
        // Makes sure that stay intact if a line wrap occurs
        textArea1.setWrapStyleWord(true);
        // Gets the number of lines in the text field
        int numofLines = textArea1.getLineCount();
        // Appends after the current text
        textArea1.append(" number of lines: " + numofLines);
        // Adds scroll bars to the text area
        JScrollPane scrollBar1 = new JScrollPane(textArea1,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        thePanel.add(scrollBar1);

        // Makes the frame show on the screen
        this.add(thePanel);
        this.setVisible(true);
        // Gives focus to the textfield
        textField1.requestFocus();
        // request focus for the text array
        // textArea1.requestFocus();

    }
}
