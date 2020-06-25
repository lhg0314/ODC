package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.JDBCTemplate;
import dto.UserInfo;

public class UserInfoUpdateDaoImpl implements UserInfoUpdateDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public UserInfo userInfoLoad(UserInfo u) {
		
		String sql = "";
		sql += "SELECT * FROM userinfo WHERE user_id = ?";
		
		
		conn = JDBCTemplate.getConnection();
		
		UserInfo uinfo = null;
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUserid());
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				 uinfo = new UserInfo();
				 
				 uinfo.setUserno(rs.getInt("user_no"));
				 uinfo.setUserid(rs.getString("user_id"));
				 uinfo.setUserpw(rs.getString("user_pw"));
				 uinfo.setUsername(rs.getString("user_name"));
				 uinfo.setUsernick(rs.getString("user_nick"));
				 uinfo.setUserphone(rs.getLong("user_phone"));
				 uinfo.setUserbirth(rs.getDate("user_birth"));
				 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return uinfo;
	}


	@Override
	public void userInfoUpdate(UserInfo uinfo) {
		
		String sql = "";
		sql += "UPDATE userinfo";
		sql += " SET user_name=?, user_pw=?,";
		sql += " user_phone=?, user_birth=?, user_nick=?";
		sql += " WHERE user_id=?";
			
		conn = JDBCTemplate.getConnection();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, uinfo.getUsername());
			ps.setString(2, uinfo.getUserpw());
			ps.setLong(3, uinfo.getUserphone());
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(uinfo.getUserbirth().getTime());
			ps.setDate(4, d); 
			
			ps.setString(5, uinfo.getUsernick());
			ps.setString(6, uinfo.getUserid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		

		
	}

}
