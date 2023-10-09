package spring.com.rest.api.controller;

import java.util.List;

import org.slf4j.Logger;
import spring.com.rest.api.dto.ProductDto;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.com.rest.api.dto.CommentDto;
import spring.com.rest.api.dto.ProductDto;
import spring.com.rest.api.entity.CommentEntity;
import spring.com.rest.api.entity.ProductEntity;
import spring.com.rest.api.service.CommentService;
import spring.com.rest.api.service.ProductService;

@RestController

public class ProductAndCommentController {
	Logger logger=LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ProductService productservice;
	@Autowired
	private CommentService commentservice;
	@PostMapping("/product")

	public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductDto productDTO) {
        ProductEntity createdProduct = productservice.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDto>getById(@PathVariable int id){
ProductDto product=productservice.getProductById(id);

return ResponseEntity.status(HttpStatus.CREATED).body(product);
		
	}
	@GetMapping("/products")
	public List<ProductDto>getAllProducts(){
		return productservice.getAllProducts();
		
	}
	
	@PostMapping("/comment")
	public ResponseEntity<CommentEntity>addComment(@RequestBody CommentDto commentdto){
		CommentEntity addcomment=commentservice.createComment(commentdto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addcomment);
		
	}
	@GetMapping("/comments")
	public List<CommentDto> getAllComments() {
	    return commentservice.getAllComments();
	}
//	@GetMapping("/comment/{id}")
//	public ResponseEntity<CommentDto>getCommentById(@PathVariable int id){
//CommentDto product=commentservice.getCommentById(id);
//
//return ResponseEntity.status(HttpStatus.CREATED).body(product);
//		
//	
//}
}

