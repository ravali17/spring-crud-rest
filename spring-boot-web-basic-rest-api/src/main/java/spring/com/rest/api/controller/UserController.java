package spring.com.rest.api.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import spring.com.rest.api.Events.RegistrationCompleteEvent;
import spring.com.rest.api.dto.UserDto;
import spring.com.rest.api.entity.UserEntity;
import spring.com.rest.api.service.UserService;

@RestController
public class UserController {
	Logger logger=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userdto,HttpServletRequest request) {
		
		logger.info("registration of the user");
		UserEntity user=userService.createUser(userdto);
		applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
		return ResponseEntity.ok(userdto);
	}
	private String  applicationUrl(HttpServletRequest request) {
		return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
	}
	@GetMapping("/verificationUrl")
	public String verifyUser(@RequestParam String token) {
		String result=userService.validateUser(token);
		if(result.equalsIgnoreCase("valid")) {
			return "user verification success";
		}
		return "not verified";
		
	}


	@PutMapping("/users/{id}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable int id) {
	    userDto.setId(id);
	    userService.updateUser(userDto, id);
	    return ResponseEntity.ok(userDto);
	}
	@GetMapping("/users/{id}")
public ResponseEntity<UserDto>getUserById(@PathVariable int id){
	
	UserDto userdto= userService.getUserById(id);
	return ResponseEntity.ok(userdto);
	 
	
}
	@GetMapping("/Users")//APPLYING FILTERS
	public ResponseEntity<MappingJacksonValue> getAllUsers(){
		logger.info("to get all the users");
		List<UserDto>userlist=userService.getAllUsers();
		 SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "email");
		    FilterProvider filters = new SimpleFilterProvider()
		            .addFilter("somebean", filter);
		    
		    
		    MappingJacksonValue jacksonValue = new MappingJacksonValue(userlist);
		    jacksonValue.setFilters(filters);
		    
		   
		    return ResponseEntity.ok(jacksonValue);
		}
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers1(){
		List<UserDto>userlist=userService.getAllUsers();

        return ResponseEntity.ok(userlist);
		
	}
	@SuppressWarnings("unchecked")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserDto>deleteUSerById(@RequestParam int id){
		userService.deleteUser(id);
		return (ResponseEntity<UserDto>) ResponseEntity.ok();
		
		
	}
	

	 @GetMapping("/count")
	    public ResponseEntity<String> getCountOfUsers() {
		 int count = userService.getCountOUsers();	
	        String response = "COUNT=" + count;
	        return ResponseEntity.ok(response);
	    }
	 
	 
}
