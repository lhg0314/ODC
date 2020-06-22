package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//로그인후 보여짐 로고누르면 보여지는 페이지 
//관리자 메인
//이인주 20200620
@WebServlet("/admin/main")
public class AdminmainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/WEB-INF/layout/admin/adminmain.jsp").forward(req,resp);
	}
}
