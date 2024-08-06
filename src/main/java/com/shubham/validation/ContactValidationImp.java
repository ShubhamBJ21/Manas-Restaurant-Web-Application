package com.shubham.validation;

public class ContactValidationImp implements ContactValidation {
	private String result;

	@Override
	public String contactValidation(String name, String email, String subject, String message) {
		
		int nameLen = name.length();
		int emailLen = email.length();
		int subjectLen = subject.length();
		int messageLen = message.length();
		
		if(nameLen < 2 || nameLen > 50) {
			result = "INVALID NAME";
		}
		else if(emailLen < 10 || emailLen > 30 || !email.contains("@") || !email.endsWith(".com")) {
			result = "INVALID EMAIL";
		}
		else if(subjectLen < 2 || subjectLen > 25) {
			result = "INVALID SUBJECT";
		}
		else if(messageLen < 2 || messageLen > 200) {
			result = "INVALID MESSAGE";
		}
		else {
			result = "VALID";
		}
		return result;
	}

}
