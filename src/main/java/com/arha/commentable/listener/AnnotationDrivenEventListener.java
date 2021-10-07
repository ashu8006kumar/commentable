package com.arha.commentable.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.arha.commentable.datatype.RoleValue;
import com.arha.commentable.domain.Role;
import com.arha.commentable.domain.User;
import com.arha.commentable.domain.UserRole;
import com.arha.commentable.repository.RoleRepository;
import com.arha.commentable.repository.UserRepository;
import com.arha.commentable.repository.UserRoleRepository;
 

@Component
public class AnnotationDrivenEventListener {
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		ApplicationContext applicationContext = event.getApplicationContext();
		if (applicationContext.getParent() == null) { // Root Parent initialized
			System.out.println("Application started.");
			addRolesAndUserOnInit();

		}
	}

	private void addRolesAndUserOnInit() {
		Role adminRole = roleRepository.findByUserRole(RoleValue.ROLE_ADMIN);
		if (adminRole == null) {
			adminRole = new Role(RoleValue.ROLE_ADMIN);
			roleRepository.save(adminRole);
		}
		Role userRole = roleRepository.findByUserRole(RoleValue.ROLE_USER);
		if (userRole == null) {
			userRole = new Role(RoleValue.ROLE_USER);
			roleRepository.save(userRole);
		}
		addUser(adminRole, userRole);
	}

	private void addUser(Role adminRole, Role userRole) {
		User user = userRepository.findByEmail("admin@xyz.com");
		if (user == null) {
			user = new User();
			user.setEnabled(true);
			user.setEmail("admin@xyz.com");
			user.setName("Admin user");
			user.setPassword(passwordEncoder.encode("XYz"));
			userRepository.save(user);
			UserRole uRole = new UserRole(adminRole, user);
			UserRole uRole2 = new UserRole(userRole, user);
			userRoleRepository.save(uRole);
			userRoleRepository.save(uRole2);
		}
	}
}
