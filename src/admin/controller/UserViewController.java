package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminService;
import admin.service.impl.AdminServiceImpl;
import dto.UserInfo;

/* 미완성
 * 200620 이서연
 * 관리자페이지의 사용자 정보에서 사용자 상세정보 불러오는 servlet
 */

@WebServlet("/admin/userview")
public class UserViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	AdminService adminService = new AdminServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/userview [GET]");
		
		//유저정보 전체조회
		UserInfo userInfo = adminService.selectUserno(req);
		
		//조회결과 model값 전달
		req.setAttribute("userInfo", userInfo);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/user/UserView.jsp").forward(req, resp);
	
	
	}
	
}