import java.sql.*;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/bank";
        String usr = "root";
        String pss = "1234";
        Scanner myObj = new Scanner(System.in);

        System.out.println("enter number 1 for get all the data");
        System.out.println("enter number 2 to add an emp");
        System.out.println("enter number 3 to delete an emp");
        System.out.println("enter number 4 to update an emp");
        System.out.println("enter number 5 to search for an emp");
        System.out.println("**********************************************");
        for (int i = 0;;i++) {
            System.out.print("Enter a number: ");

            int no = myObj.nextInt();  // Read user input
            switch (no) {
                case 1:
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        PreparedStatement mystt = myconn.prepareStatement("SELECT * FROM bank.customers");
                        //exe a sql code
                        ResultSet myres = mystt.executeQuery("SELECT * FROM bank.customers");
                        //process
                        while (myres.next()) {
                            System.out.println(myres.getString("customer_id") + " " + myres.getString("customer_name") + " " + myres.getString("customer_email"));
                        }
                        myconn.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }   break;
                case 2:
                {
                    String id = myObj.nextLine();  // Read user input
                    String name = myObj.nextLine();  // Read user input
                    String email = myObj.nextLine();  // Read user input
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        String sql = "INSERT INTO `bank`.`customers` (`customer_id`, `customer_name`, `customer_email`) VALUES (?,?,?)";
                        PreparedStatement mystt = myconn.prepareStatement(sql);
                        //exe a sql code

                        //process
                        mystt.setString(1,id);
                        mystt.setString(2, name);
                        mystt.setString(3, email);

                        int rows = mystt.executeUpdate();
                        if (rows >0){
                            System.out.println("success");
                        }
                        myconn.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }       break;
                }
                case 3:
                {
                    int id = myObj.nextInt();  // Read user input
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        PreparedStatement mystt = myconn.prepareStatement("delete FROM bank.customers where customer_id = ?");
                        //exe a sql code
                        //process

                        mystt.setInt(1, id);
                        mystt.executeUpdate();
                        myconn.close();


                    } catch (Exception exc) {
                        System.out.println(exc);
                    }       break;
                }
                case 4:
                {
                    int id = myObj.nextInt();  // Read user input
                    String name = myObj.nextLine();  // Read user input
                    String email = myObj.nextLine();  // Read user input
                    try {
                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement    //exe a sql code
                        PreparedStatement mystt = myconn.prepareStatement("UPDATE bank.customers SET customer_email = ? ,customer_name = ?where customer_id = ?");
                        //process

                        mystt.setInt(3, id);
                        mystt.setString(1, name);
                        mystt.setString(2, email);

                        mystt.executeUpdate();
                        myconn.close();

                    } catch (Exception exc) {
                        System.out.println(exc);
                    }       break;
                }
                case 5:
                    try {
                        int id = myObj.nextInt();  // Read user input

                        //get connection to database
                        Connection myconn = DriverManager.getConnection(url, usr, pss);
                        //create a statement
                        PreparedStatement mystt=myconn.prepareStatement("SELECT * FROM bank.customers WHERE customer_id = ?");
                        //exe a sql code

                        //process
                        mystt.setInt(1, id);
                        mystt.executeUpdate();

                        myconn.close();
                    } catch (Exception exc) {
                        System.out.println(exc);
                    }   break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
    }
}