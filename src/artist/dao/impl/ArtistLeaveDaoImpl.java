package artist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import artist.dao.face.ArtistLeaveDao;
import dbutil.JDBCTemplate;
import dto.ArtistInfo;

public class ArtistLeaveDaoImpl implements ArtistLeaveDao {

	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	
	@Override
	public int pwcheck(ArtistInfo ainfo) {
		
		String sql = "";
		
		sql += "SELECT count(*) FROM artistinfo";
		sql += " WHERE art_id = ? AND art_pw = ?";
		
		
		conn = JDBCTemplate.getConnection();
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, ainfo.getArtid());
			ps.setString(2, ainfo.getArtpw());
			
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
	public void leave(ArtistInfo ainfo) {
		
		String sql = "";
		sql += "UPDATE artistinfo"; 
		sql += " SET art_id=null, art_pw=null, art_name=null,";
		sql += " art_phone=null, art_email=null, art_birth=null,";
		sql += " art_nick=null, art_code=null, art_tel=null,";
		sql += " art_addr=null, art_content=null";
		sql += " WHERE art_id=?";

		conn = JDBCTemplate.getConnection();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, ainfo.getArtid());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
	}



	@Override
	public int classcheck(ArtistInfo ainfo) {
		
		String sql = "";
		
		sql += "SELECT count(*) FROM classinfo";
		sql += " WHERE art_no = ? AND post_status = 1";
		
		conn = JDBCTemplate.getConnection();
		
		int cnt = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ainfo.getArtno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				cnt = rs.getInt(1);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return cnt;
	}

}
