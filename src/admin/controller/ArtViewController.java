package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 미완성
 * 200620 이서연
 * 관리자페이지의 작가정보에서 작가상세정보 불러오는 servlet
 */

@WebServlet("/admin/artview")
public class ArtViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/artview [GET]");
		
	
		
		req.getRequestDispatcher("/WEB-INF/views/admin/artist/ArtView.jsp").forward(req, resp);
	
	
	}

}