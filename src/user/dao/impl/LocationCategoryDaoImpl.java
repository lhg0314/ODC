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
import dto.ClassInfo;
import user.dao.face.LocationCategoryDao;

public class LocationCategoryDaoImpl implements LocationCategoryDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<Map<String, Object>> selectClassByLocation(int location) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM classinfo i";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " ON( i.class_no = f.class_no )";
		sql += " WHERE i.post_status = 1";
		sql += " AND i.recruit_enddate >= sysdate";
		sql += " AND f.class_rename_filename LIKE 'main%'";
		if( location > 0) {
			sql += " AND i.location = ?";
		}
		sql += " ORDER BY i.class_no DESC";
		
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			if( location > 0) {
				ps.setInt(1, location);
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
	public List<Map<String, Object>> selectClassByCategory(int category) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * FROM classinfo i";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " ON( i.class_no = f.class_no )";
		sql += " WHERE i.post_status = 1";
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

}
