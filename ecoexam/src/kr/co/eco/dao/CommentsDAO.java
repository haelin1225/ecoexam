package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.CommentsVO;

public interface CommentsDAO {
	
	public int addComments(CommentsVO commentsVO);
	public int updateComments(CommentsVO commentsVO);
	public int deleteComments(int commentNo);
	public CommentsVO getComments(int commentsNo);
	public List<CommentsVO> getCommentsList(int postNo);
	
}