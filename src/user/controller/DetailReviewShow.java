package user.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ReviewBoard;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DetailReviewShow
 */
@WebServlet("/review/show")
public class DetailReviewShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");//printwriter를 위한 인코딩
        PrintWriter out=resp.getWriter();//ajax로 응답을 하기위한 printwriter
		System.out.println("완료");
		int classno=Integer.parseInt(req.getParameter("classno"));
		System.out.println(classno);
		List<Map<String, Object>> review=us.getDetailReview(classno);
		System.out.println(review);
		out.println(review);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
