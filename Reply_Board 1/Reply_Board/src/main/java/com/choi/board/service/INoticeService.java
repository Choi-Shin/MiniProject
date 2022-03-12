package com.choi.board.service;

import java.util.List;

import com.choi.board.common.Notice;
import com.choi.board.common.NoticeReply;
import com.choi.board.common.Page;

public interface INoticeService {
	List<Notice> 게시판목록을가져오다(Page page);
	int 모든게시물의갯수를세다();
	Notice 찾는다By번호(int no);
	int 새글을저장하다(Notice board);
	void 조회수를올리다(Notice board);
	int 게시글을삭제하다(int no);
	int 댓글달다(NoticeReply reply);
	int 댓글수를세다(int no);
	List<NoticeReply> 댓글목록을가져오다(int no);
	int 게시글을수정하다(Notice board);
	int 몇번째글인지출력한다(int no);
	Notice n번째행을출력한다(int no);
	int 댓글을삭제하다(int no, int ReplyNo);
}
