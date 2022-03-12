package com.choi.board.common;

import java.util.Date;

public class Message {
	private int no;
	private String recv_id;
	private String send_id;
	private String title;
	private String note;
	private Date date_sent;
	private Date date_read;
	private char recv_read;
	private char recv_del;
	private char sent_del;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRecv_id() {
		return recv_id;
	}
	public void setRecv_id(String recv_id) {
		this.recv_id = recv_id;
	}
	public String getSend_id() {
		return send_id;
	}
	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getDate_sent() {
		return date_sent;
	}
	public void setDate_sent(Date date_sent) {
		this.date_sent = date_sent;
	}
	public Date getDate_read() {
		return date_read;
	}
	public void setDate_read(Date date_read) {
		this.date_read = date_read;
	}
	public char getRecv_read() {
		return recv_read;
	}
	public void setRecv_read(char recv_read) {
		this.recv_read = recv_read;
	}
	public char getRecv_del() {
		return recv_del;
	}
	public void setRecv_del(char recv_del) {
		this.recv_del = recv_del;
	}
	public char getSent_del() {
		return sent_del;
	}
	public void setSent_del(char sent_del) {
		this.sent_del = sent_del;
	}
}
