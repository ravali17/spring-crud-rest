package spring.com.rest.api.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.com.rest.api.entity.NetworkEntity1;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO1 {
    private Long id;
    private String username;
    @JsonIgnore
    private Set<NetworkEntity1> networks = new HashSet<>();
    
}
