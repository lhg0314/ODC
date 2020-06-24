package admin.dao.face;

import java.util.List;
import java.util.Map;

import dto.NoticeBoard;
import util.Paging;

public interface AdminBoardDao {

	int selectCntAllNotice();
	List<NoticeBoard> selectAllNotice(Paging paging);

	int selectCntAllReview(String search);
	List<Map<String, Object>> selectAllReview(Paging paging);

	void deleteNoticeList(String names);
	void deleteReviewList(String names);

}
