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
 * Servlet implementation class ArtistIdCheckServlet
 */
@WebServlet("/artist/idcheck")
public class ArtistIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArtistService artistService=new ArtistServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		resp.setContentType("text/html;charset=utf-8");
		String checkId=req.getParameter("userid");
		int result=artistService.idCheck(checkId);
		
		PrintWriter out=resp.getWriter();
		
		if(result==0) out.println("1");//사용가능한 아이디
		else out.println("0");//중복된 아이디
		
		out.close();
	}

}
