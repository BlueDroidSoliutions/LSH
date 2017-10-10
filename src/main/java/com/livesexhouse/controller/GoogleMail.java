/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livesexhouse.controller;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class GoogleMail {

    

        final String username = "lshtest11";
        final String password = "livesexhouse";
        
        public void send(String email, String key, String name){
            Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("lshtest11@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("Verify");
            message.setText("Dear "+name+","
                + "\n please click on link:\n"+ "http://www.livesexhouse.com/check/"+key);

            Transport.send(message);

           

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        }

        
    }
