package app.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
	static final int MALE = 1;
	static final int FEMALE = 0;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message="{NotEmpty.user.name}")
	@Column(name = "name", nullable = false)
	private String name;

	@Email(message="{Email.user.email}")
	@Column(name = "email")
	private String email;

	@Column(name = "sex")
	private int sex;

	@Column(name = "created_at")
	private LocalDateTime createDateTime;

	@Column(name = "updated_at")
	private LocalDateTime updateDateTime;

	@Column(name = "avatar")
	private String avatar;

	@Column(name = "passworld")
	private String passworld;

	@Column(name = "status")
	private int status;

	@Column(name = "role")
	private int role;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob")
	private LocalDate dob;

	public String getSexAttr() {
		return (this.sex == MALE) ? "MALE" : "FEMALE";
	}

}