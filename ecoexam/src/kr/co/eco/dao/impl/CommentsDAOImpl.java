package kr.co.eco.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import kr.co.eco.dao.CommentsDAO;
import kr.co.eco.vo.CommentsVO;

@Repository("CommentsDAO")
public class CommentsDAOImpl implements CommentsDAO {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public int addComments(CommentsVO commentsVO) {
		return sqlMapClientTemplate.update("addComments", commentsVO);
	}

	public int updateComments(CommentsVO commentsVO) {
		return sqlMapClientTemplate.update("updateComments", commentsVO);
	}

	public int deleteComments(int commentNo) {
		return sqlMapClientTemplate.delete("deleteComments", commentNo);
	}

	public List<CommentsVO> getCommentsList(int postNo) {
		return (List<CommentsVO>)sqlMapClientTemplate.queryForList("getCommentsList", postNo);
	}

	@Override
	public CommentsVO getComments(int commentsNo) {
		return (CommentsVO)sqlMapClientTemplate.queryForObject("getComments", commentsNo);
	}

}