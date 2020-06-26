package user.dao;

import dto.UserInfo;

public interface UserInfoUpdateDao {

	/**
	 * 사용자 정보 가져오기
	 * @param u
	 * @return
	 */
	public UserInfo userInfoLoad(UserInfo u);

	/**
	 * 사용자 정보 수정하기
	 * @param uinfo
	 * @return
	 */
	public void userInfoUpdate(UserInfo uinfo);

}
