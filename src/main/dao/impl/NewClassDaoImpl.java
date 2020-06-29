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
		sql += " ON c.post_status=1 AND c.class_no = f.class_no";
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
		sql += "SELECT c.class_no, c.class_name, c.location, c.category,";
		sql += " f.class_rename_filename"; 
		sql += " FROM classinfo c, classFile f, classbooking b";
		sql += " WHERE c.post_status=1 AND c.class_no = f.class_no AND c.class_no = b.class_no";
		sql += " GROUP BY c.class_no, f.class_rename_filename, c.class_name, c.location, c.category "; 
		sql += " ORDER BY sum(b.booking_count) DESC, class_no";
		
		//classfile 없이 테스트 -> 정상 확인
//		sql += "SELECT c.class_no, c.class_name, c.location, c.category";
//		sql += " FROM classinfo c, classbooking b";
//		sql += " WHERE c.post_status=1 AND c.class_no = b.class_no";
//		sql += " GROUP BY c.class_no, c.class_name, c.location, c.category "; 
//		sql += " ORDER BY sum(b.booking_count) DESC, class_no";
		
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

}
