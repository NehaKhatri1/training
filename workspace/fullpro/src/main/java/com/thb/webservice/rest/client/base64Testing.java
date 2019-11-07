package com.thb.webservice.rest.client;

import com.sun.jersey.core.util.Base64;

public class base64Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // Define the string
         String string = "http://localhost:8080/portal1/HomePage.html?userName=lagda@gmail.com";

        // Encode the String
         byte[] encodedString = Base64.encode(string);
        System.out.println(encodedString); // Outputs: "SGVsbG8gV29ybGQh"

		
	}

}
