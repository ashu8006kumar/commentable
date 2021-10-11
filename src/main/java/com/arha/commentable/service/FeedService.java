package com.arha.commentable.service;

import java.util.List;

import com.arha.commentable.bo.FeedBo;
import com.arha.commentable.bo.FeedDetailBo;
import com.arha.commentable.datatype.StatusValue;
import com.arha.commentable.domain.Feed;

public interface FeedService {
	List<FeedBo> myFeeds();

	FeedDetailBo update(FeedDetailBo feedBo);

	FeedDetailBo save(FeedDetailBo feedBo);

	Feed get(Long id);

	void delete(Long feedId);

	void updateStatus(Long feedId, StatusValue blocked);

}
