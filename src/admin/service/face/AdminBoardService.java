package admin.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.NoticeBoard;
import util.Paging;

public interface AdminBoardService {

	Paging getPagingNotice(HttpServletRequest req);
	Paging getPagingReview(HttpServletRequest req);

	List<NoticeBoard> selectAllNotice(Paging paging);
	List<Map<String, Object>> selectAllReview(Paging paging);
	
	void noticeListDelete(String names);
	void reviewListDelete(String names);

}
