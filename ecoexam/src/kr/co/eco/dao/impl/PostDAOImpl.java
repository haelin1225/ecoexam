package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.PostDAO;
import kr.co.eco.vo.PostNoVO;
import kr.co.eco.vo.PostVO;

@Repository("postDAO")
public class PostDAOImpl implements PostDAO{

	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public int addPost(PostVO postVO) {
		return (Integer) sqlMapClientTemplate.update("addPost", postVO);
	}

	public int deletePost(int postNo) {	
		return (Integer) sqlMapClientTemplate.delete("deletePost",postNo);
	}

	public List<PostVO> getAllPostList() {
		return (List<PostVO>) sqlMapClientTemplate.queryForList("getAllPostList");
	}
	
	public List<PostVO> getPostList(int boardNo) {
		return (List<PostVO>) sqlMapClientTemplate.queryForList("getPostList", boardNo);
	}

	public PostVO getPost(int postNo) {
		return (PostVO) sqlMapClientTemplate.queryForObject("getPost",postNo) ;
	}

	public int updatePost(PostVO postVO) {
		return (Integer) sqlMapClientTemplate.update("updatePost",postVO);
	}

	public int updatePostCount(PostVO postVO) {
		return (Integer) sqlMapClientTemplate.update("updatePostCount", postVO);
	}

	@Override
	public List<PostVO> getPostListByTitle(int boardNo, String postTitle) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("boardNo", boardNo);
		parameters.put("postTitle", postTitle);
		return (List<PostVO>)sqlMapClientTemplate.queryForList("getPostListByTitle", parameters);
	}

	@Override
	public List<PostVO> getPostListByTitleAndContent(int boardNo, String postTitle, String postContent) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("boardNo", boardNo);
		parameters.put("postTitle", postTitle);
		parameters.put("postContent", postContent);
		return (List<PostVO>)sqlMapClientTemplate.queryForList("getPostListByTitleAndContent", parameters);
	}

	@Override
	public List<PostVO> getPostListByContent(int boardNo, String postContent) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("boardNo", boardNo);
		parameters.put("postContent", postContent);
		return (List<PostVO>)sqlMapClientTemplate.queryForList("getPostListByContent", parameters);
	}

	@Override
	public List<PostVO> getPostListByMemberID(int boardNo, String memberID) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("boardNo", boardNo);
		parameters.put("memberID", memberID);
		return (List<PostVO>)sqlMapClientTemplate.queryForList("getPostListByMemberID", parameters);
	}
	
	@Override
	public List<PostNoVO> getAllPostNo(int boardNo) {
		return (List<PostNoVO>)sqlMapClientTemplate.queryForList("getAllPostNo", boardNo);
	}

}
