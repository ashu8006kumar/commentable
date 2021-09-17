package com.arha.commentable.bo;

import java.util.Date;

public class FeedBo {
	private String description;
	private Date dateCreated;

	public FeedBo() {
	}

	public FeedBo(String description, Date dateCreated) {
		super();
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
