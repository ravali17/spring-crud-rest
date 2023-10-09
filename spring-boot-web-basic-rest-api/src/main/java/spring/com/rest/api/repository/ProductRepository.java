package spring.com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.com.rest.api.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
