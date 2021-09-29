package com.arha.commentable.service;

import com.arha.commentable.domain.User;

public interface UserService {

	User findUserByEmail(String email);
}
