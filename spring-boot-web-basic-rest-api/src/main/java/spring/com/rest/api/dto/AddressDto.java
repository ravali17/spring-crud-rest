package spring.com.rest.api.dto;

import java.util.List;

import lombok.Data;
import spring.com.rest.api.entity.UserEntity;

@Data
public class AddressDto {
	private int id;
	private String city;
	private String state;
	

}
