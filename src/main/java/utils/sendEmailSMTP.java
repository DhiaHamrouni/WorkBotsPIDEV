package utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class sendEmailSMTP {
    public static Properties config() {
        System.out.println("Preparing !!");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("email", "elpatchino007@gmail.com");
        properties.put("pwd", "flamethrower");

        return properties;
    }

    public static void changePasswordEmail(String username, String recepient, String token) throws MessagingException {

        Session session = Session.getInstance(config(), new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config().getProperty("email"), config().getProperty("pwd"));
            }

        });

        Message message = new MimeMessage(session);
        try {

            message.setFrom(new InternetAddress(config().getProperty("email")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Password update");
            message.setText("Welcome " + username + "\nYou have asked for a password reset. Please user this code in the reset password window: " + token);

        } catch (MessagingException ex) {
            Logger.getLogger(sendEmailSMTP.class.getName()).log(Level.SEVERE, null, ex);
        }

        Transport.send(message);

        System.out.println("Success !!");
    }
}
