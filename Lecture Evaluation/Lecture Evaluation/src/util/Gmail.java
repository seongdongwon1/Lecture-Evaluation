package util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class Gmail extends Authenticator{
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		                 //��������(gmeil_���̵�,gmail_��й�ȣ)
		return new PasswordAuthentication("", "");
	}
}
