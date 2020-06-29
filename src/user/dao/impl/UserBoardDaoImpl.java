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
import dto.AskBoardComm;
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

	@Override
	public int selectCntAskByUserNo(String search, int userno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from askboard r";
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
	public List<Map<String, Object>> selectAskByUserNo(Paging paging, int userno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select ask.ask_board_no, art.art_name, c.class_name, c.class_no, ask_title, ask_date, nvl2(cmcnt.cnt, cmcnt.cnt, 0) commcnt from askboard ask";
		sql += "	inner join artistinfo art on (ask.art_no = art.art_no)";
		sql += "	inner join classinfo c on (ask.class_no = c.class_no)";
		sql += "	left outer join (select count(*) cnt, ask_board_no from askboardcomm group by ask_board_no) cmcnt";
		sql += "	on (cmcnt.ask_board_no = ask.ask_board_no)";
		sql += "	where ask.user_no = ? and c.class_name like '%'||?||'%' order by ask.ask_board_no desc";
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

				map.put("askNo", rs.getInt("ask_board_no"));
				map.put("classNo", rs.getInt("class_no"));
				map.put("artName", rs.getString("art_name"));
				map.put("className", rs.getString("class_name"));
				map.put("askTitle", rs.getString("ask_title"));
				map.put("askDate", rs.getDate("ask_date"));
				map.put("commCnt", rs.getInt("commcnt"));
				
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
	public void deleteReviewListByUserNo(String names, int userno) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "delete from reviewboard where review_no in ( "+names+" ) and user_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

	@Override
	public void deleteAskListByUserNo(String names, int userno) {
		conn = JDBCTemplate.getConnection();
		
		String sql = "delete from askboard where ask_board_no in ( "+names+" ) and user_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userno);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
	}

	@Override
	public Map<String, Object> selectAskByAskNo(int askno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select ask.ask_board_no, art.art_name, u.user_name, c.class_name, ask_title, ask_content, ask_date from askboard ask";
		sql += "	inner join artistinfo art on (ask.art_no = art.art_no)";
		sql += "	inner join classinfo c on (ask.class_no = c.class_no)";
		sql += "	inner join userinfo u on (ask.user_no = u.user_no)";
		sql += "	where ask.ask_board_no = ?";

		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, askno);
			
			rs = ps.executeQuery();

			while (rs.next()) {
				
				map = new HashMap<String, Object>();
	
				map.put("askNo", rs.getInt("ask_board_no"));
				map.put("artName", rs.getString("art_name"));
				map.put("userName", rs.getString("user_name"));
				map.put("className", rs.getString("class_name"));
				map.put("askTitle", rs.getString("ask_title"));
				map.put("askContent", rs.getString("ask_content"));
				map.put("askDate", rs.getDate("ask_date"));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return map;
	}

	@Override
	public List<AskBoardComm> selectCommByAskNo(int askno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select comm_content, comm_date, ask_comm_no from askboardcomm where ask_board_no= ? order by comm_date desc, ask_comm_no desc";

		List<AskBoardComm> list = new ArrayList<AskBoardComm>();
		AskBoardComm comm = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, askno);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				comm = new AskBoardComm();
				
				comm.setAskCommno(rs.getInt("ask_comm_no"));
				comm.setCommContent(rs.getString("comm_content"));
				comm.setCommDate(rs.getDate("comm_date"));
				
				list.add(comm);
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
