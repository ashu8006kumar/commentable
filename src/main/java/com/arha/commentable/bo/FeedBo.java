package com.arha.commentable.bo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class FeedBo {
	private Long id;
	private String description;
	private Date dateCreated;
	private UserCompactBo createdBy;
	private List<CommentBo> comments;

	public Long getId() {
		return id;
	}

	public List<CommentBo> getComments() {
		return comments;
	}

	public void setComments(List<CommentBo> comments) {
		this.comments = comments;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FeedBo() {
	}

	public FeedBo(Long id, String description, Date dateCreated) {
		super();
		this.id = id;
		this.description = description;
		this.dateCreated = dateCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "FeedBo [description=" + description + "]";
	}

}
