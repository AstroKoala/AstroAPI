package com.astroapi.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	public static void sendVerification(String to, String code) {
		String content = modifyVerificationEmailTemplate(code);
		String from = "";
		final String username = "";
		final String password = "";
		
		Properties props = new Properties();

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Please Verify Your Email");
			message.setContent(content, "text/html");
			Transport.send(message);
			System.out.println("Sent message successfully.");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private static String modifyVerificationEmailTemplate(String code) {
		File fileToBeModified = new File("src/verification.html");
		StringBuilder oldContent = new StringBuilder();
	
		try (BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified))) {
			String line = reader.readLine();
			while (line != null) {
				oldContent.append(oldContent + line + System.lineSeparator());
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return oldContent.toString().replace("<a href=\"\"","<a href=\"http://localhost:3000/verification/?verification=" + code + "\"");
	}
}