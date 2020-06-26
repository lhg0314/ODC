package artist.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import artist.dao.face.ArtistClassDao;
import dbutil.JDBCTemplate;
import dto.ArtistInfo;
import dto.ClassFile;
import dto.ClassInfo;
import util.Paging;

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
		sql += " VALUES(classFile_SEQ.nextval, ?, ?, ?)";
		
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
	
	
	@Override
	public List<Map<String, Object>> selectAllClassCheck(int artno) {
		
	conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT * ";
		sql += " FROM classinfo c";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " on (c.class_no = f.class_no)";
		sql += " WHERE 1=1";
		sql += " AND c.art_no = ?";
		sql += " AND c.class_check <> 1";
		sql += " AND f.class_rename_filename LIKE 'main%'";
		sql += " ORDER BY C.class_no DESC";

		//최종 결과 변수
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, artno);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
//			System.out.println(rs.next());
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("classPrice", rs.getInt("class_price"));
				map.put("talentDonation",rs.getInt("talent_donation"));
				map.put("postDate",rs.getDate("post_date"));
				map.put("recruitStartdate",rs.getDate("recruit_startdate"));
				map.put("recruitEnddate",rs.getDate("recruit_enddate"));
				map.put("maxPeople",rs.getInt("max_people"));
				map.put("minPeople",rs.getInt("min_people"));
				map.put("classStartdate",rs.getDate("class_startdate"));
				map.put("classEnddate",rs.getDate("class_enddate"));
				map.put("classContent",rs.getString("class_content"));
				map.put("postStatus",rs.getInt("post_Status"));
				map.put("classCheck",rs.getInt("class_check"));

				map.put("classFileNo", rs.getInt("class_file_no"));
				map.put("classOriginFilename", rs.getString("class_origin_filename"));
				map.put("classRenameFilename", rs.getString("class_rename_filename"));
				
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return list;
	}
	@Override
	public int selectCntAll(String search, int artno) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT ";
		sql += "	count(*)";
		sql += " FROM classinfo";
		sql += " WHERE 1=1";
		sql += " AND class_check = 1";
		sql += " AND art_no = ?";
		if( search != null && !"".equals(search)) {
			sql += " AND class_name LIKE ?";
		}
		
		//최종 결과 변수
		int cnt = 0;
		
		// index 변수
		int index = 1;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(index++, artno);
			
			if( search != null && !"".equals(search)) {
				ps.setString(index++, "%" + search + "%");
			}
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return cnt;
		
	}
	@Override
	public List<Map<String, Object>> selectAllClass(Paging paging, int artno) {
		// DB 연결
		conn = JDBCTemplate.getConnection();
		
		// sql
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "    SELECT rownum rnum, X.* FROM (";
		sql += "        SELECT *";
		sql += " 		FROM classinfo i";
		sql += " 		LEFT OUTER JOIN classfile f";
		sql += " 		ON (i.class_no = f.class_no)";
		sql += " 		WHERE 1=1";
		sql += "		AND i.class_check = 1";
		sql += " 		AND f.class_rename_filename LIKE 'main%'";
		sql += "		AND i.art_no = ?"; 
		sql += " 		ORDER BY i.class_no DESC";
		sql += "    ) X";
		sql += "    ORDER BY rnum";
		sql += " ) t";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 결과 객체
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, artno);
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			
			while( rs.next()) {
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("classPrice", rs.getInt("class_price"));
				map.put("talentDonation",rs.getInt("talent_donation"));
				map.put("postDate",rs.getDate("post_date"));
				map.put("recruitStartdate",rs.getDate("recruit_startdate"));
				map.put("recruitEnddate",rs.getDate("recruit_enddate"));
				map.put("maxPeople",rs.getInt("max_people"));
				map.put("minPeople",rs.getInt("min_people"));
				map.put("classStartdate",rs.getDate("class_startdate"));
				map.put("classEnddate",rs.getDate("class_enddate"));
				map.put("classContent",rs.getString("class_content"));
				map.put("postStatus",rs.getInt("post_Status"));
				map.put("classCheck",rs.getInt("class_check"));

				map.put("classFileNo", rs.getInt("class_file_no"));
				map.put("classOriginFilename", rs.getString("class_origin_filename"));
				map.put("classRenameFilename", rs.getString("class_rename_filename"));
				
				list.add(map);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
		
	}
	@Override
	public Map<String, Object> selectClassByClassNo(int classno) {	
	
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT * ";
		sql += " FROM classinfo c";
		sql += " LEFT OUTER JOIN classfile f";
		sql += " on (c.class_no = f.class_no)";
		sql += " WHERE c.class_no = ?";
		sql += " AND f.class_rename_filename LIKE 'main%'";
	
		//최종 결과 변수
		Map<String, Object> map = null;
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classno);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
			//SQL 수행 결과 처리
			while( rs.next() ) {
				
				map = new HashMap<String, Object>();
				
				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("category", rs.getInt("category"));
				map.put("location", rs.getInt("location"));
				map.put("classPrice", rs.getInt("class_price"));
				map.put("talentDonation",rs.getInt("talent_donation"));
				map.put("postDate",rs.getDate("post_date"));
				map.put("recruitStartdate",rs.getDate("recruit_startdate"));
				map.put("recruitEnddate",rs.getDate("recruit_enddate"));
				map.put("maxPeople",rs.getInt("max_people"));
				map.put("minPeople",rs.getInt("min_people"));
				map.put("classStartdate",rs.getDate("class_startdate"));
				map.put("classEnddate",rs.getDate("class_enddate"));
				map.put("classContent",rs.getString("class_content"));
				map.put("postStatus",rs.getInt("post_Status"));
				map.put("classCheck",rs.getInt("class_check"));
	
				map.put("classFileNo", rs.getInt("class_file_no"));
				map.put("classOriginFilename", rs.getString("class_origin_filename"));
				map.put("classRenameFilename", rs.getString("class_rename_filename"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return map;
	}
	
	@Override
	public void deleteMainFile(ClassFile classFile) {

		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "DELETE FROM classfile";
		sql += " WHERE class_no = ?";
		sql += " AND class_rename_filename LIKE 'main%'";

		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classFile.getClassno());
			
			//SQL 수행 및 결과 저장
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void deleteDetailFile(ClassFile classFile) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "DELETE FROM classfile";
		sql += " WHERE class_no = ?";
		sql += " AND class_rename_filename NOT LIKE 'main%'";
		
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classFile.getClassno());
			
			//SQL 수행 및 결과 저장
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void updateClassInfo(ClassInfo classInfo) {
		
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "UPDATE classinfo";
		sql += " SET class_price = ?";
		sql += " , min_people = ?";
		sql += " , max_people = ?";
		sql += " , class_startdate = ?";
		sql += " , class_enddate = ?";
		sql += " , recruit_startdate  = ?";
		sql += " , recruit_enddate  = ?";
		sql += " , class_content  = ?";
		sql += " WHERE class_no = ?";

		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			int index = 1;
			
			ps.setInt(index++, classInfo.getClassprice());
			ps.setInt(index++, classInfo.getMinPeople());
			ps.setInt(index++, classInfo.getMaxPeople());
			
			java.sql.Date d = null;
			
			d = new java.sql.Date(classInfo.getClassStartdate().getTime());
			ps.setDate(index++, d);

			d = new java.sql.Date(classInfo.getClassEnddate().getTime());
			ps.setDate(index++, d);
			
			d = new java.sql.Date(classInfo.getRecruitStartdate().getTime());
			ps.setDate(index++, d);
			
			d = new java.sql.Date(classInfo.getRecruitEnddate().getTime());
			ps.setDate(index++, d);
			
			ps.setString(index++, classInfo.getClassContent());
			
			ps.setInt(index++, classInfo.getClassno());
			
			
			//SQL 수행 및 결과 저장
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
	}
	@Override
	public ClassFile selectDetailFileByClassno(int classno) {
		conn = JDBCTemplate.getConnection(); //DB 연결
		
		//수행할 SQL
		String sql = "";
		sql += "SELECT * ";
		sql += " FROM classfile";
		sql += " WHERE class_no = ?";
		sql += " AND class_rename_filename NOT LIKE 'main%'";
	
		//최종 결과 변수
		ClassFile detailFile = new ClassFile();
		
		try {
			//SQL 수행 객체
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, classno);
			
			//SQL 수행 및 결과 저장
			rs = ps.executeQuery();
			
	//		System.out.println(rs.next());
			
			//SQL 수행 결과 처리
			while( rs.next() ) {

				detailFile.setClassno(rs.getInt("class_no"));
				detailFile.setClassFileno(rs.getInt("class_file_no"));
				detailFile.setClassOriginFilename(rs.getString("class_origin_filename"));
				detailFile.setClassRenameFilename(rs.getString("class_rename_filename"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//최종 결과 반환
		return detailFile;
	}
}
