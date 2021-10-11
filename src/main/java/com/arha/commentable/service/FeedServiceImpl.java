package com.arha.commentable.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.arha.commentable.bo.CommentBo;
import com.arha.commentable.bo.FeedBo;
import com.arha.commentable.bo.FeedDetailBo;
import com.arha.commentable.datatype.StatusValue;
import com.arha.commentable.domain.Comment;
import com.arha.commentable.domain.Feed;
import com.arha.commentable.repository.FeedRepository;

@Service
public class FeedServiceImpl implements FeedService {

	@Autowired
	private FeedRepository feedRepository;

	/**
	 * Show feed details according to user. but for now we are show hard coded list
	 */
	@Override
	@Transactional
	public List<FeedBo> myFeeds() {
		List<FeedBo> feeds = new ArrayList<>();
		List<Feed> list = feedRepository.findAllByCreatedBy("Ashish@XYZ");
		for (Feed feed : list) {
			FeedBo bo = new FeedBo(feed.getId(), feed.getDescription(), feed.getDateCreated());
			if (!CollectionUtils.isEmpty(feed.getComments())) {
				bo.setComments(new ArrayList<>());
				for (Comment comment : feed.getComments()) {
					CommentBo cbo = new CommentBo(comment.getId(), comment.getText());
					bo.getComments().add(cbo);
				}
			}
			feeds.add(bo);
		}
		return feeds;
	}

	@Override
	public FeedDetailBo save(FeedDetailBo feedBo) {
		Feed feed = new Feed();
		feed.setDescription(feedBo.getDescription());
		feed.setCreatedBy("Ashish@XYZ");
		// where ?
		feedRepository.save(feed);
		feedBo.setId(feed.getId());
		return feedBo;
	}

	@Override
	public FeedDetailBo update(FeedDetailBo feedBo) {
		Feed feed = get(feedBo.getId());
		feed.setDescription(feedBo.getDescription());
		feed.setUpdatedBy("XYZ@XYZ");
		feedRepository.save(feed);
		return feedBo;
	}

	@Override
	public Feed get(Long id) {
		return feedRepository.getById(id);
	}

	@Override
	public void delete(Long feedId) {
		Feed feed = get(feedId);
		feedRepository.delete(feed);
	}

	@Override
	public void updateStatus(Long feedId, StatusValue statusValue) {
		Feed feed = get(feedId);
		feed.setStatus(statusValue);
		feed.setUpdatedBy("XYZ@XYZ");
		feedRepository.save(feed);

	}

}
