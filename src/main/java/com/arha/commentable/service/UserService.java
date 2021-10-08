package com.arha.commentable.service;

import java.util.List;

import com.arha.commentable.bo.UserBo;
import com.arha.commentable.domain.User;

public interface UserService {

	User findUserByEmail(String email);

	List<UserBo> list();
}
