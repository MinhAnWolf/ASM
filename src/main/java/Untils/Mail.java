package Untils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mail {
	
	public void sendMail(HttpServletRequest req, HttpServletResponse resp,
		String to, String subject, String content ) {
		final String userName = "minhanlefz09@gmail.com";
		final String passWord = "39391359as";
		Properties pro = new Properties();
		pro.put("mail.smtp.host","smtp.gmail.com");
		pro.put("mail.smtp.port","587");
		pro.put("mail.smtp.auth","true");
		pro.put("mail.smtp.starttls.enable","true");
		Session session = Session.getInstance(pro,new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, passWord);
			}
		});
//		String to = req.getParameter("to");
		System.out.println("To : "+to);
//		String subject = req.getParameter("subject");
		System.out.println("subject : "+subject);
//		String content = req.getParameter("content");
		System.out.println("content : "+content);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(userName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
			System.out.println("succes send");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
