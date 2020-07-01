package main.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import main.dao.face.LocationCategoryDao;
import main.dao.impl.LocationCategoryTalentDaoImpl;
import main.service.face.LocationCategoryTalentService;
import util.Pagingphoto;

public class LocationCategoryTalentServiceImpl implements LocationCategoryTalentService {
	
	private LocationCategoryDao locCateDao = new LocationCategoryTalentDaoImpl();
	
	public List<Map<String, Object>> changeString(List<Map<String, Object>> list){
	
		for( Map<String, Object> map : list ){
			
			// 카테고리 처리
			int category = (int)map.get("category");
			
			if( category == 1) {
				map.put("category", "플라워");
			}else if( category == 2) {
				map.put("category", "음악");
			}else if( category == 3) {
				map.put("category", "수공예");
			}else if( category == 4) {
				map.put("category", "요리");
			}else if( category == 5) {
				map.put("category", "뷰티");
			}else if( category == 6) {
				map.put("category", "미술");
			}else if( category == 7) {
				map.put("category", "기타");
			}
			
			// 지역 처리
			int loc = (int)map.get("location");
			
			if( loc == 1) {
				map.put("location", "서울");
			}else if( loc == 2) {
				map.put("location", "경기");
			}else if( loc == 3) {
				map.put("location", "강원");
			}else if( loc == 4) {
				map.put("location", "충청");
			}else if( loc == 5) {
				map.put("location", "경상");
			}else if( loc == 6) {
				map.put("location", "전라");
			}else if( loc == 7) {
				map.put("location", "제주");
			}
			
		}
		
		return list;
	}

	@Override
	public List<Map<String, Object>> selectClassByLocation(Pagingphoto paging, int location) {
		
		List<Map<String, Object>> list = locCateDao.selectClassByLocation(paging, location);
		
		list = changeString(list);
		
		return list;
	}

	@Override
	public String getLocation(HttpServletRequest req, int location) {
		
		
		String msg = new String();
		
		if( location == 0) {
			msg = "전체";
		}else if(location == 1) {
			msg = "서울";
		}else if(location == 2) {
			msg = "경기";
		}else if(location == 3) {
			msg = "강원";
		}else if(location == 4) {
			msg = "충청";
		}else if(location == 5) {
			msg = "경상";
		}else if(location == 6) {
			msg = "전라";
		}else if(location ==7) {
			msg = "제주";
		}
		
		
		return msg;
	}

	@Override
	public String getCategory(HttpServletRequest req, int category) {
		
		String msg = new String();
		
		if( category == 0) {
			msg = "전체";
		}else if(category == 1) {
			msg = "플라워";
		}else if(category == 2) {
			msg = "음악";
		}else if(category == 3) {
			msg = "수공예";
		}else if(category == 4) {
			msg = "요리";
		}else if(category == 5) {
			msg = "뷰티";
		}else if(category == 6) {
			msg = "미술";
		}else if(category ==7) {
			msg = "기타";
		}
		
		return msg;
	}

	@Override
	public List<Map<String, Object>> selectClassByCategory(Pagingphoto paging, int category) {
		List<Map<String, Object>> list = locCateDao.selectClassByCategory(paging, category);
		
		list = changeString(list);
		
		return list;
	}

	@Override
	public List<Map<String, Object>> selectClassByTalentDonation(int category) {
		List<Map<String, Object>> list = locCateDao.selectClassByTalentDonation(category);
		
		list = changeString(list);
		
		return list;
	}

	@Override
	public Pagingphoto getPagingLocation(HttpServletRequest req, int location) {
		
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = locCateDao.selectCntAllLocation(location);

		// Paging 객체 생성
		Pagingphoto paging = new Pagingphoto(totalCount, curPage);

		return paging;
	}

	@Override
	public Pagingphoto getPagingCategory(HttpServletRequest req, int category) {
		
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = locCateDao.selectCntAllCategory(category);

		// Paging 객체 생성
		Pagingphoto paging = new Pagingphoto(totalCount, curPage);

		return paging;
	}

	@Override
	public Pagingphoto getPagingTalent(HttpServletRequest req, int i) {
		
		// 요청파라미터 curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0;
		if (param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}

		// 클래스 전체 Paging 객체를 생성하고 반환
		int totalCount = locCateDao.selectCntAllTalent(i);

		System.out.println(totalCount);
		
		// Paging 객체 생성
		Pagingphoto paging = new Pagingphoto(totalCount, curPage);

		return paging;
	}

}
