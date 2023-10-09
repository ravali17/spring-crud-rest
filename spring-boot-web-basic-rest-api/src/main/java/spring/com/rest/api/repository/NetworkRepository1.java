package spring.com.rest.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.com.rest.api.entity.NetworkEntity1;
@Repository
public interface NetworkRepository1 extends JpaRepository<NetworkEntity1, Integer>{

}
