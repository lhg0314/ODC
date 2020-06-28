package user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dbutil.JDBCTemplate;
import user.dao.face.ReviewBoardDao;
import util.Pagingphoto;

public class ReviewBoardDaoImpl implements ReviewBoardDao{

	//OJDBC 
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int reviewboardCntAll() {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from reviewboard RB";
		sql += " LEFT OUTER JOIN reviewfile RF";
		sql += " ON RB.review_no= RF.review_no";
		sql += " WHERE RF.review_file_no IS NOT NULL";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return totalCount;
	}
	
	@Override
	public ArrayList<Map<String, Object>> reviewboard(Pagingphoto paging) {
		conn = JDBCTemplate.getConnection();//디비 연결
		String sql = "";
		
		sql += "select * from (";
		sql += "	    select rownum rnum, r.* from(";
		sql += "		select ";
		sql += " 			UI.user_id, UI.user_nick, ";
		sql += " 			AI.art_id, AI.art_nick,";
		sql += " 			CI.class_name,";
		sql += " 			RB.review_no, RB.review_date, RB.sat_level, RB.review_title, RB.review_content,";
		sql += " 			RF.review_rename";
		sql += " 			from reviewboard RB";
		sql += " 			LEFT OUTER JOIN reviewfile RF";
		sql += " 				ON RB.review_no= RF.review_no";
		sql += " 			LEFT OUTER JOIN userinfo UI";
		sql += " 				ON RB.user_no = UI.user_no";
		sql += " 			LEFT OUTER JOIN classinfo CI";
		sql += " 				ON RB.class_no = CI.class_no";
		sql += " 			LEFT OUTER JOIN artistinfo AI";
		sql += " 				ON CI.art_no = AI.art_no";
		sql += "  				WHERE RF.review_file_no IS NOT NULL";
		sql += " 				ORDER BY RB.review_no DESC";
		sql += "	     ) r";
		sql += " ) reviewboard ";
		sql += " where rnum BETWEEN ? AND ?";

		
		ArrayList<Map<String, Object>> reviewboard = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNO());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("userid",rs.getString("user_id"));
				map.put("usernick",rs.getString("user_nick"));
				
				map.put("artid",rs.getString("art_id"));
				map.put("artnick",rs.getString("art_nick"));
				
				map.put("classname",rs.getString("class_name"));

				map.put("reviewno",rs.getInt("review_no"));
				map.put("reviewdate",rs.getDate("review_date"));
				map.put("satlevel",rs.getString("sat_level"));
				map.put("reviewtitle",rs.getString("review_title"));
				map.put("reviewcontent",rs.getString("review_content"));
				
				map.put("reviewrename",rs.getString("review_rename"));
				
				reviewboard.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return reviewboard;
	}
	
	@Override
	public int reviewboardcontentCntAll() {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from reviewboard RB";
		sql += " LEFT OUTER JOIN reviewfile RF";
		sql += " ON RB.review_no= RF.review_no";
		sql += " WHERE RF.review_file_no IS NULL";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return totalCount;
	}
	
	@Override
	public ArrayList<Map<String, Object>> reviewboardcontent(Pagingphoto paging) {
		conn = JDBCTemplate.getConnection();//디비 연결
		String sql = "";
		
		sql += "select * from (";
		sql += "	    select rownum rnum, r.* from(";
		sql += "		select ";
		sql += " 			UI.user_id, UI.user_nick, ";
		sql += " 			AI.art_id, AI.art_nick,";
		sql += " 			CI.class_name,";
		sql += " 			RB.review_no, RB.review_date, RB.sat_level, RB.review_title, RB.review_content,";
		sql += " 			RF.review_rename";
		sql += " 			from reviewboard RB";
		sql += " 			LEFT OUTER JOIN reviewfile RF";
		sql += " 				ON RB.review_no= RF.review_no";
		sql += " 			LEFT OUTER JOIN userinfo UI";
		sql += " 				ON RB.user_no = UI.user_no";
		sql += " 			LEFT OUTER JOIN classinfo CI";
		sql += " 				ON RB.class_no = CI.class_no";
		sql += " 			LEFT OUTER JOIN artistinfo AI";
		sql += " 				ON CI.art_no = AI.art_no";
		sql += "  				WHERE RF.review_file_no IS NULL";
		sql += " 				ORDER BY RB.review_no DESC";
		sql += "	     ) r";
		sql += " ) reviewboard ";
		sql += " where rnum BETWEEN ? AND ?";

		
		ArrayList<Map<String, Object>> reviewboardcontent = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNO());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("userid",rs.getString("user_id"));
				map.put("usernick",rs.getString("user_nick"));
				
				map.put("artid",rs.getString("art_id"));
				map.put("artnick",rs.getString("art_nick"));
				
				map.put("classname",rs.getString("class_name"));

				map.put("reviewno",rs.getInt("review_no"));
				map.put("reviewdate",rs.getDate("review_date"));
				map.put("satlevel",rs.getString("sat_level"));
				map.put("reviewtitle",rs.getString("review_title"));
				map.put("reviewcontent",rs.getString("review_content"));
				
				reviewboardcontent.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return reviewboardcontent;
	}
	
	@Override
	public int reviewboardsearchphoCntAll(String classname) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from reviewboard RB";
		sql += " LEFT OUTER JOIN reviewfile RF";
		sql += " ON RB.review_no= RF.review_no";
		sql += " LEFT OUTER JOIN classinfo CI";
		sql += " ON rb.class_no = CI.class_no";
		sql += " WHERE RF.review_file_no IS NOT NULL";
		sql += " AND class_name = ?";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, classname);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return totalCount;
	}
	
	@Override
	public ArrayList<Map<String, Object>> searchreviewboardpho(Pagingphoto paging, String classname) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, r.* from(";
		sql += "		select ";
		sql += " 			UI.user_id, UI.user_nick, ";
		sql += " 			AI.art_id, AI.art_nick,";
		sql += " 			CI.class_name,";
		sql += " 			RB.review_no, RB.review_date, RB.sat_level, RB.review_title, RB.review_content,";
		sql += " 			RF.review_rename";
		sql += " 			from reviewboard RB";
		sql += " 			LEFT OUTER JOIN reviewfile RF";
		sql += " 				ON RB.review_no= RF.review_no";
		sql += " 			LEFT OUTER JOIN userinfo UI";
		sql += " 				ON RB.user_no = UI.user_no";
		sql += " 			LEFT OUTER JOIN classinfo CI";
		sql += " 				ON RB.class_no = CI.class_no";
		sql += " 			LEFT OUTER JOIN artistinfo AI";
		sql += " 				ON CI.art_no = AI.art_no";
		sql += "  				WHERE RF.review_file_no IS NOT NULL";
		sql += " 				AND class_name = ?";
		sql += " 				ORDER BY RB.review_no DESC";
		sql += "	     ) r";
		sql += " ) reviewboard ";
		sql += " where rnum BETWEEN ? AND ?";

		
		ArrayList<Map<String, Object>> searchreviewboardpho = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, classname);
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("userid",rs.getString("user_id"));
				map.put("usernick",rs.getString("user_nick"));
				
				map.put("artid",rs.getString("art_id"));
				map.put("artnick",rs.getString("art_nick"));
				
				map.put("classname",rs.getString("class_name"));

				map.put("reviewno",rs.getInt("review_no"));
				map.put("reviewdate",rs.getDate("review_date"));
				map.put("satlevel",rs.getString("sat_level"));
				map.put("reviewtitle",rs.getString("review_title"));
				map.put("reviewcontent",rs.getString("review_content"));
				
				map.put("reviewrename",rs.getString("review_rename"));
				
				searchreviewboardpho.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return searchreviewboardpho;
	}
	
	@Override
	public int reviewboardsearchcontCntAll(String classname) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from reviewboard RB";
		sql += " LEFT OUTER JOIN reviewfile RF";
		sql += " ON RB.review_no= RF.review_no";
		sql += " LEFT OUTER JOIN classinfo CI";
		sql += " ON rb.class_no = CI.class_no";
		sql += " WHERE RF.review_file_no IS NULL";
		sql += " AND class_name = ?";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, classname);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return totalCount;
	}
	
	@Override
	public ArrayList<Map<String, Object>> searchreviewboardcont(Pagingphoto paging, String classname) {
		conn = JDBCTemplate.getConnection();//디비 연결
		String sql = "";
		
		sql += "select * from (";
		sql += "	    select rownum rnum, r.* from(";
		sql += "		select ";
		sql += " 			UI.user_id, UI.user_nick, ";
		sql += " 			AI.art_id, AI.art_nick,";
		sql += " 			CI.class_name,";
		sql += " 			RB.review_no, RB.review_date, RB.sat_level, RB.review_title, RB.review_content,";
		sql += " 			RF.review_rename";
		sql += " 			from reviewboard RB";
		sql += " 			LEFT OUTER JOIN reviewfile RF";
		sql += " 				ON RB.review_no= RF.review_no";
		sql += " 			LEFT OUTER JOIN userinfo UI";
		sql += " 				ON RB.user_no = UI.user_no";
		sql += " 			LEFT OUTER JOIN classinfo CI";
		sql += " 				ON RB.class_no = CI.class_no";
		sql += " 			LEFT OUTER JOIN artistinfo AI";
		sql += " 				ON CI.art_no = AI.art_no";
		sql += "  				WHERE RF.review_file_no IS NULL";
		sql += " 				AND class_name = ?";
		sql += " 				ORDER BY RB.review_no DESC";
		sql += "	     ) r";
		sql += " ) reviewboard ";
		sql += " where rnum BETWEEN ? AND ?";

		
		ArrayList<Map<String, Object>> reviewboardcontent = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, classname);
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("userid",rs.getString("user_id"));
				map.put("usernick",rs.getString("user_nick"));
				
				map.put("artid",rs.getString("art_id"));
				map.put("artnick",rs.getString("art_nick"));
				
				map.put("classname",rs.getString("class_name"));

				map.put("reviewno",rs.getInt("review_no"));
				map.put("reviewdate",rs.getDate("review_date"));
				map.put("satlevel",rs.getString("sat_level"));
				map.put("reviewtitle",rs.getString("review_title"));
				map.put("reviewcontent",rs.getString("review_content"));
				
				reviewboardcontent.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return reviewboardcontent;
	}
}
