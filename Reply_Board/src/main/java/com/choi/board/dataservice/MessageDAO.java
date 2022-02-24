package com.choi.board.dataservice;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.choi.board.common.AuthUser;
import com.choi.board.common.Message;

@Repository
public class MessageDAO implements IMessageDAO {
	private Connection conn;

	public MessageDAO() {
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

	@Override
	public int 메시지보내다(Message message) {
		String sql = "insert into message(recv_id, send_id, title, note, date_sent) values(?,?,?,?,now())";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, message.getRecv_id());
			pstmt.setString(2, message.getSend_id());
			pstmt.setString(3, message.getTitle());
			pstmt.setString(4, message.getNote());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		}
		return 0;
	}

	@Override
	public int 메시지를삭제하다(Message message, String del) {
		String sql = "update message set ?='Y' where no=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, del);
			pstmt.setInt(2, message.getNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
		}
		return 0;
	}

	@Override
	public Message 메시지를읽다(Message message, AuthUser user) {
		String sql = "update message set date_read=now(), recv_read=? where no = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setInt(2, message.getNo());
			pstmt.executeUpdate();
			
			pstmt = null;
			Message m = new Message();
			sql = "select * from message where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, message.getNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				m.setNo(rs.getInt("no"));
				m.setRecv_id(rs.getString("recv_id"));
				m.setSend_id(rs.getString("send_id"));
				m.setTitle(rs.getString("title"));
				m.setNote(rs.getString("note"));
				Date d = rs.getTimestamp("date_sent");
				m.setDate_sent(d);
				d = rs.getTimestamp("date_read");
				m.setDate_read(d);
				m.setRecv_read(rs.getString("recv_read").charAt(0));
				m.setRecv_del(rs.getString("recv_del").charAt(0));
				m.setSent_del(rs.getString("sent_del").charAt(0));
				return m;
			}
			
		} catch (SQLException e) {
		}
		return null;
	}

	@Override
	public List<Message> 수신함을열다(AuthUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> 발신함을열다(AuthUser user) {
		// TODO Auto-generated method stub
		return null;
	}
}
