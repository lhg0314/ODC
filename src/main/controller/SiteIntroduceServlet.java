package main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//메인 fooer a (4) 
//사이트소개
// 이인즈 20200620
@WebServlet("/footer/siteIntroduce")
public class SiteIntroduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/views/main/footer/siteIntroduce.jsp").forward(req,resp);
	
	
	}

}
