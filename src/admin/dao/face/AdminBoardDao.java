package admin.dao.face;

import java.util.List;

import dto.NoticeBoard;
import util.Paging;

public interface AdminBoardDao {

	int selectCntAllNotice();

	List<NoticeBoard> selectAllNotice(Paging paging);

	void deleteNoticeList(String names);


}
