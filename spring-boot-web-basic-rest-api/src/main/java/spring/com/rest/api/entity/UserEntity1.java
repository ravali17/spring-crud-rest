package spring.com.rest.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name="user_1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_network",
               joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(name = "network_id",referencedColumnName = "id")})
    private Set<NetworkEntity1> networks = new HashSet<>();

    // Other user-related fields, getters, setters
}

