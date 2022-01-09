package com.choi.board.common;

import java.sql.Timestamp;
import java.util.Date;

public class Board {
	private int no;
	private String title;
	private String contents;
	private String writer;
	private Timestamp regDate;
	private Long hit;
	private int replyCnt;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public Date setRegDate(Timestamp regDate) {
		return regDate.
		
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	
}
