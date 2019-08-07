package app.model;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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

	@NotEmpty(message = "{NotEmpty.user.name}")
	@Column(name = "name", nullable = false)
	private String name;

	@Email(message = "{Email.user.email}")
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

	@Column(name = "password")
	@NotEmpty(message = "{pass.not.empty}")
	@Size(message = "{pass.size}", min = 5, max = 100)
	private String password;

	@Column(name = "status")
	private int status;

	@Column(name = "role")
	@ColumnDefault(value = "0")
	private int role;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob")
	private LocalDate dob;

	public String getSexAttr() {
		return (this.sex == MALE) ? "MALE" : "FEMALE";
	}

	public String getRoleString() {
		if (this.role == 1) {
			return "ADMIN";
		} else {
			return "USER";
		}
	}

	@Transient
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.getRoleString()));
		return authorities;
	}

}