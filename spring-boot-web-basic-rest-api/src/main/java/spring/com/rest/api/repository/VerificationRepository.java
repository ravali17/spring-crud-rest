package spring.com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.com.rest.api.entity.VerificationToken;

public interface VerificationRepository  extends JpaRepository<VerificationToken, Long>{

	static VerificationToken findByToken(String token) {
		return null;
	}

}
