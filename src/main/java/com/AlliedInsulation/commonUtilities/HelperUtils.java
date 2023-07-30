package com.AlliedInsulation.commonUtilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class HelperUtils {
	
	int number;
	Faker fake;
	Random random = new Random();
	
	public int generateRandomNumbers() {
		return random.nextInt(0, 9999);
	}
	
	public String generateRandomName() {
		 fake = new Faker();
		 return fake.name().fullName();
	}
	
	public String generateRandomEmail(){
		fake = new Faker();
		return fake.internet().emailAddress();
	}
	
	public String generateRandomPhone() {
		fake = new Faker();
		return "("+fake.numerify("###")+")  "+fake.numerify("###")+"-"+fake.numerify("####");
	}
	
	public String generateRandomFax() {
		fake = new Faker();
		String fax = fake.number().digits(10);
		return fax.substring(0, 3)+"-"+fax.substring(3, 6)+"-"+fax.substring(6);
	}
	
	public String generateRandomStrings(int length) {
        String Alphabet = "abcdefghijklmnopqrstuvwyxzABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321";
        //StringBuilder class provides a mutable sequence of characters
        //It helps us to append the characters to the string     
        StringBuilder builder = new StringBuilder(length);
        for(int i=0; i<length; i++) {
        	//Random index can range from 0 to ALPHABET.length() - 1
        	int randomIndex = random.nextInt(Alphabet.length());
        	//Getting the character from Alphabet by using index value
        	char randomChar = Alphabet.charAt(randomIndex);
        	// random character is generated and appended to the StringBuilder
        	builder.append(randomChar);
        }
        return builder.toString();
	}
}
