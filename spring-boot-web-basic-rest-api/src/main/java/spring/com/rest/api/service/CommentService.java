package spring.com.rest.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.com.rest.api.dto.CommentDto;
import spring.com.rest.api.dto.ProductDto;
import spring.com.rest.api.entity.CommentEntity;
import spring.com.rest.api.entity.ProductEntity;
import spring.com.rest.api.repository.CommentRepository;
import spring.com.rest.api.repository.ProductRepository;
import spring.com.rest.api.exceptions.*;

@Service
public class CommentService {
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private CommentRepository commentRepo;
//	public CommentEntity createComment(CommentDto commentdto,int id) {
//		CommentEntity commententity=new CommentEntity();
//		
//		commententity.setComment(commentdto.getComment());
//		 Optional<ProductEntity> productOptional = productRepo.findById(id);
//		    
//		    if (productOptional.isPresent()) {
//		        ProductEntity productEntity = productOptional.get();
//		        commententity.setProduct(productEntity);
//		        return commentRepo.save(commententity);
//		    } else {
//		        throw new ResourceNotFoundException("prouct", "id", id);
//		    }
//		
//	}
	public CommentEntity createComment(CommentDto commentdto) {
		CommentEntity commententity=new CommentEntity();
		commententity.setId(commentdto.getId());
		commententity.setComment(commentdto.getComment());

		ProductEntity productOptional = productRepo.findById(commentdto.getProduct().getId()).get();
	//	 ProductEntity productOptional = productRepo.findById(commentdto.getProductId()).get();
		 commententity.setProduct(productOptional);
		 commentRepo.save(commententity);
		return commententity;
	}
	
	public List<CommentDto>getAllComments() {
		List<CommentEntity>comment=commentRepo.findAll();
		List<CommentDto>commentList=comment.stream().map(comments->{
			CommentDto  commentDto=new CommentDto();
			commentDto.setId(comments.getId());
			
			commentDto.setComment(comments.getComment());
			if (comments.getProduct() != null) {
	            ProductDto productDto = new ProductDto();
	            productDto.setId(comments.getProduct().getId());
	            productDto.setName(comments.getProduct().getName());
	            commentDto.setProduct(productDto);
	          //  commentDto.setProductId(productDto.getId());
	        }
			 return commentDto; 
        }).collect(Collectors.toList());
        
        return commentList;
    }
//	public CommentDto getCommentById(int id) {
//		Optional<CommentEntity> commentEntity =commentRepo.findById(id);
//	       return commentEntity.map(x ->{
//	    	   CommentDto user = new CommentDto();
//	            user.setId(x.getId());
//	            user.setComment(x.getComment());
//	            user.setProduct(x.getProduct());
//	            
//	            
//	            return user;
//	        }).orElseThrow(()->new ResourceNotFoundException("comment", "id", id));
//	    }
		
}