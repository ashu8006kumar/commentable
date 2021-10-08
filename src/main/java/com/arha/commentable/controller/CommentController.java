package com.arha.commentable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arha.commentable.bo.CommentBo;
import com.arha.commentable.domain.Feed;
import com.arha.commentable.service.CommentService;
import com.arha.commentable.service.FeedService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;
	@Autowired
	private FeedService feedService;

	@GetMapping("/{feedId}")
	public List<CommentBo> list(@PathVariable Long feedId) {
		Feed feed = feedService.get(feedId);
		return commentService.getAcitiveCommentsByFeed(feed);
	}

	@PostMapping("/{feedId}")
	public CommentBo save(@PathVariable Long feedId, @RequestBody @Valid CommentBo coomment) {
		Feed feed = feedService.get(feedId);
		return commentService.save(feed, coomment);
	}

	@DeleteMapping("/{commentId}") // user/feedid/admin
	public void delete(@PathVariable Long commentId) {
		commentService.delete(commentId);
	}

	@PostMapping("/report/{commentId}")
	public void report(@PathVariable Long commentId) {
		commentService.report(commentId);
	}
}
