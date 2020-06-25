package user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbutil.JDBCTemplate;
import user.dao.face.UserBoardDao;
import util.Paging;

public class UserBoardDaoImpl implements UserBoardDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectUserNoById(String userid) {
		conn = JDBCTemplate.getConnection();
		
		int userno = -1;
		
		String sql = "";
		sql += "select user_no from userinfo where user_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			
			rs = ps.executeQuery();
			rs.next();
			
			userno = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return userno;
	}

	@Override
	public int selectCntReviewByUserNo(String search, int userno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from reviewboard r";
		sql += "	inner join userinfo u on (r.user_no = u.user_no)";
		sql += "	inner join classinfo c on (r.class_no = c.class_no)";
		sql += "	where u.user_no = ? and c.class_name like '%'||?||'%'";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			ps.setString(2, search);
			
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
	public List<Map<String, Object>> selectReviewByUserNo(Paging paging, int userno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select r.review_no, r.review_date, r.class_no, r.sat_level, r.review_title, u.user_id, c.class_name from reviewboard r";
		sql += "	inner join userinfo u on (r.user_no = u.user_no)";
		sql += "	inner join classinfo c on (r.class_no = c.class_no)";
		sql += "	where u.user_no = ? and c.class_name like '%'||?||'%' order by r.review_no desc";
		sql += "	) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userno);
			ps.setString(2, paging.getSearch());
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			
			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("reviewNo", rs.getInt("review_no"));
				map.put("classNo", rs.getInt("class_no"));
				map.put("reviewDate", rs.getDate("review_date"));
				map.put("satLevel", rs.getInt("sat_level"));
				map.put("userId", rs.getString("user_id"));
				map.put("className", rs.getString("class_name"));
				map.put("reviewTitle", rs.getString("review_title"));
				
				list.add(map);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return list;
	}

}
