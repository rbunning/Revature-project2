package com.revature.dto;

public class TaskDTO {
	private int storyId;
	private String taskDescription;
	
	public TaskDTO() {}

	public TaskDTO(int storyId, String taskDescription) {
		super();
		this.storyId = storyId;
		this.taskDescription = taskDescription;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	@Override
	public String toString() {
		return "TaskDTO [storyId=" + storyId + ", taskDescription=" + taskDescription + "]";
	}
	
	
}
