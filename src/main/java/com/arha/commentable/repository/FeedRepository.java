package com.arha.commentable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arha.commentable.datatype.StatusValue;
import com.arha.commentable.domain.Feed;

@Repository
public interface FeedRepository extends JpaRepository<Feed, Long>{
	
	List<Feed> findAllByCreatedBy(String createdBy);
	
	List<Feed> findAllByCreatedByAndStatus(String createdBy,StatusValue statusValue);

}
