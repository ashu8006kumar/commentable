package com.arha.commentable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arha.commentable.bo.FeedBo;
import com.arha.commentable.bo.FeedDetailBo;
import com.arha.commentable.service.FeedService;

@RestController
@RequestMapping("/api/feeds")
public class FeedController {

	@Autowired
	private FeedService feedService;

	/**
	 * List of all feeds created by me
	 * 
	 * @return
	 */
	@GetMapping("")
	public List<FeedBo> list() {
		try {
			return feedService.myFeeds();
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}

	/**
	 * validate and save feed for user
	 * 
	 */
	@PostMapping("")
	public FeedDetailBo save(@RequestBody @Valid FeedDetailBo feed) {
		feed.setId(1L);
		return feed;
	}

	/**
	 * update and exiting feed. [note user can update only his feed.]
	 */
	public void update() {

	}

	/**
	 * Delete a feed. user can only delete his feed.
	 */
	public void delete() {

	}

	/**
	 * report / spam / offensive feed
	 * 
	 */
	public void reportFeed() {

	}

	/**
	 * Only admin can do it.
	 */
	public void blockFeed() {

	}
}
