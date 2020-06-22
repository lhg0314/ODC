package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dao.face.UserManageDao;
import dbutil.JDBCTemplate;
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



}