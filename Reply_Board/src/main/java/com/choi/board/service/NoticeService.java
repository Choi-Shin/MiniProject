package com.choi.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.Board;
import com.choi.board.common.Notice;
import com.choi.board.common.NoticeReply;
import com.choi.board.common.Page;
import com.choi.board.common.Reply;
import com.choi.board.dataservice.NoticeDAO;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDAO noticeDAO;
	
	public List<Notice> 게시판목록을가져오다(Page page) {
		return noticeDAO.게시판목록을가져오다(page);
	}
	public int 모든게시물의갯수를세다() {
		return noticeDAO.모든게시물의갯수를세다();
	}
	public Notice 찾는다By번호(int 번호) {
		return noticeDAO.찾는다By번호(번호);
	}
	public int 새글을저장하다(Notice 새게시물) {
		return noticeDAO.새글을저장하다(새게시물);
	}
	public void 조회수를올리다(Notice 게시물) {
		noticeDAO.조회수를올리다(게시물);
	}
	public int 게시글을삭제하다(int no) {
		return noticeDAO.게시글을삭제하다(no);
	}
	public int 댓글달다(NoticeReply noticeRe) {
		return noticeDAO.댓글달다(noticeRe);
	}
	public List<NoticeReply> 댓글목록을가져오다(int no) {
		return noticeDAO.댓글목록을가져오다(no);
	}
	public int 게시글을수정하다(Notice notice) {
		return noticeDAO.게시글을수정하다(notice);
	}
	public Notice n번째행을출력한다(int no) {
		return noticeDAO.n번째행을출력한다(no);
	}
}
