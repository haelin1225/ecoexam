package kr.co.eco.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.BoardDAO;
import kr.co.eco.vo.BoardVO;
@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public int addBoard(BoardVO boardVO) {
		return sqlMapClientTemplate.update("insertBoard",boardVO); 
	}
	
	@Override
	public int deleteBoard(int boardNo) {
		return sqlMapClientTemplate.delete("deleteBoard",boardNo);
	}
	
	@Override
	public int updateBoard(BoardVO boardVO) {
		return sqlMapClientTemplate.update("updateBoard",boardVO);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		return sqlMapClientTemplate.queryForList("boardList");
	}
	
	@Override
	public BoardVO getBoardByBoardName(String boardName){
		return (BoardVO)sqlMapClientTemplate.queryForObject("getBoardByBoardName", boardName);
	}

}
