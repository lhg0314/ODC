package user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.JDBCTemplate;
import dto.UserInfo;
import user.dao.face.UserLeaveDao;

public class UserLeaveDaoImpl implements UserLeaveDao {

	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public int pwcheck(UserInfo uinfo) {
		
		String sql = "";
		
		sql += "SELECT count(*) FROM userinfo";
		sql += " WHERE user_id = ? AND user_pw = ?";
		
		
		conn = JDBCTemplate.getConnection();
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, uinfo.getUserid());
			ps.setString(2, uinfo.getUserpw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				cnt = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}


	
	@Override
	public void leave(UserInfo uinfo) {
		
		String sql = "";
		sql += "update userinfo"; 
		sql += " SET user_id=null, user_pw=null, user_name=null,";
		sql += " user_phone=null, user_email=null, user_birth=null,";
		sql += " user_nick=null, user_grade=null";
		sql += " WHERE user_id=?";

		conn = JDBCTemplate.getConnection();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, uinfo.getUserid());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
	}

}
