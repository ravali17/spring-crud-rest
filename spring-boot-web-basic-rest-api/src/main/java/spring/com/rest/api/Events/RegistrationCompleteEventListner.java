package spring.com.rest.api.Events;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import spring.com.rest.api.controller.UserController;
import spring.com.rest.api.entity.UserEntity;
import spring.com.rest.api.service.EmailService;
import spring.com.rest.api.service.UserService;
@Component
public class RegistrationCompleteEventListner implements ApplicationListener<RegistrationCompleteEvent>{
@Autowired
private UserService service;
Logger logger=LoggerFactory.getLogger(UserController.class);
@Autowired
private EmailService emailService;
	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// TODO Auto-generated method stub
		UserEntity user=event.getUser();
		String token=UUID.randomUUID().toString();
		service.saveVerifficstionTokenUser(user,token);
		String url=event.getApplicationurl()+"/verificationUrl?token="
				+token;
		 String subject = "Verify your email address";
	        String emailText = "Click the following link to verify your email address: " + url;
	        emailService.sendVerificationEmail(user.getEmail(), subject, emailText);
		logger.info("click the url to verify:{}",url);
	}

	

}
