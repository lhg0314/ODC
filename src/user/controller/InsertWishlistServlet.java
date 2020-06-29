package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Classwish;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class InsertWishlistServlet
 */
@WebServlet("/insert/wishlist")
public class InsertWishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	
	
		@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setCharacterEncoding("UTF-8");//printwriter를 위한 인코딩
	        PrintWriter out=resp.getWriter();//ajax로 응답을 하기위한 printwriter
	        Classwish c=new Classwish();
			int userno=Integer.parseInt(req.getParameter("userno"));
			int count=Integer.parseInt(req.getParameter("count"));
			int total=Integer.parseInt(req.getParameter("totalPrice"));
			int classno=Integer.parseInt(req.getParameter("classno"));
			
			String param = req.getParameter("wishdate"); //2020-07-01 String
			String date1=param.split("/")[0];
			String date2=param.split("/")[1];
			String date3=param.split("/")[2];
			
			String newdate=date3+"-"+date1+"-"+date2;
			System.out.println(newdate);
			
			
			

			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				Date to = transFormat.parse(newdate);
				c.setWishDate(to);
				System.out.println(to);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}



			
			
			
			
			c.setClassno(classno);
			c.setUser_no(userno);
			c.setWishCount(count);
			c.setTotalPrice(total);
			System.out.println(c);
			
			int res=us.insertWish(c);
			if(res==0) {//삽입이 안됨
				
				out.println("0");
			}else {//삽입이 됨
			out.println("1");
			}
			
			
			
			
			}

}
