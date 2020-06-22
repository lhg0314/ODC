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

}
