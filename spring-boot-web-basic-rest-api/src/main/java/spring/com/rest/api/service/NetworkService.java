//package spring.com.rest.api.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import spring.com.rest.api.dto.NetworkDto;
//import spring.com.rest.api.dto.UserDto;
//import spring.com.rest.api.repository.NetworkRepository;
//import spring.com.rest.api.repository.UserRepository;
//import spring.com.rest.api.entity.*;
//import java.util.*;
//import java.util.stream.Collectors;
//@Service
//public class NetworkService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private NetworkRepository networkRepository;
//
//    @Transactional
//    public UserDto createUser(UserDto userDto) {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setName(userDto.getName());
//        userEntity.setEmail(userDto.getEmail());
//        userEntity.setGender(userDto.getGender());
//        userEntity.setNationality(userDto.getNationality());
//
//        List<NetworkEntity> networkEntities = new ArrayList<>();
//        if (userDto.getNetworks() != null) {
//            for (NetworkDto networkDto : userDto.getNetworks()) {
//                NetworkEntity networkEntity = new NetworkEntity();
//                networkEntity.setName(networkDto.getName());
//                networkEntities.add(networkEntity);
//            }
//        }
//        userEntity.setNetworks(networkEntities);
//
//        userEntity = userRepository.save(userEntity);
//        return convertToDto(userEntity);
//    }
//
//    private UserDto convertToDto(UserEntity userEntity) {
//        UserDto userDto = new UserDto();
//        userDto.setId(userEntity.getId());
//        userDto.setName(userEntity.getName());
//        userDto.setEmail(userEntity.getEmail());
//        userDto.setGender(userEntity.getGender());
//        userDto.setNationality(userEntity.getNationality());
//
//        List<NetworkDto> networkDtos = new ArrayList<>();
//        if (userEntity.getNetworks() != null) {
//            for (NetworkEntity networkEntity : userEntity.getNetworks()) {
//                NetworkDto networkDto = new NetworkDto();
//                networkDto.setId(networkEntity.getId());
//                networkDto.setName(networkEntity.getName());
//                networkDtos.add(networkDto);
//            }
//        }
//        userDto.setNetworks(networkDtos);
//
//        return userDto;
//    }
//    
//    
//    
//    @Transactional(readOnly = true)
//    public List<UserDto> getAllUsers() {
//        List<UserEntity> userEntities = userRepository.findAll();
//        
//        return userEntities.stream()
//            .map(this::convertToDto)
//            .collect(Collectors.toList());
//    }
//
//    private UserDto convertToDto1(UserEntity userEntity) {
//        UserDto userDto = new UserDto();
//        userDto.setId(userEntity.getId());
//        userDto.setName(userEntity.getName());
//        userDto.setEmail(userEntity.getEmail());
//        userDto.setGender(userEntity.getGender());
//        userDto.setNationality(userEntity.getNationality());
//
//        return userDto;
//    }
//}