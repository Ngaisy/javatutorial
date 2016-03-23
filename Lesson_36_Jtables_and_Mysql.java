package javatutorial;

/**
 * Created by Shawn on 3/22/16.
 */
import java.awt.BorderLayout;
import java.awt.Font;
import java.sql.*;

import javax.swing.*;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Lesson_36_Jtables_and_Mysql {

    // The column data for dataoutput
    static Object[][] databaseInfo;

    static Object[] columnName ={"Year","PlayerID","Name","TTRC","Team","Salary","CPR","POS"};

    // ResultSet contains data returned

    static ResultSet rows;

    // ResultSetMetaData contains information on the date
    // from the query

    static ResultSetMetaData metaData;

    // DefaultTableModel defines the methods JTabel
    // Overwrite getColumnClass
    static DefaultTableModel dTableModel = new DefaultTableModel(databaseInfo, columnName){
        public Class getColumnClass(int column) {
            Class returnValue;

            // Verifying that the column exists (index > 0 && index < numbers of columns

            if((column >= 0) && (column < getColumnCount())){
                returnValue = getValueAt(0,column).getClass();
            }else{
                //returns the class for the item in the column
                returnValue = Object.class;
            }
            return returnValue;
        }
    };

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Connection conn = null;

        try{
            // The driver allows you to query the database with Java
            // forName dynamically loads the class for you
            Class.forName("com.mysql.jdbc.Driver");

            // DriverManager is used to handle a set of JDBC drivers
            // getConnection establishes a connection to the database;
            // UseID and password is needed for the access of the database

            conn = DriverManager.getConnection("jdbc:mysql://localhost/lahman591","mysqladm","turtledove");

            // Statement objects executes a SQL query
            // createStatement returns a Statement object

            Statement sqlState = conn.createStatement();

            // The query to the database
            String selectStuff = "select b.yearID, b.playerID, " +
                    "CONCAT(m.nameFirst, ' ', m.nameLast) AS Name, " +
                    "((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.TB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB)) AS TTRC, " +
                    "b.teamID AS Team, s.salary AS Salary, " +
                    "CAST( s.salary/(((b.H+b.BB)+(2.4*(b.AB+b.BB)))*(t.TB+(3*(b.AB+b.BB)))/(9*(b.AB+b.BB))-(.9*(b.AB+b.BB))) as decimal(10,2)) AS CPR, " +
                    "f.POS AS POS FROM Batting b, Master m, Salaries s, TOTBYR t, Fielding f " +
                    "WHERE b.playerID = m.playerID AND t.playerID = m.playerID " +
                    "AND t.yearID = 2010 AND b.yearID = t.yearID AND s.playerID = b.playerID " +
                    "AND s.yearID = b.yearID AND b.AB > 50 AND b.playerID = f.playerID " +
                    "AND b.playerID = t.playerID GROUP BY b.playerID ORDER BY TTRC DESC LIMIT 200;";


            int numOfCol;

            // Retrieves the number, types and properties of the Query Results
            metaData = rows.getMetaData();

            // Returns the number of columns;
            numOfCol = metaData.getColumnCount();

            // One way to get the column titles
            columnName = new String[numOfCol];

            for(int i=1; i<=numOfCol; i++)
            {
                // Returns the columns name

                columnName[i] = metaData.getColumnName(i);
                System.out.println(i);
            }

            // Temporarily holds the row results
            Object[] tempRow;

            //next method is used to iterate through the results of a query

            while(rows.next()){
                // Gets the column values based on clas type expected
                tempRow = new Object[]{rows.getInt(1), rows.getString(2), rows.getString(3),
                        rows.getDouble(4), rows.getString(5), rows.getInt(6), rows.getDouble(7),
                        rows.getString(8)};
                // Adds the data to the end of the model
                dTableModel.addRow(tempRow);
            }
        }
        catch (SQLException ex) {
            // String describing the error

            System.out.println("SQLException: " + ex.getMessage());

            // Vendor specific error code

            System.out.println("VendorError: " + ex.getErrorCode());
        }

        catch (ClassNotFoundException e){
            // Executes if the driver can't be found
            e.printStackTrace();
        }

        // Create a JTable using the custom DefaultTableModel

        JTable table = new JTable(dTableModel);

        // Increase the font size for the cells in the table

        table.setFont(new Font("Serif", Font.PLAIN, 20));

        // Increase the size of the cells to allow for bigger fonts

        table.setRowHeight(table.getRowHeight()+10);

        // Allows the user to sort the data

        table.setAutoCreateRowSorter(true);

        // Right Justify column
        TableColumn tc = table.getColumn("TTRC");
        RightTableCellRenderer rightRenderer = new RightTableCellRenderer();
        tc.setCellRenderer(rightRenderer);

        // Disable auto resizing
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Set the width for the columns
        TableColumn col1 = table.getColumnModel().getColumn(0);
        col1.setPreferredWidth(100);

        TableColumn col2 = table.getColumnModel().getColumn(1);
        col2.setPreferredWidth(190);

        TableColumn col3 = table.getColumnModel().getColumn(2);
        col3.setPreferredWidth(260);

        TableColumn col4 = table.getColumnModel().getColumn(3);
        col4.setPreferredWidth(200);

        TableColumn col5 = table.getColumnModel().getColumn(5);
        col5.setPreferredWidth(200);

        TableColumn col6 = table.getColumnModel().getColumn(6);
        col6.setPreferredWidth(200);

        // Change justification of column to Center

        tc = table.getColumn("Team");
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        tc = table.getColumn("POS");
        centerRenderer = new CenterTableCellRenderer();
        tc.setCellRenderer(centerRenderer);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(800,500);
        frame.setVisible(true);
    }
}

    // Change justification to the right
    class RightTableCellRenderer extends DefaultTableCellRenderer {
        public RightTableCellRenderer() {
            setHorizontalAlignment(JLabel.RIGHT);
        }
    }

    class CenterTableCellRenderer extends DefaultTableCellRenderer {
        public CenterTableCellRenderer() {
            setHorizontalAlignment(JLabel.CENTER);
        }
    }

