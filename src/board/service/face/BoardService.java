package board.service.face;

import dto.NoticeBoard;

public interface BoardService {

	public void boardListDelete(String names);

	/**
	 * 공지사항 올리기
	 * @param noticeBoard
	 */
	public void insertNotice(NoticeBoard noticeBoard);

	/**
	 * 공지사항 내용 가져오기
	 * @param noticeno
	 * @return
	 */
	public NoticeBoard selectNoticeBoard(int noticeno);

	/**
	 * 공지사항 수정하기
	 * @param noticeBoard
	 */
	public void updateNotice(NoticeBoard noticeBoard);

}
