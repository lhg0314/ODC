package user.dao.face;

import java.util.List;
import java.util.Map;

import util.Paging;

public interface UserBoardDao {

	int selectUserNoById(String userid);

	int selectCntReviewByUserNo(String search, int userno);

	List<Map<String, Object>> selectReviewByUserNo(Paging paging, int userno);

	int selectCntAskByUserNo(String search, int userno);

	List<Map<String, Object>> selectAskByUserNo(Paging paging, int userno);

	void deleteReviewListByUserNo(String names, int userno);

	void deleteAskListByUserNo(String names, int userno);

	Map<String, Object> selectAskByAskNo(int askno);

}
