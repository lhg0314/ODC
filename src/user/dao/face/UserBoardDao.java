package user.dao.face;

import java.util.List;
import java.util.Map;

import util.Paging;

public interface UserBoardDao {

	int selectUserNoById(String userid);

	int selectCntReviewByUserNo(String search, int userno);

	List<Map<String, Object>> selectCntReviewByUserNo(Paging paging, int userno);

}
