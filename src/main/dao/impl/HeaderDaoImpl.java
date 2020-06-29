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
import main.dao.face.HeaderDao;

public class HeaderDaoImpl implements HeaderDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Map<String, Object>> hotclassTopFive() {
		
		String sql = "";
		sql += "SELECT c.class_name, c.class_no";
		sql += " FROM classinfo c, classbooking b"; 
		sql += " WHERE c.class_no = b.class_no";
		sql += " AND c.post_status=1";
		sql += " GROUP BY c.class_no, c.class_name"; 
		sql += " ORDER BY sum(b.booking_count) DESC, c.class_no";
		
		conn = JDBCTemplate.getConnection();
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			for( int i = 0; i<5;i++) {
				
				if( rs.next()) {

					Map<String, Object> map = new HashMap<>();
					
					map.put("classNo", rs.getInt("class_no"));
					map.put("className", rs.getString("class_name"));
					
					list.add(map);
				}
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
