package user.dao.face;

import java.util.ArrayList;
import java.util.Map;

import util.Pagingphoto;

public interface ReviewBoardDao {

	/**
	 * reviewboard 전체 조회 (포토)
	 * @param paging 
	 * @return
	 */
	public ArrayList<Map<String, Object>> reviewboard(Pagingphoto paging);

	/**
	 * 포토후기 개수
	 * @return
	 */
	public int reviewboardCntAll();

	/**
	 * 후기게시판 - 글 개수
	 * @return
	 */
	public int reviewboardcontentCntAll();

	/**
	 * reviewboard 전체 조회 (글)
	 * @param paging
	 * @return
	 */
	public ArrayList<Map<String, Object>> reviewboardcontent(Pagingphoto paging);

	/**
	 * 검색한 클래스 갯수
	 * @param classname
	 * @return
	 */
	public int reviewboardsearchphoCntAll(String classname);

	/**
	 * 클래스 이름 검색 - pho
	 * @param paging
	 * @param classname
	 * @return
	 */
	public ArrayList<Map<String, Object>> searchreviewboardpho(Pagingphoto paging, String classname);

	/**
	 * 검색 글 개수
	 * @param classname
	 * @return
	 */
	public int reviewboardsearchcontCntAll(String classname);

	/**
	 * 검색 글 리스트 전체 조회
	 * @param paging
	 * @param classname
	 * @return
	 */
	public ArrayList<Map<String, Object>> searchreviewboardcont(Pagingphoto paging, String classname);

}
