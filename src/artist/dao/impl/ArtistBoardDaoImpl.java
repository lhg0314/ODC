package artist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import artist.dao.face.ArtistBoardDao;
import dbutil.JDBCTemplate;
import util.Paging;

public class ArtistBoardDaoImpl implements ArtistBoardDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;


	@Override
	public int selectArtNoByArtId(String artid) {
		conn = JDBCTemplate.getConnection();
		
		int artno = -1;
		
		String sql = "";
		sql += "select art_no from artistinfo where art_id = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, artid);
			
			rs = ps.executeQuery();
			rs.next();
			
			artno = rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return artno;
	}
	
	@Override
	public int selectCntReviewByArtNo(String search, int artno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from reviewboard r";
		sql += "	inner join userinfo u on (r.user_no = u.user_no)";
		sql += "	inner join classinfo c on (r.class_no = c.class_no)";
		sql += "	where c.art_no = ? and c.class_name like '%'||?||'%'";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, artno);
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
	public List<Map<String, Object>> selectReviewByArtNo(Paging paging, int artno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select r.review_no, r.class_no, r.review_date, r.sat_level, r.review_title, u.user_id, c.class_name from reviewboard r";
		sql += "	inner join userinfo u on (r.user_no = u.user_no)";
		sql += "	inner join classinfo c on (r.class_no = c.class_no)";
		sql += "	where c.art_no = ? and c.class_name like '%'||?||'%' order by r.review_no desc";
		sql += "	) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, artno);
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
	public int selectCntAskByArtNo(String search, int artno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from askboard a";
		sql += "	inner join userinfo u on (a.user_no = u.user_no)";
		sql += "	inner join classinfo c on (a.class_no = c.class_no)";
		sql += "	where a.art_no = ? and c.class_name like '%'||?||'%'";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, artno);
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
	public List<Map<String, Object>> selectAskByArtNo(Paging paging, int artno) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select a.ask_board_no, u.user_id, c.class_name, c.class_no, ask_title, ask_date, nvl2(cmcnt.cnt, cmcnt.cnt, 0) commcnt from askboard a";
		sql += "	inner join userinfo u on (a.user_no = u.user_no)";
		sql += "	inner join classinfo c on (a.class_no = c.class_no)";
		sql += "	left outer join (select count(*) cnt, ask_board_no from askboardcomm group by ask_board_no) cmcnt";
		sql += "	on (cmcnt.ask_board_no = a.ask_board_no)";
		sql += "	where c.art_no = ? and c.class_name like '%'||?||'%' order by a.ask_board_no desc";
		sql += "	) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, artno);
			ps.setString(2, paging.getSearch());
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("askNo", rs.getInt("ask_board_no"));
				map.put("classNo", rs.getInt("class_no"));
				map.put("userId", rs.getString("user_id"));
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

}
