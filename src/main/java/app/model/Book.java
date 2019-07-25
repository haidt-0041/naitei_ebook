package app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "books")
@Setter
@Getter
@NoArgsConstructor

public class Book {
	@Id
	@Column (name= "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "review_id", referencedColumnName = "id")
    private Review review;
	
	@Column (name= "user_id")
	private int user_id;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column (name= "created_at")
	private LocalDateTime createDateTime;
	
	@Column (name= "updated_at")
	private LocalDateTime updateDateTime;
	
	@NotEmpty(message="{book.title.empty}")
	@Column (name= "title")
	private String title;
	
	@NotEmpty(message="{book.cover.empty}")
	@Column (name= "cover")
	private String cover;
	
	@NotEmpty(message="{book.link.empty}")
	@Column (name= "link")
	private String link;
	
	@Column (name= "rate")
	private Double rate;
	
	@Column (name= "status")
	private int status;
	
	@Column (name= "author")
	private String author;

}