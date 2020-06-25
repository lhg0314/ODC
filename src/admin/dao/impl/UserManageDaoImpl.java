package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.dao.face.UserManageDao;
import dbutil.JDBCTemplate;
import dto.AskBoard;
import dto.ClassBooking;
import dto.ReviewBoard;
import dto.UserInfo;
import util.Paging;

/* 
 * 200620 이서연
 */

public class UserManageDaoImpl implements UserManageDao{

	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	
	@Override
	public int selectCntAllUser(String search) {
		
		String sql = "";
		sql += "SELECT count(*) FROM userinfo";
		sql += " WHERE user_id LIKE '%'||?||'%'";
				
		
		conn = JDBCTemplate.getConnection();
		
		int totalCount = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);
			
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				totalCount = rs.getInt(1);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return totalCount;
	}


	@Override
	public List<UserInfo> selectAllUser(Paging paging) {
		
		conn = JDBCTemplate.getConnection();
			
			String sql = "";
			
			sql += "SELECT * FROM(";
			sql += "	SELECT rownum rnum, U.* FROM (";
			sql += " 		SELECT user_no, user_name, user_id, user_email, user_grade, user_nick";
			sql += " 		FROM userinfo";
			sql += "		WHERE user_id LIKE '%'||?||'%'"; 
			sql += " 		ORDER BY user_no DESC";
			sql += " 	)U";
			sql += "    ORDER BY rnum";
			sql += " )";
			sql += " WHERE rnum BETWEEN ? AND ?";
			
			UserInfo userInfo = null;
			
			//결과 저장할 List
			List<UserInfo> userList = new ArrayList<>();
			
			try {
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, paging.getSearch());
				ps.setInt(2, paging.getStartNO());
				ps.setInt(3, paging.getEndNo());
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					userInfo = new UserInfo();
					
					userInfo.setUserno(rs.getInt("user_no"));
					userInfo.setUsername(rs.getString("user_name"));
					userInfo.setUserid(rs.getString("user_id"));
					userInfo.setUseremail(rs.getString("user_email"));
					userInfo.setUsergrade(rs.getInt("user_grade"));
					userInfo.setUsernick(rs.getString("user_nick"));
					
					userList.add(userInfo);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
		
		return userList;
	}


	@Override
	public UserInfo selectByUserno(UserInfo userInfo) {
		
		String sql = "";
		sql += "SELECT * FROM userinfo WHERE user_no = ?";
				
		
		conn = JDBCTemplate.getConnection();
		
		
		UserInfo uinfo = null;
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userInfo.getUserno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				uinfo = new UserInfo();
				
				uinfo.setUserno(rs.getInt("user_no"));
				uinfo.setUserid(rs.getString("user_id"));
				uinfo.setUserpw(rs.getString("user_pw"));
				uinfo.setUsername(rs.getString("user_name"));
				uinfo.setUserphone(rs.getLong("user_phone"));
				uinfo.setUseremail(rs.getString("user_email"));
				uinfo.setUserbirth(rs.getDate("user_birth"));
				uinfo.setUsernick(rs.getString("user_nick"));
				uinfo.setUsergrade(rs.getInt("user_grade"));
				uinfo.setUserEmailAuth(rs.getInt("user_email_auth"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return uinfo;
	}


	@Override
	public List<Map<String, Object>> bookingList(ClassBooking book) {
		
		String sql = "";
		
		sql += "SELECT b.booking_no, b.class_no, c.class_name, b.booking_date, b.payment_date, b.total_price";
		sql += " FROM classbooking b JOIN classinfo c";
		sql += " ON b.user_no = ? AND b.class_no = c.class_no";
		sql += " ORDER BY b.booking_no, b.booking_date, b.class_no";
	
		conn = JDBCTemplate.getConnection();
		
		
		List<Map<String, Object>> list = new ArrayList<>();
		
//		ClassBooking booking = null;
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, book.getUserno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("bookingNo", rs.getInt("booking_no"));
				map.put("classno", rs.getInt("class_no"));
				map.put("classname", rs.getString("class_name"));
				map.put("bookingDate", rs.getDate("booking_date"));
				map.put("paymentDate", rs.getDate("payment_date"));
				map.put("totalPrice", rs.getInt("total_price"));
				
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
	public List<Map<String, Object>> reviewList(ReviewBoard review) {
		
		String sql = "";
		
		sql += "SELECT r.review_no, r.class_no, c.class_name, r.review_content, r.sat_level, r.review_date";
		sql += " FROM reviewboard r JOIN classinfo c";
		sql += " ON user_no = ? AND r.class_no = c.class_no";
		sql += " ORDER BY review_no";
		
		conn = JDBCTemplate.getConnection();
		
		List<Map<String, Object>> list = new ArrayList<>();
		
//		ReviewBoard rb = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, review.getUserno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
//				rb = new ReviewBoard();
//				
//				rb.setReviewno(rs.getInt("review_no"));
//				rb.setClassno(rs.getInt("class_no"));
//				rb.setReviewContent(rs.getString("review_content"));
//				rb.setSat_level(rs.getInt("sat_level"));
//				rb.setReviewDate(rs.getDate("review_date"));
//				
//				list.add(rb);
				
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("reviewno", rs.getInt("review_no"));
				map.put("classno", rs.getInt("class_no"));
				map.put("classname", rs.getString("class_name"));
				map.put("reviewContent", rs.getString("review_content"));
				map.put("sat_level", rs.getInt("sat_level"));
				map.put("reviewDate", rs.getDate("review_date"));
				
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
	public List<AskBoard> askList(AskBoard ask) {
		
		String sql = "";
		
		sql += "SELECT ask_board_no, class_no, ask_content, ask_date";
		sql += " FROM askboard";
		sql += " WHERE user_no = ?";
		sql += " ORDER BY ask_board_no, ask_date";
		
		conn = JDBCTemplate.getConnection();
		
		List<AskBoard> list = new ArrayList<>();
		
		AskBoard ab = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ask.getUserno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ab = new AskBoard();
				
				ab.setAskBoardno(rs.getInt("ask_board_no"));
				ab.setClassno(rs.getInt("class_no"));
				ab.setAskContent(rs.getString("ask_content"));
				ab.setAskDate(rs.getDate("ask_date"));
				
				list.add(ab);
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
