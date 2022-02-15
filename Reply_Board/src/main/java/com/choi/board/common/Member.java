package com.choi.board.common;

import java.util.Date;

public class Member {
	private String id;
	private String name;
	private String password;
	private String email;
	private Date regDate;
	private int state;
	
	public Member() {
	}
	
	public Member(String id, String name, String password, String email, int state) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.state = state;
	}
	
	public Member(String newPassword, String newEmail) {
		this.password = newPassword;
		this.email = newEmail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
