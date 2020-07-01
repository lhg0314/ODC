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
import main.dao.face.NewClassDao;

public class NewClassDaoImpl implements NewClassDao {

	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public List<Map<String, Object>> newclass() {
		
		
		String sql = "";
		sql += "SELECT c.class_no, c.class_name, c.location, c.category, f.class_rename_filename"; 
		sql += " FROM classinfo c JOIN classFile f";
		sql += " ON c.post_status=1 AND c.class_no = f.class_no AND f.class_rename_filename LIKE 'main%'";
		sql += " ORDER BY post_date DESC, class_no DESC";
		
		conn = JDBCTemplate.getConnection();
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classno", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("location", rs.getInt("location"));
				map.put("category", rs.getInt("category"));
				map.put("filename", rs.getString("class_rename_filename"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}


	
	@Override
	public List<Map<String, Object>> hotclass() {
		
		String sql = "";

		sql += "SELECT ";
		sql += " CI.class_no, CI.class_name, CI.category, CI.location";
		sql += " , CF.class_file_no, CF.class_rename_filename";
		sql += " FROM classinfo CI, classFile CF";
		sql += " WHERE CI.post_status = 1";
		sql += " 	AND CI.class_no = CF.class_no";
		sql += " 	AND class_rename_filename LIKE 'main%'";
		sql += " 	ORDER BY (";
		sql += " 		SELECT SUM(CB.booking_count)";
		sql += " 		FROM classbooking CB";
		sql += " 		WHERE CF.class_no = CB.class_no";
		sql += " 	) DESC NULLS LAST";
		
		conn = JDBCTemplate.getConnection();
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classno", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("location", rs.getInt("location"));
				map.put("category", rs.getInt("category"));
				map.put("filename", rs.getString("class_rename_filename"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}



	@Override
	public List<Map<String, Object>> hotClassBySelectedCate(int category) {
		
		String sql = "";

		sql += "SELECT ";
		sql += " CI.class_no, CI.class_name, CI.category, CI.location";
		sql += " , CF.class_file_no, CF.class_rename_filename";
		sql += " FROM classinfo CI, classFile CF";
		sql += " WHERE CI.post_status = 1";
		
		if( category > 0) {
		sql += " AND CI.category = ?";
		}
		
		sql += " AND CI.class_no = CF.class_no";
		sql += " AND class_rename_filename LIKE 'main%'";
		sql += " ORDER BY (";
		sql += " 	SELECT SUM(CB.booking_count)";
		sql += " 	FROM classbooking CB";
		sql += " 	WHERE CF.class_no = CB.class_no";
		sql += " ) DESC NULLS LAST";

		
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
				
				map.put("classno", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
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
	public List<Map<String, Object>> newClassBySelectedCate(int category) {
		
		String sql = "";
		
		sql += "SELECT c.class_no, c.class_name, c.location, c.category, f.class_rename_filename"; 
		sql += " FROM classinfo c JOIN classFile f";
		sql += " ON c.post_status=1 AND c.class_no = f.class_no AND f.class_rename_filename LIKE 'main%'";
		
		if( category > 0) {
			sql += " AND c.category = ?";
		}
		
		sql += " ORDER BY post_date DESC, class_no DESC";
		
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
				
				map.put("classno", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
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
	public int selectCntAllHot(int category) {
		
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
		
		conn = JDBCTemplate.getConnection();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			if(category > 0 ) {
				
				ps.setInt(1, category);
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				cnt = rs.getInt(1);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		//최종 결과 반환
		return cnt;
	}

}
