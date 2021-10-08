package com.arha.commentable.service;

import java.util.List;

import com.arha.commentable.bo.CommentBo;
import com.arha.commentable.domain.Feed;

public interface CommentService {

	List<CommentBo> getAcitiveCommentsByFeed(Feed feed);

	CommentBo save(Feed feed, CommentBo commentBo);

	void delete(Long commentId);

	void report(Long commentId);

}
