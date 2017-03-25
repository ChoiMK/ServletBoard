package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.ibatis.build.SqlMapClientFactory;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.MemberVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class BoardDaoImpl implements BoardDao {
private static BoardDao dao = new BoardDaoImpl();
private SqlMapClient client;

private BoardDaoImpl(){
	client = SqlMapClientFactory.getSqlMapClient();
}
	
	
public static BoardDao getInstance(){
	return (dao == null) ? new BoardDaoImpl() : dao;
}
	
	
	@Override
	public MemberVO getMemberInfo(Map<String, String> params)
			throws SQLException {
		return (MemberVO)client.queryForObject("member.memberInfo",params);
	}

	@Override
	public List<BoardVO> getBoardList(Map<String, String> params) throws SQLException {
		return client.queryForList("board.boardList",params); 
		
	}
	@Override
	public BoardVO getBoardInfo(Map<String, String> params) throws SQLException {
		return (BoardVO)client.queryForObject("board.boardInfo",params);
	}

	@Override
	public void insertBoardInfo(BoardVO boardInfo) throws SQLException {
		client.insert("board.insertBoard",boardInfo);
	}

	@Override
	public int deleteBoardInfo(Map<String, String> params) throws SQLException {
		return client.delete("board.deleteBoard",params);
	}

	@Override
	public int updateBoardInfo(BoardVO boardInfo) throws SQLException {
		return client.update("board.updateBoard",boardInfo);
	}


	
}
