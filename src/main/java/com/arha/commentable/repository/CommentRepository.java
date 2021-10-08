package com.arha.commentable.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arha.commentable.datatype.StatusValue;
import com.arha.commentable.domain.Comment;
import com.arha.commentable.domain.Feed;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findAllByFeedAndStatus(Feed feed, StatusValue statusValue);

}
