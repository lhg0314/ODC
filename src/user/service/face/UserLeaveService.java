package user.service.face;

import dto.UserInfo;

public interface UserLeaveService {

	/**
	 * 아이디비번체크
	 * @param uinfo
	 * @return
	 */
	boolean pwcheck(UserInfo uinfo);

	
	/**
	 * 회원정보 0으로 바꾸기
	 * @param uinfo
	 */
	void leave(UserInfo uinfo);

}
