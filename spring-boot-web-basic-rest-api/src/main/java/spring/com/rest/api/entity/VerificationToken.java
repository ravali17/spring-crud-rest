package spring.com.rest.api.entity;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
	private  static final int EXPIRATION_TIME=10; 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String token;
private Date ExpireDate;
@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name="user_id",nullable = false,foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN"))
private UserEntity user;
public VerificationToken(String token, UserEntity user) {
	super();
	this.token = token;
	this.ExpireDate = calucalteExpireDate(EXPIRATION_TIME);
	this.user = user;
}
public VerificationToken(String token) {
	super();
	this.token = token;
	this.ExpireDate = calucalteExpireDate(EXPIRATION_TIME);
	
}
private Date calucalteExpireDate(int expirationTime) {
	Calendar calender=Calendar.getInstance();
	calender.setTimeInMillis(new Date().getTime());
	calender.add(Calendar.MINUTE, expirationTime);
	return new Date(calender.getTime().getTime());

	
}

}
