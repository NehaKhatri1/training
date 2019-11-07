package com.thb.webservice.rest.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.thb.db.DatabaseConnection;

public class DBTest1 {
 public static void main(String[] args) throws SQLException{
	     String values="";
		// Boolean bool = false;
			Connection connection = DatabaseConnection.getConnection();
			try{
				System.out.println(connection);
				String sql = "select Emailid from  user_registration ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			//	preparedStatement.setString(1,"EmailId");
			//	preparedStatement.setString(2,"password");
				//preparedStatement.setString(3,"Profession");
				//preparedStatement.setString(4,"bookName");
				ResultSet res = preparedStatement.executeQuery();
				while(res.next()){
					values = values + ","+res.getString(1);
					//InvitationList = InvitationList + System.lineSeparator() +res.getString(1);
				}
			System.out.println("values are "+values);
				//bool = preparedStatement.execute();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			finally{
				connection.close();
			}
	 
	 }
}
