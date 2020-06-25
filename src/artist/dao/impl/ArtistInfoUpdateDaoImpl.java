package artist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import artist.dao.face.ArtistInfoUpdateDao;
import dbutil.JDBCTemplate;
import dto.ArtistDetail;
import dto.ArtistFile;
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
				 ainfo.setArtContent(rs.getString("art_content"));
				 System.out.println("test"+ainfo);
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
	public void artInfoUpdate(ArtistInfo ainfo) {
		
		String sql = "";
		sql += "UPDATE artistinfo";
		sql += " SET art_name=?, art_pw=?,";
		sql += " art_phone=?, art_tel=?, art_nick=?,";
		sql += " art_addr=?, art_birth=?";
		sql += " WHERE art_id=?";
		
			
		conn = JDBCTemplate.getConnection();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, ainfo.getArtName());
			ps.setString(2, ainfo.getArtpw());
			ps.setLong(3, ainfo.getArtPhone());
			ps.setLong(4, ainfo.getArtTel());
			ps.setString(5, ainfo.getArtNick());
			ps.setString(6, ainfo.getArtAddr());
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(ainfo.getArtBirth().getTime());
			ps.setDate(7, d); 
			ps.setString(8, ainfo.getArtid());
			
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		
	}


}
