package spring.com.rest.api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.com.rest.api.dto.ProductDto;
import spring.com.rest.api.dto.UserDto;
import spring.com.rest.api.entity.ProductEntity;
import spring.com.rest.api.entity.UserEntity;
import spring.com.rest.api.exceptions.ResourceNotFoundException;
import spring.com.rest.api.repository.CommentRepository;
import spring.com.rest.api.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	

	public ProductEntity createProduct(ProductDto productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        return productRepo.save(productEntity);
    }
	
	public ProductDto getProductById(int id) {
		Optional<ProductEntity> productEntity =productRepo.findById(id);
	       return productEntity.map(x ->{
	    	   ProductDto user = new ProductDto();
	            user.setId(x.getId());
	            user.setName(x.getName());
	            
	            
	            
	            return user;
	        }).orElseThrow(()->new ResourceNotFoundException("Product", "id", id));
	    }
	public List<ProductDto> getAllProducts() {
		List<ProductEntity>productentity=productRepo.findAll();
		List<ProductDto>productlist=productentity.stream().map(products->{
			ProductDto product=new ProductDto();
			product.setId(products.getId());
			product.setName(products.getName());
			return  product;
		}).collect(Collectors.toList());
		return productlist;
		
	}
		
	}


