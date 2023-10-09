package spring.com.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import spring.com.rest.api.dto.UserDTO1;
import spring.com.rest.api.service.NetworkService1;

@RestController
public class UserNetworkController {
    @Autowired
    private NetworkService1 userNetworkService;


	@PostMapping("/user1")
	public ResponseEntity<UserDTO1> saveUser(@Valid @RequestBody UserDTO1 userdto) {
		
	
		userNetworkService.createUser(userdto);
		return ResponseEntity.ok(userdto);
	}

	
}

	


