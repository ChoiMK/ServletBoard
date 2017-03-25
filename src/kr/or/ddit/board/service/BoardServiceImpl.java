package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;

public class BoardServiceImpl implements BoardService{

	private static BoardServiceImpl service = new BoardServiceImpl();
	private BoardDao dao;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardService getInstacne(){
		if(service == null){
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public MemberVO getMemberInfo(Map<String, String> params) {
		MemberVO memberInfo = null;
		try {
			 memberInfo = dao.getMemberInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberInfo;
		
	}

	@Override
	public List<BoardVO> getBoardList(Map<String, String> params) {
		List<BoardVO> boardList = null;
		try{
			boardList = dao.getBoardList(params);
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		return boardList;
	}
	@Override
	public BoardVO getBoardInfo(Map<String, String> params) {
		BoardVO boardInfo= null;
		try {
			boardInfo = dao.getBoardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardInfo;
	}

	@Override
	public void insertBoardInfo(BoardVO boardInfo) {
		try {
			dao.insertBoardInfo(boardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int deleteBoardInfo(Map<String, String> params) {
		int deleteCnt = 0;
		try {
			deleteCnt = dao.deleteBoardInfo(params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleteCnt;
	}

	@Override
	public int updateBoardInfo(BoardVO boardInfo) {
		int updateCnt = 0;
		try {
			updateCnt = dao.updateBoardInfo(boardInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return updateCnt;
	}


}
