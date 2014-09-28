package kr.co.eco.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.co.eco.vo.ClubTestVO;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:./resource/applicationContext.xml"})
public class ClubTestDAOTest {

	@Autowired
	ClubTestDAO dao;

	@Test
	public void testAddClubTest() {
		ClubTestVO clubTestVO = new ClubTestVO();
		clubTestVO.setTestNo("N2");
		clubTestVO.setclubNo(1);
		assertNotNull(dao.addClubTest(clubTestVO));
	}

	@Test
	public void testDeleteClubTest() {
		ClubTestVO clubTestVO = new ClubTestVO();
		clubTestVO.setTestNo("N2");
		clubTestVO.setclubNo(1);		
		assertNotNull(dao.deleteClubTest(clubTestVO));
	}
	
	@Test
	public void testGetClubTestByClubNo() {
		List<ClubTestVO> list = dao.getClubTestByClubNo(1);
		for(ClubTestVO ct : list) {
			System.out.println(ct);
		}
	}
	@Test
	public void testGetClubTestByTestNo() {
		List<ClubTestVO> list = dao.getClubTestByTestNo("N1");
		for(ClubTestVO ct : list) {
			System.out.println(ct);
		}
	}

}
