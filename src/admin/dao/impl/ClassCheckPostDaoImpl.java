package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.dao.face.ClassCheckPostDao;
import dbutil.JDBCTemplate;
import dto.ClassFile;
import dto.ClassInfo;
import util.Paging;

public class ClassCheckPostDaoImpl implements ClassCheckPostDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<Map<String, Object>> selectAllClass(Paging paging) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "			c.class_no, c.location, c.class_name, c.category, c.post_date, c.class_check, c.post_status, a.art_id  FROM classinfo c";
		sql += " 		INNER JOIN artistinfo a";
		sql += " 		on (c.art_no = a.art_no)";
		sql += "		WHERE c.class_check = 1";
		sql += "		AND c. class_name LIKE '%'||?||'%'"; 
		sql += " 		ORDER BY class_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) t";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("postDate",rs.getDate("post_date"));
				map.put("postStatus",rs.getInt("post_status"));
				map.put("classCheck",rs.getInt("class_check"));
				map.put("artId",rs.getString("art_id"));
				
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
	public int selectCntAll(String search) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM classinfo";
		sql += " WHERE class_check = 1";
		sql += " AND class_name LIKE '%'||?||'%'";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, search);
			
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
	public List<Map<String, Object>> selectAllClassCheck(Paging paging) {
		
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, B.* FROM (";
		sql += "        SELECT";
		sql += "			c.class_no, c.class_name, c.location, c.category, c.post_date, c.class_check, a.art_id  FROM classinfo c";
		sql += " 		INNER JOIN artistinfo a";
		sql += " 		on (c.art_no = a.art_no)";
		sql += "		WHERE c.class_check <> 1";
		sql += "		AND c. class_name LIKE '%'||?||'%'"; 
		sql += " 		ORDER BY class_no DESC";
		sql += "    ) B";
		sql += "    ORDER BY rnum";
		sql += " ) t";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("postDate",rs.getDate("post_date"));
				map.put("classCheck",rs.getInt("class_check"));
				map.put("artId",rs.getString("art_id"));
				
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
	public int selectCntclassCheck(String search) {
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM classinfo";
		sql += " WHERE class_check <> 1";
		sql += " AND class_name LIKE '%'||?||'%'";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, search);
			
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
	public Map<String, Object> selectClassByClassNo(int classno) {
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT * ";
		sql += " FROM classinfo c";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " on (c.class_no = f.class_no)";
		sql += " WHERE c.class_no = ?";
		sql += " AND class_rename_filename LIKE 'main%'";

		//최종 결과 변수
		Map<String, Object> map = null;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classno);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
//			System.out.println(rs.next());
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				
				map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("classPrice", rs.getInt("class_price"));
				map.put("talentDonation",rs.getInt("talent_donation"));
				map.put("postDate",rs.getDate("post_date"));
				map.put("recruitStartdate",rs.getDate("recruit_startdate"));
				map.put("recruitEnddate",rs.getDate("recruit_enddate"));
				map.put("maxPeople",rs.getInt("max_people"));
				map.put("minPeople",rs.getInt("min_people"));
				map.put("classStartdate",rs.getDate("class_startdate"));
				map.put("classEnddate",rs.getDate("class_enddate"));
				map.put("classContent",rs.getString("class_content"));
				map.put("postStatus",rs.getInt("post_Status"));
				map.put("classCheck",rs.getInt("class_check"));
	
				map.put("classFileNo", rs.getInt("class_file_no"));
				map.put("classOriginFilename", rs.getString("class_origin_filename"));
				map.put("classRenameFilename", rs.getString("class_rename_filename"));
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
		return map;
	}

	@Override
	public void updatePostStatus(ClassInfo classInfo) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "UPDATE classinfo ";
		sql += " SET post_status = ?, class_check = 1";
		sql += " WHERE class_no = ?";
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classInfo.getPostStatus());
			ps.setInt(2, classInfo.getClassno());
			
			//SQL 수행 및 결과 저장
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateClassCheck(ClassInfo classInfo) {
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "UPDATE classinfo ";
		sql += " SET class_check = ?";
		sql += " WHERE class_no = ?";
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classInfo.getClassCheck());
			ps.setInt(2, classInfo.getClassno());
			
			//SQL 수행 및 결과 저장
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public int selectCntBookingClass(int classno) {
		
	conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM classbooking b";
		sql += " LEFT OUTER JOIN classinfo c";
		sql += " ON (b.class_no = c.class_no)";
		sql += " WHERE b.class_no = ?";
		sql += " ORDER BY b.booking_no DESC";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			ps.setInt(1, classno);
			
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
	public List<Map<String, Object>> selectClassBookingByClassNo(Paging paging, int classno) {
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, X.* FROM (";
		sql += "        SELECT";
		sql += "			c.class_name, b.booking_no, b.booking_date, b.booking_count ,b.payment_date, b.total_price, u.user_id";
		sql += " 		FROM classbooking b";
		sql += " 		LEFT OUTER JOIN classinfo c";
		sql += " 		ON (b.class_no = c.class_no)";
		sql += " 		INNER JOIN userinfo u";
		sql += "		ON (u.user_no = b.user_no)";
		sql += "		WHERE b.class_no = ?"; 
		sql += " 		ORDER BY b.booking_no DESC";
		sql += "    ) X";
		sql += "    ORDER BY rnum";
		sql += " ) t";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classno);
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("className", rs.getString("class_name"));
				map.put("bookingNo", rs.getInt("booking_no"));
				map.put("bookingDate", rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("totalPrice",rs.getInt("total_price"));
				map.put("userId",rs.getString("user_id"));
				
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
	public int selectCntClassReview(int classno) {
	conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT count(*)";
		sql += " FROM reviewboard r";
		sql += " LEFT OUTER JOIN classinfo c";
		sql += " ON (r.class_no = c.class_no)";
		sql += " WHERE r.class_no = ?";

		//최종 결과 변수
		int cnt = 0;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classno);
			
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
	public List<Map<String, Object>> selectClassReviewByClassNo(Paging paging, int classno) {
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, X.* FROM (";
		sql += "        SELECT r.class_no, r.review_no, r.review_content, r.review_date, r.sat_level, u.user_id";
		sql += " 		FROM reviewboard r";
		sql += " 		INNER JOIN classinfo c";
		sql += " 		ON (r.class_no = c.class_no)";
		sql += " 		INNER JOIN userinfo u";
		sql += "		ON (r.user_no = u.user_no)";
		sql += "		WHERE r.class_no = ?"; 
		sql += " 		ORDER BY r.review_no DESC";
		sql += "    ) X";
		sql += "    ORDER BY rnum";
		sql += " ) t";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classno);
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("reviewNo", rs.getInt("review_no"));
				map.put("reviewContent", rs.getString("review_content"));
				map.put("reviewDate", rs.getDate("review_date"));
				map.put("satLevel",rs.getString("sat_level"));
				map.put("userId",rs.getString("user_id"));
				
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
