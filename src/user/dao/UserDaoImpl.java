package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbutil.JDBCTemplate;
import dto.AskBoard;
import dto.ClassFile;
import dto.ClassInfo;
import dto.Classwish;
import dto.Donation;
import dto.ReviewBoard;
import dto.UserInfo;


public class UserDaoImpl implements UserDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	@Override
	public int idCheck(String id) {
		
		conn=JDBCTemplate.getConnection();
		String sql="select count(*) from UserInfo where user_id=?";
		int result=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}


	@Override
	public void insertUser(UserInfo user) {
		// TODO Auto-generated method stub
		conn=JDBCTemplate.getConnection();
		String sql="";
		sql+="insert into userinfo(user_no,user_id,user_pw,user_name,";
		sql+="user_phone,user_email,user_birth,user_nick)";
		sql+="  values(UserInfo_SEQ.nextval,?,?,?,?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.setLong(4, user.getUserphone());
			ps.setString(5, user.getUseremail());
			ps.setDate(6, (Date) user.getUserbirth());
			ps.setString(7, user.getUsernick());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
	}


	@Override
	public int userLogin(String id, String pw) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from userinfo where user_id=? and user_pw=?";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public int userIdChkByEN(String email, String name) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from userinfo where user_name=? and user_email=?";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public String selectUserIdByEN(String email, String name) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select user_id from userinfo where user_name=? and user_email=?";
		String res="";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getString("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public int userPwChkByEN(String email, String name, String id) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from userinfo where user_name=? and user_email=? and user_id=?";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public String selectUserPwByEN(String email, String name, String id) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select user_pw from userinfo where user_name=? and user_email=? and user_id=?";
		String res="";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getString("user_pw");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public List<Map<String, Object>> getDetailReview(int classno) {
		conn=JDBCTemplate.getConnection();

		String sql = "";
		sql += "SELECT * ";
		sql += " FROM userinfo u";
		sql += " JOIN reviewboard r";
		sql += " on (u.user_no = r.user_no)";
		sql += " WHERE 1=1";
		sql += " AND r.class_no = ?";
		List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, classno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<>();
				System.out.println("dao:"+rs.getDate("review_date"));
				map.put("reviewDate", rs.getDate("review_date"));
				map.put("sat", rs.getString("sat_level"));
				map.put("content", rs.getString("review_content"));
				map.put("userid", rs.getString("user_id"));
				System.out.println(map);
				list.add(map);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return list;
	}


	@Override
	public void insertReview(ReviewBoard board) {
		
		conn=JDBCTemplate.getConnection();
		String sql="";
		sql+="insert into ReviewBoard(review_no,user_no, class_no,sat_level,review_content,review_title,booking_no)";
		sql+=" values(ReviewBoard_SEQ.nextval,?,?,?,?,?,1)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, 6);
			ps.setInt(2, 25);
			ps.setString(3, "만족");
			ps.setString(4, board.getReviewContent());
			ps.setString(5, "제목");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getUserIdById(String id) {
		conn=JDBCTemplate.getConnection();
		String sql="";
		sql+="select user_no from userInfo where user_id=? ";
		int userno=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				userno=rs.getInt("user_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userno;
	}


	@Override
	public void insertAskBoard(AskBoard a) {
		// TODO Auto-generated method stub
		conn=JDBCTemplate.getConnection();
		String sql="insert into askboard(ask_board_no,user_no,art_no,class_no,ask_title,ask_content)";
		sql+=" values(AskBoard_SEQ.nextval,?,?,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, a.getUserno());
			ps.setInt(2, a.getArtno());
			ps.setInt(3, a.getClassno());
			ps.setString(4, "title");
			ps.setString(5, a.getAskContent());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
	}


	@Override
	public List<AskBoard> selectAskByClassno(int classno) {
		conn=JDBCTemplate.getConnection();
		String sql="select * from Askboard join  where class_no=?";
		List<AskBoard> list=new ArrayList<AskBoard>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, classno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				AskBoard a= new AskBoard();
				a.setAskContent(rs.getString("ask_content"));
				a.setUserno(rs.getInt("user_no"));
				a.setAskDate(rs.getDate("ask_date"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return list;
	}


	@Override
	public int insertWish(Classwish c) {
		// TODO Auto-generated method stub
		conn=JDBCTemplate.getConnection();
		
		String sql="";
		sql+="insert into classwish(wish_no,class_no,user_no,wish_count,wish_total_price,wish_date)";
		sql+=" values(ClassWish_SEQ.nextval,?,?,?,?,?)";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getClassno());
			ps.setInt(2, c.getUser_no());
			ps.setInt(3, c.getWishCount());
			ps.setInt(4, c.getTotalPrice());
			ps.setDate(5, new java.sql.Date( c.getWishDate().getTime() ));
			
			res=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}


	@Override
	public List<Map<String, Object>> getAskAndComm(int classno) {
		conn=JDBCTemplate.getConnection();
		
		String sql="";
		sql+="select user_id,ask_date,ask_content,comm_content,comm_date,art_id from askboard a ";
		sql+=" left outer join askboardcomm c on a.ask_board_no= c.ask_board_no ";
		sql+="  join userinfo u on u.user_no=a.user_no ";
		sql+="  join artistinfo art on a.art_no=art.art_no";
		sql+="  where class_no=? order by ask_date desc";
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, classno);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("userid",rs.getString("user_id"));
				map.put("askDate",rs.getDate("ask_date"));
				map.put("askContent",rs.getString("ask_content"));
				map.put("artid",rs.getString("art_id"));
				map.put("commDate",rs.getDate("comm_date"));
				map.put("commContent",rs.getString("comm_content"));
				
				list.add(map);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return list;
	}


	@Override
	public List<Map<String, Object>> getClassList(int artno) {
		conn=JDBCTemplate.getConnection();
		String sql="select * from classinfo i";
		sql+=" left outer join classfile f on i.class_no=f.class_no";
		sql+=" where f.class_rename_filename like '%main%' and i.art_no=?";
		List<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, artno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("classname",rs.getString("class_name"));
				map.put("classfilename",rs.getString("class_rename_filename"));
				map.put("cate",rs.getInt("category"));
				map.put("loc",rs.getInt("location"));
				map.put("classno",rs.getInt("class_no"));
				
				
				list.add(map);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		// TODO Auto-generated method stub
		return list;
	}


	@Override
	public int insertDonation(Donation d) {
		conn=JDBCTemplate.getConnection();
		String sql="insert into donation(user_no,art_no,donation_price)";
		sql+="  values(?,?,?)";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, d.getUserno());
			ps.setInt(2, d.getArtno());
			ps.setInt(3, d.getDonationPrice());
			res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public ArrayList<Map<String, Object>> getReviewbyClassno(int classno) {
		
		conn=JDBCTemplate.getConnection();
		String sql="select * from reviewboard b";
		sql+=" left outer join reviewfile f ";
		sql+=" on b.review_no=f.review_no";
		sql+=" left outer join userinfo u";
		sql+=" on b.user_no=u.user_no";
		sql+=" where b.class_no=? order by b.review_date desc";
		
		ArrayList<Map<String, Object>> list = new ArrayList<>();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, classno);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("userid",rs.getString("user_id"));
				map.put("reviewDate",rs.getDate("review_date"));
				map.put("title",rs.getString("review_title"));
				map.put("sta",rs.getString("sat_level"));
				map.put("content",rs.getString("review_content"));
				map.put("filename",rs.getString("review_rename"));
				list.add(map);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return list;
	}


	@Override
	public List<ClassFile> selectDetailFileByClssno(int classno) {
		conn=JDBCTemplate.getConnection();
		
		String sql = "";
		sql += "SELECT * ";
		sql += " FROM classfile";
		sql += " WHERE class_no = ?";
		
		List<ClassFile> list=new ArrayList<ClassFile>();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, classno);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				ClassFile f=new ClassFile();
				f.setClassRenameFilename(rs.getString("class_rename_filename"));
				list.add(f);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
