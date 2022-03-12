package com.choi.board.common;

import java.util.List;

public class AuthUser {
	private String id;
	private String password;
	private List<Message> unreadMsg;
	
	public AuthUser(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Message> getUnreadMsg() {
		return unreadMsg;
	}

	public void setUnreadMsg(List<Message> unreadMsg) {
		this.unreadMsg = unreadMsg;
	}
	
}
