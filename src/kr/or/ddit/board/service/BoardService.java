package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;

public interface BoardService {
	public MemberVO getMemberInfo(Map<String, String> params);
	public BoardVO getBoardInfo(Map<String, String> params);
	public List<BoardVO> getBoardList(Map<String, String> params);
	public void insertBoardInfo(BoardVO boardInfo);
	public int deleteBoardInfo(Map<String, String> params);
	public int updateBoardInfo(BoardVO boardInfo);
}
