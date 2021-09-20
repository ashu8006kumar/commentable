package com.arha.commentable.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arha.commentable.bo.FeedBo;

@Service
public class FeedServiceImpl implements FeedService {
	/**
	 * Show feed details according to user. but for now we are show hard coded list
	 */
	@Override
	public List<FeedBo> myFeeds() {
		List<FeedBo> feeds = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			feeds.add(new FeedBo("feed info " + (i + 1), new Date()));

		}
		return feeds;
	}

}
