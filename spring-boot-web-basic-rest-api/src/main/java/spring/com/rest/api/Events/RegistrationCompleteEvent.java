package spring.com.rest.api.Events;

import org.springframework.context.ApplicationEvent;

import lombok.Data;
import spring.com.rest.api.entity.UserEntity;


@Data
public class RegistrationCompleteEvent  extends ApplicationEvent{
private UserEntity user;
private String applicationurl;
	public RegistrationCompleteEvent(UserEntity user,String applicationurl ) {
		super(user);
		
		this.user=user;
		this.applicationurl=applicationurl;
		
	}

}
