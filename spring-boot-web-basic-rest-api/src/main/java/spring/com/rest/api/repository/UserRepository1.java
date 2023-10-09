package spring.com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.com.rest.api.entity.UserEntity1;
@Repository
public interface UserRepository1 extends JpaRepository<UserEntity1, Integer> {

}
