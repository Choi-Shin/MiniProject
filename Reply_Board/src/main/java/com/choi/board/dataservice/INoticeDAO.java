package com.choi.board.dataservice;

import java.util.List;

import com.choi.board.common.Notice;
import com.choi.board.common.Page;
import com.choi.board.common.NoticeReply;

public interface INoticeDAO {
	int 모든게시물의갯수를세다();

	Notice n번째행을출력한다(int no);

	int 몇번째글인지출력한다(int 게시물번호);

	List<Notice> 게시판목록을가져오다(Page page);

	Notice 찾는다By번호(int 번호);

	int 댓글수를세다(int 글번호);

	List<NoticeReply> 댓글목록을가져오다(int 게시글번호);

	int 새글을저장하다(Notice 새게시물);

	int 게시글을수정하다(Notice board);

	int 게시글을삭제하다(int no);

	int 댓글달다(NoticeReply reply);

	void 조회수를올리다(Notice 조회할게시물);
}
