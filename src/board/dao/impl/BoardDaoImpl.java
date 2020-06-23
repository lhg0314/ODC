package board.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.dao.face.BoardDao;
import dbutil.JDBCTemplate;

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

}
