package com.thb.db;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.*;
 
public class NewClass
{
    public static void main(String[] args)
    {
        // Length of your password as I have choose
        // here to be 8
        int length = 8;
       System.out.println(geek_Password(length));
    }
 
    // This our Password generating method
    // We have use static here, so that we not to
    // make any object for it
    static char[] geek_Password(int len)
    {
       String x = "hey neha";
    	System.out.println("Generating password using random() : ");
    	Font font = new Font("LucidaSans", Font.BOLD, 14);
    	String msg = "<strong>Hello World!</strong>";
    	
    	Font f = new Font("LucidaSans", Font.BOLD, 14);

    	AttributedString as= new AttributedString("Example text string");

    	as.addAttribute(TextAttribute.FONT, f);

        System.out.print("as is "+as.toString());
        System.out.print(" Your new password is : ");
        // A strong password has Cap_chars, Lower_chars,
        // numeric value and symbols. So we are using all of
        // them to generate our password
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&*";
 
 
        String values = Capital_chars + Small_chars +
                        numbers + symbols;
 
        // Using random method
        Random rndm_method = new Random();
 
        char[] password = new char[len];
 
        for (int i = 0; i < len; i++)
        {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] =
              values.charAt(rndm_method.nextInt(values.length()));
 
        }
        return password;
    }
}