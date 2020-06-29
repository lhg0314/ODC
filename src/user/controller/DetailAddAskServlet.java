package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.AskBoard;
import user.service.face.UserService;
import user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DetailAddAskServlet
 */
@WebServlet("/add/ask")
public class DetailAddAskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us=new UserServiceImpl();
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
			AskBoard a=new AskBoard();
			int userno=Integer.parseInt(req.getParameter("userno"));
			System.out.println(req.getParameter("artno"));
			int artno=Integer.parseInt(req.getParameter("artno"));
			int classno=Integer.parseInt(req.getParameter("classno"));
			String content=req.getParameter("comment");
			//a에 세팅
			a.setUserno(userno);
			a.setArtno(artno);
			a.setClassno(classno);
			a.setAskContent(content);
			System.out.println(a);
			
			us.insertAskBoard(a);
		}

}
