package artist.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import artist.dao.face.ArtistClassSalesDao;
import artist.dao.impl.ArtistClassSalesDaoImpl;
import artist.service.face.ArtistClassSalesService;
import util.Paging;

public class ArtistClassSalesServiceImpl implements ArtistClassSalesService{
	private ArtistClassSalesDao artistclasssalesDao = new ArtistClassSalesDaoImpl();
	
	@Override
	public ArrayList<Map<String, Object>> nowartsales(Paging paging,String artid, Date[] artnowday) {
		ArrayList<Map<String, Object>> nowartsales = artistclasssalesDao.nowartsales(paging,artid,artnowday);
		return nowartsales;
	}
	
	
	@Override
	public Paging getPaging(HttpServletRequest req, String artid, Date[] artnowday) {
		
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//classbooking 테이블의 총 게시글 수를 조회한다
		int totalCount = artistclasssalesDao.selectCntAll(artid,artnowday);
		
		//paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
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
			nowyearday31 = resday+"32" ;
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
	public int nowartsalestot(String artid, Date[] artnowday) {
		int nowartsalestot = artistclasssalesDao.nowtotalsales(artid,artnowday);
		return nowartsalestot;
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
	public ArrayList<Map<String, Object>> choartsales(Paging paging,String artid, Date[] chooseyearday) {
		ArrayList<Map<String, Object>> choartsales = artistclasssalesDao.choartsales(paging,artid,chooseyearday);
		return choartsales;
	}
	
	@Override
	public Paging chogetPaging(HttpServletRequest req, String artid, Date[] chooseyearday) {
		//전달 파라미터  curPage를 파싱한다
		String param = req.getParameter("curPage");
		int curPage = 0 ;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		}
		
		//classbooking 테이블의 총 게시글 수를 조회한다
		int totalCount = artistclasssalesDao.choselectCntAll(artid,chooseyearday);
		
		//paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		//계산된 Paging 객체 반환
		return paging;
		
	}
	
	@Override
	public int choartsalestot(String artid, Date[] chooseyearday) {
		int choartsalestot = artistclasssalesDao.choartsalestot(artid,chooseyearday);
		return choartsalestot;
	}
	
	
	@Override
	public String classnameparam(HttpServletRequest req) {
		//전달 파라미터  추출
		String classname = req.getParameter("classname");
		
		return classname;
	}
	
	@Override
	public ArrayList<Map<String, Object>> choartsalessearch(String artid, String classname) {
		ArrayList<Map<String, Object>> choartsalessearch = artistclasssalesDao.choartsalessearch(artid,classname);
		return choartsalessearch;
	}
	
	@Override
	public Paging searchgetPaging(HttpServletRequest req, String artid, String classname) {
		//전달 파라미터  curPage를 파싱한다
				String param = req.getParameter("curPage");
				int curPage = 0 ;
				if(param != null && !"".equals(param)) {
					curPage = Integer.parseInt(param);
				}
				
				//classbooking 테이블의 총 게시글 수를 조회한다
				int totalCount = artistclasssalesDao.searchCntAll(artid,classname);
				
				//paging객체 생성
				Paging paging = new Paging(totalCount, curPage);
				
				//계산된 Paging 객체 반환
				return paging;
	}
	
	@Override
	public int searchclassnametotal(String artid, String classname) {
		int searchclassnametotal = artistclasssalesDao.searchclassnametotal(artid,classname);
		return searchclassnametotal;
	}
}
