package com.arha.commentable.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.arha.commentable.datatype.StatusValue;

@Entity(name = "feeds")
public class Feed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	@Column(name = "updated_by", nullable = true)
	private String updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_created", nullable = false)
	private Date dateCreated;
	@Temporal(TemporalType.TIMESTAMP)

	@Column(name = "last_updated", nullable = true)
	private Date lastUpdated;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusValue status;

	@OneToMany(mappedBy = "feed", orphanRemoval = true)
	private List<Comment> comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public StatusValue getStatus() {
		return status;
	}

	public void setStatus(StatusValue status) {
		this.status = status;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Feed() {
	}

	@PrePersist
	public void prePersistFeed() {
		System.out.println("new feed saved");
		setDateCreated(new Date());
		setStatus(StatusValue.ACTIVE);
	}

	@PreUpdate
	public void preUpdateUpdate() {
		System.out.println("Feed updated");
		setLastUpdated(new Date());
	}

}
