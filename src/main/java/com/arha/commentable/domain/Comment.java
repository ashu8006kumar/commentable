package com.arha.commentable.domain;

import java.util.Date;

public class Comment {
	private Long id;
	private Long feedId; // later we use mapping, find type db relations
	private String text;
	private String createdBy;
	private Date dateCreated;
}
