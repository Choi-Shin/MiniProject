package com.choi.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choi.board.common.Board;
import com.choi.board.dataservice.BoardDAO;

@Service
public class BoardService {
	
	@Autowired
	BoardDAO dao;
	
	public List<Board> 게시판목록을요청하다() {
		List<Board> 목록 = dao.게시판목록을가져오다();
		return 목록;
	}
}
