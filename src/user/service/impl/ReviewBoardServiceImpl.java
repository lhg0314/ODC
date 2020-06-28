package user.service.impl;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import user.dao.face.ReviewBoardDao;
import user.dao.impl.ReviewBoardDaoImpl;
import user.service.face.ReviewBoardService;
import util.Pagingphoto;

public class ReviewBoardServiceImpl implements ReviewBoardService{
	private ReviewBoardDao reviewboardDao = new ReviewBoardDaoImpl();
	
	@Override
	public Pagingphoto getPagingreview(HttpServletRequest req) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//reviewboard 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewboardDao.reviewboardCntAll();
		
		//paging객체 생성
		Pagingphoto paging = new Pagingphoto(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public ArrayList<Map<String, Object>> reviewboard(Pagingphoto paging) {
		ArrayList<Map<String, Object>> reviewboard  = reviewboardDao.reviewboard(paging);
		return reviewboard;
	}
	
	@Override
	public Pagingphoto getPagingreviewcontent(HttpServletRequest req) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//reviewboard 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewboardDao.reviewboardcontentCntAll();
		
		//paging객체 생성
		Pagingphoto paging = new Pagingphoto(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public ArrayList<Map<String, Object>> reviewboardcontent(Pagingphoto paging) {
		ArrayList<Map<String, Object>> reviewboardcontent  = reviewboardDao.reviewboardcontent(paging);
		return reviewboardcontent;
	}
	
	@Override
	public String getclassnameparam(HttpServletRequest req) {
		String classname = req.getParameter("classname");
		return classname;
	}
	
	@Override
	public Pagingphoto getPagingreviewsearchpho(HttpServletRequest req, String classname) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//reviewboard 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewboardDao.reviewboardsearchphoCntAll(classname);
		
		//paging객체 생성
		Pagingphoto paging = new Pagingphoto(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public ArrayList<Map<String, Object>> searchreviewboardpho(Pagingphoto paging, String classname) {
		ArrayList<Map<String, Object>> searchreviewboardpho  = reviewboardDao.searchreviewboardpho(paging,classname);
		return searchreviewboardpho;
	}

	@Override
	public Pagingphoto getPagingreviewsearchcont(HttpServletRequest req, String classname) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//reviewboard 테이블의 총 게시글 수를 조회한다
		int totalCount = reviewboardDao.reviewboardsearchcontCntAll(classname);
		
		//paging객체 생성
		Pagingphoto paging = new Pagingphoto(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public ArrayList<Map<String, Object>> searchreviewboardcont(Pagingphoto paging, String classname) {
		ArrayList<Map<String, Object>> searchreviewboardcont  = reviewboardDao.searchreviewboardcont(paging,classname);
		return searchreviewboardcont;
	}
	
}
