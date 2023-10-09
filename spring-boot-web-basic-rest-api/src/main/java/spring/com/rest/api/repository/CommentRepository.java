package spring.com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.com.rest.api.entity.CommentEntity;
@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

}
