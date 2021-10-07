package com.arha.commentable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arha.commentable.datatype.RoleValue;
import com.arha.commentable.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByUserRole(RoleValue value);

}
