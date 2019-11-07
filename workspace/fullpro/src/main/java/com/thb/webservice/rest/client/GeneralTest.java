package com.thb.webservice.rest.client;

import java.io.UnsupportedEncodingException;    
import javax.xml.bind.DatatypeConverter;

public class GeneralTest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str = "Hello World!"; // SGVsbG8gV29ybGQh SGVsbG8gV29ybGQh
        // encode data using BASE64
        String encoded = DatatypeConverter.printBase64Binary(str.getBytes());
        System.out.println("encoded value is \t" + encoded);

        // Decode data 
        String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        System.out.println("decoded value is \t" + decoded);

        System.out.println("original value is \t" + str);

    }

}