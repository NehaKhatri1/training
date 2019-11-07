package com.thb.db;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class twilioSMSGateway {

  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC61e79ac5804d3ac132a8ccc7b394957d";
  public static final String AUTH_TOKEN = "5289fe3f07e4dfa518fff3cf4815ad29";

  public static void main(String[] args) throws TimeoutException {
    TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
 //   TwilioRestClient client = new TwilioRestClient(userSms.getAccountSid(), userSms.getAuthToken());
//  String toNumber="+918800236796";
 // String FromNumber="+918800236796";
    //to solve if arabic numbers was submitted and avoid exceptiono
    // com.twilio.sdk.TwilioRestException: The 'To' number +???????????? is not a valid phone number.
   // long phoneNumber = Long.parseLong(toNumber.replace("+", ""));// remove plus just in case cause strange parse is working ! with +s
    
    // Build a filter for the MessageList
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    params.add(new BasicNameValuePair("Body", "lets send text via Java code!!"));
    params.add(new BasicNameValuePair("To","918800236796"));
    params.add(new BasicNameValuePair("From","918800236796"));

    MessageFactory messageFactory = client.getAccount().getMessageFactory();
    Message message;
	try {
		message = messageFactory.create(params);
		 System.out.println(message.getSid());
	} catch (TwilioRestException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
  }
}