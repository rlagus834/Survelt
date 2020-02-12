package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GoogleAuthentication extends Authenticator {
	PasswordAuthentication passAuth; //Authentication(인증자)
	
	public GoogleAuthentication() {
		passAuth = 
			new PasswordAuthentication("rlagus004","sjznjsqkgrqzvnra");
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return passAuth;
	}
}
