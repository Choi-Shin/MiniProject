package com.choi.board.service;

import java.util.List;

import com.choi.board.common.Board;
import com.choi.board.common.Page;
import com.choi.board.common.Reply;

public interface IBoardService {
	List<Board> 게시판목록을가져오다(Page page);
	int 모든게시물의갯수를세다();
	Board 찾는다By번호(int no);
	int 새글을저장하다(Board board);
	void 조회수를올리다(Board board);
	int 게시글을삭제하다(int no);
	int 댓글달다(Reply reply);
	int 댓글수를세다(int no);
	List<Reply> 댓글목록을가져오다(int no);
	int 게시글을수정하다(Board board);
	int 몇번째글인지출력한다(int no);
	Board n번째행을출력한다(int no);
	int 댓글을삭제하다(int no, int ReplyNo);
}
