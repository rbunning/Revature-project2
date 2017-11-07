package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TASK")

public class Task implements Serializable {

	private static final long serialVersionUID = 4991925864180552219L;

	@Id
	@Column(name="TASK_ID")
	@SequenceGenerator(name="taskSeq",sequenceName="task_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="taskSeq")
	private int taskId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="STORY_ID")
	private Story story;

	@Column(name="TASK_DESC")
	private String description;

	public Task() {
		super();
	}

	public Task(int taskId, Story story, String description) {
		super();
		this.taskId = taskId;
		this.story = story;
		this.description = description;
	}
	
	public Task(Story story, String description) {
		super();
		this.story = story;
		this.description = description;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", story=" + story + ", description=" + description + "]";
	}

}
