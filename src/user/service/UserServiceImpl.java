package user.service;

import dto.UserInfo;
import user.dao.UserDao;
import user.dao.UserDaoImpl;

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

}
