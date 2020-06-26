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

}
