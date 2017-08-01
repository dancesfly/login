package com.model;

public class User {

	String password;
	String name;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [password=" + password + ", name=" + name + "]";
	}
}
