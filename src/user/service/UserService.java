package user.service;

import dto.UserInfo;

public interface UserService {
	public int idCheck(String id);

	public void insertUser(UserInfo user);

	public boolean userLogin(String id, String pw);

	public int selectUserIdByEN(String email, String name);

	public String getIdByEN(String email, String name);

	public int selectUserPwByEN(String email, String name, String id);

	public String getPwByEN(String email, String name, String id);
}
