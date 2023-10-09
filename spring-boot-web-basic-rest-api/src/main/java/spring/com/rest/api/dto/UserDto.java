package spring.com.rest.api.dto;



import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFilter;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//@JsonFilter("somebean")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int id;

	private String name;
	
	private String email;
	private String password;
	
	private String gender;

	private String nationality;
//	private AddressDto address;
//	
//	 private List<ContactDTO> contacts;
//
//	 private List<NetworkDto> networks;
}
