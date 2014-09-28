package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.ClubTestVO;
import kr.co.eco.vo.PostNoVO;
import kr.co.eco.vo.PostVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class PostDAOTest {
	@Autowired
	private PostDAO postDAO;

	@Test
	public void testAddPost() {
		PostVO postVO = new PostVO();
		postVO.setPostTitle("title");
		postVO.setMemberID("M1");
		postVO.setPostContent("content");
		postVO.setBoardNo(1);
		assertNotNull(postDAO.addPost(postVO));
	}
	
	@Test
	public void testUpdatePost(){
		PostVO postVO = new PostVO();
		postVO.setPostNo(2);
		postVO.setPostTitle("two");
		postVO.setPostContent("22222");
		assertNotNull(postDAO.updatePost(postVO));
	}
	
	@Test
	public void testDeletePost(){
		assertNotNull(postDAO.deletePost(3));
	}
	
	@Test
	public void testGetAllPostList() {
		List<PostVO> list = postDAO.getAllPostList();
		for(PostVO ct : list) {
			System.out.println(ct);
		}
	}
	
	@Test
	public void testGetPostList() {
		List<PostVO> list = postDAO.getPostList(1);
		for(PostVO ct : list) {
			System.out.println(ct);
		}
	}
	
	@Test
	public void testGetPostListByTitle() {
		List<PostVO> list = postDAO.getPostListByTitle(1, "test");
		for(PostVO ct : list) {
			System.out.println(ct);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetPostListByTitleAndContent() {
		List<PostVO> list = postDAO.getPostListByTitleAndContent(1, "hello", "hello");
		for(PostVO ct : list) {
			System.out.println(ct);
		}
		assertEquals(list.size(), 4);
	}
	
	@Test
	public void testGetPostListByContent() {
		List<PostVO> list = postDAO.getPostListByContent(1, "hi");
		for(PostVO ct : list) {
			System.out.println(ct);
		}
		assertEquals(list.size(), 3);
	}
	
	@Test
	public void testGetPostListByMemberID() {
		List<PostVO> list = postDAO.getPostListByMemberID(1, "user02");
		for(PostVO ct : list) {
			System.out.println(ct);
		}
		assertEquals(list.size(), 2);
	}
	
	@Test
	public void testGetPost() {
			System.out.println(postDAO.getPost(4));
	}
	
	@Test
	public void testGetPostNo() {
		List<PostNoVO> postNo = postDAO.getAllPostNo(1);
		for(PostNoVO no : postNo) {
			System.out.println(no);
			if(no.getPostNo() == 1) {
				assertEquals(no.getNext_postNo(), 2);
				System.out.println(no.getPostNo()+" "+no.getNext_postNo());
			}
		}
	}
}
