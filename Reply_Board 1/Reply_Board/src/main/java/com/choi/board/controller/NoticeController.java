package com.choi.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choi.board.common.Notice;
import com.choi.board.common.NoticeReply;
import com.choi.board.common.Page;
import com.choi.board.common.PageNavigator;
import com.choi.board.service.INoticeService;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	@Autowired
	INoticeService ns;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView 게시판목록수집하다(Page page, Device device) {
		ModelAndView mv = new ModelAndView();
		PageNavigator 페이지탐색기 = new PageNavigator();
		if (page == null) {
			page = new Page();
		}
		페이지탐색기.setPage(page);
		페이지탐색기.setTotalCount(ns.모든게시물의갯수를세다());
		mv.addObject("boards", ns.게시판목록을가져오다(page));
		mv.addObject("pageNavigator", 페이지탐색기);
		if (device.isMobile()) {
			mv.setViewName("m/notice/list");
		} else {
			mv.setViewName("notice/list");
		}
		return mv;
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public ModelAndView 게시글상세내용출력하다(int no, Device device) {
		ModelAndView mv = new ModelAndView();
		Notice board = ns.찾는다By번호(no);
		mv.addObject("board", board);
		List<NoticeReply> 댓글목록 = ns.댓글목록을가져오다(no);
		mv.addObject("comments", 댓글목록);
		ns.조회수를올리다(board);
		if (device.isMobile()) {
			mv.setViewName("m/notice/read");
		} else {
			mv.setViewName("notice/read");
		}
		return mv;
	}

	@GetMapping(value = "/write")
	public String 글쓰기양식을보여주다(Device device) {
		if (device.isMobile()) {
			return "m/notice/write";
		}
		return "notice/write";
	}

	@PostMapping(value = "/write")
	public ModelAndView 새글을저장하다(Notice 새게시물, Device device) {
		ModelAndView mv = new ModelAndView();
		int result = ns.새글을저장하다(새게시물);
		String url;
		if (result > 0) {
			mv.addObject("msg", "글이 등록되었습니다.");
			int rownum = ns.모든게시물의갯수를세다();
			새게시물 = new Notice();
			새게시물 = ns.n번째행을출력한다(rownum);
			url = "/notice/read?no=" + 새게시물.getNo();
			mv.addObject("url", url);
			mv.setViewName("redirect");
		} else {
			mv.addObject("msg", "글 등록에 실패하였습니다.");
			url = "/notice/write";
			mv.addObject("url", url);
			mv.setViewName("redirect");
		}
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView 게시글을삭제하다(int no, Device device) {
		ModelAndView mv = new ModelAndView();
		int result = ns.게시글을삭제하다(no);
		String url = "/notice/list";
		mv.addObject("url", url);
		if (result > 0) {
			mv.addObject("msg", "게시글이 삭제되었습니다.");
		} else {
			mv.addObject("msg", "삭제에 실패하였습니다.");
		}
		mv.setViewName("redirect");
		return mv;
	}

	@GetMapping(value = "/modify")
	public ModelAndView 게시글을수정하다(int no, Device device) {
		ModelAndView mv = new ModelAndView();
		Notice board = ns.찾는다By번호(no);
		mv.addObject("board", board);
		if (device.isMobile()) {
			mv.setViewName("m/notice/modify");
		} else {
			mv.setViewName("notice/modify");
		}
		return mv;
	}

	@PostMapping(value = "/modify")
	public ModelAndView 게시글수정저장하다(Notice board, Device device) {
		ModelAndView mv = new ModelAndView();
		String msg;
		int result = ns.게시글을수정하다(board);
		if (result > 0) {
			msg = "'" + board.getTitle() + "' 게시글을 수정하였습니다.";
			mv.addObject("msg", msg);
		} else {
			msg = "게시글 수정에 실패하였습니다.";
			mv.addObject("msg", msg);
		}
		String url = "../notice/read?no=" + board.getNo();
		mv.addObject("url", url);
		mv.setViewName("redirect");
		return mv;
	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public ModelAndView 댓글을달다(int no, NoticeReply noticeReply, Device device) {
		ModelAndView mv = new ModelAndView();
		int result = ns.댓글달다(noticeReply);
		String url = "/notice/read?no=" + no;
		mv.addObject("url", url);
		if (result > 0) {
			mv.addObject("msg", "댓글을 달았습니다.");

		} else {
			mv.addObject("msg", "댓글 작성에 실패하였습니다.");
		}
		mv.setViewName("redirect");
		return mv;
	}

	@RequestMapping(value = "/replyDelete", method = RequestMethod.GET)
	public ModelAndView 댓글을삭제하다(int no, int replyNo, Device device) {
		ModelAndView mv = new ModelAndView();
		int result = ns.댓글을삭제하다(no, replyNo);
		String url = "/notice/read?no=" + no;
		mv.addObject("url", url);
		if (result > 0) {
			mv.addObject("msg", "게시글이 삭제되었습니다.");
		} else {
			mv.addObject("msg", "삭제에 실패하였습니다.");
		}
		mv.setViewName("redirect");
		return mv;
	}
}
