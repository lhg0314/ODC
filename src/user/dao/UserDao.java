package user.dao;

import dto.UserInfo;

public interface UserDao {

	int idCheck(String id);

	void insertUser(UserInfo user);

	int userLogin(String id, String pw);

	int userIdChkByEN(String email, String name);

	String selectUserIdByEN(String email, String name);

	int userPwChkByEN(String email, String name, String id);

	String selectUserPwByEN(String email, String name, String id);

}
