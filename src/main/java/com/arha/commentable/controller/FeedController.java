package com.arha.commentable.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arha.commentable.bo.FeedBo;
import com.arha.commentable.bo.FeedDetailBo;
import com.arha.commentable.datatype.StatusValue;
import com.arha.commentable.domain.Feed;
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
		try {
			return feedService.save(feed);
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}

	/**
	 * update and exiting feed. [note user can update only his feed.]
	 * 
	 * @return
	 */
	@PutMapping("/{feedId}")
	public FeedDetailBo update(@PathVariable Long feedId, @RequestBody @Valid FeedDetailBo feed) {
		try {
			feed.setId(feedId);
			return feedService.update(feed);
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}

	/**
	 * update and exiting feed. [note user can update only his feed.]
	 * 
	 * @return
	 */
	@GetMapping("/{feedId}")
	public FeedDetailBo get(@PathVariable Long feedId) {
		try {
			Feed feed = feedService.get(feedId);
			FeedDetailBo feedDetailBo = new FeedDetailBo();
			feedDetailBo.setDescription(feed.getDescription());
			feedDetailBo.setId(feed.getId());
			return feedDetailBo;
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}

	/**
	 * Delete a feed. user can only delete his feed.
	 */
	@DeleteMapping("/{feedId}") // user/feedid/admin feed has many comments
	public void delete(@PathVariable Long feedId) {
		try {
			feedService.delete(feedId);
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}

	/**
	 * report / spam / offensive feed
	 * 
	 */
	@PutMapping("/report/{feedId}")
	public void reportFeed(@PathVariable Long feedId) {
		try {
			feedService.updateStatus(feedId,StatusValue.REPORTED_SPAM);
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}

	/**
	 * Only admin can do it.
	 */
	@PutMapping("/block/{feedId}")
	public void blockFeed(@PathVariable Long feedId) {
		try {
			feedService.updateStatus(feedId,StatusValue.BLOCKED);
		} catch (Exception e) {
			throw new RuntimeException("Internal server error.");
		}
	}
}
