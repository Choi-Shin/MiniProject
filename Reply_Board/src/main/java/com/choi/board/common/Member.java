package com.choi.board.common;

import java.util.Date;

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
//	private String authKey; // 난수 생성
//	private int authStatus; //default 0, 인증 후 1
	
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

}
