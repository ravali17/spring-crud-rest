package spring.com.rest.api.entity;

import java.util.Optional;

import jakarta.persistence.CascadeType;
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
@Table(name="comment_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="comment_id")
	private int id;
	
	@Column(name="comments")
	private String comment;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="products_id")
	private ProductEntity product;

}
