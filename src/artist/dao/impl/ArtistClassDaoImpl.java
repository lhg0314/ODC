package artist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import artist.dao.face.ArtistClassDao;
import dbutil.JDBCTemplate;
import dto.ArtistInfo;

public class ArtistClassDaoImpl implements ArtistClassDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public ArtistInfo getArtInfoByArtId(String artId) {
		
		//DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM artistinfo";
		sql += " WHERE art_id = ?";
		
		// 결과 객체
		ArtistInfo artInfo = null;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, artId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				artInfo = new ArtistInfo();
				
				artInfo.setArtno(rs.getInt("art_no"));
				artInfo.setArtid(rs.getString("art_id"));
				artInfo.setArtpw(rs.getString("art_pw"));
				artInfo.setArtName(rs.getString("art_nick"));
				artInfo.setArtCode(rs.getInt("art_code"));
				artInfo.setArtPhone(rs.getLong("art_phone"));
				artInfo.setArtTel(rs.getLong("art_tel"));
				artInfo.setArtAddr(rs.getString("art_addr"));
				artInfo.setArtEmail(rs.getString("art_email"));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return artInfo;
	}

}
