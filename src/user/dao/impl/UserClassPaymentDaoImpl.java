package user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dbutil.JDBCTemplate;
import dto.ClassBooking;
import dto.UserInfo;
import user.dao.face.UserClassPaymentDao;

public class UserClassPaymentDaoImpl implements UserClassPaymentDao{
	
	//ojdbc 관련객체
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs =null;
	
	@Override
	public UserInfo userinfo(String userid) {
		
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select ";
		sql += " user_name, user_phone, user_email";
		sql += " from userinfo";
		sql += " where user_id = ?";
		
		UserInfo userinfo = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			while(rs.next()) {

				userinfo = new UserInfo();
				
				userinfo.setUsername(rs.getString("user_name"));
				userinfo.setUserphone(rs.getLong("user_phone"));
				userinfo.setUseremail(rs.getString("user_email"));

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return userinfo;
	}
	
	@Override
	public Map<String, Object> classpayment(ClassBooking userclasspayment, UserInfo userinfo) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select ";
		sql += " cf.class_rename_filename,";
		sql += " ci.class_name,";
		sql += " ai.art_id, ai.art_addr";
		sql += " from artistinfo ai,classinfo ci,classfile cf";
		sql += " where ci.class_no = cf.class_no";
		sql += " and ci.art_no = ai.art_no";
		sql += " and cf.class_rename_filename LIKE 'main%'";
		sql += " and ci.class_no =  ?";
		
		Map<String, Object> classpayment = new HashMap<String,Object>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userclasspayment.getClassno());
			rs = ps.executeQuery();
			
			while(rs.next()) {

				classpayment.put("classno", userclasspayment.getClassno());
				classpayment.put("username",userinfo.getUsername());
				classpayment.put("userphone",userinfo.getUserphone());
				classpayment.put("useremail",userinfo.getUseremail());
				classpayment.put("classrenamefilename",rs.getString("class_rename_filename"));
				classpayment.put("classname",rs.getString("class_name"));
				classpayment.put("artid",rs.getString("art_id"));
				classpayment.put("artaddr",rs.getString("art_addr"));
				
				//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
		         // -> java.sql.Date(long millis)생성자를 이용한다
		         java.sql.Date d = new java.sql.Date(userclasspayment.getBookingDate().getTime());
				classpayment.put("wishdate",d);
				
				classpayment.put("wishcount",userclasspayment.getBookingCount());
				classpayment.put("wishtotalprice",userclasspayment.getTotalPrice());

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return classpayment;
	}
	

}
