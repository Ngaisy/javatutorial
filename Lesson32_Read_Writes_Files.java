package javatutorial;

import java.io.*;

/**
 * Created by Shawn on 3/10/16.
 */
public class Lesson32_Read_Writes_Files {

    public static void main(String[] args){
        // Create an array of type Customer
        Customer[] customers = getCustomers();

        // PrintWriter is used to write characters to a file in this situation
        PrintWriter custOutput = createFile("/Users/Shawn/Documents/Code/Java/FirstProject/src/javatutorial/customer.txt");

        for(Customer person:customers){

            createCustomers(person, custOutput);
        }

        custOutput.close();

        getFileInfo();
    }

    private static class Customer{
        public String firstName, lastName;
        public int custAge;

        public Customer(String firstName, String lastName, int custAge){
            this.firstName = firstName;
            this.lastName = lastName;
            this.custAge = custAge;
        }
    }


    // Creates an array of Customer objects
    private static Customer[] getCustomers(){
        Customer[] customers = new Customer[5];

        customers[0] = new Customer("John", "Smith", 21);
        customers[1] = new Customer("Sally", "Smith", 30);
        customers[2] = new Customer("Paul", "Smith", 21);
        customers[3] = new Customer("Tom", "Smith", 21);
        customers[4] = new Customer("Mark", "Smith", 21);

        return customers;

    }

    private static PrintWriter createFile(String fileName){

        try{
            File listOfNames = new File(fileName);

            PrintWriter infoToWrite = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(listOfNames)));
            return infoToWrite;
        }
        catch(IOException e){

            System.out.println("An I/O Error Occurred");
            System.exit(0);
        }
        return null;
    }

    private static void createCustomers(Customer customer, PrintWriter custOutput){
        String custInfo = customer.firstName + " " + customer.lastName + " ";
        custInfo += Integer.toString(customer.custAge);

        custOutput.println(custInfo);

    }

    private static void getFileInfo(){

        System.out.println("Info Written to File\n");

        File listOfNames = new File("/Users/Shawn/Documents/Code/Java/FirstProject/src/javatutorial/customer.txt");

        try{

            BufferedReader getInfo = new BufferedReader(
                    new FileReader(listOfNames));

            String custInfo = getInfo.readLine();

            while(custInfo != null){

                //System.out.println(custInfo);

                String[] indivCustData = custInfo.split(" ");
                int custAge = Integer.parseInt(indivCustData[2]);
                System.out.print("Customer " + indivCustData[0] + " is " + custAge + "\n");
                custInfo = getInfo.readLine();

            }

        }
        catch(FileNotFoundException e){
            System.out.println("Couldn't Find File");
            System.exit(0);
        }

        catch(IOException e){
            System.out.println("An I/O Error Occurred");
            System.exit(0);
        }
    }
}
