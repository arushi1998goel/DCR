package utils;

import java.io.IOException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class maiUtility {
public static void main(String args[]) throws IOException
{
	maiUtility ml=new maiUtility();
    ml.SendEmail("Test Messages","ExtentReports//ExtentReportResults.html");
}
   public void SendEmail(String m,String filepath) throws IOException {     
      // Recipient's email ID needs to be mentioned.
      //String[] to = {"ashwanis@360logica.com","ashwani.hcst@gmail.com"};
	   PropertyReader pr=new PropertyReader();
	   
      String to = pr.readproperty("to");
      // Sender's email ID needs to be mentioned
      String from = "ashwanis@360logica.com";

      // Assuming you are sending email from localhost
      String host = "smtp.mailtrap.io";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
     
      properties.put("mail.smtp.host", host);
      properties.put("mail.smtp.port", "465");
      //properties.put("mail.smtp.ssl.enable", "true");
      properties.put("mail.smtp.starttls.enable", "true");
      
      properties.put("mail.smtp.auth", "true");
      // Get the default Session object.
      Session session = Session.getInstance(properties, new Authenticator() {

          protected PasswordAuthentication getPasswordAuthentication() {

              return new PasswordAuthentication("980b8aa78a6819", "5e3c9ad9f59bf8");

          }

      });
      //Session session = Session.getInstance(properties);
      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Automation Script Execution Report");

         // Create the message part 
         BodyPart messageBodyPart = new MimeBodyPart();

         // Fill the message
         messageBodyPart.setContent(m,"text/html");
         
         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
         String filename = filepath;
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart );

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}