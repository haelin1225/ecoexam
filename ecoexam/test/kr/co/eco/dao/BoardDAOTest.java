package kr.co.eco.dao;

import static org.junit.Assert.assertEquals;
import kr.co.eco.vo.BoardVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class BoardDAOTest {
	
	@Autowired
	private BoardDAO boardDAO;
	private BoardVO boardVO;
	
	@Test 
	public void testAddBoard(){
		boardVO = new BoardVO();
		
		boardVO.setBoardName("¾È³ç2");
		
		int count = boardDAO.addBoard(boardVO);
		assertEquals(1, count);
		
	}
	
	@Test
	public void testDeleteBoard(){
		boardVO = new BoardVO();
		boardVO.setBoardNo(2);
		
		int count = boardDAO.deleteBoard(boardVO.getBoardNo());
		
		assertEquals(1, count);
	}
	@Test
	public void testUpdateBoard(){
		boardVO = new BoardVO();
		boardVO.setBoardName("¾È³ç1");
		boardVO.setBoardNo(1);
		
		int count = boardDAO.updateBoard(boardVO);
		
		assertEquals(1, count);
	}
	@Test
	public void testGetBoardList(){
		
		boardDAO.getBoardList();
		assertEquals(2,boardDAO.getBoardList().size());
	}
	
	@Test
	public void testGetBoardNo(){
		
		//BoardVO board = boardDAO.getBoardByBoardNo("1");
		//System.out.println(board);
		
		//assertEquals(1, board.getBoardNo());
	}
	
	

}
