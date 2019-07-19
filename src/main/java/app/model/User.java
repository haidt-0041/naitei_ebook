package app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name")
	private String name;

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

	@Column(name = "dob")
	private LocalDateTime dob;

	public String getSexAttr() {
		return (this.sex == MALE) ? "MALE" : "FEMALE";
	}

}