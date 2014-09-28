package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.PostNoVO;
import kr.co.eco.vo.PostVO;

import org.springframework.beans.factory.annotation.Autowired;

public interface PostDAO {
	
	public int addPost(PostVO postVO);
	public int deletePost(int postNo);
	public List<PostVO> getAllPostList();
	public List<PostVO> getPostList(int boardNo);
	public List<PostVO> getPostListByTitle(int boardNo, String postTitle);
	public List<PostVO> getPostListByTitleAndContent(int boardNo, String postTitle, String postContent);
	public List<PostVO> getPostListByContent(int boardNo, String postContent);
	public List<PostVO> getPostListByMemberID(int boardNo, String memberID);
	public PostVO getPost(int postNo);
	public int updatePost(PostVO postVO);
	public int updatePostCount(PostVO postVO);
	public List<PostNoVO> getAllPostNo(int boardNo);
}

