package com.choi.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choi.board.common.Board;

@Controller
public class BoardController {
	
	@RequestMapping("/List")
	public String 게시판목록수집하다() {
		List<Board> 목록 = new ArrayList<Board>();
		return "boardlist";
	}
}
