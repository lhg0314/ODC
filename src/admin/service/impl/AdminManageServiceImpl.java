package admin.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.ArtManageDao;
import admin.dao.face.UserManageDao;
import admin.dao.impl.ArtManageDaoImpl;
import admin.dao.impl.UserManageDaoImpl;
import admin.service.face.AdminManageService;
import dto.ArtistDetail;
import dto.ArtistInfo;
import dto.AskBoard;
import dto.ClassBooking;
import dto.ClassInfo;
import dto.ReviewBoard;
import dto.UserInfo;
import util.Paging;

/* 
 * 200620 이서연
 */

public class AdminManageServiceImpl implements AdminManageService {

	
	UserManageDao userManageDao = new UserManageDaoImpl();
	ArtManageDao artManageDao = new ArtManageDaoImpl();
	
	
	@Override
	public Paging getPagingUser(HttpServletRequest req) {
		
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			
			curPage = Integer.parseInt(param);
		}
		
		
		//검색어
		String search = (String)req.getParameter("search");
		
		
		//userInfo 테이블의 총 사용자 수를 조회한다
		int totalCount = userManageDao.selectCntAllUser(search);
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);
		
		//계산된 Paging 객체 반환		
		return paging;
		
	}
	
	

	@Override
	public Paging getPagingArt(HttpServletRequest req) {
		
		//전달파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			
			curPage = Integer.parseInt(param);
		}
		
		
		//검색어
		String search = (String)req.getParameter("search");
		
				
		
		//artistInfo 테이블의 총 작가 수를 조회한다
		int totalCount = artManageDao.selectCntAllArt(search);
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//검색어
		paging.setSearch(search);
		
		//계산된 Paging 객체 반환		
		return paging;
	}

	

	@Override
	public List<UserInfo> selectAllUser(Paging paging) {
		
		return userManageDao.selectAllUser(paging);
	}


	@Override
	public List<ArtistInfo> selectAllArt(Paging paging) {

		return artManageDao.selectAllArt(paging);
	}



	@Override
	public UserInfo selectUserno(HttpServletRequest req) {
		
		UserInfo userInfo = new UserInfo();
		
		userInfo.setUserno(Integer.parseInt(req.getParameter("userno")));
		
		return userManageDao.selectByUserno(userInfo);
	}



	@Override
	public List<Map<String, Object>> bookingList(ClassBooking book) {
		
		return userManageDao.bookingList(book);
	}



	@Override
	public List<Map<String, Object>> reviewList(ReviewBoard review) {
		
		return userManageDao.reviewList(review);
	}



	@Override
	public List<AskBoard> askList(AskBoard ask) {
		
		return userManageDao.askList(ask);
	}



	@Override
	public ArtistInfo selectArtistno(HttpServletRequest req) {
		
		ArtistInfo artistInfo = new ArtistInfo();
		
		artistInfo.setArtno(Integer.parseInt(req.getParameter("artno")));
		
		return artManageDao.selectByArtno(artistInfo);
	}



	@Override
	public ArtistDetail selectArtistDetail(HttpServletRequest req) {
		
		ArtistDetail artistDetail = new ArtistDetail();
		
		artistDetail.setArtno(Integer.parseInt(req.getParameter("artno")));
		
		return artManageDao.selectArtDetail(artistDetail);
	}



	@Override
	public List<ClassInfo> classList(ClassInfo classInfo) {
		
		return artManageDao.classList(classInfo);
	}



	@Override
	public List<Map<String, Object>> askCommList(HttpServletRequest req) {
		
		AskBoard ab = new AskBoard();
		
		ab.setArtno(Integer.parseInt(req.getParameter("artno")));
		
		return artManageDao.askCommList(ab) ;
	}




}
