package board.dao.face;

import dto.NoticeBoard;

public interface BoardDao {

	public void deleteNoticeList(String names);

	/**
	 * 공지사항 올리기
	 * @param noticeBoard
	 */
	public void insertNotice(NoticeBoard noticeBoard);

	/**
	 * 공지사항 상세보기
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
