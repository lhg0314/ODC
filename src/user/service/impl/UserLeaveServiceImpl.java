package user.service.impl;

import dto.UserInfo;
import user.dao.face.UserLeaveDao;
import user.dao.impl.UserLeaveDaoImpl;
import user.service.face.UserLeaveService;

public class UserLeaveServiceImpl implements UserLeaveService {

	
	UserLeaveDao uLeaveDao = new UserLeaveDaoImpl();
	
	
	@Override
	public boolean pwcheck(UserInfo uinfo) {
		
	int res = uLeaveDao.pwcheck(uinfo);
		
		if(res>0) return true;
		
		return false;
	}


	@Override
	public void leave(UserInfo uinfo) {
		
		uLeaveDao.leave(uinfo);
		
	}

}
