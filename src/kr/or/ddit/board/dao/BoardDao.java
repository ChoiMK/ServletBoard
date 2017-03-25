package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;

public interface BoardDao {
	public MemberVO getMemberInfo(Map<String, String> params) throws SQLException;
	public List<BoardVO> getBoardList(Map<String, String> params) throws SQLException;
	public BoardVO getBoardInfo(Map<String, String> params)throws SQLException;
	public void insertBoardInfo(BoardVO boardInfo) throws SQLException;
	public int deleteBoardInfo(Map<String, String> params) throws SQLException;
	public int updateBoardInfo(BoardVO boardInfo) throws SQLException;
}
