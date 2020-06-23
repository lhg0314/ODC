package board.service.impl;

import board.dao.face.BoardDao;
import board.dao.impl.BoardDaoImpl;
import board.service.face.BoardService;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao = new BoardDaoImpl();
	
	@Override
	public void boardListDelete(String names) {
		boardDao.deleteNoticeList(names);
	}

}
