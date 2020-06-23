package artist.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistService;
import artist.service.impl.ArtistServiceImpl;

/**
 * Servlet implementation class FindArtPwServlet
 */
@WebServlet("/find/artpw")
public class FindArtPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArtistService artistService=new ArtistServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/views/artist/join/findpw.jsp").forward(req, resp);
		}
	
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");

			PrintWriter out= resp.getWriter();

			String email=req.getParameter("email");
			String name=req.getParameter("name");
			String id=req.getParameter("id");

			System.out.println(email+","+name+","+id);

			int res=artistService.selectUserPwByEN(email,name,id);//일치하는 회원정보가 있는지 조회

			if(res==1) {//일치하는 회원정보가 있으면
				String pw=artistService.getPwByEN(email,name,id);
				System.out.println(pw);
				out.println(pw);
			}else {//일치하는 회원정보가 없을떄
				out.println(0);
			}
		
		}

}
