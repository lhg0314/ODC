package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public int selectCntAllReview(String search) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from reviewboard r";
		sql += "	inner join userinfo u on (r.user_no = u.user_no)";
		sql += "	inner join classinfo c on (r.class_no = c.class_no)";
		sql += "	where c.class_name like '%'||?||'%'";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);

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
	public List<Map<String, Object>> selectAllReview(Paging paging) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select r.review_no, r.review_date, r.sat_level, r.review_title, u.user_id, c.class_name from reviewboard r";
		sql += "	inner join userinfo u on (r.user_no = u.user_no)";
		sql += "	inner join classinfo c on (r.class_no = c.class_no)";
		sql += "	where c.class_name like '%'||?||'%' order by r.review_no desc";
		sql += "	) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("reviewNo", rs.getInt("review_no"));
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
	public void deleteReviewList(String names) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "delete from reviewboard where review_no in ( "+names+" )";
		
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
	public Map<String, Object> selectReviewByReviewNo(int reviewno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select r.review_no, u.user_nick, c.class_name, a.art_name, r.review_content, r.review_date, r.sat_level, r.review_title,";
		sql += "	f.review_rename_filename from reviewboard r";
		sql += "	inner join userinfo u on (r.user_no = u.user_no)";
		sql += "	inner join classinfo c on (r.class_no = c.class_no)";
		sql += "	inner join artistinfo a on (c.art_no = a.art_no)";
		sql += "	left outer join reviewfile f on (r.review_no = f.review_no)";
		sql += "	where r.review_no = ?";

		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewno);
			rs = ps.executeQuery();

			while (rs.next()) {
			
				map = new HashMap<String, Object>();
	
				map.put("reviewNo", rs.getInt("review_no"));
				map.put("artName", rs.getString("art_name"));
				map.put("userName", rs.getString("user_name"));
				map.put("className", rs.getString("class_name"));
				map.put("reviewTitle", rs.getString("review_title"));
				map.put("reviewContent", rs.getString("review_content"));
				map.put("reviewDate", rs.getDate("review_date"));
//				map.put("satLevel", rs.getString("sat_level"));
				map.put("filename", rs.getString("review_rename_filename"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return map;
	}	

}
