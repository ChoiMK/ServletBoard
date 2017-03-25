package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.vo.BoardVO;

import org.apache.commons.beanutils.BeanUtils;

public class InsertBoardServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTf-8");
		
		BoardVO boardInfo = new BoardVO();
		try {
			BeanUtils.populate(boardInfo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		BoardService service = BoardServiceImpl.getInstacne();
		service.insertBoardInfo(boardInfo);
		
		response.sendRedirect("/ServletBoard/boardList");
		
		
	}

}
