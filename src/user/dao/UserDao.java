package user.dao;

import dto.UserInfo;

public interface UserDao {

	int idCheck(String id);

	void insertUser(UserInfo user);

	int userLogin(String id, String pw);

}
