package kr.co.eco.dao;

import java.util.List;

import kr.co.eco.vo.GradeVO;

public interface GradeDAO {
	public int addGrade(GradeVO gradeVO);
	public GradeVO getGrade(int clubNo, String memberID, String testNo);
	public List<GradeVO> getGradeListByClub(int clubNo);
	public List<GradeVO> getGradeListByMember(String memberID);
	public List<GradeVO> getGradeListByTest(String testVO);	
}
