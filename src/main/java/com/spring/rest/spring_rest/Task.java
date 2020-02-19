package com.spring.rest.spring_rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private long taskId;
	private String taskDescription;
	private long workerId;
	private float taskTotal;
	
	public Task(){}

	public Task(long taskId, String taskDescription, long workerId, float taskTotal) {
		super();
		this.taskId = taskId;
		this.taskDescription = taskDescription;
		this.workerId = workerId;
		this.taskTotal = taskTotal;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public long getWorkerId() {
		return workerId;
	}

	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}

	public float getTaskTotal() {
		return taskTotal;
	}

	public void setTaskTotal(float taskTotal) {
		this.taskTotal = taskTotal;
	}
}
