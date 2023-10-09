package spring.com.rest.api.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name="user_contacts")

public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contact_id")
    private Long id;

    @Column(name="contact_phonenum")

    private String phone;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // getters and setters
}
