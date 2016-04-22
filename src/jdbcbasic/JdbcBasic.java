
package jdbcbasic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author OSUKA VANESSA
 */
public class JdbcBasic {

   Connection con; //The Connection class is instantiated. The word 'con' can be customized.
   private final String url = "jdbc:derby://localhost:1527/demo4"; //This is the address or path of your DB.
   //test is the name of the table created in the DB jdbc:mysql://localhost/test
PreparedStatement prep; //This is an initilaization of the PreparedStatement class.

    String  empName,empDept,location; // Instantiating the Variables that'd hold the data
   
     void connect()
           {
               try{
       Class.forName("org.apache.derby.jdbc.ClientDriver"); /** This brings in the Driver class com.mysql.jdbc.Driver **/
       con = DriverManager.getConnection(url,"nessa","1234"); /**To establish a connection, 
       you need to initialize the DriverManager class the getConnection method **/
     
    }catch(Exception e)
    {
     
        System.out.println(e);
    } 
           }
     //Connection method has been created. Now, you need to create the insert method.
     void insert()
     {
         connect();//calling the connect method in the insert.
               try{
              
               Scanner input = new Scanner(System.in); //Initializes the scanner class
              System.out.println("Enter your empName"); //Prompts the employee to enter  a name
              empName = input.next(); //Stores the name in a variable empName
              System.out.println("Enter your Department");
              empDept = input.next();
              System.out.println("Enter your location");
              location = input.next();
             
              String sql = "insert into demo4 values (?,?,?)"; /**Sql command that inserts the data into  a table in the 
              called 'company'. The number of question marks is the number of details that is expected to be entered **/
              prep= con.prepareStatement(sql);
              prep.setString(1, empName); /**Sets empName to the first column in the database table **/
               prep.setString(2, empDept); /**Sets empDept to the second column in DB **/
                prep.setString(3, location);
                int y = prep.executeUpdate(); /**Without the executeUpdate function, records won't insert. 
                 This function gives the DB the go-ahead so to say to save the records into itself **/
                if (y>0)
                {
                    System.out.println("Record inserted");
                }
                 else
                {
                    System.out.println("Record not inserted");
                }
           }catch(Exception e)
           {
              System.out.println(e); 
           }
            
     }
    public static void main(String[] args) {
        JdbcBasic jay = new JdbcBasic();/** Here we create jay which is  an  is an object of JdbcBasic **/
        jay.insert(); /**Then we use Jay to call the method insert **/
     
    }
    
}
