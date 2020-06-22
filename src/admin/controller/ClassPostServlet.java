package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminClassService;
import admin.service.impl.AdminClassServiceImpl;
import dto.ClassInfo;
import util.Paging;

/**
 * 클래스 게시/삭제 서블릿
 * 20200620 구동영
 */
@WebServlet("/admin/class/post")
public class ClassPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AdminClassService adminClassService = new AdminClassServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//			System.out.println("/admin/class/post [GET]");
			
			// 요청 파라미터를 전달하여 Paging 객체 생성하기
			Paging paging = adminClassService.getPagingPostClass(req);
//			System.out.println("BoardListController =" + paging);
			
			// DB에서 클래스 정보 꺼내오기
//			map = adminService.selectAllClass();
			List<Map<String, Object>> list = adminClassService.selectAllClass(paging);

//			System.out.println(map);
			// list data VIEW 로 넘겨주기
			req.setAttribute("list", list);
			// Paging 처리 결과 Model 값 전달
			req.setAttribute("paging", paging);
			
			req.getRequestDispatcher("/WEB-INF/views/admin/classManage/classPost.jsp").forward(req, resp);
		}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int classno = -1;
			
			// 파라미터 처리
			String cn = req.getParameter("classno");
			if( cn != null && !"".equals(cn)) {
				classno = Integer.parseInt(cn);
			}

			int postStatus= -1;
			
			cn = req.getParameter("postStatus");
			if( cn != null && !"".equals(cn)) {
				postStatus = Integer.parseInt(cn);
			}
		
			ClassInfo classInfo = new ClassInfo();
			
			// 클래스 업데이트할 정보가 담긴 객체
			classInfo.setClassno(classno);
			classInfo.setPostStatus(postStatus);
			
				
			// 게시사항 변경하기
			adminClassService.updatePostStatus(classInfo);
			
			
			// 리다이렉트
			if( "check".equals(req.getParameter("view"))){
				resp.sendRedirect("/admin/class/check");
			}else {	resp.sendRedirect("/admin/class/post"); }
		
		
		}



}
