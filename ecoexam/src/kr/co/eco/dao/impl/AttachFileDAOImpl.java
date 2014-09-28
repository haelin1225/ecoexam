package kr.co.eco.dao.impl;

import java.util.List;

import kr.co.eco.dao.AttachFileDAO;
import kr.co.eco.vo.AttachFileVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("attachFileDAO")
public class AttachFileDAOImpl implements AttachFileDAO{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	public int addAttachFile(AttachFileVO attachFileVO) {
		return (Integer) sqlMapClientTemplate.update("addAttachFile",attachFileVO);
	}

	public int deleteAttachFile(int fileNo) {
		return (Integer) sqlMapClientTemplate.delete("deleteAttachFile", fileNo);
	}

	public List<AttachFileVO> getAttachFileList(int postNo) {
		return (List<AttachFileVO>) sqlMapClientTemplate.queryForList("getAttachFileList",postNo);
	}

	public int updateAttachFile(AttachFileVO attachFileVO) {
		return (Integer) sqlMapClientTemplate.update("updateAttachFile",attachFileVO);
	}

	public AttachFileVO getAttachFile(int fileNo) {
		return (AttachFileVO) sqlMapClientTemplate.queryForObject("getAttachFile",fileNo);
	}
	
}
