package kr.co.eco.dao;

import static org.junit.Assert.assertEquals;
import kr.co.eco.vo.ClubVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class ClubDAOTest {
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	
	@Autowired
	private ClubDAO clubDAO;
	
	@Test
	public void testAddClub() {
		ClubVO clubVO = new ClubVO();
		int count=0;
		
	
		clubVO.setClubCreateDate("11/11/11");
		clubVO.setClubManagerID("user");
		clubVO.setClubName("clubclub");
		clubVO.setClubBoardNo(1);
		clubVO.setClubNo(1);
//		count = sqlMapClientTemplate.update("insertClub", clubVO);
		count = clubDAO.addClub(clubVO);
		assertEquals(1, count);
	}
	
	@Test
	public void testUpdateClub() {
		ClubVO clubVO = new ClubVO();
		int count = 0;
		clubVO.setClubNo(1);
	
		clubVO.setClubManagerID("user");
		clubVO.setClubName("clubgame");
		clubVO.setClubBoardNo(1);
//		count = sqlMapClientTemplate.update("updateClub", clubVO);
		count = clubDAO.updateClub(clubVO);
		assertEquals(1, count);		
	}
	
	@Test
	public void testDeleteClub() {
		ClubVO  clubVO = new ClubVO();
		clubVO.setClubNo(1);
		
//		int count = sqlMapClientTemplate.delete("deleteClub", clubVO.getClubNo());
		int count = clubDAO.deleteClub(clubVO.getClubNo());
		assertEquals(1, count);
	}
	
	@Test
	public void testGetClub() {
		ClubVO clubVO = new ClubVO();
		clubVO.setClubName("clubclub");

//		clubVO = (ClubVO)sqlMapClientTemplate.queryForObject("getClub", clubVO.getClubName());
		clubVO = (ClubVO)clubDAO.getClub(clubVO.getClubNo());
		assertEquals("user01", clubVO.getClubManagerID());
	}
	
	@Test
	public void testGetClubList() {
		ClubVO clubVO = new ClubVO();
//		clubVO.setClubManagerID("admin");
//		sqlMapClientTemplate.queryForList("clubList", clubVO.getClubManagerID());
		
		assertEquals(1, clubDAO.getClubList().size());
	}
	
	@Test
	public void testGetClubListByClubName() {
		System.out.println(clubDAO.getClubListByClubName("club01"));
		assertEquals(1, clubDAO.getClubListByClubName("club01").size());
	}
 }
