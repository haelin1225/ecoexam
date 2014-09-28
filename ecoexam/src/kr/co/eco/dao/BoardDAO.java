package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.BoardVO;

public interface BoardDAO {
	public int addBoard(BoardVO boardVO);
	public int deleteBoard(int boardNo);
	public int updateBoard(BoardVO boardVO);
	public List<BoardVO> getBoardList();
	public BoardVO getBoardByBoardName(String boardName);
}
