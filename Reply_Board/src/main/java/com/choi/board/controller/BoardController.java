package com.choi.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choi.board.common.Board;
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
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView 게시글상세내용출력하다(int no) {
		ModelAndView mv = new ModelAndView();
		Board board = bs.찾는다By번호(no);
		mv.addObject("board", board);
		bs.조회수를올리다(board);
		mv.setViewName("board/read");
		return mv;
	}
	
	
	
	@GetMapping(value = "/write")
	public String 글쓰기양식을보여주다() {
		return "board/write";
	}
	
	@PostMapping(value = "/write")
	public ModelAndView 새글을저장하다(Board 새게시물) {
		ModelAndView mv = new ModelAndView();
		int result = bs.새글을저장하다(새게시물);
		if(result > 0) {
			mv.addObject("msg", "글이 등록되었습니다.");
			int no = bs.모든게시물의갯수를세다();
			새게시물.setNo(no);
			mv.addObject("board", 새게시물);
			mv.setViewName("board/read");
		} else {
			mv.addObject("msg", "글 등록에 실패하였습니다.");
			mv.setViewName("board/write");
		}
		return mv;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView 게시글을삭제하다(int no) {
		ModelAndView mv = new ModelAndView();
		int result = bs.게시글을삭제하다(no);
		if (result > 0) {
			mv.addObject("msg", "게시글이 삭제되었습니다.");
		} else {
			mv.addObject("msg", "삭제에 실패하였습니다.");
		}
		mv.setViewName("board/list?page=1");
		return mv;
	}
}
