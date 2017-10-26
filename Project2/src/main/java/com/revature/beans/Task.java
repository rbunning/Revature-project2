package com.revature.beans;

import java.io.Serializable;

public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4991925864180552219L;
	
	private int taskId;
	private Story story;
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
