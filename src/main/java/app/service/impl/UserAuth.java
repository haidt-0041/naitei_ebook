package app.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import app.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserAuth extends org.springframework.security.core.userdetails.User {
	private User user;
	private static final long serialVersionUID = 1L;

	public UserAuth(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			User user) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
}
