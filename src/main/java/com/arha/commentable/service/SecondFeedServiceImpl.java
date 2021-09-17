package com.arha.commentable.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.arha.commentable.bo.FeedBo;

@Service("secondFeedService")
public class SecondFeedServiceImpl implements FeedService {
	/**
	 * Show feed details according to user. but for now we are show hard coded list
	 */
	@Override
	public List<FeedBo> myFeeds() {
		List<FeedBo> feeds = new ArrayList<>();
		FeedBo feedBo = new FeedBo("1", new Date());
		feeds.add(feedBo);
		FeedBo feedBo2 = new FeedBo("2", new Date());
		feeds.add(feedBo2);
		FeedBo feedBo3 = new FeedBo("3", new Date());
		feeds.add(feedBo3);
		FeedBo feedBo4 = new FeedBo("4", new Date());
		feeds.add(feedBo4);
		return feeds;
	}

}
