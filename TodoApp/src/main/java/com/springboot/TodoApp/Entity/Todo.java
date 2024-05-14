package com.springboot.TodoApp.Entity;

import java.time.LocalDate;

public class Todo {
	private int id;
	private String descriptionString;
	private String username;
	private LocalDate targetDate;
	private boolean isDone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescriptionString() {
		return descriptionString;
	}

	public void setDescriptionString(String descriptionString) {
		this.descriptionString = descriptionString;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", descriptionString=" + descriptionString + ", username=" + username
				+ ", targetDate=" + targetDate + ", isDone=" + isDone + "]";
	}

	public Todo(int id, String descriptionString, String username, LocalDate targetDate, boolean isDone) {
		super();
		this.id = id;
		this.descriptionString = descriptionString;
		this.username = username;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}

	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
