package user.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ClassBooking;
import user.dao.UserMyPageClassDaoImpl;
import user.dao.face.UserMyPageClassDao;
import user.service.face.UserMyPageClassService;

public class UserMyPageClassServiceImpl implements UserMyPageClassService{
	private UserMyPageClassDao usermypageclassDao = new UserMyPageClassDaoImpl();
	
	@Override
	public Date nowday() {
		//현재 날짜 기준 년원일
		SimpleDateFormat format = new SimpleDateFormat ( "yyyyMMdd");
		Date nowdat = new Date();
		String resday = format.format(nowdat);
		
		Date nowday = null;
		
		try {
			nowday = format.parse(resday);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
						
		return nowday;
	}
	
	@Override
	public ArrayList<Map<String, Object>> userbooking(String userid, Date nowday) {
		ArrayList<Map<String, Object>> userbooking = usermypageclassDao.userbooking(userid,nowday);
		return userbooking;
	}
	
	@Override
	public int bookingnoparam(HttpServletRequest req) {

		String param = req.getParameter("bookingno");
		
        int bookingno = 0;
        if( param != null && !"".equals(param)) {
        	bookingno  = Integer.parseInt(param);
        }
		
		return bookingno;
	}
	
	@Override
	public int bookingcancel(int bookingno) {
		int bookingcancel  = usermypageclassDao.bookingcancel(bookingno);
		return bookingcancel;
	}
	
	@Override
	public ArrayList<Map<String, Object>> userwish(String userid) {
		ArrayList<Map<String, Object>> userwish = usermypageclassDao.userwish(userid);
		return userwish;
	}
	
	@Override
	public int wishnoparam(HttpServletRequest req) {
		String param = req.getParameter("wishno");
		
        int wishno = 0;
        if( param != null && !"".equals(param)) {
        	wishno  = Integer.parseInt(param);
        }
		
		return wishno;
	}
	
	@Override
	public void wishcancel(int wishno) {
		usermypageclassDao.wishcancel(wishno);
	}
	
	@Override
	public Map<String, Object> classpayment(String userid, int wishno) {
		Map<String, Object> classpayment = usermypageclassDao.classpayment(userid,wishno);
		return classpayment;
	}
	
	@Override
	public int userno(String userid) {
		int userno = usermypageclassDao.userno(userid);
		return userno;
	}
	
	@Override
	public int classbookingno() {
		int classbookingno = usermypageclassDao.classbookingno();
		return classbookingno;
	}
	
	@Override
	public Map<String,Object> paymentparam(HttpServletRequest req) {
		
		Map<String, Object> paymentparam = new HashMap<String,Object>();
		
		//String merchant_uid - 고유주문번호 - random, unique 
		paymentparam.put("merchantuid",req.getParameter("merchant_uid"));
		
		//String classname - 주문명 - 선택항목, 결제정보 확인을 위한 입력, 16자 이내로 작성
//		paymentparam.put("classname",req.getParameter("name"));
		
		//int totalprice 결제금액 - 필수항목
		String param = req.getParameter("amount");
		if(param != null && !"".equals(param)) {
			paymentparam.put("totalprice",Integer.parseInt(param));
		}
		
		//String useremail 주문자Email - 선택항목
		paymentparam.put("useremail",req.getParameter("buyer_email"));
		
		//String username  주문자명 - 선택항목
		paymentparam.put("username",req.getParameter("buyer_name"));
		
		//Long userphone 주문자연락처 - 필수항목, 누락되면 PG사전송 시 오류 발생
		param = req.getParameter("userphone");
		if(param != null && !"".equals(param)) {
			paymentparam.put("userphone",Long.parseLong(param));
		}
		
		//Date bookingdate //클래스 예약날짜
		param = req.getParameter("bookingdate");
		if(param != null && !"".equals(param)) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			
			try {
				paymentparam.put("bookingdate",format.parse(param));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//int wishcount // 예약인원
		param = req.getParameter("wishcount");
		if(param != null && !"".equals(param)) {
			paymentparam.put("wishcount",Integer.parseInt(param));
		}
		
		//int classno // 클래스 번호
		param = req.getParameter("classno");
		if(param != null && !"".equals(param)) {
			paymentparam.put("classno",Integer.parseInt(param));
		}
		
		return paymentparam;
	}
	
	@Override
	public void insertclassbooking(int classbookingno, int userno, Map<String, Object> paymentparam) {
		usermypageclassDao.insertclassbooking(classbookingno,userno,paymentparam);
		
	}

}
