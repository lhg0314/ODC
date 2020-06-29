package user.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dto.ClassBooking;
import dto.ClassInfo;
import dto.UserInfo;
import user.dao.face.UserClassPaymentDao;
import user.dao.impl.UserClassPaymentDaoImpl;
import user.service.face.UserClassPaymentService;

public class UserClassPaymentServiceImpl implements UserClassPaymentService{
	private UserClassPaymentDao userclasspaymentDao = new UserClassPaymentDaoImpl();
	
	@Override
	public UserInfo userinfo(String userid) {
		UserInfo userinfo = userclasspaymentDao.userinfo(userid);
		return userinfo;
	}
	
	@Override
	public ClassBooking userclasspayment(HttpServletRequest req) {
		
		ClassBooking userclasspayment = new ClassBooking();
		
		int userno=Integer.parseInt(req.getParameter("userno"));
		userclasspayment.setUserno(userno);
		
        int count=Integer.parseInt(req.getParameter("count"));
        userclasspayment.setBookingCount(count);
        
        int total=Integer.parseInt(req.getParameter("totalPrice"));
        userclasspayment.setTotalPrice(total);
        
        int classno=Integer.parseInt(req.getParameter("classno"));
        userclasspayment.setClassno(classno);
        
        
        String param = req.getParameter("wishdate"); //2020-07-01 String
        String date1=param.split("/")[0];
        String date2=param.split("/")[1];
        String date3=param.split("/")[2];
        
        String newdate=date3+"-"+date1+"-"+date2;

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
           Date to = transFormat.parse(newdate);
           userclasspayment.setBookingDate(to);
        } catch (ParseException e1) {
           e1.printStackTrace();
        }

        return userclasspayment;
	}
	
	@Override
	public Map<String, Object> classpayment(ClassBooking userclasspayment, UserInfo userinfo) {
		Map<String, Object> classpayment = userclasspaymentDao.classpayment(userclasspayment, userinfo);
		return classpayment;
	}
	
	
	
	

}
