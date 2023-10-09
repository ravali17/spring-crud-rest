//package spring.com.rest.api.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.validation.Valid;
//import spring.com.rest.api.dto.UserDto;
//import spring.com.rest.api.service.NetworkService;
//
//@RestController
//public class NetworkController {
//    @Autowired
//    private NetworkService networkService;
//
//    @PostMapping("/network")
//    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto) {
//        UserDto savedUser = networkService.createUser(userDto);
//        return ResponseEntity.ok(savedUser);
//    }
//    @GetMapping("/networks")
//    public ResponseEntity<List<UserDto>> getAllUsers() {
//        List<UserDto> users = networkService.getAllUsers();
//        return ResponseEntity.ok(users);
//    }
//
//}
//
