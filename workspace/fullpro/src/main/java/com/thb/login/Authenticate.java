package com.thb.login;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.mail.EmailException;

import com.thb.model.RegisterBean;

public interface Authenticate {
	public Boolean authenticateLoginData(String username , String password ) throws SQLException;
	//public RegisterBean getUserData(String userName) throws SQLException;
	public String getBookList(String userName , String category) throws SQLException;
	public String getCategoryListForUser(String userName ) throws SQLException;
	public String getBookDetailsForUserCategoryAndBookName(String username,String category,String bookName)throws SQLException;
	public String getBookDetailsForUserCategoryAndBookId(String username,String category,String bookId)throws SQLException;
	
	public String getUserProfileDataMethod(String EMAILID)throws SQLException;
	
	//public String getTutorsOrStudentsProfileInListMethod(String EMAILID,String course,String field,String state,String city,String district) throws SQLException;
		
	//public String SendInvitationMethod(String requestSender, String recipient) throws SQLException;

	//commenting first 
	//public Boolean SendInvitationMethod(String EMAILID,String INVITEDBY)throws SQLException;

    //public Boolean sendInvitationForFirstTimeLoggedInUserMethod(String SenderEmailId,String RecipientEmailId) throws SQLException;
		
	//public String receiveInvitationInListMethod(String emailId) throws SQLException;
	public String verifyIfUserLogInFirstTimeOrNotMethod(String emailId)throws SQLException;
	//public String getTutorsOrStudentsProfileAllTimeMethod(String EMAILID,String course,String field,String state,String city,String district) throws SQLException;
	//public Boolean sendInvitationAllTimeMethod(String SenderEmailId,String RecipientEmailId) throws SQLException;	
	public RegisterBean getProfilePic(String EmailId) throws SQLException;
	public String getUserNameMethod(String EmailId)throws SQLException;
	public String getAddressMethod(String EmailId)throws SQLException;
	public String getUpdatedNamePhoneNoMethod(String EmailId)throws SQLException;
	public String getPhoneNoMethod(String EmailId)throws SQLException;
	public RegisterBean automaticallyLoadingProfilePicJustAfterLoginMethod(String EmailId) throws SQLException;
	
	public RegisterBean getSenderOtherDetailsAllTimeMethod(String SenderEmailId) throws SQLException;
//	public Boolean sendInvitationAllTimeMethod(String RecipientEmailId,String SenderEmailId,String SenderImage,String SenderName,String SenderCourse,String SenderField) throws SQLException;
	public RegisterBean receiveInvitationInListMethod(String EMAILID) throws SQLException ;
	//public RegisterBean getSenderOtherDetailsMethod(String SenderEmailId) throws SQLException ;
	public String getTutorsOrStudentsProfileInListMethod(String EMAILID,String commaSepratedListOfSubjects,String state,String city) throws SQLException;
	//public String getTutorsOrStudentsProfileAllTimeMethod(String EMAILID,String commaSepratedListOfSubjects,String state,String city,String country) throws SQLException;
	public String getEditableSubjectsMethod(String EmailId)throws SQLException;
	public String getGenderMethod(String EmailId)throws SQLException;
	public String getUserProfileDataForGuestUsersMethod(String EMAILID) throws SQLException;
	public String getUserProfileDataForRegisteredUsersMethod(String EMAILID) throws SQLException;
	//public String getTrendingTutorProfilesMethod() throws SQLException ;
	public RegisterBean getGuestStudentsGroupBasedOnHandshakeFlagMethod(String TutorEmail) throws SQLException ;	
	public RegisterBean getGuestStudentsProfileDataMethod(String studentEmailId) throws SQLException ;
	public String viewIndividualTrendingTutorToGuestMethod(String TutorEmail) throws SQLException ;
	public String viewIndividualTrendingTutorToGuestInNewTabMethod(String TutorEmail) throws SQLException;
	public String getGoogleUserDetailsAlreadySavedBeforeReplaceMethod(String googleEmailid)throws SQLException;
	public boolean sendRecoveryPasswordMethod(String recoveryEmailId,String randomPassword)throws SQLException,EmailException;
	public boolean ifUserRegisteredMethod(String recoveryEmailId)throws SQLException;
	//public String getTrendingTutorProfilesOnScrollMethod() throws SQLException;
	//public String getTrendingTutorProfilesMethod(String itemLocality,String itemCountry,String itemPc) throws SQLException;
	public String getTrendingTutorProfilesMethod2(String itemCountry,String itemPc) throws SQLException ;
	public String getTrendingTutorProfilesMethod1(String itemLocality,String itemCountry,String itemPc) throws SQLException ;
	public String getTutorsOrStudentsProfileAllTimeMethod1(String EMAILID,String commaSepratedListOfSubjects,String state,String cityVar,String country) throws SQLException;
	public String getTutorsOrStudentsProfileAllTimeMethod2(String EMAILID,String commaSepratedListOfSubjects,String state,String country) throws SQLException ;
	public String getTrendingTutorProfilesOnScrollMethod1(String itemLocality,String itemCountry,String itemPc) throws SQLException;
	public String getTrendingTutorProfilesOnScrollMethod2(String itemCountry,String itemPc) throws SQLException ;
	public String getCurrentPasswordMethod(String EmailId)throws SQLException;
	public String getAttributesMethod(String EmailId)throws SQLException;
	
	public String getTrendingTutorProfilesByCategoryMethod2(String itemCountry,String itemPc,String subj) throws SQLException;
		
	public String getTrendingTutorProfilesByCategoryMethod1(String itemLocality,String itemCountry,String itemPc,String subj) throws SQLException;
	

	public String getCategoryDataMethod(String name)throws SQLException, FileNotFoundException;
	public String verifyIfStoreEmailCategoryPresentMethod(String emailIdValue)throws SQLException;
}