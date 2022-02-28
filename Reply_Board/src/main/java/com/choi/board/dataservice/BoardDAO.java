package com.choi.board.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.choi.board.common.Board;
import com.choi.board.common.Page;
import com.choi.board.common.Reply;
import com.choi.board.util.JdbcUtil;

@Repository
public class BoardDAO {
	private Connection conn;

	public BoardDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://3.37.252.132:3306/miniproject?useUnicode=true&"
					+ "characterEncoding=utf8&&ServerTimeZone=UTC&autoReconnect=true", "miniproject", "1234");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("Connection을 연결할 수 없습니다.");
		}
	}

	public int 모든게시물의갯수를세다() {
		String sql = "Select count(*) from board where state = 1";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Board> 게시판목록을가져오다(Page page) {
		String sql = "SELECT * FROM board " + "WHERE no > 0 and state =1 ORDER BY no DESC " + "LIMIT ?, ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> 목록 = new ArrayList<Board>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page.getPageStart());
			pstmt.setInt(2, page.getPerPageNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board 글 = new Board();
				글.setNo(rs.getInt("no"));
				글.setRownum(몇번째글인지출력한다(글.getNo()));
				글.setTitle(rs.getString("title"));
				글.setWriter(rs.getString("writer"));
				글.setContent(rs.getString("content"));
				Date date = rs.getTimestamp("regDate");
				글.setRegDate(date);
				글.setHit(rs.getInt("hit"));
				글.setReplyCnt(댓글수를세다(글.getNo()));
				목록.add(글);
			}
			if (목록.size() > 0) {
				return 목록;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + ": 목록을 가져오는데에 실패하였습니다.");
		}
		return null;
	}

	public int 새글을저장하다(Board 새게시물) {
		String sql = "insert into board (title, writer, content, regDate) values(?,?,?,now())";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, 새게시물.getTitle());
			pstmt.setString(2, 새게시물.getWriter());
			pstmt.setString(3, 새게시물.getContent());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "저장 실패");
		}
		return 0;
	}

	public Board 찾는다By번호(int 번호) {
		Board 찾는게시물 = null;
		PreparedStatement 명령자 = null;
		ResultSet 게시물표 = null;
		String sql = "select * from board where no = ?";
		try {
			명령자 = conn.prepareStatement(sql);
			명령자.setInt(1, 번호);
			게시물표 = 명령자.executeQuery();
			if (게시물표.next()) {
				찾는게시물 = new Board();
				찾는게시물.setNo(번호);
				찾는게시물.setRownum(몇번째글인지출력한다(번호));
				찾는게시물.setTitle(게시물표.getString("title"));
				찾는게시물.setContent(게시물표.getString("content"));
				찾는게시물.setWriter(게시물표.getString("writer"));
				Date date = 게시물표.getTimestamp("regDate");
				찾는게시물.setRegDate(date);
				찾는게시물.setHit(게시물표.getInt("hit"));
				찾는게시물.setReplyCnt(댓글수를세다(번호));
			}
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(게시물표);
			JdbcUtil.close(명령자);
		}
		return 찾는게시물;
	}

	public int 게시글을수정하다(Board board) {
		String sql = "update board set title=?, content=?, regDate=now() where no=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	public int 게시글을삭제하다(int no) {
		String sql = "delete from board where no=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return result;
	}

	public int 댓글수를세다(int 글번호) {
		String sql = "Select count(*) from reply where board_no=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 글번호);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt(1);
				return cnt;
			}
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return cnt;
	}

	public int 댓글달다(Reply reply) {
		String sql = "Insert into reply(board_no,reply_no, writer, memo,regdate) values (?,?,?,?,now())";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getBoard_no());
			pstmt.setInt(2, 댓글수를세다(reply.getBoard_no()) + 1);
			pstmt.setString(3, reply.getWriter());
			pstmt.setString(4, reply.getMemo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public void 조회수를올리다(Board 조회할게시물) {
		String sql = "update board set hit=? where no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 조회할게시물.getHit() + 1);
			pstmt.setInt(2, 조회할게시물.getNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public List<Reply> 댓글목록을가져오다(int 게시글번호) {
		String sql = "select * from reply where board_no=? order by reply_no asc";
		List<Reply> 댓글목록 = new ArrayList<Reply>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 게시글번호);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reply 댓글 = new Reply();
				댓글.setBoard_no(rs.getInt("board_no"));
				댓글.setReply_no(rs.getInt("reply_no"));
				댓글.setWriter(rs.getString("writer"));
				댓글.setMemo(rs.getString("memo"));
				Date date = rs.getTimestamp("regdate");
				댓글.setRegDate(date);
				댓글목록.add(댓글);
			}
			return 댓글목록;
		} catch (SQLException e) {
			System.out.println(e.getStackTrace() + "댓글 조회 실패");
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}

	public int 몇번째글인지출력한다(int 게시물번호) {
		String sql = "SELECT COUNT(*) FROM board WHERE no <= (SELECT no FROM board WHERE no = ?)";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 게시물번호);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public Board n번째행을출력한다(int no) {
		String sql = "SELECT * FROM board ORDER BY no asc LIMIT ?,1";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no-1);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				board = new Board();
				board.setNo(rs.getInt("no"));
				board.setRownum(no);
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setWriter(rs.getString("writer"));
				Date date = rs.getTimestamp("regDate");
				board.setRegDate(date);
				board.setHit(rs.getInt("hit"));
				board.setReplyCnt(댓글수를세다(board.getNo()));
				return board;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return board;
	}

	public int 댓글을삭제하다(int no, int replyNo) {
		String sql = "delete from reply where board_no=? and reply_no=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setInt(2, replyNo);
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(pstmt);
		}
		return 0;
	}

	public List<Board> 작성자로검색하다(String id, Page page) {
		String sql = "select * from board where no > 0 and writer = ? ORDER BY no DESC " + "LIMIT ?, ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, page.getPageStart());
			pstmt.setInt(3, page.getPerPageNum());
			rs = pstmt.executeQuery();
			List<Board> boards = new ArrayList<Board>();
			while (rs.next()) {
				Board 글 = new Board();
				글.setNo(rs.getInt("no"));
				글.setRownum(몇번째글인지출력한다(글.getNo()));
				글.setTitle(rs.getString("title"));
				글.setWriter(rs.getString("writer"));
				글.setContent(rs.getString("content"));
				Date date = rs.getTimestamp("regDate");
				글.setRegDate(date);
				글.setHit(rs.getInt("hit"));
				글.setReplyCnt(댓글수를세다(글.getNo()));
				글.setState(rs.getInt("state"));
				if(글.getState() == 1) {
					boards.add(글);
				}
			}
			return boards;
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}
}
