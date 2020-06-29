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

@WebServlet("/notice/update")
public class NoticeBoardUpdateServlet extends HttpServlet {
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
		
		req.getRequestDispatcher("/WEB-INF/views/admin/board/noticeupdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		// 저장 객체
		NoticeBoard noticeBoard = new NoticeBoard();
		
		int noticeno = 0;
		
		String param = req.getParameter("noticeno");
		if( param != null && !"".equals(param) ) {
			noticeno = Integer.parseInt(param);
		}
		
		
		String noticeTitle = req.getParameter("noticeTitle");
		String noticeContent = req.getParameter("content");
		
		noticeBoard.setNoticeNo(noticeno);
		noticeBoard.setNoticeTitle(noticeTitle);
		noticeBoard.setNoticeContent(noticeContent);
		
		// 공지사항 저장
		boardService.updateNotice(noticeBoard);
		
		//리스트 페이지로 리다이렉트
		resp.sendRedirect("/admin/noticelist");
	
	
	
	
	
	}

}
