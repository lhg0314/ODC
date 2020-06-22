package admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.ClassCheckPostDao;
import admin.dao.impl.ClassCheckPostDaoImpl;
import admin.service.face.AdminClassService;
import dto.ClassInfo;
import util.Paging;

public class AdminClassServiceImpl implements AdminClassService {
	
	private ClassCheckPostDao classCheckPostDao = new ClassCheckPostDaoImpl();

	//-----------20200620 구동영 클래스 검토/게시/삭제------------------------------------
	@Override
	public Paging getPagingPostClass(HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
//		System.out.println("curPage : " + curPage);
		
		//검색어
		String search = (String)req.getParameter("search");

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = classCheckPostDao.selectCntAll(search);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);

		return paging;
		
	}
	
	@Override
	public Paging getPagingCheckClass(HttpServletRequest req) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
//		System.out.println("curPage : " + curPage);
		
		//검색어
		String search = (String)req.getParameter("search");

		
		// 검토클래스를 대상으로 Paging 객체를 생성하고 반환
		int totalCount = classCheckPostDao.selectCntclassCheck(search);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);

		return paging;
		
	}
	

	@Override
	public Paging getPagingBookingClass(HttpServletRequest req, int classno) {
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
//		System.out.println("curPage : " + curPage);

		
		// 클래스 예약 현황을 대상으로 Paging 객체를 생성하고 반환
		int totalCount = classCheckPostDao.selectCntBookingClass(classno);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);

		return paging;
		
	}
	
	@Override
	public Paging getPagingClassReview(HttpServletRequest req, int classno) {
		
		//요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param!=null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		}
//		System.out.println("curPage : " + curPage);

		
		// 클래스 예약 현황을 대상으로 Paging 객체를 생성하고 반환
		int totalCount = classCheckPostDao.selectCntClassReview(classno);
		
		// Paging 객체 생성 
		Paging paging = new Paging(totalCount, curPage);

		return paging;

	}


	
	@Override
	public List<Map<String, Object>> selectAllClass(Paging paging) {
		return classCheckPostDao.selectAllClass(paging);
	}

	@Override
	public List<Map<String, Object>> selectAllClassCheck(Paging paging) {
		
		return classCheckPostDao.selectAllClassCheck(paging);
		
	}

	@Override
	public Map<String, Object> selectClassByClassNo(int classno) {
		return classCheckPostDao.selectClassByClassNo(classno);
	}
	
	@Override
	public void updatePostStatus(ClassInfo classInfo) {
		classCheckPostDao.updatePostStatus(classInfo);
	}

	@Override
	public void updateClassCheck(ClassInfo classInfo) {
		classCheckPostDao.updateClassCheck(classInfo);
	}

	@Override
	public List<Map<String, Object>> selectClassBookingByClassNo(Paging paging, int classno) {
		return classCheckPostDao.selectClassBookingByClassNo(paging, classno);
	}


	@Override
	public List<Map<String, Object>> selectClassReviewByClassNo(Paging paging, int classno) {
		return classCheckPostDao.selectClassReviewByClassNo(paging, classno);
	}

	
	//-----------------------------------------------------------------

}
