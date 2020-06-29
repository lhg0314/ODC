package board.service.impl;

import board.dao.face.BoardDao;
import board.dao.impl.BoardDaoImpl;
import board.service.face.BoardService;
import dto.NoticeBoard;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public void boardListDelete(String names) {
		boardDao.deleteNoticeList(names);
	}

	@Override
	public void insertNotice(NoticeBoard noticeBoard) {	
		boardDao.insertNotice(noticeBoard);
	}

	@Override
	public NoticeBoard selectNoticeBoard(int noticeno) {
		return boardDao.selectNoticeBoard(noticeno);
	}

	@Override
	public void updateNotice(NoticeBoard noticeBoard) {
		boardDao.updateNotice(noticeBoard);
	}

}
