package artist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import artist.dao.face.ArtistInfoUpdateDao;
import dbutil.JDBCTemplate;
import dto.ArtistDetail;
import dto.ArtistInfo;

public class ArtistInfoUpdateDaoImpl implements ArtistInfoUpdateDao {

	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	@Override
	public ArtistInfo artInfoLoad(ArtistInfo a) {
		
		String sql = "";
		sql += "SELECT * FROM artistinfo WHERE art_id = ?";
		
		
		conn = JDBCTemplate.getConnection();
		
		ArtistInfo ainfo = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, a.getArtid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				 ainfo = new ArtistInfo();
				 
				 ainfo.setArtno(rs.getInt("art_no"));
				 ainfo.setArtid(rs.getString("art_id"));
				 ainfo.setArtpw(rs.getString("art_pw"));
				 ainfo.setArtName(rs.getString("art_name"));
				 ainfo.setArtNick(rs.getString("art_nick"));
				 ainfo.setArtCode(rs.getInt("art_code"));
				 ainfo.setArtPhone(rs.getLong("art_phone"));
				 ainfo.setArtEmail(rs.getString("art_email"));
				 ainfo.setArtTel(rs.getLong("art_tel"));
				 ainfo.setArtBirth(rs.getDate("art_birth"));
				 ainfo.setArtAddr(rs.getString("art_addr"));
				 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return ainfo;
	}


	
	
	@Override
	public ArtistDetail artDetailLoad(ArtistDetail ad) {
		
		String sql = "";
		sql += "SELECT art_content FROM artistdetail WHERE art_no = ?";
		
		
		conn = JDBCTemplate.getConnection();
		
		ArtistDetail adetail = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ad.getArtno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				adetail = new ArtistDetail();
				
				adetail.setArtContent(rs.getString("art_content"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return adetail;
	}

}
