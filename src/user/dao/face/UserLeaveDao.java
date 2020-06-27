package user.dao.face;

import dto.UserInfo;

public interface UserLeaveDao {

	/**
	 * 
	 * @param uinfo
	 * @return
	 */
	int pwcheck(UserInfo uinfo);

	/**
	 * 회원정보 바꾸기
	 * @param uinfo
	 */
	void leave(UserInfo uinfo);

}
