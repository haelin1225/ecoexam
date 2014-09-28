package kr.co.eco.dao;

import java.util.List;


import kr.co.eco.vo.ClubTestVO;

public interface ClubTestDAO {
	public int addClubTest(ClubTestVO clubTestVO);
	public int deleteClubTest(ClubTestVO clubTestVO);
	public List<ClubTestVO> getClubTestByTestNo(String testNo);
	public List<ClubTestVO> getClubTestByClubNo(int clubNo);
}
