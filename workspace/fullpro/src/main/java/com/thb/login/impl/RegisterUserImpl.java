package com.thb.login.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thb.db.DatabaseConnection;
//import com.thb.login.RegisterUser;
import com.thb.login.RegisterUser;



public class RegisterUserImpl implements RegisterUser  {

	//public Boolean register(String fullname, String emailId, String category , String gender,String Password) throws SQLException {
	public Boolean register(String userName,String EmailId,String password) throws SQLException {

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&& Inside register method &&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("********************* Connection is ***********"+connection);
			//   String sql = "insert into login values( ? , ? , ? , ?, ? ) ";
			String sql = "insert into user_registration values( ? , ? , ? , ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,null);
			preparedStatement.setString(4,userName);
			preparedStatement.setString(5,null);
			preparedStatement.setString(6,null);
			//preparedStatement.setString(5,Password);
			bool = preparedStatement.execute();
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in register method &&&&&&&&&&&&&&&&&&"+bool);

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ; 
	}

	/*
	//2nd method
	public Boolean SaveSubjects(String EmailId,String Subjects) throws SQLException {

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&& Inside register method &&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("********************* Connection is ***********"+connection);
			//   String sql = "insert into login values( ? , ? , ? , ?, ? ) ";
			String sql = "insert into EmailIdSubjectsTable values( ? , ? ) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);
			preparedStatement.setString(2,Subjects);
			// preparedStatement.setString(3,profession);
			// preparedStatement.setString(4,gender);
			//preparedStatement.setString(5,Password);
			bool = preparedStatement.execute();
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in register method &&&&&&&&&&&&&&&&&&"+bool);

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ; 
	}
*/
	//facebookUserDetailsSettingOriginalValuesMethod
			public Boolean facebookUserDetailsSettingOriginalValuesMethod(String FacebookEmailId,String FacebookUName,String facebookPassword,String facebookProfession,String facebookPhoneNo,String facebookGender) throws SQLException {

				Boolean bool = false;
				Connection connection = DatabaseConnection.getConnection();
				try{
					System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&& Inside facebookUserDetailsSettingOriginalValuesMethod &&&&&&&&&&&&&&&&&&&&&&&&&");
					System.out.println("********************* Connection is ***********"+connection);
					//   String sql = "insert into login values( ? , ? , ? , ?, ? ) ";
					String sql = "REPLACE into user_registration values( ? , ? , ? , ?, ?, ?) ";
					PreparedStatement preparedStatement = connection.prepareStatement(sql);        
					preparedStatement.setString(1,FacebookEmailId);
					preparedStatement.setString(2,facebookPassword);
				    preparedStatement.setString(3,facebookProfession);
					preparedStatement.setString(4,FacebookUName);
					preparedStatement.setString(5,facebookPhoneNo);
					preparedStatement.setString(6,facebookGender);
					//preparedStatement.setString(5,Password);
					bool = preparedStatement.execute();
					bool=true;
					System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in facebookUserDetailsSettingOriginalValuesMethod &&&&&&&&&&&&&&&&&&"+bool);

					System.out.println("******************** statement executed. ***************");

				}
				catch(SQLException e){
					e.printStackTrace();
				}
				finally{
					connection.close();
				}
				return bool ; 
			}

	
	public Boolean UserLocationInfoCapturedThroughMapMethod(String EmailId,String itemCountry,String itemPc,String itemLocality,String address)throws SQLException {

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId in method: "+EmailId);
		System.out.println("itemCountry in method: "+itemCountry);
		System.out.println("state in method "+itemPc);
		System.out.println("city in method : "+itemLocality);
		System.out.println("address in method "+address);
		
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method UserLocationInfoCapturedThroughMapMethod ^^^^^^^^^^^");
	      // String sql = "REPLACE into LOCATIONTABLEWITHOUTPRIMARYKEY values( ? , ? , ? , ? , ? , ?) ";
	       String sql = "REPLACE INTO LOCATIONTABLEWITHOUTPRIMARYKEY(EMAIID,CITY,STATE,COUNTRY,ADDRESS)VALUES(? , ? , ? , ? , ?);";
	       
	       
	       
	       
			// String sql = "UPDATE LOCATIONTABLEWITHOUTPRIMARYKEY SET COUNTRY =? ,STATE =? ,CITY =?, ADDRESS=? WHERE EMAIID =?;";
			  //EMAIID CITY STATE PICURLDATA COUNTRY ADDRESS   
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId );
			preparedStatement.setString(2,itemLocality );
			preparedStatement.setString(3,itemPc);
			preparedStatement.setString(4,itemCountry);
			preparedStatement.setString(5,address);
			//preparedStatement.setString(6,address);
			bool = preparedStatement.execute();
			
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in UserLocationInfoCapturedThroughMapMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	
	/*
	@Override
	public Boolean saveCourseAndFileldUserInfo(String emailId,String coursesValue,String fieldValue)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveCourseAndFileldUserInfo ^^^^^^^^^^^");
			String sql = "insert into CourseTable values( ? , ? , ? ) ";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,emailId);
			preparedStatement.setString(2,coursesValue);
			preparedStatement.setString(3,fieldValue);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveCourseAndFileldUserInfo &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}
*/
	
//	saveProfilePic
	
	
	public Boolean saveProfilePic(String EmailId,String PicUrlData)throws SQLException {
		// TODO Auto-generated method stub
          String EMAIID= EmailId;
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveProfilePic ^^^^^^^^^^^");
			String sql = "UPDATE LOCATIONTABLEWITHOUTPRIMARYKEY SET PICURLDATA = ? WHERE EMAIID = ?;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,PicUrlData);
			preparedStatement.setString(2,EMAIID);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&& bool in saveProfilePic &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}
	



	public void saveStandardSubjectAddressForUserName(String userName,String standard,String subject,String address) throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveStandardSubjectAddressForUserName^^^^^^^^^^^");
			String sql = "insert into userNameStandardSubjectAddress values( ? , ? , ? , ?) ";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,standard);
			preparedStatement.setString(3,subject);
			preparedStatement.setString(4,address);
			bool = preparedStatement.execute();

			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in add method &&&&&&&&&&&&&&&&&&"+bool);

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}

	}

	   
/*
	public Boolean updateNameEmailPhoneMethod(String userName,String phoneNo,String genderValue,String EmailId)throws SQLException {
		// TODO Auto-generated method stub
        //String EMAIID=EmailId;
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method updateNameEmailPhoneMethod ^^^^^^^^^^^");
			String sql = "UPDATE USER_REGISTRATION SET USERNAME =? ,PHONENO =? ,GENDER =? WHERE EmailId =?;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);    
			
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,phoneNo);
			preparedStatement.setString(3,genderValue);
			preparedStatement.setString(4,EmailId);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in updateNameEmailPhoneMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	*/
	
	
	
	public Boolean updateNameEmailPhoneMethod(String nameVal,String contactNoVal,String genderVal,String EmailId)throws SQLException {
		// TODO Auto-generated method stub
        //String EMAIID=EmailId;
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method updateNameEmailPhoneMethod ^^^^^^^^^^^");
			//String sql = "UPDATE USER_REGISTRATION SET USERNAME =? ,PHONENO =? ,GENDER =? WHERE EmailId =?;";
		//	String sql = "INSERT INTO USER_REGISTRATION(EMAILID,USERNAME,PHONENO,GENDER)VALUES(?,?,?,?)ON DUPLICATE KEY UPDATE USERNAME=VALUES(USERNAME),PHONENO=VALUES(PHONENO),GENDER=VALUES(GENDER);";
			String sql = "REPLACE INTO USER_REGISTRATION (EMAILID,USERNAME,PHONENO,GENDER)VALUES(?,?,?,?);";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);    
			
			
			preparedStatement.setString(1,EmailId);
			preparedStatement.setString(2,nameVal);
			preparedStatement.setString(3,contactNoVal);
			preparedStatement.setString(4,genderVal);
			
		
			/*preparedStatement.setString(1,nameVal);
			preparedStatement.setString(2,contactNoVal);
			preparedStatement.setString(3,genderVal);
			preparedStatement.setString(4,EmailId);
			*/
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in updateNameEmailPhoneMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	
	
	
	
	
	public Boolean saveSenderDetailsMethod(String RecipientEmailId,String SenderEmailId,String SenderImage,String SenderName,String SenderSubjects)throws SQLException {
		// TODO Auto-generated method stub
         // String EMAIID= EmailId;
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveSenderDetailsMethod ^^^^^^^^^^^");
		        String sql ="insert into INVITATIONTABLE values( ?, ?, ?, ?, ? ,?);";
			System.out.println("sql statement allTime"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
		preparedStatement.setString(1,RecipientEmailId);
		preparedStatement.setString(2,SenderEmailId);
		preparedStatement.setString(3,SenderImage);
		preparedStatement.setString(4,SenderName);
		//preparedStatement.setString(5,SenderCourse);
	//	preparedStatement.setString(6,SenderField);
		preparedStatement.setString(5,SenderSubjects);
		preparedStatement.setString(6,null);
		
		
		System.out.println("query parameters set."+sql);

			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&& bool in saveSenderDetailsMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}
	
	
	
	
	//sendInvitationForFirstTimeLoggedInUserMethod
	

/*	public Boolean sendInvitationForFirstTimeLoggedInUserMethod(String RecipientEmailId,String SenderEmailId,String SenderImage,String SenderName,String SenderSubjects)throws SQLException {
		// TODO Auto-generated method stub
         // String EMAIID= EmailId;
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveSenderDetailsMethod ^^^^^^^^^^^");
		        String sql ="insert into INVITATIONTABLE values( ?, ?, ?, ?, ? ,?);";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
		preparedStatement.setString(1,RecipientEmailId);
		preparedStatement.setString(2,SenderEmailId);
		preparedStatement.setString(3,SenderImage);
		preparedStatement.setString(4,SenderName);
		preparedStatement.setString(5,SenderSubjects);
		preparedStatement.setString(6,null);
		
		System.out.println("query parameters set."+sql);

			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&& bool in saveSenderDetailsMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}
	
*/
	
	
	public Boolean deleteNotificationRowMethod(String senderEmailId)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ Delete method deleteNotificationRowMethod ^^^^^^^^^^^");
			String sql = "delete INVITATIONTABLE where SENDEREMAILID= ?;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,senderEmailId);
			
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in deleteNotificationRowMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	
	public Boolean saveCommaSepratedListOfSubjectsMethod(String emailId,String commaSepratedListOfSubjects)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveCommaSepratedListOfSubjectsMethod ^^^^^^^^^^^");
			String sql = "insert into CourseTable values( ? , ? ) ";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,emailId);
			preparedStatement.setString(2,commaSepratedListOfSubjects);
			//preparedStatement.setString(3,fieldValue);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveCommaSepratedListOfSubjectsMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	

	public Boolean saveEditedLocalityCityDistrictStateInfoForUser(String emailId,String city, String district, String state,String locality)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveLocalityCityDistrictStateInfoForUser ^^^^^^^^^^^");
			String sql = "update LOCATIONTABLEWITHOUTPRIMARYKEY set CITY = ? , DISTRICT = ? , STATE  = ? , LOCALITY = ? where EMAIID = ?;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,city);
			preparedStatement.setString(2,district);
			preparedStatement.setString(3,state);
			preparedStatement.setString(4,locality);
            preparedStatement.setString(5,emailId);
			//preparedStatement.setString(6,null);

			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveLocalityCityDistrictStateInfoForUser &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}
	
	
	
	public Boolean SavedEditedSubjectsMethod(String emailId,String editedSubjects)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveCommaSepratedListOfSubjectsMethod ^^^^^^^^^^^");
			String sql = "update COURSETABLE set SUBJECTS= ? where EMAIID= ? ;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,editedSubjects);
			preparedStatement.setString(2,emailId);
			//preparedStatement.setString(3,fieldValue);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveCommaSepratedListOfSubjectsMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	

	public Boolean googleUserDetailsRegistration(String googleEmailid,String googleUserName) throws SQLException {

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&& Inside googleUserDetailsRegistration method &&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("********************* Connection is ***********"+connection);
			//   String sql = "insert into login values( ? , ? , ? , ?, ? ) ";
			String sql = "REPLACE into user_registration values( ? , ? , ? , ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,googleEmailid);
			preparedStatement.setString(2,null);
		    preparedStatement.setString(3,null);
			preparedStatement.setString(4,googleUserName);
			preparedStatement.setString(5,null);
			preparedStatement.setString(6,null);
			//preparedStatement.setString(5,Password);
			bool = preparedStatement.execute();
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in googleUserDetailsRegistration method &&&&&&&&&&&&&&&&&&"+bool);

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ; 
	}

	
	
	

	public Boolean facebookUserDetailsRegistration(String FacebookEmailId,String FacebookUName,String FacebookUGender) throws SQLException {

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&& Inside facebookUserDetailsRegistration method &&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("********************* Connection is ***********"+connection);
			//   String sql = "insert into login values( ? , ? , ? , ?, ? ) ";
			String sql = "REPLACE into user_registration values( ? , ? , ? , ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,FacebookEmailId);
			preparedStatement.setString(2,null);
			preparedStatement.setString(3,null);
			preparedStatement.setString(4,FacebookUName);
			preparedStatement.setString(5,null);
			preparedStatement.setString(6,FacebookUGender);
			//preparedStatement.setString(5,Password);
			bool = preparedStatement.execute();
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in facebookUserDetailsRegistration method &&&&&&&&&&&&&&&&&&"+bool);

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ; 
	}

	
	
	

	public Boolean saveProfession(String emailId,String professionValue,String phoneValue)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveProfession ^^^^^^^^^^^");
			String sql = "update USER_REGISTRATION set PROFESSION=? ,PHONENO=? where EMAILID =?; ";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,professionValue);
			preparedStatement.setString(2,phoneValue);
			preparedStatement.setString(3,emailId);
			//preparedStatement.setString(3,district);
			//preparedStatement.setString(4,state);
			//preparedStatement.setString(5,locality);
			//preparedStatement.setString(6,null);
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveProfession &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	

	public Boolean handshakeFlagSetMethod(String senderEmailId,String RecipientEmailId)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method handshakeFlagSetMethod ^^^^^^^^^^^");
			String sql = "update INVITATIONTABLE set HANDSHAKEFLAG ='YES' where senderEmailId =? and RecipientEmailId= ?; ";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,senderEmailId);
			preparedStatement.setString(2,RecipientEmailId);
			//preparedStatement.setString(3,district);
			//preparedStatement.setString(4,state);
			//preparedStatement.setString(5,locality);
			//preparedStatement.setString(6,null);
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in handshakeFlagSetMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	
	
	//googleUserDetailsSettingOriginalValuesMethod
	public Boolean googleUserDetailsSettingOriginalValuesMethod(String googleEmailid,String googleUserName,String googlePassword,String googleProfession,String googlePhoneNo,String googleGender) throws SQLException {

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&& Inside googleUserDetailsSettingOriginalValuesMethod &&&&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println("********************* Connection is ***********"+connection);
			//   String sql = "insert into login values( ? , ? , ? , ?, ? ) ";
			String sql = "REPLACE into user_registration values( ? , ? , ? , ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,googleEmailid);
			preparedStatement.setString(2,googlePassword);
		    preparedStatement.setString(3,googleProfession);
			preparedStatement.setString(4,googleUserName);
			preparedStatement.setString(5,googlePhoneNo);
			preparedStatement.setString(6,googleGender);
			//preparedStatement.setString(5,Password);
			bool = preparedStatement.execute();
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in googleUserDetailsSettingOriginalValuesMethod &&&&&&&&&&&&&&&&&&"+bool);

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ; 
	}

	
	
	public Boolean updateRecoveryPasswordMethod(String recoveryEmailId,String randomPassword)throws SQLException {
		// TODO Auto-generated method stub
        //String EMAIID=EmailId;
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection in method updateRecoveryPassword "+connection);
			System.out.println("**** randomPassword is ***"+recoveryEmailId);
			System.out.println("**** recoveryEmailId is *** "+randomPassword);
			
			System.out.println(" ^^^^^^^^^^^ inside method updateRecoveryPasswordMethod ^^^^^^^^^^^");
			String sql = "UPDATE USER_REGISTRATION SET PASSWORD =? WHERE EmailId =?;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);    
			
			preparedStatement.setString(1,randomPassword);
			preparedStatement.setString(2,recoveryEmailId);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in updateNameEmailPhoneMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	public Boolean savePhoneNo(String emailId,String phoneValue)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method savePhoneNo ^^^^^^^^^^^");
			String sql = "update USER_REGISTRATION set PHONENO=? where EMAILID =?; ";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,phoneValue);
			preparedStatement.setString(2,emailId);
			//preparedStatement.setString(3,district);
			//preparedStatement.setString(4,state);
			//preparedStatement.setString(5,locality);
			//preparedStatement.setString(6,null);
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in savePhoneNo &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}


	
	
	
	
	public Boolean saveNewPassword(String emailId,String newPass)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveNewPassword ^^^^^^^^^^^");
			String sql = "update USER_REGISTRATION set PASSWORD=? where EMAILID =?; ";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,newPass);
			preparedStatement.setString(2,emailId);
			//preparedStatement.setString(3,district);
			//preparedStatement.setString(4,state);
			//preparedStatement.setString(5,locality);
			//preparedStatement.setString(6,null);
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveNewPassword &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	
	
	
	
	public Boolean saveAttributesMethod(String EmailId,String displayTitleValue,String strategyValue,String backgroundValue)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveAttributesMethod ^^^^^^^^^^^");
			//String sql = "update USER_ATTRIBUTE set TITLE= ?,STRATEGY=?,BACKGROUND=? where EMAILID= ? ;";
            String sql ="REPLACE INTO USER_ATTRIBUTE(EMAILID,TITLE,STRATEGY,BACKGROUND)VALUES(?,?,?,?);";
		    System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);
			preparedStatement.setString(2,displayTitleValue);
			preparedStatement.setString(3,strategyValue);
			preparedStatement.setString(4,backgroundValue);
			//preparedStatement.setString(3,fieldValue);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveAttributesMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	
	
	
	

	public Boolean SaveEditedRatesMethod(String emailId,String editedRates)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method SaveEditedRatesMethod ^^^^^^^^^^^");
			String sql = "update USER_ATTRIBUTE set RATES= ? where EMAILID= ? ;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,editedRates);
			preparedStatement.setString(2,emailId);
			//preparedStatement.setString(3,fieldValue);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in SaveEditedRatesMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	

	public Boolean saveInventoryDataMethod(String StoreEmailIdCategoryCombination,String category,String itemsList)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveInventoryDataMethod ^^^^^^^^^^^");
			String sql = "REPLACE INTO STORESINVENTORY(SEID,CATEGORY ,CVALUES)VALUES( ? ,? , ? );";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,StoreEmailIdCategoryCombination);
			preparedStatement.setString(2,category);
			preparedStatement.setString(3,itemsList);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in StoreEmailId &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	

	
	

	public Boolean saveStoreNameEmailIdMethod(String storeNameValue,String emailIdValue,String StoreEmailIdCategoryCombination)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveStoreNameEmailIdMethod ^^^^^^^^^^^");
			String sql = "UPDATE STORESINVENTORY  SET STORENAME =? ,EMAILID =? WHERE SEID =?;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,storeNameValue);
			preparedStatement.setString(2,emailIdValue);
			preparedStatement.setString(3,StoreEmailIdCategoryCombination);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveStoreNameEmailIdMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	

	public Boolean saveContactNoBankDetailsMethod(String emailIdValue,String contactNoValue,String bankAccountValue)throws SQLException {
		// TODO Auto-generated method stub

		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("connection is"+connection);
			System.out.println(" ^^^^^^^^^^^ inside method saveContactNoBankDetailsMethod ^^^^^^^^^^^");
			String sql = "UPDATE STORESINVENTORY  SET CONTACTNO =? ,BANKACCOUNT =? WHERE EMAILID =?;";
			System.out.println("sql statement"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,contactNoValue);
			preparedStatement.setString(2,bankAccountValue);
			preparedStatement.setString(3,emailIdValue);
			
			bool = preparedStatement.execute();
            
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in saveContactNoBankDetailsMethod &&&&&&&&&&&&&&&&&&"+bool);
			

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ;
	}

	
	
	
	
	
	public void saveBookDetails(String username, String category, String bookName, String pageNumber,
			String pageContent) throws SQLException {
		// TODO Auto-generated method stub
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			// first of all , check whether the book already exists , if so update the details of
			// page content and topic in the same book
			/*String sqlToFetchBookList = "select bookname from bookdetails";
                        PreparedStatement preparedStatementForBookList = connection.prepareStatement(sqlToFetchBookList);
                        ResultSet resutlSet = preparedStatementForBookList.executeQuery();
                        String bookList = "";
                        while(resutlSet.next()){
                                bookList  = bookList + "," + resutlSet.getString(1);
                        }
                        if(bookList.contains(bookName)){
                                System.out.println("this is the updation case");
                                String sqlForUpdation = " update bookdetails set pagecontent = ? , topicnumberandname = ?  where bookname= ?  and username= ?  and category = ?  ";
                                PreparedStatement preparedStatementForUpdation = connection.prepareStatement(sqlForUpdation);
                                preparedStatementForUpdation.setString(1, pageContent);
                                preparedStatementForUpdation.setString(2, pageNumber);
                                preparedStatementForUpdation.setString(3, bookName);
                                preparedStatementForUpdation.setString(4, username);
                                preparedStatementForUpdation.setString(5, category);
                                Boolean boolForUpdation = preparedStatementForUpdation.execute();
                        }*/

			// insert new book details 

			// parsing to get the topic number from the page number
			String[] strArrayOfTopicNumberAndTopicContent = pageNumber.split(":");
			String topicNumber = strArrayOfTopicNumberAndTopicContent[0];
			String bookId = bookName+":"+topicNumber;

			/**
			 *
			 * If you find bookId repeated on similar concept of above commented code , in that case just update the 
			 * page content . 
			 */

			String sqlToFetchBookIdList = "select bookId from bookDetails";
			PreparedStatement preparedStatementForBookIdList = connection.prepareStatement(sqlToFetchBookIdList);
			ResultSet resutlSet = preparedStatementForBookIdList.executeQuery();
			String bookIdList = "";
			while(resutlSet.next()){
				bookIdList  = bookIdList + "," + resutlSet.getString(1);
			}

			if(bookIdList.contains(bookId)){
				System.out.println("this is the updation case");
				String sqlForUpdation = " update bookDetails set pagecontent = ? , topicnumberandname = ?  where bookId= ?  and username= ?  and category = ?  ";
				PreparedStatement preparedStatementForUpdation = connection.prepareStatement(sqlForUpdation);
				preparedStatementForUpdation.setString(1, pageContent);
				preparedStatementForUpdation.setString(2, pageNumber);
				preparedStatementForUpdation.setString(3, bookId);
				preparedStatementForUpdation.setString(4, username);
				preparedStatementForUpdation.setString(5, category);
				Boolean boolForUpdation = preparedStatementForUpdation.execute();
			}


			/**
			 * Write code for book id having book name appended with topic number ( after parsing first element of 
			 * page number ) . Insert book detail in bookId . 
			 */

			else{
				System.out.println(connection);
				System.out.println("this is the new book details insertion case ");
				String sql = "insert into bookDetails values ( ? , ? , ? , ? , ? , ?) ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);        
				// preparedStatement.setString(1,bookId);
				preparedStatement.setString(2,bookName);
				preparedStatement.setString(3, pageContent);
				preparedStatement.setString(4, username);
				preparedStatement.setString(5, category);
				preparedStatement.setString(6, pageNumber);
				System.out.println("Saving of the book details is done");
				bool = preparedStatement.execute();
			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
	}


	

} 