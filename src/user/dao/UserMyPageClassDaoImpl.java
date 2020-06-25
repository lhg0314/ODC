package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import dbutil.JDBCTemplate;

public class UserMyPageClassDaoImpl implements UserMyPageClassDao{
	
	//ojdbc 관련객체
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs =null;
	
	@Override
	public ArrayList<Map<String, Object>> userbooking(String userid, Date nowday) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select ";
		sql += " class_rename_filename,class_name, art_id, payment_date, booking_date, booking_count, total_price,classbooking.booking_no";
		sql += " from classinfo,artistinfo, userinfo, classbooking,classfile ";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND userinfo.user_no = classbooking.user_no";
		sql += " AND classinfo.class_no = classfile.class_no";
		sql += " AND user_id = ? ";
		sql += " AND booking_date < ? ";
		sql += " order by booking_no desc";
		
		ArrayList<Map<String, Object>> userbooking = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, userid);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowday.getTime());
			ps.setDate(2, d );
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("classrenamefilename",rs.getString("class_rename_filename"));
				map.put("classname",rs.getString("class_name"));
				map.put("artid",rs.getString("art_id"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));
				map.put("bookingno",rs.getInt("booking_no"));

				userbooking.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return userbooking;
	}
	
	@Override
	public int bookingcancel(int bookingno) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "delete from classbooking";
		sql += " where booking_no = ?";
		
		int bookingcancel = 0;
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, bookingno);
			
			bookingcancel = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return bookingcancel;
	}

}
