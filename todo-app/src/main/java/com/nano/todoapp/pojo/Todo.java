package com.nano.todoapp.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@NotNull(message = "Title Cannot be empty")
	@NotBlank(message = "Title Cannot be empty")
	@Column(name = "title")
	private String title;
	
//	@NotNull(message = "Description Cannot be empty")
	@NotBlank(message = "Description Cannot be empty")
	@Column(name = "description")
	private String description;
	
	@Column(name = "completed")
	private boolean completed = false;
	
	@Column(name = "created_on")
	private Date createdOn = new Date();
	
	@Column(name = "last_updated_on")
	private Date lastUpdatedOn = new Date();
	
	public Todo() {}

	public Todo(String title, String description, boolean completed, Date createdOn, Date lastUpdatedOn) {
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Todo(int id, String title, String description, boolean completed, Date createdOn, Date lastUpdatedOn) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
		this.createdOn = createdOn;
		this.lastUpdatedOn = lastUpdatedOn;
	}
	
	public Todo(int id, String title, String description, boolean completed) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.completed = completed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", description=" + description + ", completed=" + completed
				+ ", createdOn=" + createdOn + ", lastUpdatedOn=" + lastUpdatedOn + "]";
	}
}
