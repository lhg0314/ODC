package artist.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import artist.dao.face.ArtistClassDao;
import dbutil.JDBCTemplate;
import dto.ArtistInfo;
import dto.ClassFile;
import dto.ClassInfo;

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
	@Override
	public int getClassNo() {

		//DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT classInfo_SEQ.nextval no FROM dual";
		
		// 결과 객체
		int classNo = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				classNo = rs.getInt("no");
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return classNo;
	}
	@Override
	public void insertClassInfo(ClassInfo classInfo) {
		//DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "INSERT INTO classinfo(class_no, art_no, class_name, category, location, class_price, talent_donation, recruit_startdate, recruit_enddate, max_people, min_people, class_startdate, class_enddate, class_content)";
		sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classInfo.getClassno());
			ps.setInt(2, classInfo.getArtno());
			ps.setString(3, classInfo.getClassName());
			ps.setInt(4, classInfo.getCategory());
			ps.setInt(5, classInfo.getLocation());
			ps.setInt(6, classInfo.getClassprice());
			ps.setInt(7, classInfo.getTalentDonation());
			
			java.sql.Date d = null;
			
			d = new java.sql.Date(classInfo.getRecruitStartdate().getTime());
			ps.setDate(8, d);
			
	        d = new java.sql.Date(classInfo.getRecruitEnddate().getTime());
	        ps.setDate(9, d );
	        
	        ps.setInt(10, classInfo.getMaxPeople());
	        ps.setInt(11, classInfo.getMinPeople());
	        
	        d = new java.sql.Date(classInfo.getClassStartdate().getTime());
	        ps.setDate(12, d );
	        
	        d = new java.sql.Date(classInfo.getClassEnddate().getTime());
	        ps.setDate(13, d );
	        
	        ps.setString(14, classInfo.getClassContent());
			
	        ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JDBCTemplate.close(ps);
		}
		
	}
	@Override
	public void insertClassFile(ClassFile classFile) {
		//DB 연결
				conn = JDBCTemplate.getConnection();
				
				// sql
				String sql = "";
				sql += "INSERT INTO classfile(class_file_no, class_no, class_origin_filename, class_rename_filename)";
				sql += " VALUES(classfile_SEQ.nextval, ?, ?, ?)";
				
				try {
					ps = conn.prepareStatement(sql);
					
					ps.setInt(1, classFile.getClassno());
					ps.setString(2, classFile.getClassOriginFilename());
					ps.setString(3, classFile.getClassRenameFilename());
					
			        ps.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
					JDBCTemplate.close(ps);
				}
		
		
	}
}
