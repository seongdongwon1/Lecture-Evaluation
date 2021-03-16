package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		                 //관리자의(gmeil_아이디,gmail_비밀번호)
		return new PasswordAuthentication("", "");
	}
}
