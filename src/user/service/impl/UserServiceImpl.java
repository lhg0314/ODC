package user.service.impl;

import java.util.List;
import java.util.Map;

import dto.AskBoard;
import dto.Classwish;
import dto.ReviewBoard;
import dto.UserInfo;
import user.dao.UserDao;
import user.dao.UserDaoImpl;
import user.service.face.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao=new UserDaoImpl();
	@Override
	public int idCheck(String id) {
		
		return userDao.idCheck(id) ;
	}
	@Override
	public void insertUser(UserInfo user) {
		userDao.insertUser(user);
		
	}
	@Override
	public boolean userLogin(String id, String pw) {
		
		int res=userDao.userLogin(id,pw);
		boolean ismember=false;
		if(res==0) {
			
			ismember=false;
		}else {
			ismember=true;
		}
		return ismember;
	}
	@Override
	public int selectUserIdByEN(String email, String name) {
		int res=userDao.userIdChkByEN(email,name);
		return res;
	}
	@Override
	public String getIdByEN(String email, String name) {
		String id=userDao.selectUserIdByEN(email,name);
		return id;
	}
	@Override
	public int selectUserPwByEN(String email, String name, String id) {
		int res=userDao.userPwChkByEN(email,name,id);
		return res;
	}
	@Override
	public String getPwByEN(String email, String name, String id) {
		String pw=userDao.selectUserPwByEN(email,name,id);
		return pw;
	}
	@Override
	public List<Map<String, Object>> getDetailReview(int classno) {
		// TODO Auto-generated method stub
		return userDao.getDetailReview(classno);
	}
	@Override
	public void insertReview(ReviewBoard board) {
		userDao.insertReview(board);
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getUsernoBy(String id) {
		// TODO Auto-generated method stub
		return userDao.getUserIdById(id);
	}
	@Override
	public void insertAskBoard(AskBoard a) {
		// TODO Auto-generated method stub
		userDao.insertAskBoard(a);
		
	}
	@Override
	public List<AskBoard> selectAskByClassno(int classno) {
		// TODO Auto-generated method stub
		return userDao.selectAskByClassno(classno);
	}
	@Override
	public int insertWish(Classwish c) {
		return userDao.insertWish(c);
		
	}
	@Override
	public List<Map<String, Object>> getAskAndComm(int classno) {
		// TODO Auto-generated method stub
		return userDao.getAskAndComm(classno);
	}

}
