package user.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import user.dao.UserInfoUpdateDao;
import user.dao.UserInfoUpdateDaoImpl;

public class UserInfoUpdateServiceImpl implements UserInfoUpdateService {

	
	UserInfoUpdateDao userUpdateDao = new UserInfoUpdateDaoImpl();
	
	
	@Override
	public UserInfo userInfoLoad(UserInfo u) {
		
		//사용자정보 가져오기
		return userUpdateDao.userInfoLoad(u);
	}


	
	@Override
	public void userInfoUpdate(HttpServletRequest req) {
		
		
		HttpSession session =  req.getSession();
		
		
		//UserInfo 객체 만들어서 id 넣어주기
		UserInfo u = new UserInfo();
		u.setUserid((String)session.getAttribute("userid"));
		
		
		//UserInfo 싹 가져오기
		UserInfo uu = userInfoLoad(u);
		String pw = uu.getUserpw();
		
		
		UserInfo uinfo = new UserInfo();
		
		
		//사용자가 입력한 값 넣어주기
		uinfo.setUsername(req.getParameter("username")); //이름
		uinfo.setUserid((String)session.getAttribute("userid")); //아이디
		uinfo.setUserphone(Long.parseLong(req.getParameter("userphone"))); //휴대폰번호
		uinfo.setUsernick(req.getParameter("usernick")); //닉네임
		
		
		if(req.getParameter("userpw") != null && req.getParameter("userpw") != "" ) {
			
			uinfo.setUserpw(req.getParameter("userpw")); //입력된 비밀번호
			
		} else {
			
			uinfo.setUserpw(pw); //기존 비밀번호
		}
		
		
		//생일
		String birth=req.getParameter("userbirth");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date todate = null;
		try {
			todate = transFormat.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	    java.sql.Date sqlDate = new java.sql.Date(todate.getTime());
		uinfo.setUserbirth(sqlDate);
		
		
		
		//정보 수정하기
		userUpdateDao.userInfoUpdate(uinfo);
		
	}

}
