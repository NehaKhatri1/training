
package com.thb.login.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.thb.db.DatabaseConnection;
import com.thb.login.Authenticate;
import com.thb.model.RegisterBean;

public class AuthenticateImpl implements Authenticate{

	String serverDb = " count is 6";
	String localDb = "";


	public Boolean authenticateLoginData(String emailId, String password) throws SQLException {
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select password from USER_REGISTRATION where emailId = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,emailId); //first placeholder is username. 
			ResultSet res = preparedStatement.executeQuery();
			String str = "";
			while(res.next()){
				str = str + res.getString(1);
			}
			System.out.println("password fetched from db for userid :"+str+":");         
			if(str.equalsIgnoreCase(password)){
				System.out.println("******** matched *************");
				bool = true ; 
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("bool:"+bool);
		return bool ; 
	}


	/*
	public String getTutorsOrStudentsProfileInListMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		System.out.println("**** Executing method  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select * from USER_REGISTRATION  where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID = ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				StudentOrTutorList = StudentOrTutorList + ","+res.getString(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning StudentOrTutorList *****"+StudentOrTutorList);
		return StudentOrTutorList ;
	}

	 */

	
/*
	///"+EmailId+"/"+coursesValue+"/"+fieldValue+"/"+state+"/"+city+"/"+district,

	public String getTutorsOrStudentsProfileInListMethod(String EMAILID,String course,String field,String state,String city,String district) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EMAILID);
		System.out.println("coursesValue is : "+course);
		System.out.println("fieldValue is "+field);
		System.out.println("state is : "+state);
		System.out.println("city is "+city);
		System.out.println("district is : "+district);


		System.out.println("**** Executing method  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.*,COURSETABLE.COURSE,COURSETABLE.FIELD from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and course=? and field=? and state=? and city=? and district=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID = ?) );";
			System.out.println("sql statement "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,course);
			preparedStatement.setString(2,field);
			preparedStatement.setString(3,state);
			preparedStatement.setString(4,city);
			preparedStatement.setString(5,district);
			preparedStatement.setString(6,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			System.out.println("getting result ***");
			System.out.println("res is "+res);

			while(res.next()){
				StudentOrTutorList = StudentOrTutorList + ","+res.getString(1);
				System.out.println("StudentOrTutorList in while loop "+StudentOrTutorList);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning StudentOrTutorList *****"+StudentOrTutorList);
		return StudentOrTutorList ;
	}

*/

	/* commenting first  
        public Boolean SendInvitationMethod(String EMAILID,String INVITEDBY) throws SQLException {
            // TODO Auto-generated method stub
        	Boolean bool = false;
            System.out.println("**** SendRequestMethod called *****");


            Connection connection = DatabaseConnection.getConnection();

            try{
            	// EMAILID="'"+EMAILID+"'";
            	// INVITEDBY="'"+INVITEDBY+"'";


                    System.out.println("********connection is *******"+connection);
                    System.out.println("********EmailId is ******* "+EMAILID); 
                    System.out.println("********InvitedBy is ******* "+INVITEDBY);

                   // System.out.println("******** EMAILID1 is ******* "+EMAILID1);
                   // System.out.println("********INVITEDBY1 is ******* "+INVITEDBY1);



                    String sql ="UPDATE DUMMY1 SET INVITEDBY= ? WHERE EMAILID= ?;";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);        
                   preparedStatement.setString(1,EMAILID);
                    preparedStatement.setString(2,INVITEDBY); 
                    System.out.println("query parameters set."+sql);

                    //ResultSet res 
                  //  bool= preparedStatement.execute();
                    preparedStatement.executeUpdate();

               /*     while(res.next()){
                    //	StudentOrTutorList = StudentOrTutorList + ","+res.getString(1);
                    	InvitedBy = res.getString(1) + ":" + res.getString(2);
                    } 
                    bool=true;
                    System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in SendInvitationMethod &&&&&&&&&&&&&&&&&&"+bool);

                    System.out.println("******************** statement executed. ***************");

            }
            catch(SQLException e){ 
                    e.printStackTrace();
            }
            finally{
                    connection.close();
            }
           System.out.println("****** Returning bool from subordinate *****"+bool);
            return bool ;
    }
	 */


	//second method 
/*
	@Override
	public Boolean sendInvitationForFirstTimeLoggedInUserMethod(String SenderEmailId,String RecipientEmailId) throws SQLException {
		// TODO Auto-generated method stub
		Boolean bool = false;
		System.out.println("**** SendRequestMethod called *****");


		Connection connection = DatabaseConnection.getConnection();

		try{
			// EMAILID="'"+EMAILID+"'";
			// INVITEDBY="'"+INVITEDBY+"'";


			System.out.println("********connection is *******"+connection);
			System.out.println("********SenderEmailId is ******* "+SenderEmailId); 
			System.out.println("********RecipientEmailId is ******* "+RecipientEmailId);

			// System.out.println("******** EMAILID1 is ******* "+EMAILID1);
			// System.out.println("********INVITEDBY1 is ******* "+INVITEDBY1);



			String sql ="insert into INVITATIONTABLE values( ?, ?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,SenderEmailId);
			preparedStatement.setString(2,RecipientEmailId); 
			System.out.println("query parameters set."+sql);

			//ResultSet res 
			bool= preparedStatement.execute();
			//preparedStatement.executeUpdate();

			/*     while(res.next()){
                    //	StudentOrTutorList = StudentOrTutorList + ","+res.getString(1);
                    	InvitedBy = res.getString(1) + ":" + res.getString(2);
                    } *
			bool=true;
			System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in SendInvitationMethod &&&&&&&&&&&&&&&&&&"+bool);

			System.out.println("******************** statement executed. ***************");

		}
		catch(SQLException e){ 
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning bool from subordinate *****"+bool);
		return bool ;
	}
*/


/*
	@Override
	public String receiveInvitationInListMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String InvitationList = "";
		System.out.println("**** Executing method  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select SENDEREMAILID from INVITATIONTABLE where RECIPIENTEMAILID = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				InvitationList = InvitationList + ","+res.getString(1);
				//InvitationList = InvitationList + System.lineSeparator() +res.getString(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning InvitationList *****"+InvitationList);
		return InvitationList ;
	}

	*/
	
	
	// Method to verify If user already selected(Means not first time user) subjects from MutlipleSubjectSelectionDiv.


	public String verifyIfUserLogInFirstTimeOrNotMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String SubjectList = "";
		System.out.println("**** Executing verifyIfUserLogInFirstTimeOrNotMethod method  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			//String sql = "select STATE from LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID = ?;";
			String sql = "SELECT SUBJECTS FROM COURSETABLE where EMAIID = ?;";
			
			
			//SELECT PROFESSION  FROM USER_REGISTRATION where EMAILID='ya@y.com';
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				SubjectList = SubjectList + ","+res.getString(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning State *****"+SubjectList);
		return SubjectList ;
	}



	
	public String getUserProfileDataMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String allColumnsOfRows = "";
		System.out.println("**** Executing getUserProfileDataMethod   &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			//String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.DISTRICT,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID = ? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID ;";
			String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID = ? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID ;";
			
             
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			// preparedStatement.setString(2, category);
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
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

				//  allColumnsOfRows=allColumnsOfRows.concat("#");

				System.out.println("allColumnsOfRows is "+allColumnsOfRows);
				//writeToFile(row);

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning userProfileData *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}


/*
	//getTutorsOrStudentsProfileAllTimeMethod

	@Override
	public String getTutorsOrStudentsProfileAllTimeMethod(String EMAILID,String commaSepratedListOfSubjects,String state,String city,String district) throws SQLException {
		// TODO Auto-generated method stub
		String allTimeMatches = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EMAILID);
		System.out.println("commaSepratedListOfSubjects is : "+commaSepratedListOfSubjects);
		System.out.println("state is : "+state);
		System.out.println("city is "+city);
		System.out.println("district is : "+district);


		System.out.println("**** Executing method  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.DISTRICT,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.COURSE,COURSETABLE.FIELD  from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID  and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and course=? and field=? and state=? and city=?  and district=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID = ?) );";
			System.out.println("sql statement "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,course);
			preparedStatement.setString(2,field);
			preparedStatement.setString(3,state);
			preparedStatement.setString(4,city);
			preparedStatement.setString(5,district);
			preparedStatement.setString(6,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			System.out.println("getting result of getTutorsOrStudentsProfileAllTimeMethod ***");
			System.out.println("res is "+res);

			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result ***");
			System.out.println("resulit of getTutorsOrStudentsProfileAllTimeMethod is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					allTimeMatches += res.getString(i) + " khatri_neha01 ";  

				}

				allTimeMatches=allTimeMatches.concat("#");

				//System.out.println("allTimeMatches is "+allTimeMatches);
				//writeToFile(row);

			}


			/*		while(res.next()){
				allTimeMatches = allTimeMatches + ","+res.getString(1);
				System.out.println("allTimeMatches inside while "+allTimeMatches);

			}*
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		//System.out.println("****** Returning allTimeMatches *****"+allTimeMatches);
		return allTimeMatches ;
	}
*/

	/*
 @Override
public String getTutorsOrStudentsProfileInListMethod(String EMAILID,String course,String field,String state,String city,String district) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EMAILID);
		System.out.println("courses is : "+course);
		System.out.println("field is "+field);
		System.out.println("state is : "+state);
		System.out.println("city is "+city);
		System.out.println("district is : "+district);

  
		System.out.println("**** Executing StudentOrTutorList  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.DISTRICT,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.COURSE,COURSETABLE.FIELD  from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID  and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and course=? and field=? and state=? and city=?  and district=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID = ?) );";
			System.out.println("sql statement "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,course);
			preparedStatement.setString(2,field);
			preparedStatement.setString(3,state);
			preparedStatement.setString(4,city);
			preparedStatement.setString(5,district);
			preparedStatement.setString(6,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			System.out.println("getting result of getTutorsOrStudentsProfileInListMethod ***");
			System.out.println("result of getTutorsOrStudentsProfileInListMethod is "+res);

			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result ***");
			System.out.println("resulit of getTutorsOrStudentsProfileAllTimeMethod is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					StudentOrTutorList += res.getString(i) + " khatri_neha01 ";   

				}

				StudentOrTutorList=StudentOrTutorList.concat("#");

				//System.out.println("StudentOrTutorList is "+StudentOrTutorList);
				//writeToFile(row);

			}

			/*while(res.next()){
				StudentOrTutorList = StudentOrTutorList + ","+res.getString(1);
				System.out.println("StudentOrTutorList in while loop "+StudentOrTutorList);
			}*
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning StudentOrTutorList *****"+StudentOrTutorList);
		return StudentOrTutorList ;
	}
	 */

/*
 public String receiveInvitationInListMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String InvitationList = "";
		System.out.println("**** Executing method  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select SENDEREMAILID  from INVITATIONTABLE where RECIPIENTEMAILID = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			System.out.println("getting result of receiveInvitationInListMethod ***");
			System.out.println("result of receiveInvitationInListMethod is "+res);

			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			

			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					InvitationList += res.getString(i) + ",";  

				}

				InvitationList=InvitationList.concat("#");

				System.out.println("InvitationList is "+InvitationList);
				//writeToFile(row);

			}

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning InvitationList *****"+InvitationList);
		return InvitationList ;
	}

	*/

/*
 
@Override
public Boolean sendInvitationAllTimeMethod(String SenderEmailId,String RecipientEmailId) throws SQLException {
	// TODO Auto-generated method stub
	Boolean bool = false;
	System.out.println("**** sendInvitationAllTimeMethod called *****");


	Connection connection = DatabaseConnection.getConnection();

	try{
		// EMAILID="'"+EMAILID+"'";
		// INVITEDBY="'"+INVITEDBY+"'";
 

		System.out.println("********connection is *******"+connection);
		System.out.println("********SenderEmailId is ******* "+SenderEmailId); 
		System.out.println("********RecipientEmailId is ******* "+RecipientEmailId);

		// System.out.println("******** EMAILID1 is ******* "+EMAILID1);
		// System.out.println("********INVITEDBY1 is ******* "+INVITEDBY1);



		String sql ="insert into INVITATIONTABLE values( ?, ?);";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);        
		preparedStatement.setString(1,SenderEmailId);
		preparedStatement.setString(2,RecipientEmailId); 
		System.out.println("query parameters set."+sql);

		//ResultSet res 
		bool= preparedStatement.execute();
		//preparedStatement.executeUpdate();

		/*     while(res.next()){
                //	StudentOrTutorList = StudentOrTutorList + ","+res.getString(1);
                	InvitedBy = res.getString(1) + ":" + res.getString(2);
                } *
		bool=true;
		System.out.println(" &&&&&&&&&&&&&&&&&&&& bool in sendInvitationAllTimeMethod &&&&&&&&&&&&&&&&&&"+bool);

		System.out.println("******************** statement executed. ***************");

	}
	catch(SQLException e){ 
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	System.out.println("****** Returning bool from sendInvitationAllTimeMethod *****"+bool);
	return bool ;
}
	 */

	
	public RegisterBean getProfilePic(String EmailId) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("****## getProfilePic called ###############*****");
		Connection connection = DatabaseConnection.getConnection();
		RegisterBean registerBean = new RegisterBean();
		String EMAIID=EmailId;
		System.out.println("$$$$$$ EMAIID is $$$$$"+EMAIID);
		try{

            String sql = "SELECT PICURLDATA from LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);        
            preparedStatement.setString(1,EMAIID);
            ResultSet res = preparedStatement.executeQuery();
            String str = "";
            while(res.next()){
                    str = str + res.getString(1);
            }
            //                 System.out.println(str);
           // String[] stryArray = str.split("aparnesh-gaurav");


//            System.out.println(stryArray[0]);
//            System.out.println(stryArray[1]);
//            System.out.println(stryArray[2]);


            
           // registerBean.setUserName(userName);
           // registerBean.setPassword(stryArray[0]);
           // registerBean.setSex(stryArray[1]);
            registerBean.setUrlData(str);
            System.out.println(" &&&&&&&&&&&&&&&&&&&& registerBean in getProfilePic method &&&&&&&&&&&&&&&&&&"+registerBean);

			System.out.println("******************** statement executed. ***************");

            //             System.out.println(str);         
    }
    catch(SQLException e){
            e.printStackTrace();
    }
    finally{
            connection.close();
    }
    System.out.println("****** Returning registerBean from getProfilePic  *****"+registerBean);
    return registerBean;
}
 
 

public String getUserNameMethod(String EmailId)throws SQLException{
	System.out.println("****((((((((((( getUserNameMethod called )))))))))))))");
	String username = "";
	Connection connection = DatabaseConnection.getConnection();
	try{
		System.out.println(connection) ;
		System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
		String sql = "SELECT USERNAME FROM USER_REGISTRATION where EmailId=?;";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);        
		preparedStatement.setString(1,EmailId);
		
		ResultSet res = preparedStatement.executeQuery();
		while(res.next()){
			System.out.println("inside while loop");
			username = res.getString(1); 
			System.out.println("^^^^^^ username in while is ^^^^^^^^"+username);
		}
		System.out.println("user name in getUserNameMethod is : "+ username);
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	System.out.println("Returning username from getUserNameMethod : "+ username);
	
	return username ;
}

//getAddressMethod

	
public String getAddressMethod(String EmailId)throws SQLException{
	System.out.println("<<<<<<<<<<<<<< getAddressMethod called >>>>>>>>>>>>>>>>>");
	String address = "";
	String EMAIID=EmailId;
	Connection connection = DatabaseConnection.getConnection();
	try{
		System.out.println(connection) ;
		System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
		//String sql = "SELECT CITY,DISTRICT,STATE,LOCALITY FROM LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID =?;";
		String sql = "SELECT CITY,STATE FROM LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID =?;";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);        
		preparedStatement.setString(1,EMAIID);
		ResultSet res = preparedStatement.executeQuery();
		
		while(res.next()){
			System.out.println("inside while loop");
		//	address = res.getString(1)+","+res.getString(2)+","+res.getString(3)+"#"+res.getString(4); 
			address = res.getString(1)+","+res.getString(2); 
			System.out.println("^^^^^^ address in while is ^^^^^^^^"+address);
		}
		System.out.println("address in getAddressMethod is : "+ address);
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	System.out.println("Returning address from getAddressMethod : "+ address);
	
	return address ;
}


	public String getUpdatedNamePhoneNoMethod(String EmailId)throws SQLException{
		System.out.println("--***------*****-----***** getUpdatedNamePhoneNoMethod called --***------*****-----***** ");
		String updatedNameAndPhone = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
			String sql = "SELECT USERNAME,PHONENO FROM USER_REGISTRATION where EmailId=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				updatedNameAndPhone = res.getString(1)+","+res.getString(2); 
				System.out.println("^^^^^^ updatedNameAndPhone in while is ^^^^^^^^"+updatedNameAndPhone);
			}

			System.out.println("updatedNameAndPhone in getUpdatedNamePhoneNoMethod is : "+updatedNameAndPhone);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning updatedNameAndPhone from getUpdatedNamePhoneNoMethod : "+ updatedNameAndPhone);

		return updatedNameAndPhone ;
	}



	public String getPhoneNoMethod(String EmailId)throws SQLException{
		System.out.println("****(( getPhoneNoMethod called )***********");
		String phoneNo = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
			String sql = "SELECT PHONENO FROM USER_REGISTRATION where EmailId=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				phoneNo = res.getString(1); 
				System.out.println("^^^^^^ phoneNo in while is ^^^^^^^^"+phoneNo);
			}
			System.out.println("phoneNo in getUserNameMethod is : "+ phoneNo);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning phoneNo from getUserNameMethod : "+phoneNo);

		return phoneNo ;
	}



	public RegisterBean automaticallyLoadingProfilePicJustAfterLoginMethod(String EmailId) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("****## automaticallyLoadingProfilePicJustAfterLoginMethod called ###############*****");
		Connection connection = DatabaseConnection.getConnection();
		RegisterBean registerBean = new RegisterBean();
		String EMAIID=EmailId;
		System.out.println("$$$$$$ EMAIID is $$$$$"+EMAIID);
		try{

           String sql = "SELECT PICURLDATA from LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID= ?;";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);        
           preparedStatement.setString(1,EMAIID);
           ResultSet res = preparedStatement.executeQuery();
           String str = "";
           while(res.next()){
                   str = str + res.getString(1);
           }
          
           registerBean.setUrlData(str);
        //   System.out.println(" &&&&&&&&&&&&&&&&&&&& registerBean in automaticallyLoadingProfilePicJustAfterLoginMethod method &&&&&&&&&&&&&&&&&&"+registerBean);

			System.out.println("******************** statement executed. ***************");

           //             System.out.println(str);         
   }
   catch(SQLException e){
           e.printStackTrace();
   }
   finally{
           connection.close();
   }
   System.out.println("****** Returning registerBean from automaticallyLoadingProfilePicJustAfterLoginMethod  *****"+registerBean);
   return registerBean;
}



	public RegisterBean getSenderOtherDetailsAllTimeMethod(String SenderEmailId) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("****## getSenderOtherDetailsAllTimeMethod called ###############*****");
		Connection connection = DatabaseConnection.getConnection();
		RegisterBean registerBean = new RegisterBean();
		String EMAILID=SenderEmailId;
		System.out.println("&&&&&& SenderEmailId is &&&&&"+SenderEmailId);
		try{

           String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME,COURSETABLE.SUBJECTS from USER_REGISTRATION,LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE  where USER_REGISTRATION.EMAILID=? and USER_REGISTRATION.EMAILID =LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID AND COURSETABLE.EMAIID=LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID;";
           PreparedStatement preparedStatement = connection.prepareStatement(sql);        
           preparedStatement.setString(1,EMAILID);
           ResultSet res = preparedStatement.executeQuery();
           String str = "";
           while(res.next()){
				//str = str + res.getString(1)+" *&mumtaaj@$ "+res.getString(2)+" *&mumtaaj@$ "+res.getString(3)+" *&mumtaaj@$ "+res.getString(4)+" *&mumtaaj@$ ";
				str = str + res.getString(1)+" *&mumtaaj@$ "+res.getString(2)+" *&mumtaaj@$ "+res.getString(3)+" *&mumtaaj@$ ";
				System.out.println(" str value in while loop "+str);
			}

			registerBean.setUrlData(str);
			System.out.println(" &&&&&&&&&&&&&&&&&&&& registerBean in getSenderOtherDetailsAllTimeMethod  &&&&&&&&&&&&&&&&&&"+registerBean);

			System.out.println("******************** statement executed. ***************");

           //             System.out.println(str);         
   }
   catch(SQLException e){
           e.printStackTrace();
   }
   finally{
           connection.close();
   }
   System.out.println("****** Returning registerBean from getSenderOtherDetailsAllTimeMethod  *****"+registerBean);
   return registerBean;
}



	
	public RegisterBean receiveInvitationInListMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String InvitationList = "";
		System.out.println("**** Executing receiveInvitationInListMethod  &&&&&&&&");


	Connection connection = DatabaseConnection.getConnection();
RegisterBean registerBean = new RegisterBean();
System.out.println("$$$$$$ EMAILID is $$$$$"+EMAILID);
	try{
		System.out.println(connection);
			//String sql = "SELECT SENDERIMAGE,SENDERNAME,SENDEREMAILID,SENDERCOURSE,SENDERFIELD  FROM INVITATIONTABLE where RECIPIENTEMAILID = ?;";
			String sql = "SELECT SENDERIMAGE,SENDERNAME,SENDEREMAILID,SENDERSUBJECTS FROM INVITATIONTABLE where RECIPIENTEMAILID = ?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();

			System.out.println("getting result of receiveInvitationInListMethod ***");
			System.out.println("res is "+res);

					java.sql.ResultSetMetaData rsmd =  res.getMetaData();
					// String name = rsmd.getColumnName(1);

					System.out.println("getting result ***");
					System.out.println("result of receiveInvitationInListMethod is "+res);


					java.sql.ResultSetMetaData metadata = res.getMetaData();
					int columnCount = metadata.getColumnCount();    
					/*  for (int i = 1; i <= columnCount; i++) {
					        writeToFile(metadata.getColumnName(i) + ", ");      
					    }*/
					System.out.println();
					while (res.next()) {

						for (int i = 1; i <= columnCount; i++) {
							InvitationList += res.getString(i) + "12neha_neha12";  

						}

						InvitationList=InvitationList.concat("#12872#3");
						//System.out.println(" Invitation List separated by #12872#3 "+InvitationList);
					}
					
					 registerBean.setUrlData(InvitationList);
					 System.out.println("******************** statement executed. ***************");
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	System.out.println("****** Returning InvitationList *****"+registerBean);
	return registerBean ;
}


/*
	public RegisterBean getSenderOtherDetailsMethod(String SenderEmailId) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("****## getSenderOtherDetailsMethod called ###############*****");
		Connection connection = DatabaseConnection.getConnection();
		RegisterBean registerBean = new RegisterBean();
		String EMAILID=SenderEmailId;
		System.out.println("&&&&&& SenderEmailId is &&&&&"+SenderEmailId);
		try{

			//String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME,COURSETABLE.COURSE,COURSETABLE.FIELD from USER_REGISTRATION,LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE  where USER_REGISTRATION.EMAILID=? and USER_REGISTRATION.EMAILID =LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID AND COURSETABLE.EMAIID=LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID;";
			String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME,COURSETABLE.SUBJECTS  from USER_REGISTRATION,LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE  where USER_REGISTRATION.EMAILID=? and USER_REGISTRATION.EMAILID =LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID AND COURSETABLE.EMAIID=LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			ResultSet res = preparedStatement.executeQuery();
			String str = "";
			while(res.next()){
				//str = str + res.getString(1)+" *&mumtaaj@$ "+res.getString(2)+" *&mumtaaj@$ "+res.getString(3)+" *&mumtaaj@$ "+res.getString(4)+" *&mumtaaj@$ ";
				str = str + res.getString(1)+" *&mumtaaj@$ "+res.getString(2)+" *&mumtaaj@$ "+res.getString(3)+" *&mumtaaj@$ ";
				System.out.println(" str value in while loop "+str);
			}

			registerBean.setUrlData(str);
			System.out.println(" &&&&&&&&&&&&&&&&&&&& registerBean in getSenderOtherDetailsMethod  &&&&&&&&&&&&&&&&&&"+registerBean);

			System.out.println("******************** statement executed. ***************");

           //             System.out.println(str);         
   }
   catch(SQLException e){
           e.printStackTrace();
   }
   finally{
           connection.close();
   }
   System.out.println("****** Returning registerBean from getSenderOtherDetailsMethod  *****"+registerBean);
   return registerBean;
}
*/



	
	public String getTutorsOrStudentsProfileInListMethod(String EMAILID,String commaSepratedListOfSubjects,String state,String city) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		int count=0;
		String matchingFlag="false";
		String nextListOfResultSetSubjectsForeveryMatchedUser;
		String spilltedEveryNewSubjectsListFirst;
		List<String> resultSetSubjectsForeveryMatchedUser = new ArrayList<String>();
		String[] spilltedResultSetSubjectsForeveryMatchedUser;
		//System.out.println("resultSetSubjectsForeveryMatchedUser is"+resultSetSubjectsForeveryMatchedUser);
		List<String> userSubjectsList = new ArrayList<String>();

		String[] spilltedCommaSepratedListOfSubjects=commaSepratedListOfSubjects.split(",");
		for(int i=0; i<spilltedCommaSepratedListOfSubjects.length;i++){
			userSubjectsList.add(spilltedCommaSepratedListOfSubjects[i]);
		}
		System.out.println("userSubjectsList is check 1"+userSubjectsList);
		//resultSetSubjectsForeveryMatchedUser.add("java");

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EMAILID);
		System.out.println("commaSepratedListOfSubjects is : "+commaSepratedListOfSubjects);
		System.out.println("state is : "+state);
		System.out.println("city is "+city);
		//System.out.println("district is : "+district);


		System.out.println("**** Executing getTutorsOrStudentsProfileInListMethod  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			//	String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.DISTRICT,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.COURSE,COURSETABLE.FIELD  from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID  and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and course=? and field=? and state=? and city=?  and district=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID = ?) );";
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID  and state=? and city=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID =?) );";
			System.out.println("sql statement "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			//preparedStatement.setString(1,commaSepratedListOfSubjects);
			//	preparedStatement.setString(2,field);
			preparedStatement.setString(1,state);
			preparedStatement.setString(2,city);
			//preparedStatement.setString(3,district);
			preparedStatement.setString(3,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			System.out.println("getting result of getTutorsOrStudentsProfileInListMethod ***");
			System.out.println("result of getTutorsOrStudentsProfileInListMethod is "+res);

			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			System.out.println("&&&&&&&&&&&&&&&&& rsmd is &&&&&&&&&&&&&&"+rsmd);

			String name = rsmd.getColumnName(6);
			System.out.println("&&&&&&&&&&&&&&&& name is &&&&&&&&&&&&&&  "+name);

			System.out.println("getting result ***");
			System.out.println("resulit of getTutorsOrStudentsProfileInListMethod is "+res);

			
			//res.getString(8).concat("$$");
			//System.out.println("^^^^^^^^ just before while loop  ^^^^^^");
			//	resultSetSubjectsForeveryMatchedUser=null;
			while(res.next()){
				matchingFlag="false";
			System.out.println(" starting while check matchingFlag  "+matchingFlag);
				
				if(res.getString(6).contains("$$"));{
					
				String[] spilltedEveryNewSubjectsList=res.getString(6).split("$$");
				System.out.println("");
				System.out.println("@@@@@@@ abc @@@@@@@"+spilltedEveryNewSubjectsList[0]);
				//System.out.println("@@@@@@@ abc @@@@@@@"+abc[1]);
				spilltedEveryNewSubjectsListFirst=spilltedEveryNewSubjectsList[0];
				System.out.println("");
				
				
				
				 spilltedResultSetSubjectsForeveryMatchedUser=spilltedEveryNewSubjectsListFirst.split(",");
				for(int i=0; i<spilltedResultSetSubjectsForeveryMatchedUser.length;i++){
					resultSetSubjectsForeveryMatchedUser.add(spilltedResultSetSubjectsForeveryMatchedUser[i]);
				}
				//resultSetSubjectsForeveryMatchedUser.add(res.getString("SUBJECTS"));
				System.out.println("hurrey resultSetSubjectsForeveryMatchedUser is "+resultSetSubjectsForeveryMatchedUser);
				System.out.println("resultSetSubjectsForeveryMatchedUser.size() is "+resultSetSubjectsForeveryMatchedUser.size());

				System.out.println("userSubjectsList.size() is "+userSubjectsList.size());

				for(int i=0;i<resultSetSubjectsForeveryMatchedUser.size(); i++){
					String elementOfResultSetSubjectsForeveryMatchedUser= resultSetSubjectsForeveryMatchedUser.get(i);
					System.out.println("elementOfResultSetSubjectsForeveryMatchedUser "+elementOfResultSetSubjectsForeveryMatchedUser);
					System.out.println(" ((((( 3 ))))))))");
					for(int j=0;j<userSubjectsList.size(); j++){
						String elementOfuserSubjectsList= userSubjectsList.get(j);
						System.out.println(" ((((( 2 ))))))))");
						if(elementOfuserSubjectsList.equalsIgnoreCase(elementOfResultSetSubjectsForeveryMatchedUser)){

							System.out.println("********* yes it contains . ********************");
							System.out.println("for userSubjectsList"+userSubjectsList);
							System.out.println(" resultSetSubjectsForeveryMatchedUser is "+resultSetSubjectsForeveryMatchedUser);
							System.out.println("elementOfResultSetSubjectsForeveryMatchedUser "+elementOfResultSetSubjectsForeveryMatchedUser);
							System.out.println("elementOfuserSubjectsList "+elementOfuserSubjectsList);
							count++;
							matchingFlag="true";
							System.out.println(" ((((( matchingFlag is ))))))))"+matchingFlag);  
							System.out.println("count of matching subjects is "+count+" common subject is "+elementOfuserSubjectsList);
							System.out.println("**************************************************************");
							
							/*java.sql.ResultSetMetaData metadata = res.getMetaData();
							int columnCount = metadata.getColumnCount();    
							for (int k = 1; k <= columnCount; k++) { 
								StudentOrTutorList += res.getString(k) + " khatri_neha01 ";   

							}
							StudentOrTutorList=StudentOrTutorList.concat("#");
							*/
							
							System.out.println(" ((((( 1 ))))))))");
							break;
							
						}
						else{
							System.out.println("$$$$$$$$$$$$$$$$$$$$ does not contain . $$$$$$$$$$$$$$$$$$$$$$$ ");
							System.out.println("does not contain for "+resultSetSubjectsForeveryMatchedUser);
							System.out.println("userSubjectList "+userSubjectsList);
							System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
							if(matchingFlag=="true")
							{
								matchingFlag="true";
							}
							else{
								matchingFlag="false";
								System.out.println(" **((**((**(( matchingFlag in else is )**))**))**)))*"+matchingFlag); 
							    }
							 
						}
						System.out.println(" ((((( 4 ))))))))");
					}  // ending for j here.
					
					
					
					
				}  // ending for i here
				System.out.println(" ((((( 6 ))))))))");
				}// ending if if(res.getString(8).contains("$$"));
				
				System.out.println(" ((((( 0 ))))))))");
				
				if(matchingFlag=="true"){
			    // Add "#" only if this row found to be matched with user profile/subjects.
					
				System.out.println("888888888 matchingFlag is 8888888888888 "+matchingFlag);
				java.sql.ResultSetMetaData metadata = res.getMetaData();
				int columnCount = metadata.getColumnCount();    
				for (int k = 1; k <= columnCount; k++) { 
					StudentOrTutorList += res.getString(k) + " khatri_neha01 ";   

				}
				StudentOrTutorList=StudentOrTutorList.concat("#");
				}
				else{
					System.out.println(";;;;;;;;;;;; I am in else ;;;;;;;;;;; ");
					System.out.println("9999999999999 matchingFlag is 999999999999 "+matchingFlag);
					System.out.println("%%%%%%  I(Row) dont have matching subjects so I m not supposed to add in matchingprofiles %%%%%%");
				}
				System.out.println("101010101001  matchingFlag is 101010101001 "+matchingFlag);
				System.out.println(" ((((( 5 ))))))))");	
				System.out.println(" ((((( 7 ))))))))");
				 nextListOfResultSetSubjectsForeveryMatchedUser= res.getString(6).concat("$$");
				 System.out.println("");
				 System.out.println("res.getString(8).concat "+nextListOfResultSetSubjectsForeveryMatchedUser);
				 System.out.println("");
				
				 resultSetSubjectsForeveryMatchedUser.removeAll(resultSetSubjectsForeveryMatchedUser);
					System.out.println("removing list ");
					
			}  // ending while loop here.

		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning StudentOrTutorListInList *****"+StudentOrTutorList);
		return StudentOrTutorList ;
	}


	
	
	public String getTutorsOrStudentsProfileAllTimeMethod2(String EMAILID,String commaSepratedListOfSubjects,String state,String country) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		int count=0;
		String matchingFlag="false";
		String nextListOfResultSetSubjectsForeveryMatchedUser;
		String spilltedEveryNewSubjectsListFirst;
		List<String> resultSetSubjectsForeveryMatchedUser = new ArrayList<String>();
		String[] spilltedResultSetSubjectsForeveryMatchedUser;
		//System.out.println("resultSetSubjectsForeveryMatchedUser is"+resultSetSubjectsForeveryMatchedUser);
		List<String> userSubjectsList = new ArrayList<String>();

		String[] spilltedCommaSepratedListOfSubjects=commaSepratedListOfSubjects.split(",");
		for(int i=0; i<spilltedCommaSepratedListOfSubjects.length;i++){
			userSubjectsList.add(spilltedCommaSepratedListOfSubjects[i]);
		}
		System.out.println("userSubjectsList is check 1"+userSubjectsList);
		System.out.println("Hello KITTY");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EMAILID);
		System.out.println("commaSepratedListOfSubjects is : "+commaSepratedListOfSubjects);
		System.out.println("state is : "+state);
		//System.out.println("city is : "+city);
		System.out.println("country is : "+country);

		//String cityName=city;
 //int a=2;
		System.out.println("**** Executing getTutorsOrStudentsProfileAllTimeMethod2  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			//System.out.println("city is"+city);
			
			
			
			System.out.println("^^^^^^^^^^^^^^^ city is 1 case;");
			//	String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.DISTRICT,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.COURSE,COURSETABLE.FIELD  from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID  and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and course=? and field=? and state=? and city=?  and district=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID = ?) );";
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME,LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID  and state=? and country=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID =?) );";
			
			                    
			//System.out.println("sql statement for AllTime "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			//preparedStatement.setString(1,commaSepratedListOfSubjects);
			//	preparedStatement.setString(2,field);
			preparedStatement.setString(1,state);
			//preparedStatement.setString(2,city);
	    	preparedStatement.setString(2,country);
			preparedStatement.setString(3,EMAILID);
			// preparedStatement.setString(2, category);
			//ResultSet res = preparedStatement.executeQuery();
			
			
			ResultSet res = preparedStatement.executeQuery();
			
			//	System.out.println("getting result of getTutorsOrStudentsProfileAllTimeMethod ***");
			System.out.println("result of getTutorsOrStudentsProfileAllTimeMethod2 is "+res);

				java.sql.ResultSetMetaData rsmd =  res.getMetaData();
				System.out.println("&&&&&&&&&&&&&&&&& rsmd is &&&&&&&&&&&&&&"+rsmd);
	           //one less then total no of columns 
				String name = rsmd.getColumnName(5);
				System.out.println("&&&&&&&&&&&&&&&&& name is &&&&&&&&&&&&&&  "+name);

			//	System.out.println("getting result ***");
				System.out.println("resulit of getTutorsOrStudentsProfileAllTimeMethod2 is "+res);

				
				//res.getString(8).concat("$$");
				//System.out.println("^^^^^^^^ just before while loop  ^^^^^^");
				//	resultSetSubjectsForeveryMatchedUser=null;
				while(res.next()){
					matchingFlag="false";
			//	System.out.println(" starting while check matchingFlag in AllTime  "+matchingFlag);
					
					if(res.getString(6).contains("$$"));{
						
					String[] spilltedEveryNewSubjectsList=res.getString(6).split("$$");
					System.out.println("");
					System.out.println("@@@@@@@ abc @@@@@@@"+spilltedEveryNewSubjectsList[0]);
					//System.out.println("@@@@@@@ abc @@@@@@@"+abc[1]);
					spilltedEveryNewSubjectsListFirst=spilltedEveryNewSubjectsList[0];
					System.out.println("");
					
					
					
					 spilltedResultSetSubjectsForeveryMatchedUser=spilltedEveryNewSubjectsListFirst.split(",");
					for(int i=0; i<spilltedResultSetSubjectsForeveryMatchedUser.length;i++){
						resultSetSubjectsForeveryMatchedUser.add(spilltedResultSetSubjectsForeveryMatchedUser[i]);
					}
					//resultSetSubjectsForeveryMatchedUser.add(res.getString("SUBJECTS"));
					//System.out.println("hurrey resultSetSubjectsForeveryMatchedUser is "+resultSetSubjectsForeveryMatchedUser);
				//	System.out.println("resultSetSubjectsForeveryMatchedUser.size() is "+resultSetSubjectsForeveryMatchedUser.size());

				//	System.out.println("userSubjectsList.size() is "+userSubjectsList.size());

					for(int i=0;i<resultSetSubjectsForeveryMatchedUser.size(); i++){
						String elementOfResultSetSubjectsForeveryMatchedUser= resultSetSubjectsForeveryMatchedUser.get(i);
						System.out.println("elementOfResultSetSubjectsForeveryMatchedUser "+elementOfResultSetSubjectsForeveryMatchedUser);
						System.out.println(" ((((( 3 Alltime))))))))");
						for(int j=0;j<userSubjectsList.size(); j++){
							String elementOfuserSubjectsList= userSubjectsList.get(j);
							System.out.println(" ((((( 2 Alltime ))))))))");
							if(elementOfuserSubjectsList.equalsIgnoreCase(elementOfResultSetSubjectsForeveryMatchedUser)){

								System.out.println("********* yes it contains . ********************");
							System.out.println("for userSubjectsList"+userSubjectsList);
								System.out.println(" resultSetSubjectsForeveryMatchedUser is "+resultSetSubjectsForeveryMatchedUser);
							System.out.println("elementOfResultSetSubjectsForeveryMatchedUser "+elementOfResultSetSubjectsForeveryMatchedUser);
								System.out.println("elementOfuserSubjectsList "+elementOfuserSubjectsList);
								count++;
								matchingFlag="true";
							System.out.println(" ((((( matchingFlag is ))))))))"+matchingFlag);  
							//	System.out.println("count of matching subjects is "+count+" common subject is "+elementOfuserSubjectsList);
								System.out.println("**************************************************************");
								
								/*java.sql.ResultSetMetaData metadata = res.getMetaData();
								int columnCount = metadata.getColumnCount();    
								for (int k = 1; k <= columnCount; k++) { 
									StudentOrTutorList += res.getString(k) + " khatri_neha01 ";   

								}
								StudentOrTutorList=StudentOrTutorList.concat("#");
								*/
								
							//	System.out.println(" ((((( 1 Alltime ))))))))");
								break;
							}
							else{
								System.out.println("$$$$$$$$$$$$$$$$$$$$ does not contain . $$$$$$$$$$$$$$$$$$$$$$$ ");
								System.out.println("does not contain for "+resultSetSubjectsForeveryMatchedUser);
								System.out.println("userSubjectList "+userSubjectsList);
								System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
								if(matchingFlag=="true")
								{
									matchingFlag="true";
								}
								else{
									matchingFlag="false";
									System.out.println(" **((**((**(( matchingFlag in else is )**))**))**)))*"+matchingFlag); 
								    }
								 
							}
							//System.out.println(" ((((( 4 Alltime))))))))");
						}  // ending for j here.
						
						
					}  // ending for i here
					//System.out.println(" ((((( 6 Alltime))))))))");
					}// ending if if(res.getString(8).contains("$$"));
					
					//System.out.println(" ((((( 0 Alltime))))))))");
					
					if(matchingFlag=="true"){
				    // Add "#" only if this row found to be matched with user profile/subjects.
						
					//System.out.println("888888888 matchingFlag in Alltime is 8888888888888 "+matchingFlag);
					java.sql.ResultSetMetaData metadata = res.getMetaData();
					int columnCount = metadata.getColumnCount();    
					for (int k = 1; k <= columnCount; k++) { 
						StudentOrTutorList += res.getString(k) + " khatri_neha01 ";   

					}
					StudentOrTutorList=StudentOrTutorList.concat("#");
					}
					else{
						System.out.println(";;;;;;;;;;;; I am in else ;;;;;;;;;;; ");
						//System.out.println("9999999999999 matchingFlag in Alltime is 999999999999 "+matchingFlag);
						//System.out.println("%%%%%%  I(Row) dont have matching subjects so I m not supposed to add in matchingprofiles %%%%%%");
					}
				//	System.out.println("101010101001  matchingFlag in Alltime is 101010101001 "+matchingFlag);
					//System.out.println(" ((((( 5 ))))))))");	
					//System.out.println(" ((((( 7 ))))))))");
					 nextListOfResultSetSubjectsForeveryMatchedUser= res.getString(6).concat("$$");
					 //System.out.println("");
					 System.out.println("res.getString(6).concat AllTime "+nextListOfResultSetSubjectsForeveryMatchedUser);
					 //System.out.println("");
					
					 resultSetSubjectsForeveryMatchedUser.removeAll(resultSetSubjectsForeveryMatchedUser);
						System.out.println("removing list ");
				}  // ending while loop here.

			
			
			
		}  //ending try here 
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTutorsOrStudentsProfileAllTimeMethod2 *****"+StudentOrTutorList);
		return StudentOrTutorList ;
	}

	//.getTutorsOrStudentsProfileAllTimeMethod1(EmailId,commaSepratedListOfSubjects,state,cityVar,country);
	
	
	public String getTutorsOrStudentsProfileAllTimeMethod1(String EMAILID,String commaSepratedListOfSubjects,String state,String cityVar,String country) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		int count=0;
		String matchingFlag="false";
		String nextListOfResultSetSubjectsForeveryMatchedUser;
		String spilltedEveryNewSubjectsListFirst;
		List<String> resultSetSubjectsForeveryMatchedUser = new ArrayList<String>();
		String[] spilltedResultSetSubjectsForeveryMatchedUser;
		//System.out.println("resultSetSubjectsForeveryMatchedUser is"+resultSetSubjectsForeveryMatchedUser);
		List<String> userSubjectsList = new ArrayList<String>();

		String[] spilltedCommaSepratedListOfSubjects=commaSepratedListOfSubjects.split(",");
		for(int i=0; i<spilltedCommaSepratedListOfSubjects.length;i++){
			userSubjectsList.add(spilltedCommaSepratedListOfSubjects[i]);
		}
		System.out.println("userSubjectsList is check 1"+userSubjectsList);
		System.out.println("Hello KITTY");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EMAILID);
		System.out.println("commaSepratedListOfSubjects is : "+commaSepratedListOfSubjects);
		System.out.println("state is : "+state);
		System.out.println("cityVar is : "+cityVar);
		System.out.println("country is : "+country);

		//String cityName=city;
 //int a=2;
		System.out.println("**** Executing getTutorsOrStudentsProfileAllTimeMethod1  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			//System.out.println("city is"+city);
			
			
			
			System.out.println("^^^^^^^^^^^^^^^ We have valid city name Method1;");
			//	String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.DISTRICT,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.COURSE,COURSETABLE.FIELD  from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID  and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and course=? and field=? and state=? and city=?  and district=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID = ?) );";
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME,LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID  and state=? and country=? and city=? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID IN(select distinct EMAILID from USER_REGISTRATION where profession not in (select PROFESSION from USER_REGISTRATION where EMAILID =?) );";
			
			                    
			//System.out.println("sql statement for AllTime "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			//preparedStatement.setString(1,commaSepratedListOfSubjects);
			//	preparedStatement.setString(2,field);
			preparedStatement.setString(1,state);
			preparedStatement.setString(2,country);
	    	preparedStatement.setString(3,cityVar);
			preparedStatement.setString(4,EMAILID);
			// preparedStatement.setString(2, category);
			//ResultSet res = preparedStatement.executeQuery();
			
			
			ResultSet res = preparedStatement.executeQuery();
			
			//	System.out.println("getting result of getTutorsOrStudentsProfileAllTimeMethod ***");
			System.out.println("result of getTutorsOrStudentsProfileAllTimeMethod1 is "+res);

				java.sql.ResultSetMetaData rsmd =  res.getMetaData();
				System.out.println("&&&&&&&&&&&&&&&&& rsmd is &&&&&&&&&&&&&&"+rsmd);
	           //one less then total no of columns 
				String name = rsmd.getColumnName(5);
				System.out.println("&&&&&&&&&&&&&&&&& name is &&&&&&&&&&&&&&  "+name);

			//	System.out.println("getting result ***");
				System.out.println("resulit of getTutorsOrStudentsProfileAllTimeMethod1 is "+res);

				
				//res.getString(8).concat("$$");
				//System.out.println("^^^^^^^^ just before while loop  ^^^^^^");
				//	resultSetSubjectsForeveryMatchedUser=null;
				while(res.next()){
					matchingFlag="false";
			//	System.out.println(" starting while check matchingFlag in AllTime  "+matchingFlag);
					
					if(res.getString(6).contains("$$"));{
						
					String[] spilltedEveryNewSubjectsList=res.getString(6).split("$$");
					System.out.println("");
					System.out.println("@@@@@@@ abc @@@@@@@"+spilltedEveryNewSubjectsList[0]);
					//System.out.println("@@@@@@@ abc @@@@@@@"+abc[1]);
					spilltedEveryNewSubjectsListFirst=spilltedEveryNewSubjectsList[0];
					System.out.println("");
					
					
					
					 spilltedResultSetSubjectsForeveryMatchedUser=spilltedEveryNewSubjectsListFirst.split(",");
					for(int i=0; i<spilltedResultSetSubjectsForeveryMatchedUser.length;i++){
						resultSetSubjectsForeveryMatchedUser.add(spilltedResultSetSubjectsForeveryMatchedUser[i]);
					}
					//resultSetSubjectsForeveryMatchedUser.add(res.getString("SUBJECTS"));
					//System.out.println("hurrey resultSetSubjectsForeveryMatchedUser is "+resultSetSubjectsForeveryMatchedUser);
				//	System.out.println("resultSetSubjectsForeveryMatchedUser.size() is "+resultSetSubjectsForeveryMatchedUser.size());

				//	System.out.println("userSubjectsList.size() is "+userSubjectsList.size());

					for(int i=0;i<resultSetSubjectsForeveryMatchedUser.size(); i++){
						String elementOfResultSetSubjectsForeveryMatchedUser= resultSetSubjectsForeveryMatchedUser.get(i);
						System.out.println("elementOfResultSetSubjectsForeveryMatchedUser "+elementOfResultSetSubjectsForeveryMatchedUser);
						System.out.println(" ((((( 3 Alltime))))))))");
						for(int j=0;j<userSubjectsList.size(); j++){
							String elementOfuserSubjectsList= userSubjectsList.get(j);
							System.out.println(" ((((( 2 Alltime ))))))))");
							if(elementOfuserSubjectsList.equalsIgnoreCase(elementOfResultSetSubjectsForeveryMatchedUser)){

								System.out.println("********* yes it contains . ********************");
							System.out.println("for userSubjectsList"+userSubjectsList);
								System.out.println(" resultSetSubjectsForeveryMatchedUser is "+resultSetSubjectsForeveryMatchedUser);
							System.out.println("elementOfResultSetSubjectsForeveryMatchedUser "+elementOfResultSetSubjectsForeveryMatchedUser);
								System.out.println("elementOfuserSubjectsList "+elementOfuserSubjectsList);
								count++;
								matchingFlag="true";
							System.out.println(" ((((( matchingFlag is ))))))))"+matchingFlag);  
							//	System.out.println("count of matching subjects is "+count+" common subject is "+elementOfuserSubjectsList);
								System.out.println("**************************************************************");
								
								/*java.sql.ResultSetMetaData metadata = res.getMetaData();
								int columnCount = metadata.getColumnCount();    
								for (int k = 1; k <= columnCount; k++) { 
									StudentOrTutorList += res.getString(k) + " khatri_neha01 ";   

								}
								StudentOrTutorList=StudentOrTutorList.concat("#");
								*/
								
							//	System.out.println(" ((((( 1 Alltime ))))))))");
								break;
							}
							else{
								System.out.println("$$$$$$$$$$$$$$$$$$$$ does not contain . $$$$$$$$$$$$$$$$$$$$$$$ ");
								System.out.println("does not contain for "+resultSetSubjectsForeveryMatchedUser);
								System.out.println("userSubjectList "+userSubjectsList);
								System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
								if(matchingFlag=="true")
								{
									matchingFlag="true";
								}
								else{
									matchingFlag="false";
									System.out.println(" **((**((**(( matchingFlag in else is )**))**))**)))*"+matchingFlag); 
								    }
								 
							}
							//System.out.println(" ((((( 4 Alltime))))))))");
						}  // ending for j here.
						
						
					}  // ending for i here
					//System.out.println(" ((((( 6 Alltime))))))))");
					}// ending if if(res.getString(8).contains("$$"));
					
					//System.out.println(" ((((( 0 Alltime))))))))");
					
					if(matchingFlag=="true"){
				    // Add "#" only if this row found to be matched with user profile/subjects.
						
					//System.out.println("888888888 matchingFlag in Alltime is 8888888888888 "+matchingFlag);
					java.sql.ResultSetMetaData metadata = res.getMetaData();
					int columnCount = metadata.getColumnCount();    
					for (int k = 1; k <= columnCount; k++) { 
						StudentOrTutorList += res.getString(k) + " khatri_neha01 ";   

					}
					StudentOrTutorList=StudentOrTutorList.concat("#");
					}
					else{
						System.out.println(";;;;;;;;;;;; I am in else ;;;;;;;;;;; ");
						//System.out.println("9999999999999 matchingFlag in Alltime is 999999999999 "+matchingFlag);
						//System.out.println("%%%%%%  I(Row) dont have matching subjects so I m not supposed to add in matchingprofiles %%%%%%");
					}
				//	System.out.println("101010101001  matchingFlag in Alltime is 101010101001 "+matchingFlag);
					//System.out.println(" ((((( 5 ))))))))");	
					//System.out.println(" ((((( 7 ))))))))");
					 nextListOfResultSetSubjectsForeveryMatchedUser= res.getString(6).concat("$$");
					 //System.out.println("");
					 System.out.println("res.getString(6).concat AllTime "+nextListOfResultSetSubjectsForeveryMatchedUser);
					 //System.out.println("");
					
					 resultSetSubjectsForeveryMatchedUser.removeAll(resultSetSubjectsForeveryMatchedUser);
						System.out.println("removing list ");
				}  // ending while loop here.

			
			
			
		}  //ending try here 
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTutorsOrStudentsProfileAllTimeMethod1 *****"+StudentOrTutorList);
		return StudentOrTutorList ;
	}


	

	public String getEditableSubjectsMethod(String EmailId)throws SQLException{
		System.out.println("****(( getEditableSubjectsMethod called )***********");
		String subjects = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
			String sql = "SELECT SUBJECTS  FROM COURSETABLE where EMAIID=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				subjects = res.getString(1); 
				System.out.println("^^^^^^ subjects in while is ^^^^^^^^"+subjects);
			}
			System.out.println("subjects in getEditableSubjectsMethod is : "+ subjects);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning subjects from getEditableSubjectsMethod : "+subjects);

		return subjects ;
	}



	public String getGenderMethod(String EmailId)throws SQLException{
		System.out.println("****(( getPhoneNoMethod called )***********");
		String phoneNo = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
			String sql = "SELECT GENDER FROM USER_REGISTRATION where EmailId=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				phoneNo = res.getString(1); 
				System.out.println("^^^^^^ GENDER in while is ^^^^^^^^"+phoneNo);
			}
			System.out.println("GENDER in getGenderMethod is : "+ phoneNo);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning GENDER from getGenderMethod : "+phoneNo);

		return phoneNo ;
	}


	
	/*
	@Override
	public String getUserProfileDataForGuestUsersMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String allColumnsOfRows = "";
		System.out.println("**** Executing getUserProfileDataForGuestUsersMethod   &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.DISTRICT,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID = ? and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID ;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EMAILID);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result ***");
			System.out.println("res is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

				//  allColumnsOfRows=allColumnsOfRows.concat("#");

				System.out.println("allColumnsOfRows in getUserProfileDataForGuestUsersMethod is "+allColumnsOfRows);
				//writeToFile(row);

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getUserProfileDataForGuestUsersMethod *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}
	*/


	public String getUserProfileDataForGuestUsersMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EMAILID is : "+EMAILID);
		


		System.out.println("**** Executing getUserProfileDataForGuestUsersMethod  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
		    String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME,LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.EMAILID=? ;" ;
			System.out.println("sql statement for AllTime "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			//preparedStatement.setString(1,commaSepratedListOfSubjects);
			//	preparedStatement.setString(2,field);
			preparedStatement.setString(1,EMAILID);
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
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

				//  allColumnsOfRows=allColumnsOfRows.concat("#");

				System.out.println("allColumnsOfRows in getUserProfileDataForGuestUsersMethod is "+allColumnsOfRows);
				//writeToFile(row);

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getUserProfileDataForGuestUsersMethod *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}


	

	public String getUserProfileDataForRegisteredUsersMethod(String EMAILID) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EMAILID is : "+EMAILID);
		


		System.out.println("**** Executing getUserProfileDataForRegisteredUsersMethod  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
		    String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME, LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.COUNTRY,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.EMAILID=? ;" ;
			System.out.println("sql statement for AllTime getUserProfileDataForRegisteredUsersMethod"+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			//preparedStatement.setString(1,commaSepratedListOfSubjects);
			//	preparedStatement.setString(2,field);
			preparedStatement.setString(1,EMAILID);
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
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

				 allColumnsOfRows=allColumnsOfRows.concat("#");

				System.out.println("allColumnsOfRows in getUserProfileDataForRegisteredUsersMethod is "+allColumnsOfRows);
				//writeToFile(row);

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getUserProfileDataForRegisteredUsersMethod *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	
	public String getTrendingTutorProfilesMethod1(String itemLocality,String itemCountry,String itemPc) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//System.out.println("EMAILID is : "+EMAILID);
		


		System.out.println("**** Executing getTrendingTutorProfilesMethod1  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("%%%%%%%%%% valid city case method%%%%%%%");
			//String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor';";
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME, LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID, USER_REGISTRATION.PHONENO ,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor' and country= ? and state= ? and city= ? limit 7;";
			System.out.println("sql statement for getTrendingTutorProfilesMethod "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,itemCountry);
			preparedStatement.setString(2,itemPc);
	     	preparedStatement.setString(3,itemLocality);
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
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

			   allColumnsOfRows=allColumnsOfRows.concat("#");

			}
		} // ending try
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTrendingTutorProfilesMethod1 *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	
	public String getTrendingTutorProfilesMethod2(String itemCountry,String itemPc) throws SQLException {
	
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//System.out.println("EMAILID is : "+EMAILID);
		


		System.out.println("**** Executing getTrendingTutorProfilesMethod2  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println("%%%%%%%%%% 1 case if clause method  %%%%%%%");
			//String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor';";
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME, LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID, USER_REGISTRATION.PHONENO ,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor' and country= ? and state= ? limit 7;";
			System.out.println("sql statement for getTrendingTutorProfilesMethod2 "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,itemCountry);
			preparedStatement.setString(2,itemPc);
	     	//preparedStatement.setString(3,itemLocality);
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
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

			   allColumnsOfRows=allColumnsOfRows.concat("#");


			}
		} // ending try
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTrendingTutorProfilesMethod2 *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	
		
	//getTrendingTutorProfilesOnScrollMethod1(itemLocality,itemCountry,itemPc);
	public String getTrendingTutorProfilesOnScrollMethod1(String itemLocality,String itemCountry,String itemPc) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//System.out.println("EMAILID is : "+EMAILID);
		
		System.out.println("**** Executing getTrendingTutorProfilesOnScrollMethod1  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			System.out.println("%%%%%%%%%% valid city name method ONSCROLL  %%%%%%%");
			
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME, LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID, USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor' and country= ? and state=? and city=?  ORDER BY RAND() limit 9;";
			System.out.println("sql statement for getTrendingTutorProfilesOnScrollMethod "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,itemCountry);
			preparedStatement.setString(2,itemPc);
		    preparedStatement.setString(3,itemLocality);
			ResultSet res = preparedStatement.executeQuery();
		
		
			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result from getTrendingTutorProfilesOnScrollMethod1 ***");
			System.out.println("finsl result is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*/
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

			   allColumnsOfRows=allColumnsOfRows.concat("#");

			
			}
		} // ending try
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTrendingTutorProfilesOnScrollMethod1 *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	
	
	public String getTrendingTutorProfilesOnScrollMethod2(String itemCountry,String itemPc) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//System.out.println("EMAILID is : "+EMAILID);
		
		System.out.println("**** Executing getTrendingTutorProfilesOnScrollMethod2  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			System.out.println("%%%%%%%%%% 1 case if clause method ONSCROLL  %%%%%%%");
			
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME, LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID, USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor' and country= ? and state=?  ORDER BY RAND() limit 9;";
			System.out.println("sql statement for getTrendingTutorProfilesOnScrollMethod2 "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,itemCountry);
			preparedStatement.setString(2,itemPc);
	
			ResultSet res = preparedStatement.executeQuery();
		
		
			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result from getTrendingTutorProfilesOnScrollMethod2 ***");
			System.out.println("finsl result is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*/
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

			   allColumnsOfRows=allColumnsOfRows.concat("#");

			
			}
		} // ending try
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTrendingTutorProfilesOnScrollMethod2 *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	
	
	
	
	

	public RegisterBean getGuestStudentsGroupBasedOnHandshakeFlagMethod(String TutorEmail) throws SQLException {
		// TODO Auto-generated method stub
		String InvitationList = "";
		System.out.println("**** Executing getGuestStudentsGroupBasedOnHandshakeFlagMethod  &&&&&&&&");


	Connection connection = DatabaseConnection.getConnection();
RegisterBean registerBean = new RegisterBean();
System.out.println("$$$$$$ TutorEmail is $$$$$"+TutorEmail);
	try{
		System.out.println(connection);
		    String sql = "SELECT RECIPIENTEMAILID,SENDEREMAILID FROM INVITATIONTABLE where HANDSHAKEFLAG = 'YES' and (RECIPIENTEMAILID = ?  OR SENDEREMAILID = ? );";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,TutorEmail);
	    	preparedStatement.setString(2,TutorEmail);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();

			System.out.println("getting result of getGuestStudentsGroupBasedOnHandshakeFlagMethod ***");
			System.out.println("res is "+res);

					java.sql.ResultSetMetaData rsmd =  res.getMetaData();
					// String name = rsmd.getColumnName(1);

					System.out.println("getting result ***");
					System.out.println("result of getGuestStudentsGroupBasedOnHandshakeFlagMethod is "+res);


					java.sql.ResultSetMetaData metadata = res.getMetaData();
					int columnCount = metadata.getColumnCount();    
					/*  for (int i = 1; i <= columnCount; i++) {
					        writeToFile(metadata.getColumnName(i) + ", ");      
					    }*/
					System.out.println();
					while (res.next()) {

						for (int i = 1; i <= columnCount; i++) {
							InvitationList += res.getString(i) + "12neha_neha12";  

						}

						InvitationList=InvitationList.concat("#12872#3");
						//System.out.println(" Invitation List separated by #12872#3 "+InvitationList);
					}
					
					 registerBean.setUrlData(InvitationList);
					 System.out.println("******************** statement executed. ***************");
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	finally{
		connection.close();
	}
	System.out.println("****** Returning getGuestStudentsGroupBasedOnHandshakeFlagMethod  list*****"+registerBean);
	return registerBean ;
}

	
	/*
	public RegisterBean getProfilePic(String EmailId) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("****## getProfilePic called ###############*****");
		Connection connection = DatabaseConnection.getConnection();
		RegisterBean registerBean = new RegisterBean();
		String EMAIID=EmailId;
		System.out.println("$$$$$$ EMAIID is $$$$$"+EMAIID);
		try{

            String sql = "SELECT PICURLDATA from LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID= ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);        
            preparedStatement.setString(1,EMAIID);
            ResultSet res = preparedStatement.executeQuery();
            String str = "";
            while(res.next()){
                    str = str + res.getString(1);
            }
            
            registerBean.setUrlData(str);
            System.out.println(" &&&&&&&&&&&&&&&&&&&& registerBean in getProfilePic method &&&&&&&&&&&&&&&&&&"+registerBean);

			System.out.println("******************** statement executed. ***************");

            //             System.out.println(str);         
    }
    catch(SQLException e){
            e.printStackTrace();
    }
    finally{
            connection.close();
    }
    System.out.println("****** Returning registerBean from getProfilePic  *****"+registerBean);
    return registerBean;
}
 
	*/
	
	public RegisterBean getGuestStudentsProfileDataMethod(String studentEmailId) throws SQLException {
		// TODO Auto-generated method stub
		String allColumnsOfRows = "";
		RegisterBean registerBean = new RegisterBean();
		System.out.println("**** Executing getGuestStudentsProfileDataMethod   &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.LOCALITY,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.EMAILID=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,studentEmailId);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result getGuestStudentsProfileDataMethod ***");
			System.out.println("res is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*/
			System.out.println();
			// String str = "";
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

				 allColumnsOfRows=allColumnsOfRows.concat("#123#");

				 registerBean.setUrlData(allColumnsOfRows);
		            System.out.println(" &&&&&&&&&&&&&&&&&&&& registerBean in getGuestStudentsProfileDataMethod &&&&&&&&&&&&&&&&&&"+registerBean);

					System.out.println("******************** statement executed. ***************");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning registerBean from getGuestStudentsProfileDataMethod  *****"+registerBean);
	    return registerBean;
	}


	
	


	public String viewIndividualTrendingTutorToGuestMethod(String TutorEmail) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("TutorEmail is : "+TutorEmail); 
		


		System.out.println("**** Executing viewIndividualTrendingTutorToGuestMethod  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
		    String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,LOCATIONTABLEWITHOUTPRIMARYKEY.COUNTRY,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.EMAILID=? ;" ;
			System.out.println("sql statement for viewIndi "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			//preparedStatement.setString(1,commaSepratedListOfSubjects);
			//	preparedStatement.setString(2,field);
			preparedStatement.setString(1,TutorEmail);
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
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

				 allColumnsOfRows=allColumnsOfRows.concat("#");

				System.out.println("allColumnsOfRows in viewIndividualTrendingTutorToGuestMethod is "+allColumnsOfRows);
				//writeToFile(row);

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning viewIndividualTrendingTutorToGuestMethod *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	

	//viewIndividualTrendingTutorToGuestInNewTabMethod
	
	public String viewIndividualTrendingTutorToGuestInNewTabMethod(String TutorEmail) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("TutorEmail is : "+TutorEmail); 
		


		System.out.println("**** Executing viewIndividualTrendingTutorToGuestInNewTabMethod  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
		    String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME , LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID,USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,LOCATIONTABLEWITHOUTPRIMARYKEY.CITY,LOCATIONTABLEWITHOUTPRIMARYKEY.STATE,LOCATIONTABLEWITHOUTPRIMARYKEY.COUNTRY,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.EMAILID=? ;" ;
			System.out.println("sql statement for viewIndiInNewTab "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			//preparedStatement.setString(1,commaSepratedListOfSubjects);
			//	preparedStatement.setString(2,field);
			preparedStatement.setString(1,TutorEmail);
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
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

				 allColumnsOfRows=allColumnsOfRows.concat("#");

				System.out.println("allColumnsOfRows in viewIndividualTrendingTutorToGuestInNewTabMethod is "+allColumnsOfRows);
				//writeToFile(row);

			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning viewIndividualTrendingTutorToGuestInNewTabMethod *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	

	public String getGoogleUserDetailsAlreadySavedBeforeReplaceMethod(String googleEmailid)throws SQLException{
		System.out.println("****(( getGoogleUserDetailsAlreadySavedBeforeReplaceMethod called )***********");
		String oldData = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("<<<<<<<<<Hello Mau 1>>>>>>>>>>>>>>");
			System.out.println("$$$$$$ EmailId is $$$$$"+googleEmailid);
			String sql = "SELECT PASSWORD,PROFESSION,PHONENO,GENDER FROM USER_REGISTRATION where EMAILID=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,googleEmailid);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				oldData = res.getString(1)+"#&0#"+res.getString(2)+"#&0#"+res.getString(3)+"#&0#"+res.getString(4); 
				System.out.println("^^^^^^ getGoogleUserDetailsAlreadySavedBeforeReplaceMethod in while is ^^^^^^^^"+oldData);
			}
			System.out.println("value from getGoogleUserDetailsAlreadySavedBeforeReplaceMethod is : "+oldData);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning value from getGoogleUserDetailsAlreadySavedBeforeReplaceMethod : "+oldData);
		System.out.println("<<<<<<<<<Hello Mau 2>>>>>>>>>>>>>>");
		return oldData ;
	}


	
	
	public boolean sendRecoveryPasswordMethod(String recoveryEmailId,String randomPassword)throws SQLException,EmailException {
		System.out.println("****(( sendRecoveryPasswordMethod called )***********");
		boolean sent = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
		
			HtmlEmail htmlEmail=new HtmlEmail(); 
			DefaultAuthenticator authenticator=new DefaultAuthenticator("do-not-reply@skillskaart.com","Donotreply@123"); 
			htmlEmail.setDebug(true);
			//htmlEmail.setHostName("smtp.gmail."); 
			//htmlEmail.setHostName("SMTPS"); 
			htmlEmail.setHostName("smtp.mail.us-east-1.awsapps.com");
			
			
			htmlEmail.setTLS(false);
			htmlEmail.setSSL(true);
			//htmlEmail.setSmtpPort(587); 
			htmlEmail.setSmtpPort(465); 
			htmlEmail.setAuthenticator(authenticator); 
		    htmlEmail.setFrom("do-not-reply@skillskaart.com");
			htmlEmail.addTo(recoveryEmailId);
			//		htmlEmail.addCc("Dinesh.Mahalingam@mu-sigma.com");
			
			htmlEmail.setSubject("Password Recovery - Skillskaart");

//			 // EmailAttachment attachment = new EmailAttachment();
//			  //attachment.setPath("D:/testImage.jpg");
//			  //attachment.setDisposition(EmailAttachment.ATTACHMENT);
//			  //htmlEmail.attach(attachment);
		
		/*	try {
				htmlEmail.embed(new URL("http:\\localhost:8080\\portal1\\css\\flower2.jpg"), "My image");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
			  htmlEmail.setMsg(" "+randomPassword +" is the system generated password for your skillskaart account with the email id <"+recoveryEmailId+">.\n You are requested to please reset your password once you login into your account using the given password.\n\n Thanks,\n The skillskaart Team");
		
			 
			htmlEmail.send();
			System.out.println("**************DATA SENT SUCCESSFULLY**************");
			sent=true;
		//	System.out.println("phoneNo in getUserNameMethod is : "+ phoneNo);
			
			
		}
		 catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		//System.out.println("Returning phoneNo from getUserNameMethod : "+phoneNo);

		return sent ;
	}
	

	
	

	public boolean ifUserRegisteredMethod(String recoveryEmailId)throws SQLException{
		System.out.println("****(( ifUserRegisteredMethod called )***********");
		boolean existence = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("$$$$$$ recoveryEmailId is $$$$$"+recoveryEmailId);
			String sql = "SELECT EXISTS(SELECT * FROM USER_REGISTRATION WHERE EMAILID = ? );";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,recoveryEmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				existence = res.getBoolean(1); 
				System.out.println("^^^^^^ existence in while is ^^^^^^^^"+existence);
			}
			System.out.println("existence in ifUserRegisteredMethod is : "+ existence);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning existence from ifUserRegisteredMethod : "+existence);

		return existence ;
	}




	
	
	public String getCurrentPasswordMethod(String EmailId)throws SQLException{
		System.out.println("****(( getCurrentPasswordMethod called )***********");
		String phoneNo = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
			String sql = "SELECT PASSWORD FROM USER_REGISTRATION where EmailId=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				phoneNo = res.getString(1); 
				System.out.println("^^^^^^ PASSWORD in while is ^^^^^^^^"+phoneNo);
			}
			System.out.println("PASSWORD in getCurrentPasswordMethod is : "+ phoneNo);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning PASSWORD from getCurrentPasswordMethod : "+phoneNo);

		return phoneNo ;
	}


	
	
	public String getAttributesMethod(String EmailId)throws SQLException{
		System.out.println("****(( getAttributesMethod called )***********");
		String attributes = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("$$$$$$ EmailId is $$$$$"+EmailId);
			String sql = "SELECT TITLE,STRATEGY,BACKGROUND,RATES FROM USER_ATTRIBUTE where EmailId=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,EmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				attributes = res.getString(1)+"$%#*99$"+res.getString(2)+"$%#*99$"+res.getString(3)+"$%#*99$"+res.getString(4); 
				System.out.println("^^^^^^ getAttributesMethod in while is ^^^^^^^^"+attributes);
			}
			System.out.println("attributes in getAttributesMethod is : "+ attributes);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning attributes from getAttributesMethod : "+attributes);

		return attributes ;
	}







	public String getFacebookUserDetailsAlreadySavedBeforeReplaceMethod(String FacebookEmailId)throws SQLException{
		System.out.println("****(( getFacebookUserDetailsAlreadySavedBeforeReplaceMethod called )***********");
		String oldData = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			System.out.println("<<<<<<<<<facebook login  troubleshooting 1>>>>>>>>>>>>>>");
			System.out.println("$$$$$$FacebookEmailId  is $$$$$"+FacebookEmailId);
			String sql = "SELECT PASSWORD,PROFESSION,PHONENO,GENDER FROM USER_REGISTRATION where EMAILID=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,FacebookEmailId);

			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				System.out.println("inside while loop");
				oldData = res.getString(1)+"#&0#"+res.getString(2)+"#&0#"+res.getString(3)+"#&0#"+res.getString(4); 
				System.out.println("^^^^^^ getFacebookUserDetailsAlreadySavedBeforeReplaceMethod in while is ^^^^^^^^"+oldData);
			}
			System.out.println("value from getFacebookUserDetailsAlreadySavedBeforeReplaceMethod is : "+oldData);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("Returning value from getFacebookUserDetailsAlreadySavedBeforeReplaceMethod : "+oldData);
		System.out.println("<<<<<<<<<facebook login  troubleshooting 2>>>>>>>>>>>>>>");
		return oldData ;
	}


	

	
	//getTrendingTutorProfilesOnScrollMethod1(itemLocality,itemCountry,itemPc);
	public String getTrendingTutorProfilesByCategoryMethod1(String itemLocality,String itemCountry,String itemPc,String subj) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("subj in method1 is : **"+subj+"**");
		
		System.out.println("**** Executing getTrendingTutorProfilesByCategoryMethod1  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			System.out.println("%%%%%%%%%% valid city name method by Category  %%%%%%%");
			
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME, LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID, USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor' and country= ? and state=? and city=? and SUBJECTS like ? limit 7;";
			System.out.println("sql statement for getTrendingTutorProfilesByCategoryMethod1 "+sql);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,itemCountry);
			preparedStatement.setString(2,itemPc);
		    preparedStatement.setString(3,itemLocality);
		    preparedStatement.setString(4, "%" + subj + "%");
		    
			ResultSet res = preparedStatement.executeQuery();
		
		
			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result from getTrendingTutorProfilesByCategoryMethod1 ***");
			System.out.println("finsl result is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*/
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

			   allColumnsOfRows=allColumnsOfRows.concat("#");

			
			}
		} // ending try
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTrendingTutorProfilesByCategoryMethod1 *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	
	
	
	
	public String getTrendingTutorProfilesByCategoryMethod2(String itemCountry,String itemPc,String subj) throws SQLException {
		// TODO Auto-generated method stub
		String StudentOrTutorList = "";
		String allColumnsOfRows = "";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		//System.out.println("EMAILID is : "+EMAILID);
		
		System.out.println("**** Executing getTrendingTutorProfilesByCategoryMethod2  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			System.out.println("%%%%%%%%%% 1 case if clause method bycategory  %%%%%%%");
			
			String sql ="select LOCATIONTABLEWITHOUTPRIMARYKEY.PICURLDATA,USER_REGISTRATION.USERNAME, LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID, USER_REGISTRATION.PHONENO,LOCATIONTABLEWITHOUTPRIMARYKEY.ADDRESS,COURSETABLE.SUBJECTS from LOCATIONTABLEWITHOUTPRIMARYKEY,COURSETABLE,USER_REGISTRATION  where LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=COURSETABLE.EMAIID and LOCATIONTABLEWITHOUTPRIMARYKEY.EMAIID=USER_REGISTRATION.EMAILID and USER_REGISTRATION.PROFESSION='Tutor' and country= ? and state=? and SUBJECTS like ? limit 7;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,itemCountry);
			preparedStatement.setString(2,itemPc);
		//	preparedStatement.setString(3,subj);
			preparedStatement.setString(3, "%" + subj + "%");
			
			ResultSet res = preparedStatement.executeQuery();
		
		
			java.sql.ResultSetMetaData rsmd =  res.getMetaData();
			// String name = rsmd.getColumnName(1);

			System.out.println("getting result from getTrendingTutorProfilesByCategoryMethod2 ***");
			System.out.println("finsl result is "+res);


			java.sql.ResultSetMetaData metadata = res.getMetaData();
			int columnCount = metadata.getColumnCount();    
			/*  for (int i = 1; i <= columnCount; i++) {
			        writeToFile(metadata.getColumnName(i) + ", ");      
			    }*/
			System.out.println();
			while (res.next()) {

				for (int i = 1; i <= columnCount; i++) {
					allColumnsOfRows += res.getString(i) + "$_52_$";  

				}

			   allColumnsOfRows=allColumnsOfRows.concat("#");

			
			}
		} // ending try
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning getTrendingTutorProfilesByCategoryMethod2 *****"+allColumnsOfRows);
		return allColumnsOfRows ;
	}

	
	public String getCategoryDataMethod(String name)throws  SQLException, FileNotFoundException{
		System.out.println("****(( getCategoryDataMethod called )***********");
		String type=name;
		String items="";
		//File file = new File("src\\inventory1.txt"); // new File("C:\\Users\\Neha\\Desktop\\inventory1.txt");
		
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("inventory1.txt").getFile());
		System.out.println(file.getAbsolutePath());
		
		
				Scanner sc = new Scanner(file); 

				while (sc.hasNextLine()) {
					
				String[] category=sc.nextLine().split(" @s1#_#jun#_#");
				System.out.println(category[0]); 
				
					if(type.equalsIgnoreCase(category[0])){
						System.out.println(category[1]);
						items=category[1];
				       
					}
					else{
						System.out.println("did not match ");
					}
			
				}
				return items ;
	           }
		
	
	
	

	public String verifyIfStoreEmailCategoryPresentMethod(String emailIdValue) throws SQLException {
		// TODO Auto-generated method stub
		String SubjectList = "";
		System.out.println("**** Executing verifyIfUserLogInFirstTimeOrNotMethod method  &&&&&&&&");


		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			//String sql = "select STATE from LOCATIONTABLEWITHOUTPRIMARYKEY where EMAIID = ?;";
			String sql = "select STORENAME,CATEGORY from STORESINVENTORY where EMAILID=?;";
			
			
			//SELECT PROFESSION  FROM USER_REGISTRATION where EMAILID='ya@y.com';
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,emailIdValue);
			// preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				SubjectList = res.getString(1) + ","+res.getString(2);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		System.out.println("****** Returning storename & category *****"+SubjectList);
		return SubjectList ;
	}

	
	
	
	
	
	
	
	

	public String getBookDetailsForUserCategoryAndBookName(String username,String category,String bookName)throws SQLException{
		// TODO Auto-generated method stub
		String bookDetails = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection) ;
			//         // @Path("attachBookDetailsWithCategoryAndUserName/{username}/{category}/{bookName}/{pageNumber}/{pageContent}")
			String sql = "select pageContent , topiCNUMBERANDNAME   from bookDetails where username = ? and category = ? and bookName = ? and topICNUMBERANDNAME like '1:%' ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, category);
			preparedStatement.setString(3, bookName);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				bookDetails = res.getString(1) + "&&**" + res.getString(2);
			}
			System.out.println("book details are : "+ bookDetails);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bookDetails ;
	}



	public String getBookDetailsForUserCategoryAndBookId(String username,String category,String bookId)throws SQLException{
		// TODO Auto-generated method stub
		String bookDetails = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			//         // @Path("attachBookDetailsWithCategoryAndUserName/{username}/{category}/{bookName}/{pageNumber}/{pageContent}")
			String sql = "select pageContent , topiCNUMBERANDNAME   from bookDetails where username = ? and category = ? and bookId = ?  ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, category);
			preparedStatement.setString(3, bookId);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				bookDetails = res.getString(1) + "&&**" + res.getString(2);
			}
			System.out.println("book details are : "+ bookDetails);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bookDetails ;
	}

	
	public String getCategoryListForUser(String userName ) throws SQLException{
		String categoryList = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select category  from userNameCategoryBookIdBookName  where username = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1,userName);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				categoryList = categoryList +","+ res.getString(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return categoryList ;
	}

	public String getContentsOfBook(String category, String userName)
			throws SQLException {
		// TODO Auto-generated method stub

		String sql = "select pagecontent from bookDetails where username='amex1' and category='racing' and topicnumberandname like '1:%' and bookname = 'race1'";
		return null;
	}

	


	public RegisterBean getUserData(String userName) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DatabaseConnection.getConnection();
		RegisterBean registerBean = new RegisterBean();
		try{
			//	String fullname, String emailId, String category , String gender,String Password)
			String sql = "select fullname,category,gender from login where emailId = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);        
			preparedStatement.setString(1, userName);
			ResultSet res = preparedStatement.executeQuery();
			String str = "";
			while(res.next()){
				str = str + res.getString(1)+"aparnesh-gaurav"+res.getString(2)+"aparnesh-gaurav"+res.getString(3);
			}
			//                 System.out.println(str);
			String[] stryArray = str.split("aparnesh-gaurav");


			//                        System.out.println(stryArray[0]);
			//                        System.out.println(stryArray[1]);
			//                        System.out.println(stryArray[2]);


			//select fullname,category,gender from login where emailId = ? 

			//       registerBean.setEmailId(emailId);
			registerBean.setFullname(stryArray[0]);
			registerBean.setCategory(stryArray[1]);
			registerBean.setGender(stryArray[2]);


			//             System.out.println(str);         
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}

		return registerBean;
	}


	public String getBookList(String userName, String category)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}




