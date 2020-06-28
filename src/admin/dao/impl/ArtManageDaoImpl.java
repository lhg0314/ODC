package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.dao.face.ArtManageDao;
import dbutil.JDBCTemplate;
import dto.ArtistDetail;
import dto.ArtistInfo;
import dto.AskBoard;
import dto.ClassInfo;
import dto.ReviewBoard;
import util.Paging;

/* 
 * 200621 이서연
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




	@Override
	public ArtistInfo selectByArtno(ArtistInfo artistInfo) {
		
		String sql = "";
		sql += "SELECT * FROM artistinfo WHERE art_no = ?";
				
		
		conn = JDBCTemplate.getConnection();
		
		
		ArtistInfo ainfo = null;
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, artistInfo.getArtno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ainfo = new ArtistInfo();
				
				ainfo.setArtno(rs.getInt("art_no"));
				ainfo.setArtName(rs.getString("art_name"));
				ainfo.setArtid(rs.getString("art_id"));
				ainfo.setArtpw(rs.getString("art_pw"));
				ainfo.setArtNick(rs.getString("art_nick"));
				ainfo.setArtBirth(rs.getDate("art_birth"));
				ainfo.setArtEmail(rs.getString("art_email"));
				ainfo.setArtCode(rs.getInt("art_code"));
				ainfo.setArtPhone(rs.getLong("art_phone"));
				ainfo.setArtTel(rs.getLong("art_tel"));
				ainfo.setArtAddr(rs.getString("art_addr"));
				ainfo.setArtContent(rs.getString("art_content"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return ainfo;
	}




	@Override
	public List<ClassInfo> classList(ClassInfo classInfo) {
		
		String sql = "";
		
		sql += "SELECT class_no, class_name, location, category, class_price, post_date";
		sql += " FROM classinfo";
		sql += " WHERE art_no = ?";
		sql += " ORDER BY class_no";
		
		conn = JDBCTemplate.getConnection();
		
		List<ClassInfo> list = new ArrayList<>();
		
		ClassInfo ci = null;
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classInfo.getArtno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ci = new ClassInfo();
				
				ci.setClassno(rs.getInt("class_no"));
				ci.setClassName(rs.getString("class_name"));
				ci.setLocation(rs.getInt("location"));
				ci.setCategory(rs.getInt("category"));
				ci.setClassprice(rs.getInt("class_price"));
				ci.setPostdate(rs.getDate("post_date"));
				
				list.add(ci);
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		return list;
	}




	@Override
	public List<Map<String, Object>> askCommList(AskBoard ab) {
		
		String sql = "";
		
		sql += "SELECT a.ask_board_no, a.user_no, f.class_name, a.ask_content, a.ask_date, ";
		sql += " c.ask_comm_no, c.comm_content, c.comm_date";
		sql += " FROM askboard a, askboardcomm c, classinfo f";
		sql += " WHERE a.art_no = ? AND a.ask_board_no = c.ask_board_no AND a.class_no = f.class_no";
		sql += " ORDER BY a.ask_board_no";

		
		conn = JDBCTemplate.getConnection();
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, ab.getArtno());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Map<String, Object> map = new HashMap<>();

				map.put("askBoardNo", rs.getInt("ask_board_no"));
				map.put("userNo", rs.getInt("user_no"));
				map.put("classname", rs.getString("class_name"));
				map.put("askContent", rs.getString("ask_content"));
				map.put("askDate", rs.getDate("ask_date"));
				map.put("askCommNo", rs.getInt("ask_comm_no"));
				map.put("commContent", rs.getString("comm_content"));
				map.put("commDate", rs.getDate("comm_date"));
				
				list.add(map);
				 
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

}
