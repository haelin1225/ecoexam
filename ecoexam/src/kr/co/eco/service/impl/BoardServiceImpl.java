package kr.co.eco.service.impl;

import java.util.List;

import kr.co.eco.dao.BoardDAO;
import kr.co.eco.dao.CommentsDAO;
import kr.co.eco.dao.PostDAO;
import kr.co.eco.service.BoardService;
import kr.co.eco.vo.BoardVO;
import kr.co.eco.vo.CommentsVO;
import kr.co.eco.vo.PostNoVO;
import kr.co.eco.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
/*
	EXAMPLE
	
	@Autowired
	DAO dao;
	
	public int add(VO vo) {
		return dao.add(vo);
	}
*/
	
	@Autowired
	BoardDAO boardDAO;
	
	@Autowired
	PostDAO postDAO;
	@Autowired
	CommentsDAO commentsDAO;
	public PostVO getPost(int postNo) {
		return postDAO.getPost(postNo);
	}
	
	public List<PostNoVO> getAllPostNo(int boardNo) {
		return postDAO.getAllPostNo(boardNo);
	}
	
	public List<PostVO> getAllPostList() {
		return postDAO.getAllPostList();
	}
	
	public List<PostVO> getPostList(int boardNo) {
		return postDAO.getPostList(boardNo);
	}
	

	public int addPostVO(PostVO postVO) {		
		return postDAO.addPost(postVO);
	}
	public int addPost(String boardName, PostVO post) {
		BoardVO board = boardDAO.getBoardByBoardName(boardName);
		post.setBoardNo(board.getBoardNo());
		return postDAO.addPost(post);
	}
	
	public int updatePost(String boardName, PostVO postVO) {
		BoardVO board = boardDAO.getBoardByBoardName(boardName);
		PostVO post = postDAO.getPost(postVO.getPostNo());	
		post.setBoardNo(board.getBoardNo());
		post.setPostTitle(postVO.getPostTitle());
		post.setPostContent(postVO.getPostContent());
		
		return postDAO.updatePost(post);
	}
	public int updatePostVO(PostVO postVO){
		return postDAO.updatePost(postVO);
	}
	public int updatePostCount(int postNo, int postCount) {
		PostVO postVO = postDAO.getPost(postNo);	
		postVO.setPostCount(postCount);
		
		return postDAO.updatePostCount(postVO);
	}
	
	public int deletePost(int postNo) {
		return postDAO.deletePost(postNo);
	}

	public int addBoard(BoardVO boardVO){
		boardDAO.addBoard(boardVO);
		BoardVO board = boardDAO.getBoardByBoardName(boardVO.getBoardName());
		int boardNo = board.getBoardNo();
		return boardNo;
	}

	public int addComments(int postNo, String memberID, String commentsContent){
		CommentsVO commentsVO = new CommentsVO();
		commentsVO.setPostNo(postNo);
		commentsVO.setMemberID(memberID);
		commentsVO.setCommentsContent(commentsContent);
		return commentsDAO.addComments(commentsVO);
	}
	public List<CommentsVO> getCommentsList(int postNo){
		return commentsDAO.getCommentsList(postNo);
	}
	
	public CommentsVO getComment(int postNo) {
		List<CommentsVO> comment = commentsDAO.getCommentsList(postNo);
		return comment.get(comment.size()-1);
	}

}
