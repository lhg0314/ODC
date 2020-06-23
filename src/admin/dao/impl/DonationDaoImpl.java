package admin.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.dao.face.DonationDao;
import dbutil.JDBCTemplate;
import util.Paging;

public class DonationDaoImpl implements DonationDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int selectCntAllTalent(String search) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from classinfo c";
		sql += "	inner join artistinfo a on (c.art_no = a.art_no)";
		sql += "	where talent_donation = 1 and class_name like '%'||?||'%'";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);

			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return cnt;
	}

	@Override
	public int selectCntAllDonation(String search) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from donation d";
		sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
		sql += "	inner join userinfo u on (d.user_no = u.user_no)";
		sql += "	where a.art_name like '%'||?||'%'";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, search);

			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return cnt;
	}

	@Override
	public int selectCntAllDonationByMonth(String month) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select count(*) from donation d";
		sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
		sql += "	inner join userinfo u on (d.user_no = u.user_no)";
		sql += "	where donation_date between ? and ?";
		//현재 날짜 기준 년원일
		SimpleDateFormat format = new SimpleDateFormat("yy");
		String thisYear = format.format(new Date());
		
		int cnt = 0;
		
		String date1 = thisYear+"/"+month+"/01";
		String date2 = null;
		
		switch(Integer.parseInt(month)) {
			case 2: 
				date2 = thisYear+"/"+month+"/29";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				date2 = thisYear+"/"+month+"/30";
				break;
			default:
				date2 = thisYear+"/"+month+"/31";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, date1);
			ps.setString(2, date2);

			rs = ps.executeQuery();

			rs.next();
			cnt = rs.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return cnt;
	}
	
	@Override
	public List<Map<String, Object>> selectAllTalentDonationClass(Paging paging) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select c.class_no, c.class_name, c.category, c.post_date, c.class_check, a.art_id, a.art_name";
		sql += "	from classinfo c inner join artistinfo a on (c.art_no = a.art_no)";
		sql += "	where c.talent_donation = 1 and c.class_name like '%'||?||'%'";
		sql += "	order by post_date desc ) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("classNo", rs.getInt("class_no"));
				map.put("className", rs.getString("class_name"));
				map.put("classCheck", rs.getString("class_check"));
				map.put("category", rs.getInt("category"));
				map.put("postDate", rs.getDate("post_date"));
				map.put("artId", rs.getString("art_id"));
				map.put("artName", rs.getString("art_name"));

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
	public List<Map<String, Object>> selectAllDonation(Paging paging) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select art_name, user_name, donation_date, donation_price from donation d";
		sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
		sql += "	inner join userinfo u on (d.user_no = u.user_no)";
		sql += "	where art_name like '%'||?||'%' order by donation_date";
		sql += "	) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, paging.getSearch());
			ps.setInt(2, paging.getStartNO());
			ps.setInt(3, paging.getEndNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				
				map.put("artName", rs.getString("art_name"));
				map.put("userName", rs.getString("user_name"));
				map.put("donationDate", rs.getDate("donation_date"));
				map.put("donationPrice", rs.getInt("donation_price"));

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
	public List<Map<String, Object>> selectAllDonationByMonth(String month, Paging paging) {
		conn = JDBCTemplate.getConnection();

		String sql = "";
		sql += "select * from ( select rownum rnum, b.* from (";
		sql += "	select art_name, user_name, donation_date, donation_price from donation d";
		sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
		sql += "	inner join userinfo u on (d.user_no = u.user_no)";
		sql += "	where donation_date between ? and ? order by donation_date";
		sql += "	) b order by rnum ) t where rnum between ? and ?";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;
		
		//현재 날짜 기준 년
		SimpleDateFormat format = new SimpleDateFormat("yy");
		String thisYear = format.format(new Date());
		
		String date1 = thisYear+"/"+month+"/01";
		String date2 = null;
		
		switch(Integer.parseInt(month)) {
			case 2: 
				date2 = thisYear+"/"+month+"/29";
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				date2 = thisYear+"/"+month+"/30";
				break;
			default:
				date2 = thisYear+"/"+month+"/31";
		}

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, date1);
			ps.setString(2, date2);
			ps.setInt(3, paging.getStartNO());
			ps.setInt(4, paging.getEndNo());
			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();
				
				map.put("artName", rs.getString("art_name"));
				map.put("userName", rs.getString("user_name"));
				map.put("donationDate", rs.getDate("donation_date"));
				map.put("donationPrice", rs.getInt("donation_price"));

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

}
