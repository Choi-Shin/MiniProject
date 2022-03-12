package com.choi.board.common;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private String id;
	private String name;
	private String password;
	MultipartFile profileFile;// 업로드된 파일 매칭요
	byte[] profile; // 프로필사진 (데이터)
	private String email;
	private Date regDate;
	private int state;
	private List<Message> unreadMsg;
	private int auth_key; // 난수 생성
	private int auth_status; // default 0, 인증 후 1

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

	public MultipartFile getProfileFile() {
		return profileFile;
	}

	public void setProfileFile(MultipartFile profileFile) {
		this.profileFile = profileFile;
	}

	public byte[] getProfile() {
		try {
			if (profileFile != null && profile == null) {
				// 업로드된 파일에서 프로필사진 데이터만 추출
				profile = profileFile.getBytes();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return profile;
	}

	public void setProfile(byte[] profile) {
		this.profile = profile;
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

	public List<Message> getUnreadMsg() {
		return unreadMsg;
	}

	public void setUnreadMsg(List<Message> unreadMsg) {
		this.unreadMsg = unreadMsg;
	}

	public int getAuth_key() {
		return auth_key;
	}

	public void setAuth_key(int auth_key) {
		this.auth_key = auth_key;
	}

	public int getAuth_status() {
		return auth_status;
	}

	public void setAuth_status(int auth_status) {
		this.auth_status = auth_status;
	}
}
