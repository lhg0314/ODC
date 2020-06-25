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
import user.dao.face.UserMyPageClassDao;

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
		sql += " merchant_uid,classinfo.class_no,class_rename_filename,class_name, art_id, payment_date, booking_date, booking_count, total_price,classbooking.booking_no";
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

				map.put("merchantuid",rs.getString("merchant_uid"));
				map.put("classno",rs.getInt("class_no"));
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
			
			JDBCTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return bookingcancel;
	}
	
	@Override
	public ArrayList<Map<String, Object>> userwish(String userid) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select ";
		sql += " wish_no,classinfo.class_no,class_rename_filename,class_name,art_id,wish_date, wish_count,wish_total_price";
		sql += " from classinfo,artistinfo, userinfo,classwish,classfile";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classwish.class_no";
		sql += " AND userinfo.user_no = classwish.user_no";
		sql += " AND classinfo.class_no = classfile.class_no";
		sql += " AND user_id = ? ";
		sql += " order by wish_no desc";
		
		ArrayList<Map<String, Object>> userwish = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("wishno",rs.getInt("wish_no"));
				map.put("classno",rs.getInt("class_no"));
				map.put("classrenamefilename",rs.getString("class_rename_filename"));
				map.put("classname",rs.getString("class_name"));
				map.put("artid",rs.getString("art_id"));
				map.put("wishdate",rs.getDate("wish_date"));
				map.put("wishcount",rs.getInt("wish_count"));
				map.put("wishtotalprice",rs.getInt("wish_total_price"));

				userwish.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return userwish;
	}

	@Override
	public void wishcancel(int wishno) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "delete from classwish";
		sql += " where wish_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, wishno);
			ps.executeUpdate();
			
			JDBCTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
	}
	
	@Override
	public Map<String, Object> classpayment(String userid, int wishno) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select";
		sql += " classinfo.class_no,user_name,user_phone,user_email,class_rename_filename,class_name,art_id,art_addr,wish_date,wish_count,wish_total_price";
		sql += " from userinfo,artistinfo,classinfo,classfile,classwish";
		sql += " where classwish.class_no = classinfo.class_no";
		sql += " and classinfo.class_no = classfile.class_no";
		sql += " and classwish.user_no = userinfo.user_no";
		sql += " and classinfo.art_no = artistinfo.art_no";
		sql += " and wish_no = ?";
		sql += " and user_id = ?";
		
		Map<String, Object> classpayment = new HashMap<String,Object>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, wishno);
			ps.setString(2, userid);
			rs = ps.executeQuery();
			
			while(rs.next()) {

				classpayment.put("classno",rs.getInt("class_no"));
				classpayment.put("username",rs.getString("user_name"));
				classpayment.put("userphone",rs.getLong("user_phone"));
				classpayment.put("useremail",rs.getString("user_email"));
				classpayment.put("classrenamefilename",rs.getString("class_rename_filename"));
				classpayment.put("classname",rs.getString("class_name"));
				classpayment.put("artid",rs.getString("art_id"));
				classpayment.put("artaddr",rs.getString("art_addr"));
				classpayment.put("wishdate",rs.getDate("wish_date"));
				classpayment.put("wishcount",rs.getInt("wish_count"));
				classpayment.put("wishtotalprice",rs.getInt("wish_total_price"));

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return classpayment;
		
	}
	
	@Override
	public int userno(String userid) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select user_no from userinfo";
		sql += " where user_id = ?";
		
		//결과 저장할 변수
		int userno = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				userno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return userno;
	}
	
	@Override
	public int classbookingno() {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select ClassBooking_SEQ.nextval from dual";
		
		//결과 저장할 변수
		int classbookingno = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				classbookingno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return classbookingno;
	}
	
	@Override
	public void insertclassbooking(int classbookingno, int userno, Map<String, Object> paymentparam) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "INSERT INTO ClassBooking(booking_no,merchant_uid, class_no, user_no,booking_date, booking_count, total_price) ";
		sql += "VALUES(?,?,?, ?,?, ?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classbookingno);
			ps.setString(2, (String)paymentparam.get("merchantuid"));
			ps.setInt(3, (int) paymentparam.get("classno"));
			ps.setInt(4, userno);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(((Date) paymentparam.get("bookingdate")).getTime());
			ps.setDate(5, d );
			
			ps.setInt(6, (int) paymentparam.get("wishcount"));
			ps.setInt(7, (int) paymentparam.get("totalprice"));
			
			ps.executeUpdate();
			
			JDBCTemplate.commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.rollback(conn);
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
	}
	
}
