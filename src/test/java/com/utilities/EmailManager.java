package com.utilities;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailManager {

    public static Email email;

    public void sendEmail(String senderEmail, String senderPassword, String subject, String text, String receiver) throws EmailException {


        email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(965);
        email.setAuthenticator(new DefaultAuthenticator(senderEmail, senderPassword));  //for authentication
        email.setSSLOnConnect(true);    // has to be true in order to send
        email.setFrom(senderEmail);   // sender' email address
        email.setSubject(subject);   // object of the email
        email.setMsg(text);  // text body part
        email.addTo(receiver); //recevier email
        email.send();
        System.out.println("Send Successfully");


    }

}
