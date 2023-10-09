package spring.com.rest.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import spring.com.rest.api.dto.UserDto;
import spring.com.rest.api.entity.UserEntity;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "User",path="user-details")
public interface UserRepository  extends JpaRepository<UserEntity, Integer>{
	
	// Custom query to get the count of students
	@Query(value = "SELECT COUNT(*) FROM user_tbl", nativeQuery = true)
    int getCountOfUsers();

	Optional<UserEntity> findByName(String name);
}
