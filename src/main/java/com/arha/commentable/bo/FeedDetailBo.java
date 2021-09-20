package com.arha.commentable.bo;

import javax.validation.constraints.NotBlank;

public class FeedDetailBo {
	private Long id;
	@NotBlank
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
