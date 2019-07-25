package app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "reviews")
@Setter
@Getter
@NoArgsConstructor

public class Review {
	@Id
	@Column (name= "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(mappedBy = "review")
    private Book book;
	
	@Column (name= "created_at")
	private LocalDateTime createDateTime;
	
	@Column (name= "updated_at")
	private LocalDateTime updateDateTime;
	
	@Column (name= "content")
	@NotEmpty(message="{review.content.empty}")
	private String content;
	
	@Column (name= "rate_number")
	private int rate_number;

}