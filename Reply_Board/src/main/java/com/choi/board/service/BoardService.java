package com.choi.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.Board;
import com.choi.board.common.Page;
import com.choi.board.dataservice.BoardDAO;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO dao;
	
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
}
