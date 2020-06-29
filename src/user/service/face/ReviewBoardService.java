package user.service.face;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Pagingphoto;

public interface ReviewBoardService {

	/**
	 * reviewboard 전체 조회 (포토후기)
	 * @param paging 
	 * @return
	 */
	public ArrayList<Map<String, Object>> reviewboard(Pagingphoto paging);

	/**
	 * 포토후기 페이징
	 * @param req
	 * @return
	 */
	public Pagingphoto getPagingreview(HttpServletRequest req);

	/**
	 * 후기 게시판 - 글
	 * @param req
	 * @return
	 */
	public Pagingphoto getPagingreviewcontent(HttpServletRequest req);

	/**
	 * reviewboard 전체 조회 (글)
	 * @param paging
	 * @return
	 */
	public ArrayList<Map<String, Object>> reviewboardcontent(Pagingphoto paging);

	/**
	 * 클래스 이름 검색 파라미터 추출
	 * @param req
	 * @return
	 */
	public String getclassnameparam(HttpServletRequest req);

	/**
	 * 검색 사진 페이징
	 * @param req
	 * @param classname
	 * @return
	 */
	public Pagingphoto getPagingreviewsearchpho(HttpServletRequest req, String classname);

	/**
	 * 클래스 이름 검색 - 포토
	 * @param paging
	 * @param classname
	 * @return
	 */
	public ArrayList<Map<String, Object>> searchreviewboardpho(Pagingphoto paging, String classname);

	/**
	 * 검색 글 페이징
	 * @param req
	 * @param classname
	 * @return
	 */
	public Pagingphoto getPagingreviewsearchcont(HttpServletRequest req, String classname);

	/**
	 * 검색 글 리스트
	 * @param paging
	 * @param classname
	 * @return
	 */
	public ArrayList<Map<String, Object>> searchreviewboardcont(Pagingphoto paging, String classname);

}
