package user.service;

import dto.UserInfo;

public interface UserService {
	public int idCheck(String id);

	public void insertUser(UserInfo user);

	public boolean userLogin(String id, String pw);
}
