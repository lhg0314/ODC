package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dao.face.AdminBoardDao;
import dbutil.JDBCTemplate;
import dto.NoticeBoard;
import util.Paging;

public class AdminBoardDaoImpl implements AdminBoardDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAllNotice() {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from noticeboard";
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return cnt;
	}

	@Override
	public List<NoticeBoard> selectAllNotice(Paging paging) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select * from noticeboard order by notice_date desc";
		sql += "	) b order by rnum ) t where rnum between ? and ?";
		
		List<NoticeBoard> list = new ArrayList<NoticeBoard>();
		NoticeBoard notice = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNO());
			ps.setInt(2, paging.getEndNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				notice = new NoticeBoard();
				
				notice.setNoticeNo(rs.getInt("notice_no"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeDate(rs.getDate("notice_date"));
				
				list.add(notice);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return list;
	}

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

}
