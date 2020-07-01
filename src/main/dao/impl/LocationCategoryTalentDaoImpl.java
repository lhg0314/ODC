package main.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbutil.JDBCTemplate;
import main.dao.face.LocationCategoryDao;
import util.Pagingphoto;

public class LocationCategoryTalentDaoImpl implements LocationCategoryDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Map<String, Object>> selectClassByLocation(Pagingphoto paging, int location) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT * FROM classinfo i";
		sql += "		LEFT OUTER JOIN classfile f";
		sql += " 		ON( i.class_no = f.class_no )";
		sql += " 		WHERE i.post_status = 1";
		sql += "		AND i.recruit_enddate >= sysdate";
		sql += "		AND f.class_rename_filename LIKE 'main%'"; 
			if( location > 0) {
				sql += " AND i.location = ?";
			}
		sql += " 		ORDER BY i.class_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) t";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			if( location > 0) {
				ps.setInt(1, location);
				ps.setInt(2, paging.getStartNO());
				ps.setInt(3, paging.getEndNo());
			}else {
				ps.setInt(1, paging.getStartNO());
				ps.setInt(2, paging.getEndNo());
			}

			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("artNo", rs.getInt("art_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("location", rs.getInt("location"));
				map.put("classPrice", rs.getInt("class_price"));
				map.put("filename", rs.getString("class_rename_filename"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if( rs != null ) JDBCTemplate.close(rs);
			if( ps != null ) JDBCTemplate.close(ps);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> selectClassByCategory(Pagingphoto paging, int category) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT * FROM classinfo i";
		sql += "		LEFT OUTER JOIN classfile f";
		sql += " 		ON( i.class_no = f.class_no )";
		sql += " 		WHERE i.post_status = 1";
		sql += "		AND i.recruit_enddate >= sysdate";
		sql += "		AND f.class_rename_filename LIKE 'main%'"; 
			if( category > 0) {
				sql += " AND i.category = ?";
			}
		sql += " 		ORDER BY i.class_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) t";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			if( category > 0) {
				ps.setInt(1, category);
				ps.setInt(2, paging.getStartNO());
				ps.setInt(3, paging.getEndNo());
			}else {
				ps.setInt(1, paging.getStartNO());
				ps.setInt(2, paging.getEndNo());
			}
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("artNo", rs.getInt("art_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("location", rs.getInt("location"));
				map.put("classPrice", rs.getInt("class_price"));
				map.put("filename", rs.getString("class_rename_filename"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if( rs != null ) JDBCTemplate.close(rs);
			if( ps != null ) JDBCTemplate.close(ps);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> selectClassByTalentDonation(int category) {
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM classinfo i";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " ON( i.class_no = f.class_no )";
		sql += " WHERE i.post_status = 1";
		sql += " AND i.talent_donation = 1";
		sql += " AND i.recruit_enddate >= sysdate";
		sql += " AND f.class_rename_filename LIKE 'main%'";
		if( category > 0) {
			sql += " AND i.category = ?";
		}
		sql += " ORDER BY i.class_no DESC";
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			if( category > 0) {
				ps.setInt(1, category);
			}
			
			rs = ps.executeQuery();
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("artNo", rs.getInt("art_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("location", rs.getInt("location"));
				map.put("classPrice", rs.getInt("class_price"));
				map.put("filename", rs.getString("class_rename_filename"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if( rs != null ) JDBCTemplate.close(rs);
			if( ps != null ) JDBCTemplate.close(ps);
		}
		return list;
	}

	@Override
	public int selectCntAllLocation(int location) {
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT count(*) FROM classinfo i";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " ON( i.class_no = f.class_no )";
		sql += " WHERE i.post_status = 1";
		sql += " AND i.recruit_enddate >= sysdate";
		sql += " AND f.class_rename_filename LIKE 'main%'";
		if( location > 0) {
			sql += " AND i.location = ?";
		}
		

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			if(location>0) {
				ps.setInt(1, location);
			}
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}

	@Override
	public int selectCntAllCategory(int category) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT count(*) FROM classinfo i";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " ON( i.class_no = f.class_no )";
		sql += " WHERE i.post_status = 1";
		sql += " AND i.recruit_enddate >= sysdate";
		sql += " AND f.class_rename_filename LIKE 'main%'";
		if( category > 0) {
			sql += " AND i.category = ?";
		}
		
		

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			if(category>0) {
				ps.setInt(1, category);
			}
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}

	@Override
	public int selectCntAllTalent(int category) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT count(*) FROM classinfo i";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " ON( i.class_no = f.class_no )";
		sql += " WHERE i.post_status = 1";
		sql += " AND i.talent_donation = 1";
		sql += " AND i.recruit_enddate >= sysdate";
		sql += " AND f.class_rename_filename LIKE 'main%'";
		if( category > 0) {
			sql += " AND i.category = ?";
		}
		

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			if(category > 0) {
				ps.setInt(1, category);
			}
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
	}

}
