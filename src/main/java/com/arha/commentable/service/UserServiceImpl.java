package com.arha.commentable.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arha.commentable.bo.UserBo;
import com.arha.commentable.datatype.RoleValue;
import com.arha.commentable.domain.User;
import com.arha.commentable.domain.UserRole;
import com.arha.commentable.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public List<UserBo> list() {
		List<User> users = userRepository.findAll();
		List<UserBo> userBos = new ArrayList<>();
		for (User user : users) {
			UserBo bo = new UserBo();
			bo.setEmail(user.getEmail());
			bo.setId(user.getId());
			bo.setName(user.getName());
			bo.setEnabled(user.isEnabled());
			List<RoleValue> userRoles = new ArrayList<>();
			for (UserRole userRole : user.getUserRoles()) {
				userRoles.add(userRole.getRole().getUserRole());
			}
			bo.setUserRoles(userRoles);
			userBos.add(bo);
		}
		return userBos;
	}

}
