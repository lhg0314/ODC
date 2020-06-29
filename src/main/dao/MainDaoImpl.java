package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbutil.JDBCTemplate;
import util.Paging;

public class MainDaoImpl implements MainDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntClassBySearch(String search) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from classinfo c left outer join classfile f on (c.class_no = f.class_no)";
		sql += "where class_name like '%'||?||'%' and post_status = 1 and f.class_rename_filename like 'main%' order by post_date desc, c.class_no desc";
		
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
	public List<Map<String, Object>> selectClassBySearch(Paging paging) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select c.class_no, c.class_name, c.location, c.category, f.class_rename_filename from classinfo c";
		sql += "	left outer join classfile f on (c.class_no = f.class_no)";
<<<<<<< HEAD
		sql += "	where class_name like '%'||?||'%' and c.post_status = 1 and f.class_rename_filename like 'main%' order by post_date desc, class_no desc";
=======
		sql += "	where class_name like '%'||?||'%' and c.post_status = 1 AND f.class_rename_filename LIKE 'main%' order by post_date desc, class_no desc";
>>>>>>> inju21
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

				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("location", rs.getInt("location"));
				map.put("category", rs.getInt("category"));
				map.put("filename", rs.getString("class_rename_filename"));
				
				
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
	public int selectCntClassBySearch(String search, int cate) {	
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from classinfo c left outer join classfile f on (c.class_no = f.class_no)";
		sql += "where class_name like '%'||?||'%' and c.category = ? and post_status = 1 order by post_date desc, c.class_no desc";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);
			ps.setInt(2, cate);
			
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
	public List<Map<String, Object>> selectClassBySearch(Paging paging, int cate) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select c.class_no, c.class_name, c.location, c.category, f.class_rename_filename from classinfo c";
		sql += "	left outer join classfile f on (c.class_no = f.class_no)";
		sql += "	where class_name like '%'||?||'%' and c.category = ? and c.post_status = 1 order by post_date desc, class_no desc";
		sql += "	) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, paging.getSearch());
			ps.setInt(2, cate);
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("location", rs.getInt("location"));
				map.put("category", rs.getInt("category"));
				map.put("filename", rs.getString	("class_rename_filename"));
				
				
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
