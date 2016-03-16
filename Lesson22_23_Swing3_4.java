package javatutorial;
import javax.swing.*;
import java.awt.event.*;

// New event listener that monitors changing values for components
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// Allows us to format the numbers
import java.text.NumberFormat;

// Allows us to edit borders on panels
import javax.swing.border.*;
/**
 * Created by Shawn on 3/7/16.
 */
public class Lesson22_23_Swing3_4 extends JFrame{

    JButton button1;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox dollarSign, commaSeparator;
    JRadioButton addNums, subtractNums, multNums, divideNums;
    JSlider howManyTimes;

    double number1, number2, totalCalc;

    public static void main(String[] args){
        new Lesson22_23_Swing3_4();
    }

    public Lesson22_23_Swing3_4(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("My Third Frame");

        JPanel thePanel = new JPanel();

        JButton button1 = new JButton("Calculate");


    // Create ListenForEvents to handle Events
        ListenForButton lForButton = new ListenForButton();
        // Alert when an event happens to the button
        button1.addActionListener(lForButton);
        thePanel.add(button1);

    // Add a label1
        label1 = new JLabel("Number 1");
        thePanel.add(label1);

    // Add a text field1
        textField1 = new JTextField("", 5);
        thePanel.add(textField1);

    // Add a label2

        label2 = new JLabel("Number 2");
        thePanel.add(label2);

    // Add a text field2
        textField2 = new JTextField("",5);
        thePanel.add(textField2);

    // Add checkboxes
        dollarSign = new JCheckBox("Dollars");
        commaSeparator = new JCheckBox("Commas");

        thePanel.add(dollarSign);
        // true here means selected as default
        thePanel.add(commaSeparator,true);

        // Create radio buttons with default labels
        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Subtract");
        multNums = new JRadioButton("Multiply");
        divideNums = new JRadioButton("Divide");


        // Create a group includes all the radioo buttons
        // Add radio buttons to the group
        ButtonGroup operation = new ButtonGroup();

        operation.add(addNums);
        operation.add(subtractNums);
        operation.add(multNums);
        operation.add(divideNums);



        JPanel operPanel = new JPanel();

        // Surround radio button panel with a border
        // You can define different types of borders
        // createEtchedBorder, createLineBorder, createTitleBorder
        // createLowerBevelBorder, createRaisedBevelBorder

        Border operBorder = BorderFactory.createTitledBorder("Operation");

        // Set the border for the panel
        operPanel.setBorder(operBorder);
        // Add the radio buttons to the panel
        operPanel.add(addNums);
        operPanel.add(subtractNums);
        operPanel.add(multNums);
        operPanel.add(divideNums);

        addNums.setSelected(true);
        thePanel.add(operPanel);

        // Create a slider
        label3 = new JLabel("Perform How Many Times?");
        thePanel.add(label3);
        // Creates a slider with a min value of 0 thru 99 and an initial value of 1
        howManyTimes = new JSlider(0,99,1);
        // Minimum space between ticks
        howManyTimes.setMinorTickSpacing(1);
        // Minimum space between major ticks
        howManyTimes.setMajorTickSpacing(10);
        // Draw the ticks on the slider
        howManyTimes.setPaintTicks(true);
        // Draw the tick labels on slider
        howManyTimes.setPaintLabels(true);

        // Creates a instance manage Slider
        ListenForSlider lForSlider = new ListenForSlider();
        howManyTimes.addChangeListener(lForSlider);
        thePanel.add(howManyTimes);

        this.add(thePanel);
        this.setVisible(true);

        textField1.requestFocus();

    }

    public class ListenForButton implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == button1){
                try{
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                }catch(NumberFormatException excep){
                    JOptionPane.showMessageDialog(Lesson22_23_Swing3_4.this, "Please Enter the right Info",
                    "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }

                if(addNums.isSelected()) {
                    totalCalc = addNumbers(number1, number2, howManyTimes.getValue());
                }else if(subtractNums.isSelected()){
                    totalCalc = subtractNumbers(number1,number2, howManyTimes.getValue());
                }else if(multNums.isSelected()){
                    totalCalc = multiplyNumbers(number1,number2,howManyTimes.getValue());
                }else {
                    totalCalc = divideNumbers(number1,number2,howManyTimes.getValue());
                }

                // If the dollar is selected in the checkbox print the number as currency
                if(dollarSign.isSelected()){
                    NumberFormat numFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(Lesson22_23_Swing3_4.this,
                            numFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(commaSeparator.isSelected()) {
                    NumberFormat numFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(Lesson22_23_Swing3_4.this,
                            numFormat.format(totalCalc), "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(Lesson22_23_Swing3_4.this,
                            totalCalc, "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    private class ListenForSlider implements ChangeListener{

        public void stateChanged(ChangeEvent e){
            //CHeck if the source of the event was the button
            if(e.getSource() == howManyTimes){
                label3.setText("Perform How Many Times? " + howManyTimes.getValue());
            }
        }

    }

    public static double addNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany ){
            total = total + (number1 + number2);
            i++;
        }
        return total;
    }

    public static double subtractNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany ){
            total = total + (number1 - number2);
            i++;
        }
        return total;
    }

    public static double multiplyNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany ){
            total = total + (number1 * number2);
            i++;
        }
        return total;
    }

    public static double divideNumbers(double number1, double number2, int howMany){
        double total = 0;
        int i = 1;

        while(i <= howMany ){
            total = total + (number1 / number2);
            i++;
        }
        return total;
    }


    private class ListenForEvent implements ActionListener{

        // This method is called when an event occurs
        public void actionPerformed(ActionEvent e) {

            //Check if the source of the event was the button
            if(e.getSource() == button1){
                try{
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                }catch(NumberFormatException excep){
                    // JOptionPane display a popup on the screen
                    // (parentComponent, message, title, error icon)
                    // Error Icons: WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE

                    JOptionPane.showMessageDialog(Lesson22_23_Swing3_4.this,
                            "Please Enter the Right Info", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0); // Closes the Java app
                }
            }

        }
    }
}
