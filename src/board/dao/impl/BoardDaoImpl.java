package board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.dao.face.BoardDao;
import dbutil.JDBCTemplate;
import dto.NoticeBoard;

public class BoardDaoImpl implements BoardDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void deleteNoticeList(String names) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "delete from noticeboard where notice_no in ( "+names+" )";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}

	@Override
	public void insertNotice(NoticeBoard noticeBoard) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "INSERT INTO noticeboard( notice_no, notice_title, notice_content)";
		sql += " VALUES(noticeboard_SEQ.nextval, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, noticeBoard.getNoticeTitle());
			ps.setString(2, noticeBoard.getNoticeContent());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}

	@Override
	public NoticeBoard selectNoticeBoard(int noticeno) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM noticeboard";
		sql += " WHERE notice_no = ?";
		
		//결과 객체
		NoticeBoard noticeBoard = null; 
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, noticeno);
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				noticeBoard = new NoticeBoard();
				
				noticeBoard.setNoticeNo(rs.getInt("notice_no"));
				noticeBoard.setNoticeDate(rs.getDate("notice_date"));
				noticeBoard.setNoticeTitle(rs.getString("notice_title"));
				noticeBoard.setNoticeContent(rs.getString("notice_content"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return noticeBoard;
	}

	@Override
	public void updateNotice(NoticeBoard noticeBoard) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "UPDATE noticeboard";
		sql += " SET";
		sql += " notice_title = ?";
		sql += " , notice_content = ?";
		sql += " WHERE notice_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, noticeBoard.getNoticeTitle());
			ps.setString(2, noticeBoard.getNoticeContent());
			ps.setInt(3, noticeBoard.getNoticeNo());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}	

}
