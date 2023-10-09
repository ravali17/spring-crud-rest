package spring.com.rest.api.entity;

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

@Entity
@Table(name="network_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="network_id")
	private int id;
	
	@Column(name="network_name")
	private String name;
	
}
