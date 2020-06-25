package user.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;

public interface UserBoardService {

	int getUserNoById(String userid);

	Paging getPagingReviewByUserNo(HttpServletRequest req, int userno);

	List<Map<String, Object>> selectReviewByUserNo(Paging paging, int userno);

	Paging getPagingAskByUserNo(HttpServletRequest req, int userno);

	List<Map<String, Object>> selectAskByUserNo(Paging paging, int userno);

}
