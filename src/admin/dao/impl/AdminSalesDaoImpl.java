// 이인주 20200621 관리자 사업자 수익 확인 
package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import admin.dao.face.AdminSalesDao;
import dbutil.JDBCTemplate;
import util.Paging;

public class AdminSalesDaoImpl implements AdminSalesDao{
	
	//ojdbc 관련객체
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs =null;
	
	@Override
	public int selectCntAll() {

		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*) from classbooking";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
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
	public int nowselectCntAll(Date[] nowyearday) {

		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*) from classbooking";
		sql += " where booking_date BETWEEN ? and ? ";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(nowyearday[1].getTime());
			ps.setDate(2, day );
			
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
	public int choselectCntAll(Date[] chooseyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*) from classbooking";
		sql += " where booking_date BETWEEN ? and ? ";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(2, day );
			
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
	public int artidnowselectCntAll(String artid, Date[] nowyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from classbooking,artistinfo,classinfo";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND booking_date BETWEEN ? and ? ";
		sql += " and art_id like '%'|| ? ||'%'";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(nowyearday[1].getTime());
			ps.setDate(2, day );
			
			ps.setString(3, artid);
			
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
	public int artsearchchoselectCntAll(String artid, Date[] chooseyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select count(*)";
		sql += " from classbooking,artistinfo,classinfo";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND booking_date BETWEEN ? and ? ";
		sql += " and art_id like '%'|| ? ||'%'";
		
		//결과 저장할 변수
		int totalCount = 0 ;
		
		try {
			ps = conn.prepareStatement(sql);
			
			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(2, day );
			
			ps.setString(3, artid);
			
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
	public ArrayList<Map<String, Object>> nowselectadminsaleslistAll(Paging paging,Date[] nowyearday) {
		
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no, class_name, user_id, payment_date, booking_date, booking_count, total_price";
		sql += "	        from userinfo, classbooking, classinfo";
		sql += "	        WHERE userinfo.user_no = classbooking.user_no";
		sql += "	        AND classinfo.class_no = classbooking.class_no";
		sql += "	        AND booking_date BETWEEN ? and ?";
		sql += "	        order by booking_no desc";
		sql += "	     ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
		
		
		ArrayList<Map<String, Object>> nowadminsaleslist = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(nowyearday[1].getTime());
			ps.setDate(2, day );
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			
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

				nowadminsaleslist.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return nowadminsaleslist;
		
		
		
	}
	
	@Override
	public ArrayList<Map<String, Object>> choselectadminsaleslistAll(Paging paging,Date[] chooseyearday) {
		
		conn = JDBCTemplate.getConnection();//디비 연결
		
		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no, class_name, user_id, payment_date, booking_date, booking_count, total_price";
		sql += "	        from userinfo, classbooking, classinfo";
		sql += "	        WHERE userinfo.user_no = classbooking.user_no";
		sql += "	        AND classinfo.class_no = classbooking.class_no";
		sql += "	        AND booking_date BETWEEN ? and ?";
		sql += "	        order by booking_no desc";
		sql += "	     ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
		
		
		ArrayList<Map<String, Object>> choadminsaleslist = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(2, day );
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			
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

				choadminsaleslist.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return choadminsaleslist;
	}
	

	
	
	@Override
	public ArrayList<Map<String, Object>> nowselectartsaleslistAll(Paging paging,Date[] nowyearday) {

		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no, art_id, class_name, user_id, payment_date, booking_date, booking_count, total_price";
		sql += "	        from classinfo,artistinfo, userinfo, classbooking";
		sql += "	        WHERE classinfo.art_no = artistinfo.art_no";
		sql += "	        AND classinfo.class_no = classbooking.class_no";
		sql += "	        AND userinfo.user_no = classbooking.user_no";
		sql += "	        AND booking_date BETWEEN ? and ?";
		sql += "	        order by booking_no desc";
		sql += "	     ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
		
		
		ArrayList<Map<String, Object>> nowartsaleslist = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(nowyearday[1].getTime());
			ps.setDate(2, day );
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bookingNo",rs.getInt("booking_no"));
				map.put("artid",rs.getString("art_id"));
				map.put("classname",rs.getString("class_name"));
				map.put("userid",rs.getString("user_id"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));

				nowartsaleslist.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return nowartsaleslist;
	}
	
	@Override
	public ArrayList<Map<String, Object>> choselectartsaleslistAll(Paging paging, Date[] chooseyearday) {

		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no, art_id, class_name, user_id, payment_date, booking_date, booking_count, total_price";
		sql += "	        from classinfo,artistinfo, userinfo, classbooking";
		sql += "	        WHERE classinfo.art_no = artistinfo.art_no";
		sql += "	        AND classinfo.class_no = classbooking.class_no";
		sql += "	        AND userinfo.user_no = classbooking.user_no";
		sql += "	        AND booking_date BETWEEN ? and ?";
		sql += "	        order by booking_no desc";
		sql += "	     ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
		
		
		ArrayList<Map<String, Object>> choadminsaleslist = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(2, day );
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bookingNo",rs.getInt("booking_no"));
				map.put("artid",rs.getString("art_id"));
				map.put("classname",rs.getString("class_name"));
				map.put("userid",rs.getString("user_id"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));

				choadminsaleslist.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return choadminsaleslist;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> nowartsearchlist(Paging paging, String artid,Date[] nowyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no,user_id, art_id, class_name, payment_date, booking_date, booking_count, total_price";
		sql += "	        from classinfo,artistinfo, userinfo, classbooking";
		sql += "	        WHERE classinfo.art_no = artistinfo.art_no";
		sql += "	        AND classinfo.class_no = classbooking.class_no";
		sql += "	        AND userinfo.user_no = classbooking.user_no";
		sql += "	        AND booking_date BETWEEN ? and ?";
		sql += "	        AND art_id like '%'|| ? ||'%'";
		sql += "	        ORDER by booking_no desc";
		sql += "	     ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
		
		
		ArrayList<Map<String, Object>> nowartsearchlist = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(nowyearday[1].getTime());
			ps.setDate(2, day );
			
			ps.setString(3,artid );
			ps.setInt(4, paging.getStartNO());
			ps.setInt(5, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bookingNo",rs.getInt("booking_no"));
				map.put("userid",rs.getString("user_id"));
				map.put("artid",rs.getString("art_id"));
				map.put("classname",rs.getString("class_name"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));

				nowartsearchlist.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return nowartsearchlist;
	}
	
	@Override
	public ArrayList<Map<String, Object>> chooseyearday(Paging paging, String artid,Date[] chooseyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select * from (";
		sql += "	    select rownum rnum, c.* from(";
		sql += "	        select ";
		sql += "	            booking_no,user_id, art_id, class_name, payment_date, booking_date, booking_count, total_price";
		sql += "	        from classinfo,artistinfo, userinfo, classbooking";
		sql += "	        WHERE classinfo.art_no = artistinfo.art_no";
		sql += "	        AND classinfo.class_no = classbooking.class_no";
		sql += "	        AND userinfo.user_no = classbooking.user_no";
		sql += "	        AND booking_date BETWEEN ? and ?";
		sql += "	        AND art_id like '%'|| ? ||'%'";
		sql += "	        ORDER by booking_no desc";
		sql += "	     ) c";
		sql += " ) classbooking ";
		sql += " where rnum BETWEEN ? AND ?";
		
		
		ArrayList<Map<String, Object>> choartsearchlist = new ArrayList<Map<String,Object>>();
		
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(2, day );
			
			ps.setString(3,artid );
			ps.setInt(4, paging.getStartNO());
			ps.setInt(5, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {

				Map<String, Object> map = new HashMap<String, Object>();

				map.put("bookingNo",rs.getInt("booking_no"));
				map.put("userid",rs.getString("user_id"));
				map.put("artid",rs.getString("art_id"));
				map.put("classname",rs.getString("class_name"));
				map.put("paymentDate",rs.getDate("payment_date"));
				map.put("bookingDate",rs.getDate("booking_date"));
				map.put("bookingCount",rs.getInt("booking_count"));
				map.put("totalPrice",rs.getInt("total_price"));

				choartsearchlist.add(map);

		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return choartsearchlist;
	}

	@Override
	public int nowtotalsales(Date[] nowyearday) {
		
		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select sum(total_price)";
		sql += " from classbooking";
		sql += " WHERE booking_date BETWEEN ? and ?";
		
		int nowtotalsales = 0;
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(nowyearday[1].getTime());
			ps.setDate(2, day );
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				nowtotalsales = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return nowtotalsales;
	}
	
	@Override
	public int chototalsales(Date[] chooseyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select sum(total_price)";
		sql += " from classbooking";
		sql += " WHERE booking_date BETWEEN ? and ?";
		
		int chototalsales = 0;
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(chooseyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(chooseyearday[1].getTime());
			ps.setDate(2, day );
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				chototalsales = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return chototalsales;
	}
	
	@Override
	public int nowsearchtotalsales(String artid,Date[] nowyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select sum(total_price)";
		sql += " from classbooking,classinfo,artistinfo";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND booking_date BETWEEN ? and ?";
		sql += " AND art_id like '%'|| ? ||'%'";
		
		int chototalsales = 0;
		try {
			ps = conn.prepareStatement(sql);

			//java.util.Date타입의 정보를 java.sql.Date로 변경해야함
			// -> java.sql.Date(long millis)생성자를 이용한다
			java.sql.Date d = new java.sql.Date(nowyearday[0].getTime());
			ps.setDate(1, d );
			
			java.sql.Date day = new java.sql.Date(nowyearday[1].getTime());
			ps.setDate(2, day );
			ps.setString(3,artid );
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				chototalsales = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		
		return chototalsales;
	}
	
	@Override
	public int chosearchtotalsales(String artid,Date[] chooseyearday) {
		conn = JDBCTemplate.getConnection();//디비 연결

		String sql = "";
		sql += "select sum(total_price)";
		sql += " from classbooking,classinfo,artistinfo";
		sql += " WHERE classinfo.art_no = artistinfo.art_no";
		sql += " AND classinfo.class_no = classbooking.class_no";
		sql += " AND booking_date BETWEEN ? and ?";
		sql += " AND art_id like '%'|| ? ||'%'";
		
		int chosearchtotal = 0;
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
				chosearchtotal = rs.getInt(1);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return chosearchtotal;
	}
}
