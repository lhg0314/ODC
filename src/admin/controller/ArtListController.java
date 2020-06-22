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
import dto.ArtistInfo;
import dto.UserInfo;
import util.Paging;

/* 완성
 * 200620 이서연
 * 관리자페이지에서 작가정보 불러오는 servlet
 */

@WebServlet("/admin/artlist")
public class ArtListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	AdminService adminService = new AdminServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/artlist [GET]");
		

		//요청 파라미터를 전달하여 Paging 객체 생성하기
		Paging paging  = adminService.getPagingArt(req);
		
		//게시글 전체조회
		List<ArtistInfo> artistList = adminService.selectAllArt(paging);
		
		
		//paging 처리결과 model값 전달
		req.setAttribute("paging", paging);
		
		//조회결과 model값 전달
		req.setAttribute("artistList", artistList);
		
		//view 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/artist/ArtList.jsp").forward(req, resp);
	
	
	}

}