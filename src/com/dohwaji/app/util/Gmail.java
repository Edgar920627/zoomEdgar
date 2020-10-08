package com.dohwaji.app.util;



import javax.mail.Authenticator;

import javax.mail.PasswordAuthentication;
public class Gmail extends Authenticator {



    @Override

    protected PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication("7dnjs711@gmail.com","1vl2wk32!!");

    }

    

}
