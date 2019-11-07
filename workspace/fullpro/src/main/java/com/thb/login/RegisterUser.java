
package com.thb.login;

import java.sql.SQLException;

public interface RegisterUser {
	//public Boolean register(String fullname, String emailId, String category , String gender,String Password) throws SQLException;
	//public Boolean register(String fullname, String emailId, String category , String gender) throws SQLException;
	public Boolean register(String userName,String emailId, String password) throws SQLException;


	public void saveStandardSubjectAddressForUserName(String userName,String standard,String subject,String address) throws SQLException;
	public void saveBookDetails(String username, String category , String bookName ,String pageNumber,String pageContent) throws SQLException;


	//public Boolean SaveSubjects(String EmailId,String Subjects)throws SQLException;


	//public Boolean saveLocalityCityDistrictStateInfoForUser(String emailId,
			//String city, String district, String state,
			//String locality) throws SQLException;

	//public Boolean saveCourseAndFileldUserInfo(String emailId,String coursesValue,String fieldValue)throws SQLException ;
	public Boolean saveProfilePic(String EmailId,String PicUrlData)throws SQLException; 
	
	//public Boolean updateNameEmailPhoneMethod(String userName,String phoneNo,String genderValue,String EmailId)throws SQLException ;
	
	public Boolean saveSenderDetailsMethod(String RecipientEmailId,String SenderEmailId,String SenderImage,String SenderName,String SenderSubjects)throws SQLException;
	
	//public Boolean sendInvitationForFirstTimeLoggedInUserMethod(String RecipientEmailId,String SenderEmailId,String SenderImage,String SenderName,String SenderSubjects)throws SQLException;
	public Boolean deleteNotificationRowMethod(String senderEmailId)throws SQLException;	
	public Boolean saveCommaSepratedListOfSubjectsMethod(String emailId,String commaSepratedListOfSubjects)throws SQLException ;
	public Boolean saveEditedLocalityCityDistrictStateInfoForUser(String emailId,String city, String district, String state,String locality)throws SQLException;
	public Boolean SavedEditedSubjectsMethod(String emailId,String editedSubjects)throws SQLException ;
	public Boolean googleUserDetailsRegistration(String googleEmailid,String googleUserName) throws SQLException ;
	public Boolean facebookUserDetailsRegistration(String FacebookEmailId,String FacebookUName,String FacebookUGender)throws SQLException;

//	public Boolean saveProfession(String emailId,String professionValue)throws SQLException;
	public Boolean handshakeFlagSetMethod(String senderEmailId,String RecipientEmailId)throws SQLException;
	public Boolean googleUserDetailsSettingOriginalValuesMethod(String googleEmailid,String googleUserName,String googlePassword,String googleProfession,String googlePhoneNo,String googleGender) throws SQLException;
	public Boolean updateRecoveryPasswordMethod(String randomPassword,String recoveryEmailId)throws SQLException;
	public Boolean UserLocationInfoCapturedThroughMapMethod(String EmailId,String itemCountry,String itemPc,String itemLocality,String address)throws SQLException ;
	public Boolean savePhoneNo(String emailId,String phoneValue)throws SQLException;
	public Boolean saveProfession(String emailId,String professionValue,String phoneValue)throws SQLException;
	public Boolean saveNewPassword(String emailId,String newPass)throws SQLException;
	public Boolean updateNameEmailPhoneMethod(String nameVal,String contactNoVal,String genderVal,String EmailId)throws SQLException;
	public Boolean saveAttributesMethod(String EmailId,String displayTitleValue,String strategyValue,String backgroundValue)throws SQLException;
	public Boolean SaveEditedRatesMethod(String emailId,String editedRates)throws SQLException;
	
	
	public Boolean saveInventoryDataMethod(String StoreEmailIdCategoryCombination,String category,String itemsList)throws SQLException;
	public Boolean saveStoreNameEmailIdMethod(String storeNameValue,String emailIdValue,String StoreEmailIdCategoryCombination)throws SQLException ;
	public Boolean saveContactNoBankDetailsMethod(String emailIdValue,String contactNoValue,String bankAccountValue)throws SQLException ;
		
}