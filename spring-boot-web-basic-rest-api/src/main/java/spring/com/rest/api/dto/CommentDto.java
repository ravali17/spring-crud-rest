package spring.com.rest.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
	private int id;
	private String comment;
	private ProductDto product;
	
//	private int productId;



}
