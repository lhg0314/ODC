package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.dao.face.ArtManageDao;
import dbutil.JDBCTemplate;
import dto.ArtistInfo;
import dto.UserInfo;
import util.Paging;

/* 
 * 200620 이서연
 */

public class ArtManageDaoImpl implements ArtManageDao {


	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	

	@Override
	public int selectCntAllArt(String search) {

		String sql = "";
		sql += "SELECT count(*) FROM artistinfo";
		sql += " WHERE art_id LIKE '%'||?||'%'";		
		
		
		conn = JDBCTemplate.getConnection();
		
		int totalCount = 0;
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);
			
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while(rs.next()) {
				
				totalCount = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return totalCount;
	}
	
	
	
	
	@Override
	public List<ArtistInfo> selectAllArt(Paging paging) {
		
		conn = JDBCTemplate.getConnection();
		
		String sql = "";
		
		sql += "SELECT * FROM(";
		sql += "	SELECT rownum rnum, A.* FROM (";
		sql += " 		SELECT art_no, art_name, art_id, art_email, art_phone, art_nick";
		sql += " 		FROM artistinfo";
		sql += "		WHERE art_id LIKE '%'||?||'%'"; 
		sql += " 		ORDER BY art_no DESC";
		sql += " 	)A";
		sql += "    ORDER BY rnum";
		sql += " )";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		ArtistInfo artistInfo = null;
		
		//결과 저장할 List
		List<ArtistInfo> artistList = new ArrayList<>();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				artistInfo = new ArtistInfo();
				
				artistInfo.setArtno(rs.getInt("art_no"));
				artistInfo.setArtName(rs.getString("art_name"));
				artistInfo.setArtid(rs.getString("art_id"));
				artistInfo.setArtEmail(rs.getString("art_email"));
				artistInfo.setArtPhone(rs.getLong("art_phone"));
				artistInfo.setArtNick(rs.getString("art_nick"));
				
				artistList.add(artistInfo);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	
	return artistList;
	}

}