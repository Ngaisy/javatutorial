package javatutorial;

import java.io.*;
public class Lesson33_Read_Write_Binary_Stream {

    public static void main(String[] args){

        // Create an array of type Customer
        Customer[] customers = getCustomer();

        // A DataOutputStream allows you to print
        // primitive data types to a file

        DataOutputStream custOutput = createFile("/Users/Shawn/Documents/Code/Java/FirstProject/src/javatutorial/customer.txt");

        for(Customer person: customers){

            createCustomers(person, custOutput);

        }

        //Closes the connection to the DataOutputStream

        try{
            custOutput.close();
        } catch (IOException e) {

            System.out.println("An I/O Error Occurred");
            // Closes the program

            System.exit(0);
        }

        getFileInfo();
    }// End of Main

    private static class Customer {

        public String custName;
        public int custAge;
        public double custDebt;
        public boolean ownMoney;
        public char custSex;

        public Customer(String custName, int custAge, double custDebt, boolean ownMoney, char custSex) {

            this.custName = custName;
            this.custAge = custAge;
            this.custDebt = custDebt;
            this.ownMoney = ownMoney;
            this.custSex = custSex;

        }
    }

        private static Customer[] getCustomer(){
            Customer[] customers = new Customer[5];

            customers[0] = new Customer("John Smith", 21, 12.25, true, 'M');
            customers[1] = new Customer("Ann Smith", 22, 12.25, true, 'M');
            customers[2] = new Customer("Bob Smith", 23, 12.25, true, 'M');
            customers[3] = new Customer("Tim Smith", 24, 12.25, true, 'M');
            customers[4] = new Customer("Sue Smith", 25, 12.25, true, 'M');

            return customers;
        }

        private static DataOutputStream createFile(String fileName){


            try{
                File listOfNames = new File(fileName);
                DataOutputStream infoToWrite = new DataOutputStream(
                        new BufferedOutputStream(
                                new FileOutputStream(listOfNames)));
                // FileOutputStream is used to write streams of data to a file
                // You define whether a new file is created versus appended
                // to based on if you add a boolean to the FileOutputStream
                // FileOutputStream(file, true) : Appends to the file
                // FileOutputStream(file, false) : Creates a new file

                // BufferedOutputStream gathers all the data and then writes
                // it all at one time (Speeds up the Program)
                // DataOutputStream is used to write primitive data to the file

                return  infoToWrite;
            } catch(IOException e){
                System.out.println("An I/O Error Occurred");
                System.exit(0);
            }
            return null;
        }

        private static void createCustomers(Customer customer, DataOutputStream custOutput){

            try{
                custOutput.writeUTF(customer.custName);
                custOutput.writeInt(customer.custAge);
                custOutput.writeDouble(customer.custDebt);
                custOutput.writeBoolean(customer.ownMoney);
                custOutput.writeChar(customer.custSex);

            }catch(IOException e){
                System.out.println("An I/O Error ocurred");
                System.exit(0);
            }
        }

        private static void getFileInfo(){
            File listOfNames = new File("/Users/Shawn/Documents/Code/Java/FirstProject/src/javatutorial/customer.txt");
            boolean eof = false;

            try{
                DataInputStream getInfo = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(listOfNames)));
                    while(eof!=true){
                        String custName = getInfo.readUTF();
                        int custAge = getInfo.readInt();
                        double custDebt = getInfo.readDouble();
                        boolean ownMoney = getInfo.readBoolean();
                        char custSex = getInfo.readChar();

                        System.out.println(custName);
                        System.out.println(custAge);
                        System.out.println(custDebt);
                        System.out.println(ownMoney);
                        System.out.println(custSex);

                    }

                }// End of try
                catch(EOFException e){
                    eof = true;
                }catch(FileNotFoundException e){
                    System.out.println("File cannot be found");
                    System.exit(0);
                }
                catch(IOException e) {
                    System.out.println("An I/O Error Occurred");
                    System.exit(0);
                }


            }

    }



