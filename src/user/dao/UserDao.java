package user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dto.AskBoard;
import dto.ClassFile;
import dto.ClassInfo;
import dto.Classwish;
import dto.Donation;
import dto.ReviewBoard;
import dto.UserInfo;

public interface UserDao {

	int idCheck(String id);

	void insertUser(UserInfo user);

	int userLogin(String id, String pw);

	int userIdChkByEN(String email, String name);

	String selectUserIdByEN(String email, String name);

	int userPwChkByEN(String email, String name, String id);

	String selectUserPwByEN(String email, String name, String id);

	List<Map<String, Object>> getDetailReview(int classno);

	void insertReview(ReviewBoard board);

	int getUserIdById(String id);

	void insertAskBoard(AskBoard a);

	List<AskBoard> selectAskByClassno(int classno);

	int insertWish(Classwish c);

	List<Map<String, Object>> getAskAndComm(int classno);

	List<Map<String, Object>> getClassList(int artno);

	int insertDonation(Donation d);

	ArrayList<Map<String, Object>> getReviewbyClassno(int classno);

	List<ClassFile> selectDetailFileByClssno(int classno);

}
