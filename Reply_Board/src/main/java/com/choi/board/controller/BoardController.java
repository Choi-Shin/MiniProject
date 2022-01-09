package com.choi.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choi.board.common.Page;
import com.choi.board.common.PageNavigator;
import com.choi.board.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	BoardService bs;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView 게시판목록수집하다(Page page) {
		ModelAndView mv = new ModelAndView();
		PageNavigator 페이지탐색기 = new PageNavigator();
		페이지탐색기.setPage(page);
		페이지탐색기.setTotalCount(bs.모든게시물의갯수를세다());
		mv.addObject("board", bs.게시판목록을가져오다(page));
		mv.addObject("pageNavigator", 페이지탐색기);
		mv.setViewName("board/list");
		return mv;
	}

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String 공지사항() {
		return "board/notice";
	}
}
