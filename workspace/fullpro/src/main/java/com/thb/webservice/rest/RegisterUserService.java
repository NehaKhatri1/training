package com.thb.webservice.rest;

import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thb.login.RegisterUser;

@Component
@Path("/register")
public class RegisterUserService {
	@Autowired
	RegisterUser registerUser;

	//@POST
	//@Consumes ("text/plain")
	@GET
	@Path("{userInformation}")


	public Response saveUserRegistartiondata(@PathParam("userInformation") String registrationData)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered saveUserRegistartiondata #####################################");
		Boolean bool = false;
		String result = "unregistered";
		try {
			//                        System.out.println("data is : "+registrationData);

			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&  Hi neha.you r about to register. &&&&&&&&&&&&&&&&&&&&&&&");
			// parse the data into usernmae , password  , sex and in urlData
			String[] arrayOfRegistrationDataElements = registrationData.split(":");
			String userName = arrayOfRegistrationDataElements[0];
			String EmailId = arrayOfRegistrationDataElements[1];
			String password = arrayOfRegistrationDataElements[2];
			//String profession = arrayOfRegistrationDataElements[3];
			//String gender = arrayOfRegistrationDataElements[3];
			//String Password = arrayOfRegistrationDataElements[4];
			// persist in the database 
			System.out.println("****** userName received form ui ******"+userName);
			System.out.println("****** EmailId received form ui ******"+EmailId);
			System.out.println("****** password received form ui ******"+password);
			//System.out.println("****** profession received form ui ******"+profession);

			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% data spillted #####################################");
			bool = registerUser.register(userName,EmailId,password);
			//bool = registerUser.register(fullname,emailId,category,gender,Password);
			System.out.println("##################### returned bool is #######################"+bool);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		if(bool){
			result = "registered the user successfully";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , registration couldn't be completed ! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 



	//@GET
	//@Path("attachUserNameWithStandardSubjectAddress/{username}/{standard}/{subject}/{address}")
	//	public Response attachUserNameWithCategory(@PathParam("username") String username ,@PathParam("standard") String standard , @PathParam("subject") String subject , @PathParam("address") String address ) {

	//EmailIdRetrivedFromURL/"+EmailId+"/"+ConcatenatedStringOfmultipleSubjectValues,

	/*
	@GET
	@Path("EmailIdRetrivedFromURL/{EmailId}/{ConcatenatedStringOfmultipleSubjectValues}")
	public Response SaveSubjectsToDB(@PathParam("EmailId") String EmailId,@PathParam("ConcatenatedStringOfmultipleSubjectValues") String ConcatenatedStringOfmultipleSubjectValues)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered savepayment #####################################");
		Boolean bool = false;
		String result = "unregistered";
		//String subject[]=null;
		// List<String> list=new ArrayList<String>();

		try {
			//                        System.out.println("data is : "+registrationData);

			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&  Hi neha.you r about to register. &&&&&&&&&&&&&&&&&&&&&&&");
			List<String> list=new ArrayList<String>();
			list.add(ConcatenatedStringOfmultipleSubjectValues);
			// for (int i = 0; i < arrayOfmultipleSubjectValues.length(); i++) {
			//  	 list.add(arrayOfmultipleSubjectValues);
			//String[] arrayOfRegistrationDataElements = arrayOfmultipleSubjectValues.split(",");
			//subject[i] = (String) arrayOfRegistrationDataElements[i];

			//String currentSubject=subject[i];
			//	System.out.println("****** subject received from ui ******"+currentSubject);


			//String password = arrayOfRegistrationDataElements[1];
			//String profession = arrayOfRegistrationDataElements[2];
			//String gender = arrayOfRegistrationDataElements[3];
			//String Password = arrayOfRegistrationDataElements[4];
			// persist in the database 
			//System.out.println("****** EmailId received form ui ******"+EmailId);
			//System.out.println("****** password received form ui ******"+password);
			//System.out.println("****** profession received form ui ******"+profession);

			//System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% data spillted #####################################");
			bool = registerUser.SaveSubjects(EmailId,ConcatenatedStringOfmultipleSubjectValues);
			//i++;
			//}
			//bool = registerUser.register(fullname,emailId,category,gender,Password);
			System.out.println("##################### returned bool is #######################"+bool);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "registered the user successfully";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , registration couldn't be completed ! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
*/
//
	

	
	///UserLocationInfoCapturedThroughMap/"+EmailId+"/"+itemCountry+"/"+itemPc+"/"+itemLocality+"/"+address,
	
	/*@GET
	@Path("UserLocationInfoCapturedThroughMap/{EmailId}/{itemCountry}/{itemPc}/{itemLocality}/{address}")
	public Response UserLocationInfoCapturedThroughMap(@PathParam("EmailId") String EmailId ,@PathParam("itemCountry") String itemCountry , @PathParam("itemPc") String itemPc , @PathParam("itemLocality") String itemLocality, @PathParam("address") String address  ) {
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("itemCountry is : "+itemCountry);
		System.out.println("state is "+itemPc);
		System.out.println("city is : "+itemLocality);
		System.out.println("address is "+address);
		
	
		try {
		bool=registerUser.UserLocationInfoCapturedThroughMapMethod(EmailId,itemCountry,itemPc,itemLocality,address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "saved Locality to DB";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , Location couldn't saved to DB! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
	*/	
		
	@GET
	@Path("UserLocationInfoCapturedThroughMap/{EmailId}/{itemCountry}/{itemPc}/{itemLocality}/{address}")
	public Response UserLocationInfoCapturedThroughMap(@PathParam("EmailId") String EmailId ,@PathParam("itemCountry") String itemCountry , @PathParam("itemPc") String itemPc , @PathParam("itemLocality") String itemLocality, @PathParam("address") String address  ) {
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("itemCountry is : "+itemCountry);
		System.out.println("state is "+itemPc);
		System.out.println("city is : "+itemLocality);
		System.out.println("address is "+address);
		
	
		try {
		bool=registerUser.UserLocationInfoCapturedThroughMapMethod(EmailId,itemCountry,itemPc,itemLocality,address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "saved Locality to DB";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , Location couldn't saved to DB! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
		
	
	
	
	/*
	
	//EmailId+"/"+coursesValue+"/"+fieldValue,
	@GET
	@Path("EmailIdRetrivedFromURL/{EmailId}/{coursesValue}/{fieldValue}")
	public Response SaveSubjectsToDB(@PathParam("EmailId") String EmailId,@PathParam("coursesValue") String coursesValue,@PathParam("fieldValue") String fieldValue)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered savepayment #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("coursesValue is : "+coursesValue);
		System.out.println("fieldValue is "+fieldValue);
		
		
		try {
		bool=registerUser.saveCourseAndFileldUserInfo(EmailId,coursesValue,fieldValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Courses saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 
	*/

/*
	@GET
	@Path("attachUserNameWithStandardSubjectAddress/{username}/{standard}/{subject}/{address}")
	public Response attachUserNameWithCategory(@PathParam("username") String username ,@PathParam("standard") String standard , @PathParam("subject") String subject , @PathParam("address") String address ) {
		String result = "attached all parameters";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("username is : "+username);
		System.out.println("standard is : "+standard);
		System.out.println("subject is "+subject);
		System.out.println("address is "+address);
		try {
			registerUser.saveStandardSubjectAddressForUserName(username,standard,subject,address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication
*/


	/*
	@GET
	@Path("saveUserProfilePic/{EmailId}/{PicUrlData}")
	public Response saveUserProfilePicToDB(@PathParam("EmailId") String EmailId,@PathParam("PicUrlData") String PicUrlData)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%  saveUserProfilePicToDB #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("PicUrlData is : "+PicUrlData);
		
		
		
		try {
		bool=registerUser.saveProfilePic(EmailId,PicUrlData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Courses saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 
*/

	@POST
    @Consumes ("text/plain")
	@Path("saveUserProfilePic")

//	@Path("saveUserProfilePic/{EmailId}/{PicUrlData}")
	public Response saveUserProfilePic(String EmailIdAndPicUrlData)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%  saveUserProfilePic #####################################");
		String result = "pic_unsaved";
		Boolean bool = false;
		
		
		 try {
          //System.out.println("data(EmailIdAndPicUrlData) is : "+EmailIdAndPicUrlData);
               
           
           // parse the data into usernmae , password  , sex and in urlData
           String[] arrayOfEmailIdAndPicUrlDataElements = EmailIdAndPicUrlData.split("vahkh_Khakh");
           String  EmailId= arrayOfEmailIdAndPicUrlDataElements[0];
           String PicUrlData = arrayOfEmailIdAndPicUrlDataElements[1];
           System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
   		  System.out.println("EmailId is : "+EmailId);
   		  System.out.println("PicUrlData is : "+PicUrlData); 
           // persist in the database 
           
           bool = registerUser.saveProfilePic(EmailId,PicUrlData);
           
           
   } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
   }
   if(bool){
           result = "ProfilePic_Saved";
   }
   else {
           result = "ProfilePic_Unsaved";
   }
  System.out.println("result is "+result);
   return Response.status(200).entity(result).build();
} // end of the method register user data 
		
		

	/*
	//updateNameEmailPhone/"+userName+"/"+phoneNo+"/"+EmailId, 
	@GET
	@Path("updateNameEmailPhone/{userName}/{phoneNo}/{genderValue}/{EmailId}")
		
	public Response updateNameEmailPhone(@PathParam("userName") String userName,@PathParam("phoneNo") String phoneNo,@PathParam("genderValue") String genderValue,@PathParam("EmailId") String EmailId)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered updateNameEmailPhone #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("userName is : "+userName);
        System.out.println("phoneNo is : "+phoneNo);
		System.out.println("EmailId is : "+EmailId);
		System.out.println("genderValue is : "+genderValue);
		
		
		try {
		bool=registerUser.updateNameEmailPhoneMethod(userName,phoneNo,genderValue,EmailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Updated";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't update.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 
*/
	
	
	@GET
	@Path("updateNameEmailPhone/{nameVal}/{contactNoVal}/{genderVal}/{EmailId}")
		
	public Response updateNameEmailPhone(@PathParam("nameVal") String nameVal,@PathParam("contactNoVal") String contactNoVal,@PathParam("genderVal") String genderVal,@PathParam("EmailId") String EmailId)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered updateNameEmailPhone #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("userName is : "+nameVal);
        System.out.println("contactNoVal is : "+contactNoVal);
		System.out.println("EmailId is : "+EmailId);
		System.out.println("genderVal is : "+genderVal);
		
		
		try{
		bool=registerUser.updateNameEmailPhoneMethod(nameVal,contactNoVal,genderVal,EmailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Updated";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't update.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	
	
	
	@POST
    @Consumes ("text/plain")
	@Path("sendInvitationAllTime")
	
	public Response sendInvitationAllTime(String senderDetails) {
    	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%  sendInvitationAllTime #####################################");

		String result = "senderDetails unsaved";
		Boolean bool = false;
	 try {
      System.out.println("data(senderDetails) is : "+senderDetails);
 
       
       // parse the data into RecipientEmailId,SenderEmailId,SenderImage,SenderName,SenderCourse,SenderField,
       String[] arrayOfsenderDetails = senderDetails.split("shahjahan123");
       int i=arrayOfsenderDetails.length;
       System.out.println("length is "+i);
       String  RecipientEmailId= arrayOfsenderDetails[0];
       String SenderEmailId = arrayOfsenderDetails[1];
    String SenderImage = arrayOfsenderDetails[2];
      String SenderName = arrayOfsenderDetails[3];
        //String SenderCourse = arrayOfsenderDetails[4];
	  //String SenderField = arrayOfsenderDetails[5]; 
	  String SenderSubjects = arrayOfsenderDetails[4];
   
       System.out.println("888888888888888888888888888888888888888888888888888");
	//	 System.out.println("********connection is *******"+connection);
	System.out.println("********RecipientEmailId is ******* "+RecipientEmailId);
	System.out.println("********SenderEmailId is ******* "+SenderEmailId); 
	System.out.println("********SenderImage is ******* "+SenderImage);
	System.out.println("********SenderName is ******* "+SenderName);
	System.out.println("********SenderSubjects is ******* "+SenderSubjects);
	//System.out.println("********SenderField is ******* "+SenderField);

	 System.out.println("888888888888888888888888888888888888888888888888888");
       // persist in the database 
       
       bool = registerUser.saveSenderDetailsMethod(RecipientEmailId,SenderEmailId,SenderImage,SenderName,SenderSubjects);
       
       
} catch (Exception e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
}
if(bool){
       result = "senderDetails_Saved";
}
else {
       result = "senderDetails_Unsaved";
}
System.out.println("result is "+result);
return Response.status(200).entity(result).build();
} // end of the method sendInvitationAllTime 
	
	
	
	
	//register/deleteNotificationRow/"+senderEmailId
	@GET
	@Path("deleteNotificationRow/{senderEmailId}")
	public Response deleteNotificationRow(@PathParam("senderEmailId") String senderEmailId)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered deleteNotificationRow #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("senderEmailId is : "+senderEmailId);
		
		
		
		try {
		bool=registerUser.deleteNotificationRowMethod(senderEmailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "deleted.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "error in deletion .";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	@GET
	@Path("editUserLocalityCityDistrictStateInfo/{EmailId}/{city}/{district}/{state}/{locality}")
	public Response editUserLocalityCityDistrictStateInfo(@PathParam("EmailId") String EmailId ,@PathParam("city") String city , @PathParam("district") String district , @PathParam("state") String state, @PathParam("locality") String locality  ) {
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("city is : "+city);
		System.out.println("district is "+district);
		System.out.println("state is "+state);
		System.out.println("locality is "+locality);
		
		try {
		bool=registerUser.saveEditedLocalityCityDistrictStateInfoForUser(EmailId,city,district,state,locality);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "saved Locality to DB";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , Location couldn't saved to DB! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
		
	
	
	
	@GET
	@Path("attachBookDetailsWithCategoryAndUserName/{username}/{category}/{bookName}/{pageNumber}/{pageContent}")
	public Response attachBookDetailsWithCategoryAndUserName(@PathParam("username") String username , @PathParam("category") String category,
			@PathParam("bookName") String bookName ,  @PathParam("pageNumber") String pageNumber ,  @PathParam("pageContent") String pageContent) {
		String result = "attached book details ";
		System.out.println("######################");
		System.out.println("username is : "+username);
		System.out.println("category is : "+category);
		try {
			registerUser.saveBookDetails(username, category , bookName , pageNumber , pageContent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//                System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication

	
	
	// not in use 
	/*
	@POST
    @Consumes ("text/plain")
	@Path("sendInvitationForFirstTimeLoggedInUser")
	
	public Response sendInvitationForFirstTimeLoggedInUser(String senderDetails) {
    	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%  sendInvitationForFirstTimeLoggedInUser #####################################");

		String result = "senderDetails unsaved";
		Boolean bool = false;
	 try {
      System.out.println("data(senderDetails) is : "+senderDetails);
 
       
       // parse the data into RecipientEmailId,SenderEmailId,SenderImage,SenderName,SenderCourse,SenderField,
       String[] arrayOfsenderDetails = senderDetails.split("shahjahan123");
       int i=arrayOfsenderDetails.length;
       System.out.println("length is "+i);
       String  RecipientEmailId= arrayOfsenderDetails[0];
       String SenderEmailId = arrayOfsenderDetails[1];
    String SenderImage = arrayOfsenderDetails[2];
      String SenderName = arrayOfsenderDetails[3];
       // String SenderCourse = arrayOfsenderDetails[4];
	  //String SenderField = arrayOfsenderDetails[5]; 
	  String SenderSubjects = arrayOfsenderDetails[4];
   
       System.out.println("888888888888888888888888888888888888888888888888888");
	//	 System.out.println("********connection is *******"+connection);
	System.out.println("********RecipientEmailId is ******* "+RecipientEmailId);
	System.out.println("********SenderEmailId is ******* "+SenderEmailId); 
	System.out.println("********SenderImage is ******* "+SenderImage);
	System.out.println("********SenderName is ******* "+SenderName);
	//System.out.println("********SenderCourse is ******* "+SenderCourse);
	//System.out.println("********SenderField is ******* "+SenderField);
	System.out.println("********SenderSubjects is ******* "+SenderSubjects);
	
	 System.out.println("888888888888888888888888888888888888888888888888888");
       // persist in the database 
       
       bool = registerUser.sendInvitationForFirstTimeLoggedInUserMethod(RecipientEmailId,SenderEmailId,SenderImage,SenderName,SenderSubjects);
       
       
} catch (Exception e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
}
if(bool){
       result = "senderDetails_Saved";
}
else {
       result = "senderDetails_Unsaved";
}
System.out.println("result is "+result);
return Response.status(200).entity(result).build();
} // end of the method sendInvitationAllTime 
	
	*/
	

	//EmailId+"/"+coursesValue+"/"+fieldValue,
	@GET
	@Path("EmailIdRetrivedFromURL/{EmailId}/{commaSepratedListOfSubjects}")
	public Response SaveSubjectsToDB(@PathParam("EmailId") String EmailId,@PathParam("commaSepratedListOfSubjects") String commaSepratedListOfSubjects)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered savepayment #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("coursesValue is : "+commaSepratedListOfSubjects);
		
		
		
		try {
		bool=registerUser.saveCommaSepratedListOfSubjectsMethod(EmailId,commaSepratedListOfSubjects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "items saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	

	//EmailId+"/"+coursesValue+"/"+fieldValue,
	@GET
	@Path("SavedEditedSubjects/{EmailId}/{editedSubjects}")
	public Response SavedEditedSubjects(@PathParam("EmailId") String EmailId,@PathParam("editedSubjects") String editedSubjects)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered savepayment #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("editedSubjects is : "+editedSubjects);
		
		
		
		try {
		bool=registerUser.SavedEditedSubjectsMethod(EmailId,editedSubjects);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Courses saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	
	@GET
	@Path("googleUserDetails/{googleEmailid}/{googleUserName}")
	//googleUserDetails/"+googleEmailid+"/"+googleUserName,//@Path("SavedEditedSubjects/{EmailId}/{editedSubjects}")

	public Response googleUserData(@PathParam("googleEmailid") String googleEmailid,@PathParam("googleUserName") String googleUserName)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered googleUserDetails #####################################");
		Boolean bool = false;
		String result = "unregistered";
		try {

			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&  Hi neha.you r about to register. &&&&&&&&&&&&&&&&&&&&&&&");
			// parse the data into usernmae , password  , sex and in urlData
			//String[] arrayOfRegistrationDataElements = googleUserInfo.split(":");
			//String userName = arrayOfRegistrationDataElements[0];
			//String EmailId = arrayOfRegistrationDataElements[1];
			
			// persist in the database 
			System.out.println("****** userName received form ui ******"+googleEmailid);
			System.out.println("****** EmailId received form ui ******"+googleUserName);
			

			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% data spillted #####################################");
			bool = registerUser.googleUserDetailsRegistration(googleEmailid,googleUserName);
			//bool = registerUser.register(fullname,emailId,category,gender,Password);
			System.out.println("##################### returned bool is #######################"+bool);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		if(bool){
			result = "registered the user successfully";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , registration couldn't be completed ! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 


	
	
	//googleUserDetailsSettingOriginalValues/"+googleEmailid+"/"+googleUserName+"/"+googleProfession+"/"+googlePhoneNo+"/"+googleGender
	@GET
	@Path("googleUserDetailsSettingOriginalValues/{googleEmailid}/{googleUserName}/{googlePassword}/{googleProfession}/{googlePhoneNo}/{googleGender}")
	//googleUserDetails/"+googleEmailid+"/"+googleUserName,//@Path("SavedEditedSubjects/{EmailId}/{editedSubjects}")

	public Response googleUserDetailsSettingOriginalValues(@PathParam("googleEmailid") String googleEmailid,@PathParam("googleUserName") 
	String googleUserName,@PathParam("googlePassword") String googlePassword, @PathParam("googleProfession") String googleProfession,@PathParam("googlePhoneNo") String googlePhoneNo,@PathParam("googleGender") String googleGender)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered googleUserDetails #####################################");
		Boolean bool = false;
		String result = "unregistered";
		try {

			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&  Hi neha.you r about to register. &&&&&&&&&&&&&&&&&&&&&&&");
			// parse the data into usernmae , password  , sex and in urlData
			//String[] arrayOfRegistrationDataElements = googleUserInfo.split(":");
			//String userName = arrayOfRegistrationDataElements[0];
			//String EmailId = arrayOfRegistrationDataElements[1];
			
			// persist in the database 
			System.out.println("****** userName received form ui ******"+googleEmailid);
			System.out.println("****** EmailId received form ui ******"+googleUserName);
			System.out.println("****** Password received form ui ******"+googlePassword);
			System.out.println("****** Profession received form ui ******"+googleProfession);
			System.out.println("****** phoneNo received form ui ******"+googlePhoneNo);
			System.out.println("****** gender received form ui ******"+googleGender);

			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% data spillted #####################################");
			bool = registerUser.googleUserDetailsSettingOriginalValuesMethod(googleEmailid,googleUserName,googlePassword,googleProfession,googlePhoneNo,googleGender);
			//bool = registerUser.register(fullname,emailId,category,gender,Password);
			System.out.println("##################### returned bool is #######################"+bool);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		if(bool){
			result = "registered the user successfully";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , registration couldn't be completed ! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 

	
	
	

	@GET
	@Path("facebookUserDetails/{FacebookEmailId}/{FacebookUName}/{FacebookUGender}")
	//googleUserDetails/"+googleEmailid+"/"+googleUserName,//@Path("SavedEditedSubjects/{EmailId}/{editedSubjects}")

	public Response facebookUserData(@PathParam("FacebookEmailId") String FacebookEmailId,@PathParam("FacebookUName") String FacebookUName,@PathParam("FacebookUGender") String FacebookUGender)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered facebookUserDetails #####################################");
		Boolean bool = false;
		String result = "unregistered";
		try {

			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&  Hi neha.you r about to register. &&&&&&&&&&&&&&&&&&&&&&&");
			// parse the data into usernmae , password  , sex and in urlData
			//String[] arrayOfRegistrationDataElements = googleUserInfo.split(":");
			//String userName = arrayOfRegistrationDataElements[0];
			//String EmailId = arrayOfRegistrationDataElements[1];
			
			// persist in the database 
			System.out.println("****** userName received form ui ******"+FacebookEmailId);
			System.out.println("****** EmailId received form ui ******"+FacebookUName);
			

			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% data spillted #####################################");
			bool = registerUser.facebookUserDetailsRegistration(FacebookEmailId,FacebookUName,FacebookUGender);
			//bool = registerUser.register(fullname,emailId,category,gender,Password);
			System.out.println("##################### returned bool is #######################"+bool);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		if(bool){
			result = "registered the user successfully";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , registration couldn't be completed ! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 

	
	
	
	
	@GET
	@Path("handshakeFlagSet/{senderEmailId}/{RecipientEmailId}")
	public Response handshakeFlagSet(@PathParam("senderEmailId") String senderEmailId ,@PathParam("RecipientEmailId") String RecipientEmailId ) {
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@ handshakeFlagSet");
		System.out.println("senderEmailId is : "+senderEmailId);
		System.out.println("RecipientEmailId is : "+RecipientEmailId);
		
		
		try {
		bool=registerUser.handshakeFlagSetMethod(senderEmailId,RecipientEmailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "YES FLAG SET";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "flag not set";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
		
	
	
	
	@GET
	@Path("Profession/{EmailId}/{professionValue}/{phoneValue}")
	public Response Profession(@PathParam("EmailId") String EmailId ,@PathParam("professionValue") String professionValue ,@PathParam("phoneValue") String phoneValue) {
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("professionValue is : "+professionValue);
		System.out.println("phoneValue is : "+phoneValue);
		
		try {
		bool=registerUser.saveProfession(EmailId,professionValue,phoneValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "profession saved to DB";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , Location couldn't saved to DB! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
		
	
	
	
	
	//updateRecoveryPassword/"
	@GET
	@Path("updateRecoveryPassword/{recoveryEmailId}/{randomPassword}")
		
	public Response updateRecoveryPassword(@PathParam("recoveryEmailId") String recoveryEmailId,@PathParam("randomPassword") String randomPassword)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered updateNameEmailPhone #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("recoveryEmailId is : "+recoveryEmailId);
		System.out.println("randomPassword is : "+randomPassword);
	       
		
		
		try {
		bool=registerUser.updateRecoveryPasswordMethod(recoveryEmailId,randomPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Updated";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't update.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	
	
	@GET
	@Path("PhoneNo/{EmailId}/{phoneValue}")
	public Response PhoneNo(@PathParam("EmailId") String EmailId ,@PathParam("phoneValue") String phoneValue ) {
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("phoneValue is : "+phoneValue);
		
		
		try {
		bool=registerUser.savePhoneNo(EmailId,phoneValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "profession saved to DB";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , Location couldn't saved to DB! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
		
	
	
	

	@GET
	@Path("NewPassword/{EmailId}/{newPass}")
	
	public Response NewPassword(@PathParam("EmailId") String EmailId ,@PathParam("newPass") String newPass) {
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("newPass is : "+newPass);
		
		
		try {
		bool=registerUser.saveNewPassword(EmailId,newPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Saved";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Sorry , Location couldn't saved to DB! ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 

	
	
//	saveAttributes/"+EmailId+"/"+displayTitleValue+"/"+strategyValue+"/"+backgroundValue,
	
	@GET
	@Path("saveAttributes/{EmailId}/{displayTitleValue}/{strategyValue}/{backgroundValue}")
	public Response saveAttributes(@PathParam("EmailId") String EmailId,@PathParam("displayTitleValue") String displayTitleValue, @PathParam("strategyValue") String strategyValue,@PathParam("backgroundValue") String backgroundValue)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered saveAttributes #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("displayTitleValue is : "+displayTitleValue);
		System.out.println("strategyValue is : "+strategyValue);
		System.out.println("backgroundValue is : "+backgroundValue);
		
		try {
		bool=registerUser.saveAttributesMethod(EmailId,displayTitleValue,strategyValue,backgroundValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	

	@GET
	@Path("SaveEditedRates/{EmailId}/{editedRates}")
	public Response SaveEditedRates(@PathParam("EmailId") String EmailId,@PathParam("editedRates") String editedRates)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered SaveEditedRates #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("SaveEditedRates is : "+editedRates);
		
		
		
		try {
		bool=registerUser.SaveEditedRatesMethod(EmailId,editedRates);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Rates Saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "Rates Couldn't be Saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	
	
	
	@GET
	@Path("Attributes/{EmailId}/{displayTitleOnceValue}/{strategyOnceValue}/{backgroundOnceValue}")
	public Response Attributes(@PathParam("EmailId") String EmailId,@PathParam("displayTitleOnceValue") String displayTitleOnceValue, @PathParam("strategyOnceValue") String strategyOnceValue,@PathParam("backgroundOnceValue") String backgroundOnceValue)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered saveAttributes #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("EmailId is : "+EmailId);
		System.out.println("displayTitleOnceValue is : "+displayTitleOnceValue);
		System.out.println("strategyOnceValue is : "+strategyOnceValue);
		System.out.println("backgroundOnceValue is : "+backgroundOnceValue);
		
		try {
		bool=registerUser.saveAttributesMethod(EmailId,displayTitleOnceValue,strategyOnceValue,backgroundOnceValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	

	
	
	@GET
	@Path("saveInventoryData/{StoreEmailIdCategoryCombination}/{category}/{itemsList}")
	public Response saveInventoryData(@PathParam("StoreEmailIdCategoryCombination") String StoreEmailIdCategoryCombination,@PathParam("category") String category,@PathParam("itemsList") String itemsList)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered into saveInventoryData #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("StoreEmailIdCategoryCombination is : "+StoreEmailIdCategoryCombination);
		System.out.println("category is : "+category);
		System.out.println("itemsList is : "+itemsList);
		
		
		
		
		try {
		bool=registerUser.saveInventoryDataMethod(StoreEmailIdCategoryCombination,category,itemsList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Courses saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	

	@GET
	@Path("saveStoreNameEmailId/{storeNameValue}/{emailIdValue}/{StoreEmailIdCategoryCombination}")
	public Response saveStoreNameEmailId(@PathParam("storeNameValue") String storeNameValue,@PathParam("emailIdValue") String emailIdValue,@PathParam("StoreEmailIdCategoryCombination") String StoreEmailIdCategoryCombination)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered into saveStoreNameEmailId #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("storeNameValue is : "+storeNameValue);
		System.out.println("emailIdValue is : "+emailIdValue);
		System.out.println("StoreEmailIdCategoryCombination is : "+StoreEmailIdCategoryCombination);
		
		
		try {
		bool=registerUser.saveStoreNameEmailIdMethod(storeNameValue,emailIdValue,StoreEmailIdCategoryCombination);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Courses saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	
	
	
	
	
		//saveContactNoBankDetails/"+emailIdValue+"/"+contactNoValue+"/"+bankAccountValue,
	
	@GET
	@Path("saveContactNoBankDetails/{emailIdValue}/{contactNoValue}/{bankAccountValue}")
	public Response saveContactNoBankDetails(@PathParam("emailIdValue") String emailIdValue,@PathParam("contactNoValue") String contactNoValue,@PathParam("bankAccountValue") String bankAccountValue)  {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%% entered into saveContactNoBankDetails #####################################");
		String result = "";
		Boolean bool = false;
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("emailIdValue is : "+emailIdValue);
		System.out.println("contactNoValue is : "+contactNoValue);
		System.out.println("bankAccountValue is : "+bankAccountValue);
		
		
		try {
		bool=registerUser.saveContactNoBankDetailsMethod(emailIdValue,contactNoValue,bankAccountValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "Courses saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "couldn't saved.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 

	
	
	
	

	@POST
	@Path("attachBookDetailsWithCategoryAndUserNameThroughPost")
	public Response attachBookDetailsWithCategoryAndUserNameThroughPost(String dataForBookDetailsSaveThroughPost)  {   
		String result = "attached book details ";
		String delimiter = "nishugaurav";
		String[] arrayOfContents = dataForBookDetailsSaveThroughPost.split(delimiter);
		String username = arrayOfContents[0];
		String category = arrayOfContents[1];
		String bookName = arrayOfContents[2];
		String consolidateTopicNumberAndName = arrayOfContents[3];
		String pageContent = arrayOfContents[4];



		try {
			registerUser.saveBookDetails(username, category , bookName , consolidateTopicNumberAndName , pageContent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//                System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} 



}
