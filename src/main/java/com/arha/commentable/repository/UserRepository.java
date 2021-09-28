package com.arha.commentable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arha.commentable.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	  

}
