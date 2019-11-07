package com.thb.webservice.rest.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.thb.db.DatabaseConnection;

public class DBTest {
 public static void main(String[] args) throws SQLException{
	 String allColumnsOfRows="";
		 Boolean bool = false;
			Connection connection = DatabaseConnection.getConnection();
			try{
				System.out.println(connection);
				String sql = "select * from user_registration where EMAILID='a@a.com'  ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);	
				//preparedStatement.setString(1,"emailId");
				//preparedStatement.setString(2,"category");
				//preparedStatement.setString(3,"bookid");
				//preparedStatement.setString(4,"bookName");
				
				ResultSet res = preparedStatement.executeQuery();
				java.sql.ResultSetMetaData rsmd =  res.getMetaData();
				// String name = rsmd.getColumnName(1);
				
				System.out.println("getting result ***");
				System.out.println("res is "+res);
				
				
				 java.sql.ResultSetMetaData metadata = res.getMetaData();
				    int columnCount = metadata.getColumnCount();    
				  /*  for (int i = 1; i <= columnCount; i++) {
				        writeToFile(metadata.getColumnName(i) + ", ");      
				    }*/
				    System.out.println();
				    while (res.next()) {
				  
				        for (int i = 1; i <= columnCount; i++) {
				        	allColumnsOfRows += res.getString(i) + ",";  
				            
				        }
				        
				       // allColumnsOfRows=allColumnsOfRows.concat("#");
				        
				       System.out.println("allColumnsOfRows is "+allColumnsOfRows);
				        //writeToFile(row);

				    }
				
			/*	while(res.next()){
					StudentOrTutorList = StudentOrTutorList + ","+res.getString(1);
					System.out.println("StudentOrTutorList in while loop "+StudentOrTutorList);
					
				}*/
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				connection.close();
			}
			System.out.println("****** Returning StudentOrTutorList *****"+allColumnsOfRows);
			//return StudentOrTutorList ;
			//return allColumnsOfRows;
		}
			
	 
	 
}
