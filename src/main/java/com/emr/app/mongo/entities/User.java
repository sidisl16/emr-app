package com.emr.app.mongo.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
public class User {

	private String firstname;
	private String lastname;
	private String email;
	private String title = "Dr. ";

	public User() {
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}