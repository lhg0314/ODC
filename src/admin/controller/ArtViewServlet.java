package admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.face.AdminManageService;
import admin.service.impl.AdminManageServiceImpl;
import dto.ArtistDetail;
import dto.ArtistInfo;
import dto.ClassInfo;


/* 
 * 200621 이서연
 * 관리자페이지의 작가정보에서 작가상세정보 불러오는 servlet
 */

@WebServlet("/admin/artview")
public class ArtViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	AdminManageService adminManageService = new AdminManageServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/admin/artview [GET]");
	

		//사업자정보 전체조회
		ArtistInfo artistInfo = adminManageService.selectArtistno(req);
		
		
		//사업자 정보상세 조회
		ArtistDetail artistDetail = adminManageService.selectArtistDetail(req);
		
		
		//개설 클래스 조회
		ClassInfo classInfo = new ClassInfo();
		
		classInfo.setArtno(Integer.parseInt(req.getParameter("artno")));
		
		List<ClassInfo> classList = adminManageService.classList(classInfo);
				
		
		//문의 답변 조회
		
		List<Map<String, Object>> askCommList = adminManageService.askCommList(req);
		
		
		
		
		//조회결과 model값 전달
		req.setAttribute("artistInfo", artistInfo);
		
		//조회결과 model값 전달
		req.setAttribute("artistDetail", artistDetail);
		
		//조회결과 model값 전달
		req.setAttribute("classList", classList);
		
		//조회결과 model값 전달
		req.setAttribute("askCommList", askCommList);
		
		
		
		//view 지정
		req.getRequestDispatcher("/WEB-INF/views/admin/artist/ArtView.jsp").forward(req, resp);
	
	
	}

}
