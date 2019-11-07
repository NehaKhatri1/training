package com.thb.webservice.rest;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thb.login.Authenticate;

import com.thb.model.RegisterBean;

@Component
@Path("/login")
public class AuthenticationService {
	@Autowired
	Authenticate  authenticate;
	RegisterBean registerBean;


	@GET
	@Path("{userCredentials}")
	public Response savePayment(@PathParam("userCredentials") String userCredentials) {
		String[] parsedLoginData = userCredentials.split(":");
		String emailId = parsedLoginData[0];
		String password = parsedLoginData[1];
		Boolean bool = false;
		String result = "unauthenticated";
		try {
			System.out.println(emailId);
			System.out.println(password);
			bool = authenticate.authenticateLoginData(emailId,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "authenticated";
		}
		else {
			result = "unauthenticated";
		}
		System.out.println(" authentication result is :"+result+":");
		return Response.status(200).entity(result).build();
	} // end of method login authentication



/*
	//String EMAILID,String coursesValue,String fieldValue,String state,String city,String district
	@GET
	@Path("getTutorsOrStudentsProfileInList/{EmailId}/{course}/{field}/{state}/{city}/{district}")
	public Response getTutorsOrStudentsProfileInList(@PathParam("EmailId") String EmailId,@PathParam("course") String course,@PathParam("field") String field,@PathParam("state") String state,@PathParam("city") String city,@PathParam("district") String district) {
		String result = "";
		System.out.println("**** i am under getTutorsOrStudentsProfileInList method  &&&&&&&&");
		try {
			result = authenticate.getTutorsOrStudentsProfileInListMethod(EmailId,course,field,state,city,district);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***** result is ****"+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication

*/

	/* commenting first  
       //SendInvitation/"+InvitedBy+"/"+EmailId,
        @GET
       // @Produces(MediaType.APPLICATION_JSON )///INVITEDBY+"/"+EMAILID,
        @Path("SendInvitation/{EMAILID}/{INVITEDBY}")
        public Response SendInvitation(@PathParam("EMAILID") String EMAILID,@PathParam("INVITEDBY") String INVITEDBY) {
                String result = "";
                Boolean bool = false;
                try {
                        bool = authenticate.SendInvitationMethod(EMAILID,INVITEDBY);
                        System.out.println("******** getting bool in main ******"+bool);
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                	System.out.println("******** I am in catch of main *******");
                        e.printStackTrace();
                }

        if(bool){
    		result = "Congrates!! Entry made into InvitedBy column.";
    		System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
    	}
    	else {
    		result = "failed  to make entry";
    		System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
    	}
    	System.out.println("result is "+result);
    	return Response.status(200).entity(result).build();
    } // end of the method register user data 

	 */

	/*
	@GET
	// @Produces(MediaType.APPLICATION_JSON )///INVITEDBY+"/"+EMAILID,
	@Path("sendInvitationForFirstTimeLoggedInUser/{SenderEmailId}/{RecipientEmailId}")  
	public Response sendInvitation(@PathParam("SenderEmailId") String SenderEmailId,@PathParam("RecipientEmailId") String RecipientEmailId) {
		String result = "";
		Boolean bool = false;
		try {
			bool = authenticate.sendInvitationForFirstTimeLoggedInUserMethod(SenderEmailId,RecipientEmailId);
			System.out.println("******** getting bool in main ******"+bool);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("******** I am in catch of main *******");
			e.printStackTrace();
		}

		if(bool){
			result = "Congrates!! Entry made into InvitedBy column.";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = "failed  to make entry";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
*/

	/*
	//  ReceiveInvitation/"+EmailId,  " +
	@GET
	@Path("receiveInvitation/{EmailId}")
	public Response receiveInvitationInList(@PathParam("EmailId") String EmailId ) {
		String result = "";
		System.out.println("**** i am under receiveInvitationInList method  &&&&&&&&");
		try {
			result = authenticate.receiveInvitationInListMethod(EmailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***** result is ****"+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication

*/
	
	
	
	// Method to verify If user already selected(Means not first time user) subjects from MutlipleSubjectSelectionDiv.
	
	@GET
	@Path("verifyIfUserLogInFirstTimeOrNot/{EmailId}")
	public Response verifyIfUserLogInFirstTimeOrNot(@PathParam("EmailId") String EmailId ) {
		String result = "";
		System.out.println("**** i am under verifyIfUserLogInFirstTimeOrNot method  &&&&&&&&");
		try {
			result = authenticate.verifyIfUserLogInFirstTimeOrNotMethod(EmailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***** result is ****"+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication



//  getProfiles/"+EmailId,  " +
	@GET
	@Path("getUserProfileData/{EmailId}")
	public Response getUserProfileData(@PathParam("EmailId") String EmailId ) {
		String result = "";
		System.out.println("**** i am under getUserProfileData method  &&&&&&&&");
		try {
			result = authenticate.getUserProfileDataMethod(EmailId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("***** result is ****"+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication


	/*
//	getTutorsOrStudentsProfileAllTime

	//String EMAILID,String coursesValue,String fieldValue,String state,String city,String district
		@GET
		@Path("getTutorsOrStudentsProfileAllTime/{EmailId}/{course}/{field}/{state}/{city}/{district}")
		public Response getTutorsOrStudentsProfileAllTheTime(@PathParam("EmailId") String EmailId,@PathParam("course") String course,@PathParam("field") String field,@PathParam("state") String state,@PathParam("city") String city,@PathParam("district") String district) {
			String result = "";
			System.out.println("**** i am under getTutorsOrStudentsProfileAllTime   &&&&&&&&");
			try {
				result = authenticate.getTutorsOrStudentsProfileAllTimeMethod(EmailId,course,field,state,city,district);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication


*/
		
	/*
	@GET
		@Path("getTutorsOrStudentsProfileAllTime/{EmailId}/{commaSepratedListOfSubjects}/{state}/{city}/{country}")
		public Response getTutorsOrStudentsProfileAllTheTime(@PathParam("EmailId") String EmailId,@PathParam("commaSepratedListOfSubjects") String commaSepratedListOfSubjects,@PathParam("state") String state,@PathParam("city") String city,@PathParam("country") String country) {
			String result = "";
			System.out.println("**** i am under getTutorsOrStudentsProfileAllTime   &&&&&&&&");
			try {
				result = authenticate.getTutorsOrStudentsProfileAllTimeMethod(EmailId,commaSepratedListOfSubjects,state,city,country);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//	System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication
*/
		
		
		@GET
		@Path("getTutorsOrStudentsProfileAllTime/{EmailId}/{commaSepratedListOfSubjects}/{state}/{city}/{country}")
		public Response getTutorsOrStudentsProfileAllTheTime(@PathParam("EmailId") String EmailId,@PathParam("commaSepratedListOfSubjects") String commaSepratedListOfSubjects,@PathParam("state") String state,@PathParam("city") String city,@PathParam("country") String country) {
			String result = "";
			System.out.println("**** i am under getTutorsOrStudentsProfileAllTime   &&&&&&&&");
			System.out.println("EmailId is"+EmailId);
			System.out.println("commaSepratedListOfSubjects is "+commaSepratedListOfSubjects);
			System.out.println("itemPc/state is "+state);
			System.out.println("city is "+city);
			System.out.println("country is "+country);
			
			
		    String cityVar=city;
		  //  city="Jaipur";
		    System.out.println("cityVar is"+cityVar);
		    
	
			try {
				 System.out.println("inside try ");
                   if(cityVar=="1" || cityVar.equals("1") || cityVar.equalsIgnoreCase("1") ){
				   
					System.out.println("%%%%%%%%%% 1 case if clause ALLTIME  %%%%%%%");
				// result = authenticate.getTrendingTutorProfilesMethod2(itemCountry,itemPc);
				 result = authenticate.getTutorsOrStudentsProfileAllTimeMethod2(EmailId,commaSepratedListOfSubjects,state,country);
					
				}
				else{
					
					 System.out.println("%%%%%%%%%% valid city case ALLTIME %%%%%%%");
					//result = authenticate.getTrendingTutorProfilesMethod1(itemLocality,itemCountry,itemPc);
					
					result = authenticate.getTutorsOrStudentsProfileAllTimeMethod1(EmailId,commaSepratedListOfSubjects,state,cityVar,country);
					
				}
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
		
		
	

	/*
		@GET
		// @Produces(MediaType.APPLICATION_JSON )///INVITEDBY+"/"+EMAILID,
		@Path("sendInvitationAllTime/{SenderEmailId}/{RecipientEmailId}")  
		public Response sendInvitationAllTime(@PathParam("SenderEmailId") String SenderEmailId,@PathParam("RecipientEmailId") String RecipientEmailId) {
			String result = "";
			Boolean bool = false;
			try {
				bool = authenticate.sendInvitationAllTimeMethod(SenderEmailId,RecipientEmailId);
				System.out.println("******** getting bool in main ******"+bool);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("******** I am in catch of main *******");
				e.printStackTrace();
			}

			if(bool){
				result = "Congrates!! Entry made into InvitedBy column.";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				result = "failed  to make entry";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			System.out.println("result is "+result);
			return Response.status(200).entity(result).build();
		} // end of the method register user data 


	*/
		
		
	
		
		///getProfilePic/"+EmailId,
		@GET
        @Path("getProfilePic/{EmailId}")
        public Response getProfilePic(@PathParam("EmailId") String EmailId) {
                String result = "unauthenticated";
               
				try {
                        System.out.println(EmailId);
                         registerBean = authenticate.getProfilePic(EmailId);
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                if(registerBean==null){
                        result = "Sorry , some issues in retrieving profile pic. !";
                        System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
                }
                else {
                        result = registerBean.getUrlData();
                        System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
                }
              System.out.println("result is "+result);
                return Response.status(200).entity(result).build();
        } // end of method login authentication
        
		
	//	login/getUserName/"+EmailId,	
		@GET
		@Path("getUserName/{EmailId}")
		public Response getUserName(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method getUserName");
			try {
				result = authenticate.getUserNameMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of username is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method login authentication

	//	getAddress
		@GET
		@Path("getAddress/{EmailId}")
		public Response getAddress(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method EmailId");
			try {
				result = authenticate.getAddressMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getAddress is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method  getAddress
		
		
	//	/getUpdatedNamePhoneNo/"+EmailId,
		@GET
		@Path("getUpdatedNamePhoneNo/{EmailId}")
		public Response getUpdatedNamePhoneNo(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method getUpdatedNamePhoneNo");
			try {
				result = authenticate.getUpdatedNamePhoneNoMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of updatedNameAndPhone is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getUpdatedNamePhoneNo

	
		
		
		@GET
		@Path("getPhoneNo/{EmailId}")
		public Response getPhoneNo(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method getPhoneNo");
			try {
				result = authenticate.getPhoneNoMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getPhoneNo is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		

	//automaticallyLoadingProfilePicJustAfterLogin/"+EmailId,

	@GET
	@Path("automaticallyLoadingProfilePicJustAfterLogin/{EmailId}")
	public Response automaticallyLoadingProfilePicJustAfterLogin(@PathParam("EmailId") String EmailId) {
		String result = "unauthenticated";

		try {
			System.out.println(EmailId);
			registerBean = authenticate.automaticallyLoadingProfilePicJustAfterLoginMethod(EmailId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(registerBean==null){
			result = "Not able to retrieve profilePic from DB & render in circular UserProfilePic Area. ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = registerBean.getUrlData();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		//System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication

	
	
	//login/getSenderOtherDetailsAllTime/"+SenderEmailId,
	@GET
	@Path("getSenderOtherDetailsAllTime/{SenderEmailId}")
	public Response getSenderOtherDetailsAllTime(@PathParam("SenderEmailId") String SenderEmailId) {
		String result = "unauthenticated";

		try {
			System.out.println(SenderEmailId);
			registerBean = authenticate.getSenderOtherDetailsAllTimeMethod(SenderEmailId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(registerBean==null){
			result = "Not able to retrieve profilePic from DB. ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = registerBean.getUrlData();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication

	
	
	
	@GET
	@Path("receiveInvitation/{EmailId}")
	public Response receiveInvitationInList(@PathParam("EmailId") String EmailId ) {
		String result = "";
		System.out.println("**** i am under receiveInvitationInList method  &&&&&&&&");
		try {
			System.out.println("Emailid is "+EmailId);
			registerBean = authenticate.receiveInvitationInListMethod(EmailId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(registerBean==null){
			result = "Not able to retrieve profilePic from DB & render in circular UserProfilePic Area. ";
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
		}
		else {
			result = registerBean.getUrlData();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
		}
		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login receiveInvitation

	
	
	// not in use now 
	/*	@GET
		@Path("getSenderOtherDetails/{SenderEmailId}")
		public Response getSenderOtherDetails(@PathParam("SenderEmailId") String SenderEmailId) {
			String result = "unauthenticated";

			try {
				System.out.println(SenderEmailId);
				registerBean = authenticate.getSenderOtherDetailsMethod(SenderEmailId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(registerBean==null){
				result = "Not able to retrieve profilePic from DB. ";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				result = registerBean.getUrlData();
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			System.out.println("result is "+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication
*/
	
		
	//	getTutorsOrStudentsProfileInList/"+EmailId+"/"+commaSepratedListOfSubjects+"/"+state+"/"+city+"/"+district,
	     
		@GET
		@Path("getTutorsOrStudentsProfileInList/{EmailId}/{commaSepratedListOfSubjects}/{state}/{city}")
		public Response getTutorsOrStudentsProfileInList(@PathParam("EmailId") String EmailId,@PathParam("commaSepratedListOfSubjects") String commaSepratedListOfSubjects,@PathParam("state") String state,@PathParam("city") String city) {
			String result = "";
			System.out.println("**** i am under getTutorsOrStudentsProfileInList method  &&&&&&&&");
			try {
				result = authenticate.getTutorsOrStudentsProfileInListMethod(EmailId,commaSepratedListOfSubjects,state,city);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
		
		
		
		//login/editableSubjects/"+EmailId," 
		
		@GET
		@Path("getEditableSubjects/{EmailId}")
		public Response getEditableSubjects(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method getEditableSubjects");
			try {
				result = authenticate.getEditableSubjectsMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getEditableSubjects is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		

		@GET
		@Path("getGender/{EmailId}")
		public Response getGender(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("<<<<<<<<<<<<< entered into method getGender >>>>>>>>>>");
			try {
				result = authenticate.getGenderMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getPhoneNo is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		
	
		/*
		//getProfiles/"+EmailId,  " +
		@GET
		@Path("getUserProfileDataForGuestUsers/{EmailId}")
		public Response getUserProfileDataForGuestUsers(@PathParam("EmailId") String EmailId ) {
			String result = "";
			System.out.println("**** i am under getUserProfileDataForGuestUsers method  &&&&&&&&");
			try {
				result = authenticate.getUserProfileDataForGuestUsersMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication
*/
		
		@GET
		@Path("getUserProfileDataForGuestUsers/{EMAILID}")
		public Response getUserProfileDataForGuestUsers(@PathParam("EMAILID") String EMAILID) {
			String result = "";
			System.out.println("**** i am under getUserProfileDataForGuestUsers   &&&&&&&&");
			try {
				result = authenticate.getUserProfileDataForGuestUsersMethod(EMAILID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
		
		@GET
		@Path("getUserProfileDataForRegisteredUsers/{EMAILID}")
		public Response getUserProfileDataForRegisteredUsers(@PathParam("EMAILID") String EMAILID) {
			String result = "";
			System.out.println("**** i am under getUserProfileDataForRegisteredUsers   &&&&&&&&");
			try {
				result = authenticate.getUserProfileDataForRegisteredUsersMethod(EMAILID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
		
		/*@GET
		@Path("getTrendingTutorProfiles")
		public Response getTrendingTutorProfiles() {
			String result = "";
			System.out.println("**** i am under getUserProfileDataForGuestUsers   &&&&&&&&");
			try {
				result = authenticate.getTrendingTutorProfilesMethod();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication
		*/
		
		
//	s/"+itemCountry+"/"+itemPc+"/"+itemLocality,      
		 
		@GET
		@Path("getTrendingTutorProfiles/{itemLocality}/{itemCountry}/{itemPc}")
		public Response getTrendingTutorProfiles(@PathParam("itemCountry") String itemCountry,@PathParam("itemPc") String itemPc,@PathParam("itemLocality") String itemLocality) {
			String result = "";
			System.out.println("**** i am under getTrendingTutorProfiles   &&&&&&&&");
			System.out.println("itemLocality is $$$$$"+itemLocality);
			System.out.println("itemCountry is "+itemCountry);
			System.out.println("itemPc/state is "+itemPc);
			
		    String city=itemLocality;
		  //  city="Jaipur";
		    System.out.println("city is"+city);
		   
	
			try {
				 System.out.println("inside try ");
                   if(city=="1" || city.equals("1") || city.equalsIgnoreCase("1") ){
				   
					System.out.println("%%%%%%%%%% 1 case if clause  %%%%%%%");
				 result = authenticate.getTrendingTutorProfilesMethod2(itemCountry,itemPc);
				
				}
				else{
					
					 System.out.println("%%%%%%%%%% valid city case %%%%%%%");
					result = authenticate.getTrendingTutorProfilesMethod1(itemLocality,itemCountry,itemPc);
				}
				 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
		
		
		
		
		
	//	/login/getGuestStudentsGroupBasedOnHandshakeFlag/"+TutorEmail,     
		
		
		@GET
		@Path("getGuestStudentsGroupBasedOnHandshakeFlag/{TutorEmail}")
		public Response getGuestStudentsGroupBasedOnHandshakeFlag(@PathParam("TutorEmail") String TutorEmail) {
			String result = "";
			System.out.println("**** i am under getGuestStudentsGroupBasedOnHandshakeFlag method  &&&&&&&&");
			try {
				System.out.println("TutorEmail is "+TutorEmail);
				registerBean = authenticate.getGuestStudentsGroupBasedOnHandshakeFlagMethod(TutorEmail);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(registerBean==null){
				result = "Not able to retrieve studentsGroupList from DB ";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				result = registerBean.getUrlData();
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			System.out.println("result is "+result);
			return Response.status(200).entity(result).build();
		} // end of method login receiveInvitation

		
		
		
		

	//  getGuestStudentsProfileData/"+studentEmailId
		@GET
		@Path("getGuestStudentsProfileData/{studentEmailId}")
		public Response getGuestStudentsProfileData(@PathParam("studentEmailId") String studentEmailId ) {
			String result = "";
			System.out.println("**** i am under getGuestStudentsProfileData method  &&&&&&&&");
			try {
				registerBean = authenticate.getGuestStudentsProfileDataMethod(studentEmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(registerBean==null){
                 result = "Sorry , some issues in retrieving profile data. !";
                 System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
         }
         else {
                 result = registerBean.getUrlData();
                 System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
         }
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication


		
		
		@GET
		@Path("viewIndividualTrendingTutorToGuest/{TutorEmail}")
		public Response viewIndividualTrendingTutorToGuest(@PathParam("TutorEmail") String TutorEmail) {
			String result = "";
			System.out.println("**** i am under viewIndividualTrendingTutorToGuest   &&&&&&&&");
			try {
				result = authenticate.viewIndividualTrendingTutorToGuestMethod(TutorEmail);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
		
		@GET
		@Path("viewIndividualTrendingTutorToGuestInNewTab/{TutorEmail}")
		public Response viewIndividualTrendingTutorToGuestInNewTab(@PathParam("TutorEmail") String TutorEmail) {
			String result = "";
			System.out.println("**** i am under viewIndividualTrendingTutorToGuestInNewTab   &&&&&&&&");
			try {
				result = authenticate.viewIndividualTrendingTutorToGuestInNewTabMethod(TutorEmail);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
		
		
		///login/getGoogleUserDetailsAlreadySavedBeforeReplace/"+googleEmailid,
		@GET
		@Path("getGoogleUserDetailsAlreadySavedBeforeReplace/{googleEmailid}")
		public Response getGoogleUserDetailsAlreadySavedBeforeReplace(@PathParam("googleEmailid") String googleEmailid) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("<<<<<<<<<<<<< entered into method getGoogleUserDetailsAlreadySavedBeforeReplace >>>>>>>>>>");
			try {
				result = authenticate.getGoogleUserDetailsAlreadySavedBeforeReplaceMethod(googleEmailid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else(null value received) clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getGoogleUserDetailsAlreadySavedBeforeReplace is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		
		@GET
		@Path("sendRecoveryPassword/{recoveryEmailId}/{randomPassword}")
		public Response sendRecoveryPassword(@PathParam("recoveryEmailId") String recoveryEmailId,@PathParam("randomPassword") String randomPassword) {
			String result= "";
			boolean resultInBool = false;
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method sendRecoveryPassword");
			try {
				resultInBool = authenticate.sendRecoveryPasswordMethod(recoveryEmailId,randomPassword);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resultInBool==true){
				result = "Mail Delivered";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				result = "Error In Mail Delivery ";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of sendRecoveryPassword is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		
		// ifUserRegistered/"+recoveryEmailId,  
		@GET
		@Path("ifUserRegistered/{recoveryEmailId}")
		public Response recoveryEmailId(@PathParam("recoveryEmailId") String recoveryEmailId) {
			String result = "";
			boolean resultBoolean = false;
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method ifUserRegistered");
			try {
				resultBoolean = authenticate.ifUserRegisteredMethod(recoveryEmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resultBoolean==true){
		     	result = "User Exists!!!";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause.User exists @@@@@@@@@@@@@@@@@");
			}
			else {
				result = "user does not exist.";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause.user does not exist .@@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of ifUserRegistered is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		/*
		@GET
		@Path("getTrendingTutorProfilesOnScroll")
		public Response getTrendingTutorProfilesOnScroll() {
			String result = "";
			System.out.println("**** i am in getTrendingTutorProfilesOnScrollMethod   &&&&&&&&");
			try {
				result = authenticate.getTrendingTutorProfilesOnScrollMethod();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication

		
	//	/login/getGuestStudentsGroupBasedOnHandshakeFlag/"+TutorEmail,     
		*/
	
	
		
		
	
		//getTrendingTutorProfilesOnScroll/"+itemLocality+"/"+itemCountry+"/"+itemPc,     
		@GET
		@Path("getTrendingTutorProfilesOnScroll/{itemLocality}/{itemCountry}/{itemPc}")
		public Response getTrendingTutorProfilesOnScroll(@PathParam("itemLocality") String itemLocality ,@PathParam("itemCountry") String itemCountry ,@PathParam("itemPc") String itemPc) {
			String result = "";
			
			System.out.println("**** i am in getTrendingTutorProfilesOnScrollMethod   &&&&&&&&");
			System.out.println("itemLocality is"+itemLocality);
			System.out.println("itemCountry is "+itemCountry);
			System.out.println("itemPc/state is "+itemPc);
			
		    String city=itemLocality;
		  //  city="Jaipur";
		    System.out.println("city is"+city);
			
			try {
				 System.out.println("inside try ");
	               if(city=="1" || city.equals("1") || city.equalsIgnoreCase("1") ){
				   
					System.out.println("%%%%%%%%%% 1 case if clause  %%%%%%%");
				result = authenticate.getTrendingTutorProfilesOnScrollMethod2(itemCountry,itemPc);
			} 
	            else{
						
						 System.out.println("%%%%%%%%%% valid city case %%%%%%%");
						result = authenticate.getTrendingTutorProfilesOnScrollMethod1(itemLocality,itemCountry,itemPc);
					}
			}
	          catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication


		   
		
		
		
		@GET
		@Path("getCurrentPassword/{EmailId}")
		public Response getCurrentPassword(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method getCurrentPassword");
			try {
				result = authenticate.getCurrentPasswordMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getPhoneNo is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		
		

		@GET
		@Path("getAttributes/{EmailId}")
		public Response getAttributes(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method getAttributes");
			try {
				result = authenticate.getAttributesMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getAttributes is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		
		//login/getTrendingTutorProfilesByCategory/"+itemLocality+"/"+itemCountry+"/"+itemPc+"/"+subj,    

		     
		@GET
		@Path("getTrendingTutorProfilesByCategory/{itemLocality}/{itemCountry}/{itemPc}/{subj}")
		public Response getTrendingTutorProfilesByCategory(@PathParam("itemLocality") String itemLocality ,@PathParam("itemCountry") String itemCountry ,@PathParam("itemPc") String itemPc,@PathParam("subj") String subj) {
			String result = "";
			
			System.out.println("**** i am in getTrendingTutorProfilesOnScrollMethod   &&&&&&&&");
			System.out.println("itemLocality is"+itemLocality);
			System.out.println("itemCountry is "+itemCountry);
			System.out.println("itemPc/state is "+itemPc);
			System.out.println("subj is "+subj);
			
			
		    String city=itemLocality;
		  //  city="Jaipur";
		    System.out.println("city is"+city);
			
			try {
				 System.out.println("inside try ");
	               if(city=="1" || city.equals("1") || city.equalsIgnoreCase("1") ){
				   
					System.out.println("%%%%%%%%%% 1 case if clause  %%%%%%%");
				result = authenticate.getTrendingTutorProfilesByCategoryMethod2(itemCountry,itemPc,subj);
			} 
	            else{
						
						 System.out.println("%%%%%%%%%% valid city case %%%%%%%");
						result = authenticate.getTrendingTutorProfilesByCategoryMethod1(itemLocality,itemCountry,itemPc,subj);
					}
			}
	          catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication


		
		
		@GET
		@Path("getAttributesDefault/{EmailId}")
		public Response getAttributesDefault(@PathParam("EmailId") String EmailId) {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("entered into method getAttributesDefault");
			try {
				result = authenticate.getAttributesMethod(EmailId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getAttributesDefault is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		
		@GET
		@Path("getCategoryData/{name}")
		public Response getCategoryData(@PathParam("name") String name) throws FileNotFoundException {
			String result = "";
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("<<<<<<<<<<<<< entered into method getCategoryData >>>>>>>>>>");
			try {
				result = authenticate.getCategoryDataMethod(name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result!=""){
			//	result = "Congrates!! we are able to retrive username .";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in if clause. @@@@@@@@@@@@@@@@@");
			}
			else {
				//result = "failed  to retrive username";
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%% in else clause. @@@@@@@@@@@@@@@@@");
			}
			  System.out.println("result of getPhoneNo is "+result);
			  System.out.println(" ");
			  System.out.println(" ");
			return Response.status(200).entity(result).build();
		} // end of method getPhoneNo
		
		
		
		
		
		//verifyIfStoreEmailCategoryPresent/"+emailIdValue
		
		@GET
		@Path("verifyIfStoreEmailCategoryPresent/{emailIdValue}")
		public Response verifyIfStoreEmailCategoryPresent(@PathParam("emailIdValue") String emailIdValue ) {
			String result = "";
			System.out.println("**** i am under verifyIfStoreEmailCategoryPresent method  &&&&&&&&");
			try {
				result = authenticate.verifyIfStoreEmailCategoryPresentMethod(emailIdValue);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("***** result in verifyIfStoreEmailCategoryPresent is ****"+result);
			return Response.status(200).entity(result).build();
		} // end of method login authentication


		
	
		
	@GET
	@Path("getBookDetails/{username}/{category}/{bookName}")
	public Response getBookDetailsForUserCategoryAndBookName(@PathParam("username") String username , @PathParam("category") String category , @PathParam("bookName") String bookName) {
		String result = "";
		System.out.println("entered the method for getBookDetails . ");
		try {
			result = authenticate.getBookDetailsForUserCategoryAndBookName(username,category,bookName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	} // end of method login authentication

	@GET
	@Path("getBookDetailsByBookId/{username}/{category}/{bookId}")
	public Response getBookDetailsForUserCategoryAndBookId(@PathParam("username") String username , @PathParam("category") String category , @PathParam("bookId") String bookId) {
		String result = "";
		System.out.println("entered the method for getBookDetails . ");
		try {
			result = authenticate.getBookDetailsForUserCategoryAndBookId(username,category,bookId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	} // end of method login authentication

	@GET
	@Path("getCategoriesListForUser/{username}")
	public Response getCategoriesListForUser(@PathParam("username") String username ) {
		String result = "";
		try {
			result = authenticate.getCategoryListForUser(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	} // end of method login authentication

}
