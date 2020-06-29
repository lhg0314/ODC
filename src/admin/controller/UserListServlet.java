package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminManageService;
import admin.service.impl.AdminManageServiceImpl;
import dto.UserInfo;
import util.Paging;

/* 
 * 200620 이서연
 * 관리자페이지에서 사용자정보 불러오는 servlet
 */

@WebServlet("/admin/userlist")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	AdminManageService adminManageService = new AdminManageServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/userlist [GET]");
		
		
		//요청 파라미터를 전달하여 Paging 객체 생성하기
		Paging paging  = adminManageService.getPagingUser(req);
		
		//유저정보 전체조회
		List<UserInfo> userList = adminManageService.selectAllUser(paging);
		
		
		//paging 처리결과 model값 전달
		req.setAttribute("paging", paging);
		
		//조회결과 model값 전달
		req.setAttribute("userList", userList);
		
		//view 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/user/UserList.jsp").forward(req, resp);
	
	
	}

}
