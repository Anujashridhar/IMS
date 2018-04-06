package in.cdac.auth.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import in.cdac.db.auth.entity.User;

public class UserPrincipal extends org.springframework.security.core.userdetails.User  {

	public UserPrincipal(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	

	

}
