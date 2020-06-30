// 이인주 20200621 관리자 사업자 수익 확인 
package admin.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import admin.dao.face.AdminSalesDao;
import admin.dao.impl.AdminSalesDaoImpl;
import admin.service.face.AdminSalesServlce;
import util.Paging;

public class AdminSalesServiceImpl implements AdminSalesServlce{
	
	private AdminSalesDao adminSalesDao = new AdminSalesDaoImpl();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//classbooking 테이블의 총 게시글 수를 조회한다
		int totalCount = adminSalesDao.selectCntAll();
		
		//paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public Paging nowgetPaging(HttpServletRequest req,Date[] nowyearday) {
		
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//classbooking 테이블의 총 게시글 수를 조회한다
		int totalCount = adminSalesDao.nowselectCntAll(nowyearday);
		
		//paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public Paging chogetPaging(HttpServletRequest req, Date[] chooseyearday) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//classbooking 테이블의 총 게시글 수를 조회한다
		int totalCount = adminSalesDao.choselectCntAll(chooseyearday);
		
		//paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public Paging artidnowgetPaging(HttpServletRequest req, String artid, Date[] nowyearday) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//classbooking 테이블의 총 게시글 수를 조회한다
		int totalCount = adminSalesDao.artidnowselectCntAll(artid,nowyearday);
		
		//paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public Paging artsearchchoPaging(HttpServletRequest req, String artid, Date[] chooseyearday) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//classbooking 테이블의 총 게시글 수를 조회한다
		int totalCount = adminSalesDao.artsearchchoselectCntAll(artid,chooseyearday);
		
		//paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
	}
	
	@Override
	public ArrayList<Map<String, Object>> nowselectadminsaleslistAll(Paging paging,Date[] nowyearday) {
		ArrayList<Map<String, Object>> nowadminsaleslist = adminSalesDao.nowselectadminsaleslistAll(paging,nowyearday);
		return nowadminsaleslist;
	}
	
	@Override
	public ArrayList<Map<String, Object>> choselectadminsaleslistAll(Paging paging,Date[] chooseyearday) {
		ArrayList<Map<String, Object>> choadminsaleslist = adminSalesDao.choselectadminsaleslistAll(paging,chooseyearday);
		return choadminsaleslist;
	}
	
	@Override
	public int getparmmonth(HttpServletRequest req) {
		//전달 파라미터  추출
		int month = 0;
		String param = req.getParameter("month");
		if(param != null && !"".equals(param)) {
			month = Integer.parseInt(param);
		}
		return month;
	}
	
	@Override
	public Date[] nowyearday() {
		
		//현재 날짜 기준 년원일
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMM");
		Date nowdat = new Date();
		String resday = format.format(nowdat);
		
		String  nowyearday01 = null;
		String  nowyearday31 = null;
		
		switch(resday) {
	    case "202001": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"32";
	         break;
	    case "202002":
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"30";
	    	break;
	    case "202003": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"32";
	    	break;
	    case "202004": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"31";
	    	break;
	    case "202005": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"32";
	    	break;
	    case "202006": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"31";
	    	break;
	    case "202007": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"32";
	    	break;
	    case "202008":
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"32";
	    	break;
	    case "202009": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"31";
	    	break;
	    case "202010": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"32";
	    	break;
	    case "202011": 
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"31";
	    	break;
	    case "202012":
	    	nowyearday01 = resday+"01";
			nowyearday31 = resday+"32";
	    	break;
	   
		}
		
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		Date res01 = null;
		Date res31 = null;
		
		try {
			res01 = fm.parse(nowyearday01);
			res31 = fm.parse(nowyearday31);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date[]	nowyearday = {res01, res31};
				
		return nowyearday;
	}
	
	@Override
	public Date[] chooseyearday(int month) {
		
		//현재 날짜 기준 년원일
		SimpleDateFormat format = new SimpleDateFormat ( "yyyy");
		Date nowyear = new Date();
		String resday = format.format(nowyear);
		
		String  chooseyearday01 = null;
		String  chooseyearday31 = null;
		
		
		switch(month) {
	    case 1: 
	    	chooseyearday01 = resday+"0101";
	    	chooseyearday31 = resday+"0132";
	         break;
	    case 2:
	    	chooseyearday01 = resday+"0201";
	    	chooseyearday31 = resday+"0230";
	    	break;
	    case 3: 
	    	chooseyearday01 = resday+"0301";
	    	chooseyearday31 = resday+"0332";
	    	break;
	    case 4:
	    	chooseyearday01 = resday+"0401";
	    	chooseyearday31 = resday+"0431";
	    	break;
	    case 5: 
	    	chooseyearday01 = resday+"0501";
	    	chooseyearday31 = resday+"0532";
	    	break;
	    case 6: 
	    	chooseyearday01 = resday+"0601";
	    	chooseyearday31 = resday+"0631";
	    	break;
	    case 7: 
	    	chooseyearday01 = resday+"0701";
	    	chooseyearday31 = resday+"0732";
	    	break;
	    case 8:
	    	chooseyearday01 = resday+"0801";
	    	chooseyearday31 = resday+"0832";
	    	break;
	    case 9: 
	    	chooseyearday01 = resday+"0901";
	    	chooseyearday31 = resday+"0931";
	    	break;
	    case 10: 
	    	chooseyearday01 = resday+"1001";
	    	chooseyearday31 = resday+"1032";
	    	break;
	    case 11: 
	    	chooseyearday01 = resday+"1101";
	    	chooseyearday31 = resday+"1131";
	    	break;
	    case 12:
	    	chooseyearday01 = resday+"1201";
	    	chooseyearday31 = resday+"1232";
	    	break;
	   
		}

		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		Date res01 = null;
		Date res31 = null;
		
		try {
			res01 = fm.parse(chooseyearday01);
			res31 = fm.parse(chooseyearday31);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Date[]	chooseyearday = {res01, res31};
				
		return chooseyearday;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> nowselectartsaleslistAll(Paging paging,Date[] nowyearday) {
		ArrayList<Map<String, Object>> nowartsaleslist = adminSalesDao.nowselectartsaleslistAll(paging,nowyearday);
		return nowartsaleslist;
	}
	
	@Override
	public ArrayList<Map<String, Object>> choselectartsaleslistAll(Paging paging, Date[] chooseyearday) {
		ArrayList<Map<String, Object>> choartsaleslist = adminSalesDao.choselectartsaleslistAll(paging,chooseyearday);
		return choartsaleslist;
	}
	
	@Override
	public String searchidparam(HttpServletRequest req) {
		String artid = req.getParameter("artid");
		return artid;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> nowartsearchlist(Paging paging, String artid,Date[] nowyearday) {
		ArrayList<Map<String, Object>> nowartsearchlist = adminSalesDao.nowartsearchlist(paging,artid,nowyearday);
		return nowartsearchlist;
	}
	
	
	@Override
	public ArrayList<Map<String, Object>> choartsearchlist(Paging paging, String artid,Date[] chooseyearday) {
		ArrayList<Map<String, Object>> choartsearchlist = adminSalesDao.chooseyearday(paging,artid,chooseyearday);
		return choartsearchlist;
	}
	
	@Override
	public int nowtotalsales(Date[] nowyearday) {
		int nowtotalsales = adminSalesDao.nowtotalsales(nowyearday);
		return nowtotalsales;
	}
	
	@Override
	public int chototalsales(Date[] chooseyearday) {
		int chototalsales = adminSalesDao.chototalsales(chooseyearday);
		return chototalsales;
	}
	
	@Override
	public int nowsearchtotalsales(String artid,Date[] nowyearday) {
		int nowsearchtotal = adminSalesDao.nowsearchtotalsales(artid,nowyearday);
		return nowsearchtotal;
	}
	
	@Override
	public int chosearchtotalsales(String artid, Date[] chooseyearday) {
		int chosearchtotal = adminSalesDao.chosearchtotalsales(artid,chooseyearday);
		return chosearchtotal;
	}
}
