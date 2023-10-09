package spring.com.rest.api.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int id;
	
	
	@Column(name="user_name")
	private String name;
	
	@Column(name="user_email")
	private String email;
	@Column(name="user_pwd",length = 60)
	
	private String password;
	
	
	@Column(name="user_gender")
	private String gender;
	
	@Column(name="user_nationality")
	private String nationality;
	
	private String role;
	private boolean enabled=false;
	
//	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//
//	private AddressEntity address;
//	@OneToMany(mappedBy = "user")//(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    private List<ContactEntity> contacts;
//
//	 @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	    @JoinColumn(name = "user_id")
//	    private List<NetworkEntity> networks;
}
