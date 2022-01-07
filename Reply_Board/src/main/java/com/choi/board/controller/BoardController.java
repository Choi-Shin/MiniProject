package com.choi.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.choi.board.common.Board;
import com.choi.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService bs;
	
	@RequestMapping(value ="/list", method = RequestMethod.GET)
	public String 게시판목록수집하다() {
		List<Board> 목록 = new ArrayList<Board>();
		return "boardlist";
	}
	
	@RequestMapping(value ="/notice", method = RequestMethod.GET)
	public String 공지사항() {
		return "notice";
	}
}
