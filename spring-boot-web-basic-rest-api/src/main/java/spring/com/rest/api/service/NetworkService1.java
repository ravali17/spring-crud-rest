package spring.com.rest.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.com.rest.api.dto.UserDTO1;
import spring.com.rest.api.entity.NetworkEntity1;
import spring.com.rest.api.entity.UserEntity1;
import spring.com.rest.api.repository.NetworkRepository1;
import spring.com.rest.api.repository.UserRepository1;

@Service
public class NetworkService1 {
    @Autowired
    private UserRepository1 userRepository;

    @Autowired
    private NetworkRepository1 networkRepository;

 

    public UserEntity1 createUser(UserDTO1 userdto) {
//	    Optional<UserEntity1> existingUser = userRepository.findByName(userdto.getName());

	    
	        UserEntity1 userEntity = new UserEntity1();
	        userEntity.setId(userdto.getId());
	        userEntity.setUsername(userdto.getUsername());
	        
	        
	        userEntity = userRepository.save(userEntity);
	        
	        if (userdto.getNetworks() != null) {
                for (NetworkEntity1 networks : userdto.getNetworks()) {
                    NetworkEntity1 network = new NetworkEntity1();
                    network.setId(networks.getId());
                    network.setName(networks.getName()); // Set the user for the contact
                    networkRepository.save(network);
                }
            }
			return userEntity;
    }
}

	        