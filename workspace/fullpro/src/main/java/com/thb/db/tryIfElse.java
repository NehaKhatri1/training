package com.thb.db;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Statement;

public class tryIfElse {

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
        
        private static void abc(){
        	System.out.println("abc called");
        }
        
        public static void main(String[] args) throws SQLException{
                System.out.println( "hello");
                String a="2";
//                getConnection();
                Connection connection = tryIfElse.getConnection();
                try{
                	if(a=="1"){
                	System.out.println("a is null");	
                	abc();
                	}
                	else{
                	System.out.println("a is other than 1");	
                	}
                }
                catch(Exception e){
                        e.printStackTrace();
                }
                finally{
                        connection.close();
                }
        }

}