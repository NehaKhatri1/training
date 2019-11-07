package com.thb.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Statement;

public class DatabaseConnectionTest {

        public static Connection getConnection() {

                System.out.println("-------- h2 JDBC Connection Testing ------");

                try {

                //  Class.forName("com.mysql.jdbc.Driver");
                	 Class.forName("org.h2.Driver");

                } catch (ClassNotFoundException e) {

                        System.out.println("Where is your mysql JDBC Driver?");
                        e.printStackTrace();

                }

                System.out.println("mysql JDBC Driver Registered!");

                Connection connection = null;

                try {
                	/*connection = DriverManager.getConnection(
                            "jdbc:mysql://thoughtsbookdb.chlgvjamyt8h.us-west-2.rds.amazonaws.com:3306/thoughtsbookdb", "aparnesh",
                            "aparnesh");
 */  
 /*               	
 connection = DriverManager.getConnection(
                                        "jdbc:mysql://aav17mvfuzmizt.cspugqd1dfen.us-east-2.rds.amazonaws.com:3306/ebdb?useUnicode=true&characterEncoding=utf-8", "neha",
                                        "khatri01");
 jdbc:mysql://thoughtsbookdb.chlgvjamyt8h.us-west-2.rds.amazonaws.com:3306/thoughtsbookdb?useUnicode=true&characterEncoding=utf-8
 //aav17mvfuzmizt.cspugqd1dfen.us-east-2.rds.amazonaws.com:3306
 */
                	connection = DriverManager.getConnection(
                            "jdbc:h2:~/test", "sa",
                            "");

                } catch (SQLException e) {

                        System.out.println("Connection Failed! Check output console");
                        e.printStackTrace();

                }

                if (connection != null) {
                        System.out.println("You made it, take control your database now!");
                } else {
                        System.out.println("Failed to make connection!");
                }
                return connection;
        }
        
        public static void main(String[] args) throws SQLException{
                System.out.println( "hello");
               String pass;
//                getConnection();
                Connection connection = DatabaseConnectionTest.getConnection();
               
                try{
        			System.out.println(connection) ;
        			System.out.println("$$$$$$ EmailId is $$$$$");
        			
        			String Subj="Urdi";
        		//	String sql = "SELECT PASSWORD FROM USER_REGISTRATION where EMAILID='bani@gmail.com';";
        		//running	//String sql = "select count(*) from COURSETABLE where SUBJECTS like '%' + @Subj + '%';";
        	// running		String sql = "select EMAIID,SUBJECTS from COURSETABLE where SUBJECTS like Concat('%',@Subj,'%') limit 50;";
        	//running		//String sql = "select EMAIID,SUBJECTS from COURSETABLE where SUBJECTS like Concat('%',(SELECT SUBJECTS FROM COURSETABLE WHERE SUBJECTS LIKE ? LIMIT 50),'%') ;";
        			
        			String sql = "select EMAIID,SUBJECTS from COURSETABLE where SUBJECTS like ?";
        			
        			System.out.println("$$$$$$ query executed $$$$$");
        			
        			PreparedStatement preparedStatement = connection.prepareStatement(sql);         
        			preparedStatement.setString(1, "%" + Subj + "%");

        			ResultSet res = preparedStatement.executeQuery();
        			System.out.println("res is "+res);
        			
        			while(res.next()){
        				System.out.println("inside while loop");
        				pass = res.getString(1)+res.getString(2); 
        				System.out.println("^^^^^^ PASSWORD in while is ^^^^^^^^"+pass);
        			}
        			//System.out.println("PASSWORD in getCurrentPasswordMethod is : "+ pass);
        		}
                        
                        
                       
                catch(Exception e){
                        e.printStackTrace();
                }
                finally{
                        connection.close();
                }
        }

}