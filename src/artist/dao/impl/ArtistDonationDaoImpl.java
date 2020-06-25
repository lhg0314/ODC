package artist.dao.impl;

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

import artist.dao.face.ArtistDonationDao;
import dbutil.JDBCTemplate;
import util.Paging;

public class ArtistDonationDaoImpl implements ArtistDonationDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public int selectCntDonationByArtNo(int artno, String month) {
		conn = JDBCTemplate.getConnection();

		int cnt = 0;
		String date1 = null;
		String date2 = null;

		String sql = "";

		try {
			if (month != null && !"00".equals(month)) {

				// 현재 날짜 기준 년원일
				SimpleDateFormat format = new SimpleDateFormat("yy");
				String thisYear = format.format(new Date());

				date1 = thisYear + "/" + month + "/01";
				date2 = null;

				switch (Integer.parseInt(month)) {
				case 2:
					date2 = thisYear + "/" + month + "/29";
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					date2 = thisYear + "/" + month + "/30";
					break;
				default:
					date2 = thisYear + "/" + month + "/31";
				}

				sql += "select count(*) from donation d";
				sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
				sql += "	inner join userinfo u on (d.user_no = u.user_no)";
				sql += "	where d.art_no = ? and donation_date between ? and ?";

				ps = conn.prepareStatement(sql);

				ps.setInt(1, artno);
				ps.setString(2, date1);
				ps.setString(3, date2);

			} else if (month == null || "00".equals(month)) {

				sql += "select count(*) from donation d";
				sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
				sql += "	inner join userinfo u on (d.user_no = u.user_no)";
				sql += "	where d.art_no = ?";

				ps = conn.prepareStatement(sql);

				ps.setInt(1, artno);

			}

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
	public List<Map<String, Object>> selectDonationByArtNo(Paging paging, int artno) {
		conn = JDBCTemplate.getConnection();

		String date1 = null;
		String date2 = null;

		String month = paging.getMonth();

		String sql = "";

		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = null;

		try {

			if (month != null && !"00".equals(month)) {

				// 현재 날짜 기준 년원일
				SimpleDateFormat format = new SimpleDateFormat("yy");
				String thisYear = format.format(new Date());

				date1 = thisYear + "/" + month + "/01";
				date2 = null;

				switch (Integer.parseInt(month)) {
				case 2:
					date2 = thisYear + "/" + month + "/29";
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					date2 = thisYear + "/" + month + "/30";
					break;
				default:
					date2 = thisYear + "/" + month + "/31";
				}

				sql += "select * from ( select rownum rnum, b.* from (";
				sql += "	select art_name, user_name, donation_date, donation_price from donation d";
				sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
				sql += "	inner join userinfo u on (d.user_no = u.user_no)";
				sql += "	where d.art_no = ? and donation_date between ? and ?";
				sql += "	order by donation_date) b order by rnum ) t where rnum between ? and ?";

				ps = conn.prepareStatement(sql);

				ps.setInt(1, artno);
				ps.setString(2, date1);
				ps.setString(3, date2);
				ps.setInt(4, paging.getStartNO());
				ps.setInt(5, paging.getEndNo());

			} else if (month == null || "00".equals(month)) {

				sql += "select * from ( select rownum rnum, b.* from (";
				sql += "	select art_name, user_name, donation_date, donation_price from donation d";
				sql += "	inner join artistinfo a on (d.art_no = a.art_no)";
				sql += "	inner join userinfo u on (d.user_no = u.user_no)";
				sql += "	where d.art_no = ?";
				sql += "	order by donation_date) b order by rnum ) t where rnum between ? and ?";

				ps = conn.prepareStatement(sql);

				ps.setInt(1, artno);
				ps.setInt(2, paging.getStartNO());
				ps.setInt(3, paging.getEndNo());
			}

			rs = ps.executeQuery();

			while (rs.next()) {
				map = new HashMap<String, Object>();

				map.put("artName", rs.getString("art_name"));
				map.put("userName", rs.getString("user_name"));
				map.put("donationDate", rs.getDate("donation_date"));
				map.put("donationPrice", rs.getInt("donation_price"));
				map.put("rnum", rs.getInt("rnum"));

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
