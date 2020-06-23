package admin.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.NoticeBoard;
import dto.ReviewBoard;
import util.Paging;

public interface AdminBoardService {

	Paging getPagingNotice(HttpServletRequest req);
	Paging getPagingReview(HttpServletRequest req);

	List<NoticeBoard> selectAllNotice(Paging paging);
	List<ReviewBoard> selectAllReview(Paging paging);
	
	void boardListDelete(String names);

}
