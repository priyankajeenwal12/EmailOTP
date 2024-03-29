package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@SuppressWarnings("unused")
	@Autowired
	private MailService mailService;
	@PostMapping("send/{mail}")
    public String sendMail(@PathVariable String mail, @RequestBody MailStructure mailStructure) {
        String otp = mailService.generateOTP();
        mailStructure.setOtp(otp);
        mailService.sendMail(mail, mailStructure);
        return "Successfully sent the mail to " + mail + " with OTP: " + otp;
    }

	
	

}
