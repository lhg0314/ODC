package user.service.face;

import javax.servlet.http.HttpServletRequest;

import dto.UserInfo;

public interface UserInfoUpdateService {

	/**
	 * 사용자 정보 가져오기
	 * @param u
	 * @return
	 */
	UserInfo userInfoLoad(UserInfo u);

	/**
	 * 사용자 정보 수정하기
	 * @param req
	 * @return
	 */
	void userInfoUpdate(HttpServletRequest req);

}
