package com.example.demo;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	 

	    // Existing code...

	    public void sendMail(String mail, MailStructure mailStructure) {
	        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	        simpleMailMessage.setFrom(fromMail);
	        simpleMailMessage.setSubject(mailStructure.getSubject());
	        simpleMailMessage.setText(mailStructure.getMessage() + "\nYour OTP is: " + mailStructure.getOtp());
	        simpleMailMessage.setTo(mail);
	        mailSender.send(simpleMailMessage);
	    }
	

	public String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = 100000 + random.nextInt(900000); // 6-digit OTP
        return String.valueOf(otp);
    }
	

}
