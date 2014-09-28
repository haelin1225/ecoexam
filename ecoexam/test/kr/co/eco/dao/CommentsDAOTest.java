package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.CommentsVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class CommentsDAOTest {

	@Autowired
	CommentsDAO dao;
	
	@Test
	public void addComments() {
		CommentsVO comments = new CommentsVO();
		comments.setPostNo(1);
		comments.setMemberID("user01");
		comments.setCommentsContent("hi");

		int count = dao.addComments(comments);
		assertEquals(1, count);
	}
	
	@Test
	public void updateComments() {
		CommentsVO comments = dao.getComments(1);
		comments.setCommentsContent("hello");
		
		int count = dao.updateComments(comments);
		assertEquals(1, count);
	}
	
	@Test
	public void deleteComments() {
		int count = dao.deleteComments(2);
		assertEquals(1, count);
	}
	
	@Test
	public void getCommentsList() {
		List<CommentsVO> list = dao.getCommentsList(1);
		assertEquals(1, list.size());
		
		for(CommentsVO comment : list) {
			System.out.println(comment);
		}
	}
}
