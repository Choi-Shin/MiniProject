package com.choi.board.dataservice;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.choi.board.common.Board;
import com.choi.board.common.Page;
import com.choi.board.common.Reply;

@Mapper
public interface IBoardMapper {

	@Select("SELECT COUNT(*) FROM board")
	int 모든게시물의갯수를세다();

	@Select("SELECT * FROM board ORDER BY no ASC LIMIT #{no},1")
	@Results(value = {
			@Result(property = "rownum", column = "rownum", one = @One(select = "com.choi.board.dataservice.몇번째글인지출력한다")),
			@Result(property = "no", column = "no"), @Result(property = "title", column = "title"),
			@Result(property = "content", column = "content"), @Result(property = "writer", column = "writer"),
			@Result(property = "regDate", column = "regDate"), @Result(property = "hit", column = "hit"),
			@Result(property = "replyCnt", column = "replyCnt") })
	Board n번째행을출력한다(@Param("no") int no);

	@Select("SELECT COUNT(*) FROM board WHERE no <= (SELECT no FROM board WHERE no = #{no}")
	int 몇번째글인지출력한다(int no);

	@Select("SELECT * FROM board where no=#{no}")
	@Results(value = {
			@Result(property = "rownum", column = "rownum", one = @One(select = "com.choi.board.dataservice.몇번째글인지출력한다")),
			@Result(property = "no", column = "no"), @Result(property = "title", column = "title"),
			@Result(property = "content", column = "content"), @Result(property = "writer", column = "writer"),
			@Result(property = "regDate", column = "regDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "hit", column = "hit"), @Result(property = "replyCnt", column = "replyCnt") })
	Board 찾는다By번호(int no);

	@Select("SELECT * FROM board WHERE no > 0 ORDER BY no DESC LIMIT #{pageStart}, #{perPageNum}")
	@Results(value = {
			@Result(property = "rownum", column = "rownum", one = @One(select = "com.choi.board.dataservice.몇번째글인지출력한다")),
			@Result(property = "no", column = "no"), @Result(property = "title", column = "title"),
			@Result(property = "content", column = "content"), @Result(property = "writer", column = "writer"),
			@Result(property = "regDate", column = "regDate", jdbcType = JdbcType.TIMESTAMP),
			@Result(property = "hit", column = "hit"), @Result(property = "replyCnt", column = "replyCnt") })
	List<Board> 게시판목록을가져오다(Page page);

	@Select("SELECT COUNT(*) FROM reply WHERE board_no=#{no}")
	int 댓글수를세다(int no);

	@Select("SELECT * FROM reply WHERE board_no=#{no} ORDER BY reply_no ASC")
	@Results(value = { @Result(property = "board_no", column = "board_no"),
			@Result(property = "reply_no", column = "reply_no"), @Result(property = "writer", column = "writer"),
			@Result(property = "memo", column = "memo"),
			@Result(property = "regDate", column = "regDate", jdbcType = JdbcType.TIMESTAMP) })
	List<Reply> 댓글목록을가져오다(int 게시글번호);

	@Insert("INSERT INTO board (title, writer, content, regDate) VALUES (?,?,?,now())")
	int 새글을저장하다(Board 새게시물);
	
	@Update("UPDATE board SET title=#{title}, content=#{content}, regDate=now() where no=#{no}")
	int 게시글을수정하다(Board board);
	
	@Delete("DELETE FROM board WHERE no=#{no}")
	int 게시글을삭제하다(int no);
	
	@Insert("INSERT INTO reply(board_no,reply_no, writer, memo,regdate) values (?,?,?,?,now())")
	int 댓글달다(Reply reply);
	
	@Update("UPDATE board SET hit=#{hit} WHERE no=#{no}")
	void 조회수를올리다(Board 조회할게시물);
}
