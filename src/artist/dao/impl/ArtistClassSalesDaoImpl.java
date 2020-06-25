package artist.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import artist.dao.face.ArtistClassSalesDao;
import dbutil.JDBCTemplate;
import util.Paging;

public class ArtistClassSalesDaoImpl implements ArtistClassSalesDao{
	
	//ojdbc 관련객체
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs =null;
	
	@Override
	public ArrayList<Map<String, Object>> nowartsales(Paging paging,String artid,Date[] artnowday) {

		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no, class_name, user_id, payment_date, booking_date, booking_count, total_price";
		sql += "	        	from classinfo,artistinfo, userinfo, classbooking";
		sql += "	       	 	WHERE classinfo.art_no = artistinfo.art_no";
		sql += "	        	AND classinfo.class_no = classbooking.class_no";
		sql += "	        	AND userinfo.user_no = classbooking.user_no";
		sql += "	        	AND art_id = ?";
		sql += " 				AND payment_date BETWEEN ? and ?";
		sql += "	        	order by booking_no desc";
		sql += "	    ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
	
		ArrayList<Map<String, Object>> nowartsales = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, artid);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(artnowday[0].getTime());
			ps.setDate(2, d );
			
			java.sql.Date day = new java.sql.Date(artnowday[1].getTime());
			ps.setDate(3, day );
			
			ps.setInt(4, paging.getStartNO());
			ps.setInt(5, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bookingNo",rs.getInt("booking_no"));
				map.put("classname",rs.getString("class_name"));
				map.put("userid",rs.getString("user_id"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));

				nowartsales.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return nowartsales;
	}
	
	@Override
	public int selectCntAll(String artid,Date[] artnowday) {

		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from classbooking,artistinfo,classinfo";
		sql += " WHERE classbooking.class_no = classinfo.class_no";
		sql += " and classinfo.art_no = artistinfo.art_no";
		sql += " and art_id = ?";
		sql += " and payment_date BETWEEN ? and ?";

		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, artid);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(artnowday[0].getTime());
			ps.setDate(2, d );
			
			java.sql.Date day = new java.sql.Date(artnowday[1].getTime());
			ps.setDate(3, day );
			
			rs = ps.executeQuery();
			
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
	public int nowtotalsales(String artid, Date[] artnowday) {
		
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select sum(total_price)";
		sql += " from classbooking,classinfo,artistinfo";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND payment_date BETWEEN ? and ?";
		sql += " AND art_id = ?";
		
		int nowartsalestot = 0;
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(artnowday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(artnowday[1].getTime());
			ps.setDate(2, day );
			ps.setString(3,artid );
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				nowartsalestot = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return nowartsalestot;
	}
	
	@Override
	public ArrayList<Map<String, Object>> choartsales(Paging paging,String artid, Date[] chooseyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no, class_name, user_id, payment_date, booking_date, booking_count, total_price";
		sql += "	        	from classinfo,artistinfo, userinfo, classbooking";
		sql += "	       	 	WHERE classinfo.art_no = artistinfo.art_no";
		sql += "	        	AND classinfo.class_no = classbooking.class_no";
		sql += "	        	AND userinfo.user_no = classbooking.user_no";
		sql += "	        	AND art_id = ?";
		sql += " 				AND payment_date BETWEEN ? and ?";
		sql += "	        	order by booking_no desc";
		sql += "	    ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
	
		ArrayList<Map<String, Object>> choartsales = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, artid);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(2, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(3, day );
			
			ps.setInt(4, paging.getStartNO());
			ps.setInt(5, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bookingNo",rs.getInt("booking_no"));
				map.put("classname",rs.getString("class_name"));
				map.put("userid",rs.getString("user_id"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));

				choartsales.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return choartsales;
	}
	
	@Override
	public int choselectCntAll(String artid, Date[] chooseyearday) {
		
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from classbooking,artistinfo,classinfo";
		sql += " WHERE classbooking.class_no = classinfo.class_no";
		sql += " and classinfo.art_no = artistinfo.art_no";
		sql += " and art_id = ?";
		sql += " and payment_date BETWEEN ? and ?";

		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, artid);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(2, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(3, day );
			
			rs = ps.executeQuery();
			
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
	public int choartsalestot(String artid, Date[] chooseyearday) {
		
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select sum(total_price)";
		sql += " from classbooking,classinfo,artistinfo";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND payment_date BETWEEN ? and ?";
		sql += " AND art_id = ?";
		
		int choartsalestot = 0;
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(2, day );
			ps.setString(3,artid );
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				choartsalestot = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return choartsalestot;
	}
	
	@Override
	public ArrayList<Map<String, Object>> choartsalessearch(String artid, String classname) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no,user_id, payment_date, booking_date, booking_count, total_price";
		sql += "	        	from classinfo,artistinfo, userinfo, classbooking";
		sql += "	       	 	WHERE classinfo.art_no = artistinfo.art_no";
		sql += "	        	AND classinfo.class_no = classbooking.class_no";
		sql += "	        	AND userinfo.user_no = classbooking.user_no";
		sql += "	        	AND art_id = ?";
		sql += "	        	AND class_name = ?";
		sql += "	        	order by booking_no desc";
		sql += "	    ) c";
		sql += " ) classbooking ";
//		sql += " where rnum BETWEEN ? AND ?";
	
		ArrayList<Map<String, Object>> choartsalessearch = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, artid);
			ps.setString(2, classname);
			
//			ps.setInt(4, paging.getStartNO());
//			ps.setInt(5, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bookingNo",rs.getInt("booking_no"));
				map.put("userid",rs.getString("user_id"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));

				choartsalessearch.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return choartsalessearch;
	}
	
	@Override
	public int searchCntAll(String artid, String classname) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from classbooking,artistinfo,classinfo";
		sql += " WHERE classbooking.class_no = classinfo.class_no";
		sql += " and classinfo.art_no = artistinfo.art_no";
		sql += " and art_id = ?";
		sql += " and class_name = ?";

		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, artid);
			ps.setString(2, classname);
			rs = ps.executeQuery();
			
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
	public int searchclassnametotal(String artid, String classname) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select sum(total_price)";
		sql += " from classbooking,classinfo,artistinfo";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND art_id = ?";
		sql += " AND class_name = ?";
		
		int searchclassnametotal = 0;
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1,artid );
			ps.setString(2,classname );
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				searchclassnametotal = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return searchclassnametotal;
	}
}
