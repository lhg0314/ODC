package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Donation;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserSupportServlet
 */
@WebServlet("/user/support")
public class UserSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doGet(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userno=Integer.parseInt(req.getParameter("userno"));
		int artno=Integer.parseInt(req.getParameter("artno"));
		int price=Integer.parseInt(req.getParameter("price"));
		
		//System.out.println(userno+","+artno+","+price);
		
		Donation d=new Donation();
		d.setUserno(userno);
		d.setArtno(artno);
		d.setDonationPrice(price);
		
		int res=us.insertDonation(d);
		
		//System.out.println(res);
		 
	}

}
