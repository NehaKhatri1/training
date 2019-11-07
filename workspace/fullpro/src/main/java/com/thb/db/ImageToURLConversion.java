package com.thb.db;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.cloudinary.Cloudinary;
import com.thb.db.DatabaseConnection;

public class ImageToURLConversion {

	
	
	public static String uploadImageStringAndReturnUrl(String imageString ) throws IOException{
		
		Map config = new HashMap();
		config.put("cloud_name", "www-minischoolers-com");
		config.put("api_key", "264925553866434");
		config.put("api_secret", "ufqMdeA-96TnKnONus3CV83KeP4");
		Cloudinary cloudinary = new Cloudinary(config);
		System.out.println(cloudinary);
		Map uploadResult = cloudinary.uploader().upload(imageString,config);
		System.out.println("uploaded");
		String url = (String) uploadResult.get("url");
		return url;
	}
	
	public static String executeSqlQuery(Connection connection,String sql , String param) throws SQLException{
		 String str = "";
		 String finalString = "";
		try{
           System.out.println(sql);
           PreparedStatement preparedStatement = connection.prepareStatement(sql);        
           ResultSet resultSet  = preparedStatement.executeQuery();
           System.out.println("queried");
         
           while(resultSet.next()){
        	   str = resultSet.getString(1);
        	   finalString = finalString +","+ str;
        	   
           }
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finalString = finalString.substring(1);
           return finalString;
	}
 public static void main(String[] args) throws  SQLException, IOException { 
	//public void run() throws  SQLException, IOException  {

		// total four changes where upper is local and the lower one is remote 
			 Connection connection = DatabaseConnection.getConnection();
	//	Connection connection = RemoteDataBaseConnection.getConnection();
		 
	// String sqlQueryForFetchingBookIds = "select bookid from bookdetails where bookid like '%:1' and pagecontent like '%data:image%' order by timestamp desc limit 2 ";
		 
		 String sqlQueryForFetchingBookIds = "SELECT EMAIID FROM LOCATIONTABLEWITHOUTPRIMARYKEY where PICURLDATA like '%data:image%' limit 1;";
		 
		 String returnedString = executeSqlQuery(connection, sqlQueryForFetchingBookIds , null );
		 
		 System.out.println("querid String from execute query method =>"+returnedString+"<=");
		 
		 
		 // conversion of string into linkedlist 
		 List<String> listOfBookIds = new LinkedList<String>();
		 String[] arrayOfBookIds = returnedString.split(",");
		 for(int i=0;i<arrayOfBookIds.length;i++){
			 listOfBookIds.add(arrayOfBookIds[i]);
		 }
		 System.out.println("queried book id list in list form is : "+listOfBookIds);
		 
		 
		 
         try{
        	 int siz=listOfBookIds.size();
        	 System.out.println("siz is "+siz);
        	 for(int i=0;i<listOfBookIds.size();i++){
        	 	 String param = listOfBookIds.get(i);
        	 	 System.out.println("param "+param);
                 System.out.println(connection);
         String sql = "SELECT PICURLDATA FROM LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID=? ;";
            
                 
                 System.out.println(sql);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql);        
                 preparedStatement.setString(1,param);
                 ResultSet resultSet  = preparedStatement.executeQuery();
                 System.out.println("queried imageString  "+resultSet);
                 String str = "";
                 String finalString = "";
                 while(resultSet.next()){
                	  str = resultSet.getString(1);
                	  System.out.println("str is"+str);
                	// String[] array = str.split("src=");
                	// String[] anotherArray = array[1].split("></pre>");
                	// String temp = anotherArray[0];
                	  finalString=str;
                	// finalString = (temp.substring(1,temp.length()-1));
                	  /*FileWriter fstream = new FileWriter("c:/dev/writeFile.txt");
        			  BufferedWriter out = new BufferedWriter(fstream);
        			  out.write(finalString);
        			  out.close();*/
//                	 System.out.println(finalString);
                 }
                 
                 String url = uploadImageStringAndReturnUrl(finalString);
                 System.out.println("returned url against image string after uploading on cloudinary is : "+url);
                 url ="https://res.cloudinary.com/www-minischoolers-com/image/fetch/f_auto/"+url;
                 System.out.println("returned url against image string after uploading on cloudinary is : "+url);
                 
                 
                 
           String sqlUpdation = "update LOCATIONTABLEWITHOUTPRIMARYKEY set PICURLDATA = ? where EMAIID = ? ";
              
                 
                  
                 System.out.println(sql);
                 PreparedStatement preparedStatementUpdation = connection.prepareStatement(sqlUpdation);        
                 preparedStatementUpdation.setString(1,url);
                 preparedStatementUpdation.setString(2, param);
                 preparedStatementUpdation.executeUpdate();
                 System.out.println("updated the new url of the image in our database ");
        	 }// end of for loop
         }
         catch(SQLException e){
                 e.printStackTrace();
         }
         finally{
                 connection.close();
         }
	}
}