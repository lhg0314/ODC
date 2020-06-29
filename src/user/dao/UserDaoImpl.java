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

}
