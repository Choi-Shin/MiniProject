package com.choi.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.Board;
import com.choi.board.common.NoticeReply;
import com.choi.board.common.Page;
import com.choi.board.dataservice.NoticeDAO;

@Service
public class NoticeService {
	
	@Autowired
	NoticeDAO dao;
	
	public List<Board> 게시판목록을가져오다(Page page) {
		return dao.게시판목록을가져오다(page);
	}
	
	public int 모든게시물의갯수를세다() {
		return dao.모든게시물의갯수를세다();
	}
	
	public Board 찾는다By번호(int 번호) {
		return dao.찾는다By번호(번호);
	}
	
	public int 새글을저장하다(Board 새게시물) {
		return dao.새글을저장하다(새게시물);
	}
	
	public void 조회수를올리다(Board 게시물) {
		dao.조회수를올리다(게시물);
	}
	public int 게시글을삭제하다(int no) {
		return dao.게시글을삭제하다(no);
	}
	public int 댓글달다(NoticeReply noticeRe) {
		return dao.댓글달다(noticeRe);
	}
}
