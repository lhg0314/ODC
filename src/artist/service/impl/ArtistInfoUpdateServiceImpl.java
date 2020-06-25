package artist.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import artist.dao.face.ArtistInfoUpdateDao;
import artist.dao.impl.ArtistInfoUpdateDaoImpl;
import artist.service.face.ArtistInfoUpdateService;
import dto.ArtistInfo;

public class ArtistInfoUpdateServiceImpl implements ArtistInfoUpdateService {

	
	ArtistInfoUpdateDao artUpdateDao = new ArtistInfoUpdateDaoImpl();
	
	
	@Override
	public ArtistInfo artInfoLoad(ArtistInfo a) {
		
		return artUpdateDao.artInfoLoad(a);
	}


	@Override
	public void artInfoUpdate(HttpServletRequest req) {
		
		HttpSession session =  req.getSession();
		
		//ArtistInfo 객체 만들어서 id 넣어주기
		ArtistInfo a = new ArtistInfo();
		a.setArtid((String)session.getAttribute("artid"));
		
		//ArtistInfo 싹 가져오기
		ArtistInfo aa = artInfoLoad(a);
		String pw = aa.getArtpw();
		
		
		ArtistInfo ainfo = new ArtistInfo();
		
		//사용자가 입력한 값 넣어주기
		ainfo.setArtName(req.getParameter("artname")); //이름
		ainfo.setArtid((String)session.getAttribute("artid")); //아이디
		ainfo.setArtNick(req.getParameter("artnick")); //닉네임
		ainfo.setArtPhone(Long.parseLong(req.getParameter("artphone"))); //휴대폰
		ainfo.setArtTel(Long.parseLong(req.getParameter("arttelephone"))); //공방전화
		ainfo.setArtContent(req.getParameter("artContent")); //소개글
		
		
		//생일
		String birth = req.getParameter("artbirth");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date todate = null;
		try {
			todate = transFormat.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	    java.sql.Date sqlDate = new java.sql.Date(todate.getTime());
		ainfo.setArtBirth(sqlDate);
				
		
		//비밀번호
		if(req.getParameter("artpw") != null && req.getParameter("artpw") != "" ) {
			
			ainfo.setArtpw(req.getParameter("artpw")); //입력된 비밀번호
			
		} else {
			
			ainfo.setArtpw(pw); //기존 비밀번호
		}
		
		
		
		
		//주소
		String addr = req.getParameter("addr1") +";"+req.getParameter("addr2")+ ";"+req.getParameter("addr3");
		ainfo.setArtAddr(addr);
		
		
		//정보 수정하기
		artUpdateDao.artInfoUpdate(ainfo);
		
	}

}
