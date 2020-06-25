package user.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import user.dao.UserMyPageClassDao;
import user.dao.UserMyPageClassDaoImpl;

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
	

}
