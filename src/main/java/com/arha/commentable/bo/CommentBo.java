package com.arha.commentable.bo;

import javax.validation.constraints.NotBlank;

public class CommentBo {
	private Long id;
	@NotBlank
	private String text;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public CommentBo(Long id, @NotBlank String text) {
		super();
		this.id = id;
		this.text = text;
	}
	
	
}
