package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.AttachFileVO;

public interface AttachFileDAO {
	
	public int addAttachFile(AttachFileVO attachFileVO);
	public int deleteAttachFile(int fileNo);
	public List<AttachFileVO> getAttachFileList(int postNo);
	public int updateAttachFile(AttachFileVO attachFileVO);
	public AttachFileVO getAttachFile(int fileNo);
}
