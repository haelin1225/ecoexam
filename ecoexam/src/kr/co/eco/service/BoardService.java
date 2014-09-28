package kr.co.eco.service;

import java.util.List;

import kr.co.eco.vo.PostNoVO;
import kr.co.eco.vo.BoardVO;
import kr.co.eco.vo.CommentsVO;
import kr.co.eco.vo.PostVO;

public interface BoardService {

	public PostVO getPost(int postNo);
	public List<PostVO> getAllPostList();
	public List<PostVO> getPostList(int boardNo);

	public int addPostVO(PostVO postVO);

	public int addPost(String boardName, PostVO postVO);
	public List<PostNoVO> getAllPostNo(int boardNo);
	public int updatePost(String boardName, PostVO postVO);
	public int updatePostVO(PostVO postVO);
	public int updatePostCount(int postNo, int postCount);
	public int deletePost(int postNo);

	public int addBoard(BoardVO boardVO);
	public int addComments(int postNo, String memberID, String commentsContent);
	public List<CommentsVO> getCommentsList(int postNo);
	
	public CommentsVO getComment(int postNo);
}	

