package com.arha.commentable.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arha.commentable.bo.CommentBo;
import com.arha.commentable.datatype.StatusValue;
import com.arha.commentable.domain.Comment;
import com.arha.commentable.domain.Feed;
import com.arha.commentable.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<CommentBo> getAcitiveCommentsByFeed(Feed feed) {
		List<Comment> comments = commentRepository.findAllByFeedAndStatus(feed, StatusValue.ACTIVE);
		List<CommentBo> commentBos = new ArrayList<>();
		for (Comment comment : comments) {
			commentBos.add(new CommentBo(comment.getId(), comment.getText()));
		}
		return commentBos;
	}

	@Override
	public CommentBo save(Feed feed, CommentBo commentBo) {
		Comment comment = new Comment();
		comment.setText(commentBo.getText());
		comment.setFeed(feed); 
		comment.setCreatedBy("Ashish");// later we do it with spring security
		commentRepository.save(comment);
		commentBo.setId(comment.getId());
		return commentBo;
	}

	@Override
	public void delete(Long commentId) {
		Comment comment = commentRepository.getById(commentId);
		if (comment == null) {
			throw new RuntimeException("comment not found with id :" + commentId);
		}
		commentRepository.delete(comment);
	}

	@Override
	public void report(Long commentId) {
		Comment comment = commentRepository.getById(commentId);
		if (comment == null) {
			throw new RuntimeException("comment not found with id :" + commentId);
		} 
		comment.setStatus(StatusValue.REPORTED_SPAM);
		commentRepository.save(comment);
		
	}

}
