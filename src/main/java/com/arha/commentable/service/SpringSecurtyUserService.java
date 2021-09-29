package com.arha.commentable.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arha.commentable.domain.UserRole;

@Service
public class SpringSecurtyUserService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.arha.commentable.domain.User userFromDb = userService.findUserByEmail(username);
		if (userFromDb == null) {
			throw new UsernameNotFoundException("We are not able to find a user with given username/password");
		} else if (!userFromDb.isEnabled()) {
			throw new RuntimeException("User is disabled. Please contact to admin.");
		}
		Collection<GrantedAuthority> authorities = new HashSet<>();
		for (UserRole userRole : userFromDb.getUserRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getRole().getUserRole().name());
			authorities.add(grantedAuthority);
		}
		String password = "XYZ";
		User springSecurityUser = new User(userFromDb.getEmail(), password, authorities);
		return springSecurityUser;
	}

}
