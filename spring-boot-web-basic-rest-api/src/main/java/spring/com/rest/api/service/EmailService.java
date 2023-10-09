package spring.com.rest.api.service;

//Importing required classes


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.mail.SimpleMailMessage;
	import org.springframework.mail.javamail.JavaMailSender;
	import org.springframework.stereotype.Service;

	@Service
	public class EmailService {

	    @Autowired
	    private JavaMailSender javaMailSender;

	    @Value("${spring.mail.username}")
	    private String senderEmail;

	    public void sendEmail(String recipientEmail, String subject, String message) {
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setFrom("ravalineelakantam11@gmail.com");
	        mailMessage.setTo("Ravalineelakantam11@gmail.com");
	        mailMessage.setSubject("testing springboot");
	        mailMessage.setText("springboot \n hello world");
	        javaMailSender.send(mailMessage);
	    }

		public void sendVerificationEmail(String email, String subject, String emailText) {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
	        mailMessage.setFrom("ravalineelakantam11@gmail.com");
	        mailMessage.setTo("Ravalineelakantam11@gmail.com");
	        mailMessage.setSubject("verification ");
	        mailMessage.setText("verified");
	        javaMailSender.send(mailMessage);
			
		}
	}
