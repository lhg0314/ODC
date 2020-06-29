package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.face.BoardService;
import board.service.impl.BoardServiceImpl;
import dto.NoticeBoard;

@WebServlet("/notice/view")
public class NoticeBoardUserViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardService boardService = new BoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int noticeno = 0;
		
		String param = req.getParameter("noticeno");
		if( param != null && !"".equals(param) ) {
			noticeno = Integer.parseInt(param);
		}
		
		NoticeBoard noticeBoard = boardService.selectNoticeBoard(noticeno);
		
		req.setAttribute("noticeBoard", noticeBoard);
		
		req.getRequestDispatcher("/WEB-INF/views/board/userNoticeView.jsp").forward(req, resp);
		
		
	}

}
