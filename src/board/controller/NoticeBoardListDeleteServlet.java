package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.face.BoardService;
import board.service.impl.BoardServiceImpl;

/**
 * 게시판 - 공지사항 게시글 선택 삭제
 * 완성
 * 200623
 * 박주이
 */
@WebServlet("/notice/listdelete")
public class NoticeBoardListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String names = req.getParameter("names");
		
		if( !"".equals(names) && names != null) {
			boardService.boardListDelete(names);
		}
		
		resp.sendRedirect("/notice/list");
	}
}
