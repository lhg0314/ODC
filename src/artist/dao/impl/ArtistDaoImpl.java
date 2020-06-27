package artist.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import artist.dao.face.ArtistDao;
import dbutil.JDBCTemplate;
import dto.ArtistInfo;

public class ArtistDaoImpl implements ArtistDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	@Override
	public int userLogin(String id, String pw) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from artistinfo where art_id=? and art_pw=?";
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
	public int idCheck(String checkId) {
		conn=JDBCTemplate.getConnection();
		String sql="select count(*) from artistInfo where art_id=?";
		int result=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, checkId);
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
	public void insertArtist(ArtistInfo artist) {
		// TODO Auto-generated method stub
		conn=JDBCTemplate.getConnection();
		String sql="";
		sql+="insert into artistinfo(art_no,art_id,art_pw,art_name,art_nick,art_code,";
		sql+="art_phone,art_tel,art_addr,art_email,art_birth,art_email_auth)";
		sql+="  values(ArtistInfo_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,1)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, artist.getArtid());
			ps.setString(2, artist.getArtpw());
			ps.setString(3, artist.getArtName());
			ps.setString(4, artist.getArtNick());
			ps.setInt(5, artist.getArtCode());
			ps.setLong(6, artist.getArtPhone());
			ps.setLong(7, artist.getArtTel());
			ps.setString(8, artist.getArtAddr());
			ps.setString(9, artist.getArtEmail());
			ps.setDate(10, (Date) artist.getArtBirth());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
	}
	@Override
	public int idCheckByEN(String email, String name) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from artistinfo where art_name=? and art_email=?";
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
	public String getIdByEN(String email, String name) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select art_id from artistinfo where art_name=? and art_email=?";
		String res="";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getString("art_id");
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
		
		String sql="select count(*) from artistinfo where art_name=? and art_email=? and art_id=?";
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
		
		String sql="select art_pw from artistinfo where art_name=? and art_email=? and art_id=?";
		String res="";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getString("art_pw");
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
	public void deleteClassFile(int classno, String filename) {
		conn=JDBCTemplate.getConnection();
		String sql="delete from classfile where class_no=? and class_origin_filename=?";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, classno);
			ps.setString(2, filename);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
