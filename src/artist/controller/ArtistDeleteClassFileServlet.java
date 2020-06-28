package artist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import artist.service.face.ArtistService;
import artist.service.impl.ArtistServiceImpl;

/**
 * Servlet implementation class ArtistDeleteClassFileServlet
 */
@WebServlet("/delete/artClassFile")
public class ArtistDeleteClassFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistService as=new ArtistServiceImpl();
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("doget");
			int classno=Integer.parseInt(req.getParameter("classno"));
			String filename=req.getParameter("name");
			
			System.out.println(classno+","+filename);
			
			as.deleteClassFile(classno,filename);
			
			
		}

}
