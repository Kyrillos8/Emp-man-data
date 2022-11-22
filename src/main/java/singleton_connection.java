import java.sql.*;

public class singleton_connection { //def static instance of itself inside the class and init it with null
        private static Connection myconn;   //make the constructor private

        static {
            String url = "jdbc:mysql://localhost:3306/bank";
            String usr = "root";
            String pss = "1234";
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); //new driver insted of 'com.mysql.jdbc.Driver'
                myconn =(Connection) DriverManager.getConnection(url, usr, pss);
                System.out.println("connected");
            }
            catch (Exception exc) {
                System.out.println(exc);
            }
        }
        public static Connection getMyconn(){   //def getinstance method and call the constructor
            return myconn;
        }

}
