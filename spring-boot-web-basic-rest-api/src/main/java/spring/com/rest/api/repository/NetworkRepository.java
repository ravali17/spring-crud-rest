package spring.com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.com.rest.api.entity.NetworkEntity;
@Repository
public interface NetworkRepository  extends JpaRepository<NetworkEntity, Integer>{

}
